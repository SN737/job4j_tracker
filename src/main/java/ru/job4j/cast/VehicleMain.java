package ru.job4j.cast;

public class VehicleMain {
    public static void main(String[] args) {
        Vehicle plane = new Plane();
        Vehicle bus = new Bus();
        Vehicle train = new Train();

        Vehicle[] vehicles = new Vehicle[]{plane, bus, train};
        for (Vehicle item : vehicles) {
            item.environment();
            item.move();
            System.out.println();
        }
    }
}
