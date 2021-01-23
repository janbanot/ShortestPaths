package edu.agh.ics.ip;

import java.util.*;

/**
 * This is a class with implemented Dijkstra algorithm for searching for shortest paths in a undirected, weighed graph
 * Along with printing shortest paths from a start vertex and printing a shortest path from start to end vertex
 */

public class Algorithms {

    public static void ShortestPaths(Graph graph, int startVertex, int endVertex) {

        int vertexCount = graph.getVertexCount();

        //storing distances of vertices removed from Queue
        float[] distances = new float[vertexCount];
        //storing predecessors ids of vertices removed from Queue
        int[] predecessors = new int[vertexCount];
        //set predecessors to -1 value, -1 means that it is a starting vertex
        Arrays.fill(predecessors, -1);

        //set up PQ with vertices
        PriorityQueue<Vertex> Q = new PriorityQueue<Vertex>();
        for (int i = 0; i < vertexCount; i++) {
            if (i != startVertex) Q.add(new Vertex(i));
        }

        //adding start vertex and setting its distance to self for 0
        Vertex node = new Vertex(startVertex);
        node.setDistance(0);
        Q.add(node);

        //go through all vertices
        while (!Q.isEmpty()) {
            //workaround for priority queue refreshing
            if(!Q.isEmpty()) {
                Q.add(Q.remove());
            }
            //using PQ property to get vertex with shortest distance
            Vertex u = Q.remove();
            distances[u.getId()] = u.getDistance();

            //iterate through all neighbours
            Iterator<Edge> it = graph.getNeighbours(u.getId()).iterator();
            while (it.hasNext()) {
                Edge e = it.next();
                Iterator<Vertex> it2 = Q.iterator();
                while (it2.hasNext()) {
                    Vertex v = it2.next();
                    //checking if vertex was already visited
                    if (e.getVertexB() != v.getId()) {
                        continue;
                    }
                    //distance checking
                    if (v.getDistance() > u.getDistance() + e.getWeight()) {
                        v.setDistance(u.getDistance() + e.getWeight());
                        v.setPredecessor(u);
                        predecessors[v.getId()] = v.getPredecessor().getId();
                    }
                }
            }
        }

        System.out.println("Dijkstra shortest paths from vertex " + startVertex +":");
        System.out.println("Vertex | Shortest Distance | Previous vertex");
        for (int i = 0; i < vertexCount; i++) {
            System.out.println(i + " | " + distances[i] + " | " + predecessors[i]);
        }

        System.out.println();
        System.out.println("Shortest path from " + startVertex + " to " + endVertex + ":");
        List<Integer> path = new ArrayList<Integer>();
        path.add(endVertex);
        int tmpVertex = endVertex;
        while (tmpVertex != startVertex) {
            path.add(predecessors[tmpVertex]);
            tmpVertex = predecessors[tmpVertex];
        }

        //print the path arr backwards to show to real path
        ListIterator li = path.listIterator(path.size());
        while (li.hasPrevious()) {
            System.out.print(li.previous());
            if (li.hasPrevious()) System.out.print(" -> ");
        }
        System.out.println();
    }
}
