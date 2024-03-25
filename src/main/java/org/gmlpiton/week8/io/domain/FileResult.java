package org.gmlpiton.week8.io.domain;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileResult {

    static String inputPath = "src/main/java/org/gmlpiton/week8/io/input/";

    public static List<UserResult> readFromFileBufferedTryWithResources(String input) throws IOException
    {

        List<UserResult> results= new ArrayList<>();
        File file = new File(   inputPath + input);
        Path path = file.toPath();
        System.out.println(path);

        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                UserResult ur = computeResultsFromResultLine(line);

                results.add(ur);
            }
        } catch (Exception e) {
            System.out.println("Cannot open results file");
            throw new IOException(e);
        }
        return results;
    }

    public static UserResult computeResultsFromResultLine(String result)
    {
        String[] fields = result.split(",");
        return new UserResult(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5], fields[6]);
    }
}
