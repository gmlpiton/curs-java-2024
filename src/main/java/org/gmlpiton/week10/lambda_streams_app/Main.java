package org.gmlpiton.week10.lambda_streams_app;

import org.gmlpiton.week10.lambda_streams_app.domain.FileOperations;
import org.gmlpiton.week10.lambda_streams_app.domain.User;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.gmlpiton.week10.lambda_streams_app.domain.FilterUser.getUsers;

public class Main {

    static String inputFile = "C:\\Users\\Moi\\IdeaProjects\\curs-java-2024\\src\\main\\java\\org\\gmlpiton\\week10\\" +
            "lambda_streams_app\\io\\Birthdays.csv";
    static String outputFile = "C:\\Users\\Moi\\IdeaProjects\\curs-java-2024\\src\\main\\java\\org\\gmlpiton\\week10\\" +
            "lambda_streams_app\\io\\out\\FoundBirthdays.csv";
    public static void main(String[] args) throws IOException {
        System.out.println("Users list!");
        List<User> users;
        users = FileOperations.readFromFileBufferedTryWithResources(inputFile);

        System.out.println(users);

        System.out.println((long) users.size());

        users.stream().filter(s->s.getBirthDay().getMonth().getValue()==11).forEach(System.out::println);
        System.out.println();
        users.stream().filter(s->s.getBirthDay().getMonth().getValue()==11).
                sorted(Comparator.comparing(i2 -> (i2.getLastName()+"_"+ i2.getFirstName())))
                .forEach(System.out::println);

        List<User> foundUsers = getUsers(users,11);

        System.out.println("Found users \n"+ foundUsers);

        FileOperations.writeToFile(outputFile, foundUsers);
    }


}
