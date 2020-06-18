package MapObjects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Should be visited once by a Vehicle
 * Contained in a Vehicle's route
 */
public class Customer extends MapObject {
    private String id;
    private double loadDemand; // 顾客的需求需求

    public Customer(String id, int x, int y, double loadDemand) {//mapFile的方式，timeDemand暂时不需要，为假数据
        super(id, x, y);
        this.id = id;
        this.loadDemand = loadDemand;
    }


    /**
     * Draws customer on canvas
     * Represented as a gray circle
     */
    @Override
    public void render() {

    }
    @Override
    public String getId() {
        return id;
    }
    @Override
    public String toString() {
        return id;
    }


    public double getLoadDemand() {
        return loadDemand;
    }



}
