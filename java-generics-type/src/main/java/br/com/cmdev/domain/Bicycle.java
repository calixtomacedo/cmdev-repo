package br.com.cmdev.domain;

public class Bicycle {
    // Bicycle attributes
    private String brand;
    private String model;
    private int year;
    private String color;
    private int gears;

    // Constructor
    public Bicycle(String brand, String model, int year, String color, int gears) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.gears = gears;
    }

    // Getter and Setter methods
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getGears() {
        return gears;
    }

    public void setGears(int gears) {
        this.gears = gears;
    }

    // Method to display bicycle information
    public void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Color: " + color);
        System.out.println("Gears: " + gears);
    }

    // toString method
    @Override
    public String toString() {
        return "Bicycle {" +
                "brand = " + brand +
                ", model = " + model +
                ", year = " + year +
                ", color = " + color +
                ", gears = " + gears +
                '}';
    }
}
