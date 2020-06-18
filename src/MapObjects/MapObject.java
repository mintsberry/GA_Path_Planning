package MapObjects;

import Utils.Utils;


public abstract class MapObject {

    private String NodeType;
    private String id;
    private int x;
    private int y;

    /**
     * Sets String id ,the x and y position of the depot or customer
     * @param x the x position
     * @param y the y position
     */
    MapObject(String id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    /**
     * Sets the x and y position of the vehicle
     * @param x the x position
     * @param y the y position
     */
    MapObject(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public abstract void render();

    /**
     * Calculates euclidean distance between two Customers
     * @param otherMapObject
     * @return
     */
    public double distance(MapObject otherMapObject) {//欧式距离计算
        return Utils.euclideanDistance(getX(), otherMapObject.getX(), getY(), otherMapObject.getY());
    }

    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public String getId() {
        return id;
    }
}
