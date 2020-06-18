package Map;

import InterfaceObjects.Node;
import MapObjects.Customer;
import MapObjects.Depot;
import MapObjects.Vehicle;

import java.io.IOException;
import java.util.List;

/**
 * Map is a visual representation of the map file
 * Draws Depots and Customers on Canvas
 */
public class Map {
    private List<Depot> depots; // All depots in map
    private List<Customer> customers; // All customers in map
    private List<Vehicle> vehicles; // All vehicles in map

    /**
     * Creates mapParser which creates Objects (Depots, Customers, Vehicles) from file
     * Retrieves Objects back to class
     * @param fileName
     * @throws IOException
     */
    public Map(String fileName) throws IOException {
        MapFileParser mapFileParser = new MapFileParser(fileName);
        this.depots = mapFileParser.getDepots();
        this.customers = mapFileParser.getCustomers();
        this.vehicles = mapFileParser.getVehicles();
    }

    public Map(List<Node> node) throws IOException {
        MapFileParser mapFileParser = new MapFileParser(node);
        this.depots = mapFileParser.getDepots();
        this.customers = mapFileParser.getCustomers();
        this.vehicles = mapFileParser.getVehicles();
    }


    public void render() {

    }

    private void renderDepots() {

    }

    public int getDepotsSize() {
        return depots.size();
    }

    public int getVehiclesSize() {
        return vehicles.size();
    }

    public int getCustomersSize() {
        return customers.size();
    }

    public List<Depot> getDepots() {
        return depots;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }
}
