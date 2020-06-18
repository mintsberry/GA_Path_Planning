package Map;

import InterfaceObjects.Node;
import MapObjects.Customer;
import MapObjects.Depot;
import MapObjects.Vehicle;
import Utils.Utils;
import com.alibaba.fastjson.JSON;
import enums.NodeEnums;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Parses map file
 */
public class MapFileParser implements FileParser {
    private List<Depot> depots = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private List<Vehicle> vehicles = new ArrayList<>();

    /**
     * Parser map file
     * Assigns customers to nearest depot
     * @param fileName
     * @throws IOException
     */
    public MapFileParser(String fileName) throws IOException {//读取数据，并分配需求
        parseFile(fileName);
        assignCustomersToNearestDepot();
    }

    public MapFileParser(List<Node> node) {
        parseNode(node);
        assignCustomersToNearestDepot();
    }

    /**
     * Parses mapFile
     * @param fileName
     * @throws IOException
     */
    @Override
    public void parseFile(String fileName) throws IOException {//读取数据
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("resources/maps/" + fileName).getFile());
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        List<Node> nodes = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            String[] stringLineArr = line.trim().split("\\s+");
            int[] lineArr = Arrays.stream(stringLineArr).mapToInt(Integer::parseInt).toArray();
            switch (lineArr[0]){
                case 1:{//set customer information（id, x, y, loadDemand ）
//                    Customer customer = new Customer(Integer.toString(lineArr[1]),lineArr[2],lineArr[3],lineArr[4]);
//                    customers.add(customer);
                    nodes.add(new Node(lineArr[0], Integer.toString(lineArr[1]),lineArr[2],lineArr[3],lineArr[4]));
                }break;
                case 2:{//set depot information（id, x, y, longestDemand, maxLoad, MaxVehicle, Speed, MaxWorkTime, Unloading）
//                    Depot depot = new Depot(Integer.toString(lineArr[1]),lineArr[2],lineArr[3],lineArr[5],
//                            lineArr[6], lineArr[7],lineArr[8],lineArr[9],lineArr[10]);
                    nodes.add(new Node(lineArr[0],Integer.toString(lineArr[1]),lineArr[2],lineArr[3],lineArr[5],
                            lineArr[6], lineArr[7],lineArr[8],lineArr[9],lineArr[10]));
                }break;
            }
        }
        String s = JSON.toJSONString(nodes);
        System.out.println(s);
    }


    public void parseNode(List<Node> nodes) {//读取数据
        nodes.forEach(node -> {
            if (node.getNodeType() == NodeEnums.CUSTOMER.getType()) {
                Customer customer = new Customer(node.getNodeId(), node.getX(), node.getY(), node.getQuantityDemand());
                customers.add(customer);
            } else if (node.getNodeType() == NodeEnums.DEPOT.getType()) {
                Depot depot = new Depot(node.getNodeId(), node.getX(), node.getY(), node.getLongestDemand(), node.getMaxLoad(), node.getMaxVehicle(),
                        node.getSpeed(), node.getMaxWorkTime(), node.getUnloading());
                depots.add(depot);
            }
        });
    }
    /**
     * Assigns customers to nearest depot
     * Based on euclidean distance
     */
    @Override
    public void assignCustomersToNearestDepot() {
        Depot nearestDepot = null;
        for (Customer customer : customers) {
            double minimumDistance = Double.MAX_VALUE;
            for (Depot depot : depots) {
                double distance = Utils.euclideanDistance(customer.getX(), depot.getX(), customer.getY(), depot.getY());
                if (distance < minimumDistance) {
                    minimumDistance = distance;
                    nearestDepot = depot;
                }
            }
            if (nearestDepot == null) {
                throw new NullPointerException("Nearest Depot is not set");
            }
            nearestDepot.addCustomer(customer);
        }
    }

    @Override
    public List<Depot> getDepots() {
        return depots;
    }
    @Override
    public List<Customer> getCustomers() {
        return customers;
    }
    @Override
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

}
