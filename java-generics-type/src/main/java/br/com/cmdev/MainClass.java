package br.com.cmdev;

import br.com.cmdev.domain.Bicycle;
import br.com.cmdev.domain.Car;
import br.com.cmdev.domain.Motorcycle;

public class MainClass {

    public static void main(String[] args) {
        var vehicles = new VehiclesGenerics<>();
        vehicles.addVehicles(new Car("Hyunday", "New Tucson", 2022, "White"));
        vehicles.addVehicles(new Motorcycle("Honda", "CB-1100", 2025, "Red"));
        vehicles.addVehicles(new Bicycle("Specialized", "Tarmac Expert", 2020, "Green Pearl", 22));
        vehicles.showVehicle();
    }
}
