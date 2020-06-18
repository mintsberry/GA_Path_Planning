package InterfaceObjects;

public class Node {
    private int nodeType;
    private String nodeId;
    private int x;
    private int y;
    private double quantityDemand; // the quantityDemond in one customer
    private double longestDemand; // the longestDemand in one depot
    private int maxLoad; // one vehicle capacity
    private int maxVehicle; // the number of vehicle

    private double speed; // the speed of vehicles in one depot
    private double maxWorkTime;
    private double unloading; // the time of unloading

    public Node(int nodeType, String nodeId, int x, int y, double quantityDemand) {
        this.nodeType = nodeType;
        this.nodeId = nodeId;
        this.x = x;
        this.y = y;
        this.quantityDemand = quantityDemand;
    }

    public Node(int nodeType, String nodeId, int x, int y, double longestDemand, int maxLoad, int maxVehicle, double speed, double maxWorkTime, double unloading) {
        this.nodeType = nodeType;
        this.nodeId = nodeId;
        this.x = x;
        this.y = y;
        this.longestDemand = longestDemand;
        this.maxLoad = maxLoad;
        this.maxVehicle = maxVehicle;
        this.speed = speed;
        this.maxWorkTime = maxWorkTime;
        this.unloading = unloading;
    }

    public Node(int nodeType, String nodeId, int x, int y, double quantityDemand, double longestDemand, int maxLoad,
                int maxVehicle, double speed, double maxWorkTime, double unloading) {
        this.nodeType = nodeType;
        this.nodeId = nodeId;
        this.x = x;
        this.y = y;
        this.quantityDemand = quantityDemand;
        this.longestDemand = longestDemand;
        this.maxLoad = maxLoad;
        this.maxVehicle = maxVehicle;
        this.speed = speed;
        this.maxWorkTime = maxWorkTime;
        this.unloading = unloading;
    }

    public int getNodeType() {
        return nodeType;
    }

    public void setNodeType(int nodeType) {
        this.nodeType = nodeType;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public double getQuantityDemand() {
        return quantityDemand;
    }

    public void setQuantityDemand(double quantityDemand) {
        this.quantityDemand = quantityDemand;
    }

    public double getLongestDemand() {
        return longestDemand;
    }

    public void setLongestDemand(double longestDemand) {
        this.longestDemand = longestDemand;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getUnloading() {
        return unloading;
    }

    public void setUnloading(double unloading) {
        this.unloading = unloading;
    }

    public int getMaxLoad() {
        return maxLoad;
    }

    public void setMaxLoad(int maxLoad) {
        this.maxLoad = maxLoad;
    }

    public int getMaxVehicle() {
        return maxVehicle;
    }

    public void setMaxVehicle(int maxVehicle) {
        this.maxVehicle = maxVehicle;
    }

    public double getMaxWorkTime() {
        return maxWorkTime;
    }
}
