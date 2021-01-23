package edu.agh.ics.ip;

import static edu.agh.ics.ip.Algorithms.ShortestPaths;
import static edu.agh.ics.ip.IO.activateOutputToFile;
import static edu.agh.ics.ip.IO.graphFromFile;

public class Test {

    public static void main(String[] args) {

        //variable that decides if output should be printed to console or into a output file
        boolean outputToFile = false;
        String outputFilePath = "C:\\tmp\\testOutput.txt";
        String inputFilePath = "C:\\tmp\\testInput.txt";

        if (outputToFile) activateOutputToFile(outputFilePath);
        Graph g2 = graphFromFile(7, inputFilePath);

        //second method of graph input
//        Graph g = new Graph(7);
//        System.out.println();
//        System.out.println("Graph:");
//        g.addEdge(0, 1, 6);
//        g.addEdge(0, 3, 1);
//        g.addEdge(1, 3, 2);
//        g.addEdge(1,4,2);
//        g.addEdge(1,2,5);
//        g.addEdge(2, 4, 5);
//        g.addEdge(4, 3, 1);
//        g.addEdge(5, 2, 8);
//        g.addEdge(6, 5, 9);

        g2.printGraph();
        System.out.println();
        ShortestPaths(g2, 0, 5);


    }
}
