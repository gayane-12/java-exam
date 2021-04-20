package main;

import model.Taxi;
import service.TaxiService;

import java.util.Scanner;

public class TaxiTest {
    public static void main(String[] args) {
        TaxiService taxiService = new TaxiService();
        Taxi taxiOne = taxiService.create();
        Taxi taxiTwo = taxiService.create();
        Taxi taxiTree = taxiService.create();
        Taxi[] taxis = {taxiOne, taxiTwo, taxiTree};

        Scanner in = new Scanner(System.in);
        System.out.println("Enter task number");
        System.out.println("Task 1. print cost and topSpeed if the taxi is sport otherwise print model and country");
        System.out.println("Task 2. return the Taxi which one is newer (if they have the same age return first one).");
        System.out.println("Task 3. print country of the Taxi with smallest seats count (if they have the same - print first)");
        System.out.println("Task 4. print all not sport Taxis.");
        System.out.println("Task 5. print all sport Taxis which were road more than 50000 km (millage)");
        System.out.println("Task 6. return the Taxi with minimal weight (if there are some of them return last one).");
        System.out.println("Task 7. return the Taxi with minimal cost from all sport Taxis (if there are some of them return first one)");
        System.out.println("Task 8. print Taxi in ascending form order by year");

        int taskNumber = in.nextInt();

        switch (taskNumber) {
            case 1:
                taxiService.printInfoDependingOfType(taxiOne);
                break;
            case 2:
                taxiService.getTheNewer(taxiOne, taxiTwo);
                break;
            case 3:
                taxiService.printCountryOfSmallestNumberOfSeats(taxiOne, taxiTwo, taxiTree);
                break;
            case 4:
                taxiService.printAllNonSports(taxis);
                break;
            case 5:
                taxiService.printAllSportsWithMoreThan50000Millage(taxis);
                break;
            case 6:
                taxiService.getTaxiWithMinimalWeight(taxis);
                break;
            case 7:
                taxiService.getSportTaxiWithMinimalCost(taxis);
                break;
            case 8:
                taxiService.printTaxisOrderedByYearAsc(taxis);
                break;
            default:
                System.err.println("Unrecognized option");
                break;
        }
    }
}
