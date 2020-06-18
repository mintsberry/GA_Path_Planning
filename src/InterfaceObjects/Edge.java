package InterfaceObjects;

import java.io.IOException;
import java.util.List;

public class Edge {
    private String node1_ID;
    private String node2_ID;
    private double distance;
    private String id;

    public Edge(String node1_ID, String node2_ID, double distance, String id) {
        this.node1_ID = node1_ID;
        this.node2_ID = node2_ID;
        this.distance = distance;
        this.id = id;
    }

    public String getNode1ID() {
        return node1_ID;
    }

    public void setNode1ID(String node1_ID) {
        this.node1_ID = node1_ID;
    }

    public String getNode2ID() {
        return node2_ID;
    }

    public void setNode2ID(String node2_ID) {
        this.node2_ID = node2_ID;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
