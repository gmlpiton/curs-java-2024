package org.gmlpiton.week9.exceptlog;

import org.gmlpiton.week9.exceptlog.domain.Gender;
import org.gmlpiton.week9.exceptlog.domain.Student;
import org.gmlpiton.week9.exceptlog.domain.StudentRepository;
import org.gmlpiton.week9.exceptlog.exception.InvalidCNPFormatException;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.logging.*;

/*
  CNP related stuff is inspired/gotten/simplified from https://github.com/vrachieru/cnp4j

 */

public class Main {

    static Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
    static String logFile = Path.of("").toAbsolutePath().toString();;



    public static Logger logger = Logger.getLogger("Main");
    public static void main(String[] args) throws IOException {

        getLogger();

        logger.info("Start from main ");

        System.out.println("Start week exception and logging homework");
        System.out.println(Gender.whatIsValid());

        Student student1 = new Student();
        try {
            student1 = new Student("John", "Smith", 2004, 12, 31, "M", "5200412312224");
        }
        catch (InvalidCNPFormatException e )
        {
            logger.log(Level.SEVERE, e.toString(), e);
            //throw RuntimeException ;
        }
        Student student2= new Student("Ada", "Brown", 2003, 2, 11, "f", "8200302112557");
        Student student3= new Student("Iain", "Foster", 2003, 1, 11, "f", "7200302112557");
        Student student4= new Student("Iain", "Idol", 2028, 1, 11, "f", "7200302112557");
        System.out.println(student1);
        System.out.println(student2);

        StudentRepository sr = new StudentRepository();

        sr.addStudent(student1);
        sr.addStudent(student2);
        sr.addStudent(student3);
        sr.addStudent(student4);

        System.out.println("All students of 21 are" + sr.getAllStudentsAgeX(21));

        sr.listStudents();

       // System.out.println(sr.calculateAge(sr.getSr().get(0)));

    }

    private static void getLogger() throws IOException {
        System.out.println(logFile);
        String  fs = File.separator ;


        String path = "src"+fs+"main"+fs+"java"+fs+"org"+fs+"gmlpiton"+fs+"week9"+fs+"exceptlog"+fs+"logs";
        path  = FileSystems.getDefault().getPath("").toAbsolutePath() +fs +  path ;
        System.out.println(path + fs + "mylog.log");

        LogManager.getLogManager().reset();

        final FileHandler fileHandler = new FileHandler(path + fs + "mylog.log");
        SimpleFormatter formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);
        logger.addHandler(fileHandler);
        //Handler consoleHandler = new ConsoleHandler();
        //consoleHandler.setLevel(Level.FINE);
        //logger.addHandler(consoleHandler);
        logger.setLevel(Level.FINE);
        logger.info("Getting logger");
    }
}
