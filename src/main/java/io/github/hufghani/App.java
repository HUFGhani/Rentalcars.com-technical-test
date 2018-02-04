package io.github.hufghani;

import io.github.hufghani.formatter.VehicleOutputFormat;
import io.github.hufghani.service.VehicleService;

import java.util.Scanner;

public class App {

    private static VehicleService vehicleService = new VehicleService();
    private static VehicleOutputFormat vehicleOutputFormat = new VehicleOutputFormat();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String userInput = "";
        boolean exit = true;

        for (; ; ) {
            if (exit) {
                System.out.println("__________________________________");
                System.out.println("1. Part 1");
                System.out.println("2. Part 2");
                System.out.println("0. Exit Program");
                System.out.println("__________________________________");

                userInput = scanner.nextLine();

                if (userInput.equals("1")) {
                    part1();
                } else if (userInput.equals("2")) {

                } else if (userInput.equals("0")) {
                    System.out.println("Exiting Program");
                    System.exit(0);
                    exit = false;
                } else {
                    System.out.println("please try again please");

                }
            }
        }
    }
    private static void part1() {
        System.out.println("----------------------------------------------------------------------");
        System.out.println("All vehicles in ascending price order:");
        System.out.println("----------------------------------------------------------------------");
        System.out.println(vehicleOutputFormat.formatPriceOrder(vehicleService.vehiclePriceOrder()));
        System.out.println("");

        System.out.println("----------------------------------------------------------------------");
        System.out.println("vehicles based on their SIPP:");
        System.out.println("----------------------------------------------------------------------");
        System.out.println(vehicleOutputFormat.formatVehicleSpecification(vehicleService.vehicleSpecification()));
        System.out.println("");

        System.out.println("----------------------------------------------------------------------");
        System.out.println("Highest supplier vehicle type in descending order:");
        System.out.println("----------------------------------------------------------------------");
        System.out.println(vehicleOutputFormat.formatSupplierRatingPerCarType(vehicleService.supplierRatingPerCarType()));
        System.out.println("");

        System.out.println("----------------------------------------------------------------------");
        System.out.println("Vehicles' score breakdown:");
        System.out.println("----------------------------------------------------------------------");
        System.out.println(vehicleOutputFormat.formatCalculateCombineScore(vehicleService.calculateCombineScore()));
        System.out.println("");
    }
}