package br.com.cmdev;

import java.util.ArrayList;
import java.util.List;

public class VehiclesGenerics<T> {

    public VehiclesGenerics() {
        this.vehicles = new ArrayList<>();
    }

    private List<T> vehicles;

    public void addVehicles(T vehicle) {
        vehicles.add(vehicle);
    }

    public void showVehicle() {
        vehicles.forEach(System.out::println);
    }
}