package io.github.hufghani;

import io.github.hufghani.formatter.VehicleOutputFormat;
import io.github.hufghani.service.VehicleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.Scanner;

@SpringBootApplication
@EnableConfigurationProperties
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
                    part2(args);
                    break;
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


    //Runs and displays part 1 tasks
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

    //Runs and displays part 2 task which is based on part 1
    private static void part2(String[] args) {
        SpringApplication.run(App.class,args);
    }
}