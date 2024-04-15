package org.gmlpiton.week10.lambda_streams_app.domain;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileOperations {


    public static List<User> readFromFileBufferedTryWithResources(String inputFile) throws IOException {

        List<User> users = new ArrayList<>();
        File file = new File(inputFile);
        Path path = file.toPath();
        System.out.println("Path is " + path);

        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            String line;
            bufferedReader.readLine(); // this will read the first line, skip it s
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                User ur = getUserFromUserLine(line);

                users.add(ur);
            }
        } catch (Exception e) {
            System.out.println("Cannot open results file" + e);
            throw new IOException(e);
        }
        return users;
    }

    public static void writeToFile(final String filename, final List<User> users) {
        try {
            // Creates a FileWriter
            FileWriter file = new FileWriter(filename);

            // Creates a BufferedWriter
            BufferedWriter output = new BufferedWriter(file);

            // Writes the content to the file
            for (User user : users)
                output.write(user.getFirstName() + ',' + user.getLastName() + ',' + user.getBirthDay().toString()+"\n");

            // Closes the writer
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static User getUserFromUserLine(String result) {
        String[] fields = result.split(";");
        return new User(fields[0], fields[1], LocalDate.of(Integer.parseInt(fields[2].split("/")[2])
                , Integer.parseInt(fields[2].split("/")[1]), Integer.parseInt(fields[2].split("/")[0])));
    }
}
