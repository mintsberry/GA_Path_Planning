package MapObjects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.ArrayList;
import java.util.List;

/**
 * Customer's are assigned to closest Depot
 * Each depot is given m Vehicles
 */
public class Depot extends MapObject {
    private String id;// ID
    private double maxDuration; // D: maximum duration of a route 最大路程限制
    private int maxLoad; // Q: allowed maximum load of a vehicle 汽车最大载重（有效）
    private int maxVehicles; // m: deport the maximum number of vehicles
    private double speed;//S: allowed speed of vehicle
    private double workTime;//T：allowed workTime of vehicle
    private double unloadTime;// uT：allowed uploading time of vehicle

    private List<Customer> customers;// 储存其中的顾客

    //id，里程限制，载重限制，最大车辆数
    public Depot(String id, double maxDuration, int maxLoad, int maxVehicles) {
        super(id, 0, 0);
        this.id = id;
        this.customers = new ArrayList<>();
        this.maxDuration = maxDuration;
        this.maxLoad = maxLoad;
        this.maxVehicles = maxVehicles;
        //默认车速10h/km，限制车辆时间8h，设置车辆每次卸货用时
        this.speed = 10;
        this.workTime = 8.0;//8h
        this.unloadTime = 5/60;//5min，单位h
    }

    //x，y坐标，id，里程限制，载重限制，最大车辆数，车辆速度，工作时间限制
    public Depot( String id, int x, int y, double maxDuration, int maxLoad, int maxVehicles, double speed,
                 double workTime, double unloadTime) {
        super(id, x, y);
        this.id = id;
        this.customers = new ArrayList<>();
        this.maxDuration = maxDuration;
        this.maxLoad = maxLoad;
        this.maxVehicles = maxVehicles;
        this.speed = speed;//传入speed，单位km/h
        this.workTime = workTime;//单位h
        this.unloadTime = unloadTime;
    }


    @Override
    public void render() {

    }
    @Override
    public String getId() {
        return id;
    }

    public double getMaxDuration() {
        return maxDuration;
    }
    public int getMaxLoad() {
        return maxLoad;
    }
    public int getMaxVehicles() {
        return maxVehicles;
    }
    public double getSpeed() {
        return speed;
    }
    public double getWorkTime() {
        return workTime;
    }
    public double getUnloadTime() {
        return unloadTime;
    }

    public List<Customer> getCustomers() {
        return customers;
    }
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }


}
