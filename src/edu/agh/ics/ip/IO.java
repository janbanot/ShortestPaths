package edu.agh.ics.ip;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class with method for handling Input and Output operations such as:
 *  - activating output to file
 *  - creating output file
 *  - reading input file
 *  - readig graph from file
 */

public class IO {

    //filePath like: "C:\\tmp\\filename.txt"
    public static void activateOutputToFile(String outputFilePath) {
            try {
                IO.createFile(outputFilePath);
                PrintStream fileStream = new PrintStream(outputFilePath);
                System.setOut(fileStream);
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }
    }

    public static void createFile(String filePath) {
        try {
            File outputFile = new File(filePath);
            if (outputFile.createNewFile()) {
                System.out.println("File has been successfully created");
            } else {
                System.out.println("File already exist");
            }
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    public static List<String> readFile(String filePath) {
        List<String> input = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while (line != null) {
                input.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return input;
    }

    //TO DO: change implementation to remove graphSize parameter
    public static Graph graphFromFile(int graphSize, String inputFilePath) {
        List<String> input = IO.readFile(inputFilePath);
        Graph g = new Graph(graphSize);
        for (String line : input) {
            String[] elements = line.split(";");
            g.addEdge(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]), Integer.parseInt(elements[2]));
        }
        return g;
    }
}
