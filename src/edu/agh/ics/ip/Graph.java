package edu.agh.ics.ip;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * This is a model to hold indirected, weighed graph informations.
 * Along with methods for adding, removing edges and printing the graph
 * */

public class Graph {

    private int vertexCount;
    private PriorityQueue<Edge>[] adjacency;

    public int getVertexCount() {
        return vertexCount;
    }

    public Graph(int vertexCount) {
        this.vertexCount = vertexCount;
        //initialize adjacency as PQ
        adjacency = new PriorityQueue[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            adjacency[i] = new PriorityQueue<Edge>();
        }
    }

    public void addEdge(int a, int b, float weight) {
        adjacency[a].add(new Edge(a, b, weight));
        adjacency[b].add(new Edge(b, a, weight));
    }

    public void addEdge(Edge e) {
        adjacency[e.getVertexA()].add(e);
    }

    public boolean containsEdge(Edge e) {
        return adjacency[e.getVertexA()].contains(e);
    }

    public void removeEdge(int a, int b) {
        Iterator<Edge> it = adjacency[a].iterator();
        Edge tmpEdge = new Edge(a, b, 0);

        while (it.hasNext()) {
            if (it.next().equals(tmpEdge)) it.remove();
        }
    }

    public PriorityQueue<Edge> getNeighbours(int vertex) {
        return adjacency[vertex];
    }

    public void printGraph() {
        for (int i = 0; i < vertexCount; i++) {
            PriorityQueue<Edge> edges = getNeighbours(i);
            Iterator<Edge> it = edges.iterator();
            System.out.print(i + ": ");
            for (int j = 0; j < edges.size(); j++) {
                System.out.print(it.next() + " ");
            }
            System.out.println();
        }
    }

}
