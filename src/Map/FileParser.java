package Map;

import MapObjects.Customer;
import MapObjects.Depot;
import MapObjects.Vehicle;

import java.io.IOException;
import java.util.List;

public interface FileParser {
    void parseFile(String fileName) throws IOException;

    List<Depot> getDepots();

    List<Customer> getCustomers();

    List<Vehicle> getVehicles();

    void assignCustomersToNearestDepot();

}
