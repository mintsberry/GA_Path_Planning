package InterfaceObjects;

import GeneticAlgorithm.Individual;
import MapObjects.Customer;
import MapObjects.Depot;
import MapObjects.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Route {
    private Depot startDepot;
    private Depot endDepot;
    private List<Customer> route;

    public Route(Vehicle vehicle) {
        this.startDepot = vehicle.getStartDepot();
        this.endDepot = vehicle.getEndDepot();
        this.route = vehicle.getRoute();
    }

    public List<String> returnOneRoute(){
        List<String> routeID = new ArrayList<>();

        routeID.add(startDepot.getId());

        for(Customer customer : route)
            routeID.add(customer.getId());

        routeID.add(endDepot.getId());
        return routeID;
    }
}
