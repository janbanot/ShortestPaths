package edu.agh.ics.ip;

/**
 * This is a model to hold indirected, weighed graph's edge informations
 */

public class Edge implements Comparable{

    private int vertexA;
    private int vertexB;
    private float weight;

    public Edge (int vertexA, int vertexB, float weight) {
        this.vertexA = vertexA;
        this.vertexB = vertexB;
        this.weight = weight;
    }

    public int getVertexA() {
        return vertexA;
    }

    public int getVertexB() {
        return vertexB;
    }

    public float getWeight() {
        return weight;
    }

    public boolean equals(Edge otherEdge) {
        if (this.vertexA == otherEdge.vertexA && this.vertexB == otherEdge.vertexB) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public int compareTo(Object o) {
        Edge otherEdge = (Edge) o;
        return Double.compare(this.weight, otherEdge.weight);
    }

    public String toString() {
        return vertexA + " -- " + vertexB + " (" + weight + "); ";
    }
}
