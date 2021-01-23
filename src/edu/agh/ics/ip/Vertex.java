package edu.agh.ics.ip;

/**
 * This is a model to hold indirected, weighed graph's vertex informations
 */

public class Vertex implements Comparable{

    private int id;
    private float distance;
    private Vertex predecessor;

    public Vertex(){
        distance = Float.MAX_VALUE; //simulate infinity
        predecessor = null;
    }

    public Vertex(int id) {
        this.id = id;
        distance = Float.MAX_VALUE; //simulate infinity
        predecessor = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    @Override
    public int compareTo(Object o) {
        Vertex otherVertex = (Vertex) o;
        return Double.compare(this.distance, otherVertex.distance);
    }
}
