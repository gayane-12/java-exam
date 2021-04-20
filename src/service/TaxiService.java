package service;

import model.Taxi;

import java.util.Scanner;

public class TaxiService {
    public Taxi create() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter taxi's model");
        String model = s.next();

        System.out.println("Enter taxi's year");
        int year = s.nextInt();

        System.out.println("Enter taxi's cost");
        double cost = s.nextDouble();

        System.out.println("Enter taxi's country");
        String country = s.next();

        System.out.println("Enter taxi's millage");
        int millage = s.nextInt();

        System.out.println("Enter taxi's weight");
        int weight = s.nextInt();

        System.out.println("Enter taxi's topSpeed");
        int topSpeed = s.nextInt();

        System.out.println("Enter taxi's number of seats");
        int seats = s.nextInt();

        System.out.println("Is sport? y/n");
        boolean isSport = s.next().charAt(0) == 'y';

        Taxi newTaxi = new Taxi();
        newTaxi.setModel(model);
        newTaxi.setCost(cost);
        newTaxi.setYear(year);
        newTaxi.setCountry(country);
        newTaxi.setMillage(millage);
        newTaxi.setWeight(weight);
        newTaxi.setSport(isSport);
        newTaxi.setTopSpeed(topSpeed);
        newTaxi.setSeats(seats);

        return newTaxi;
    }

    public void printInfoDependingOfType(Taxi taxi) {
        System.out.println(taxi.isSport() ?
                "Cost: " + taxi.getCountry() + ", Top Speed: " + taxi.getTopSpeed()
                : "Model: " + taxi.getModel() + ", Country: " + taxi.getCountry());
    }

    public Taxi getTheNewer(Taxi firstTaxi, Taxi secondTaxi) {
        return firstTaxi.getYear() >= secondTaxi.getYear() ? firstTaxi : secondTaxi;
    }

    public void printCountryOfSmallestNumberOfSeats(Taxi firstTaxi, Taxi secondTaxi, Taxi thirdTaxi) {
        Taxi taxiWithSmallestNumberOfSeats = firstTaxi.getSeats() <= secondTaxi.getSeats() ? firstTaxi : secondTaxi;
        if (taxiWithSmallestNumberOfSeats.getSeats() > thirdTaxi.getSeats()) {
            taxiWithSmallestNumberOfSeats = thirdTaxi;
        }
        System.out.println(taxiWithSmallestNumberOfSeats.getCountry());
    }

    public void printAllNonSports(Taxi[] taxis) {
        for (Taxi taxi : taxis) {
            if (!taxi.isSport()) taxi.printInfo();
        }
    }

    public void printAllSportsWithMoreThan50000Millage(Taxi[] taxis) {
        for (Taxi taxi : taxis) {
            if (taxi.isSport() && taxi.getMillage() > 50000) taxi.printInfo();
        }
    }

    public Taxi getTaxiWithMinimalWeight(Taxi[] taxis) {
        Taxi taxiWithMinimalWeight = taxis[0];
        for (int i = 1; i < taxis.length; i++) {
            if (taxiWithMinimalWeight.getWeight() >= taxis[i].getWeight()) {
                taxiWithMinimalWeight = taxis[i];
            }
        }
        return taxiWithMinimalWeight;
    }

    public Taxi getSportTaxiWithMinimalCost(Taxi[] taxis) {
        int countOfSportTaxis = 0;
        for (int i = 1; i < taxis.length; i++) {
            if (taxis[i].isSport()) {
                countOfSportTaxis++;
            }
        }

        Taxi[] sportTaxis = new Taxi[countOfSportTaxis];
        int index = 0;
        for (Taxi taxi : taxis) {
            if (taxi.isSport()) {
                sportTaxis[index++] = taxi;
            }
        }

        Taxi taxiWithMinimalCost = sportTaxis[0];
        for (int i = 1; i < sportTaxis.length; i++) {
            if (taxiWithMinimalCost.getCost() > sportTaxis[i].getCost()) {
                taxiWithMinimalCost = sportTaxis[i];
            }
        }

        int countMinimals = 0;
        for (int i = 1; i < sportTaxis.length; i++) {
            if (taxis[i].getCost() == taxiWithMinimalCost.getCost()) {
                countMinimals++;
            }
        }

        Taxi[] minimals = new Taxi[countMinimals];
        int ind = 0;
        for (int i = 1; i < sportTaxis.length; i++) {
            if (taxis[i].getCost() == taxiWithMinimalCost.getCost()) {
                minimals[ind++] = taxis[i];
            }
        }

        return minimals.length>1?minimals[0]:taxiWithMinimalCost;
    }

    public void printTaxisOrderedByYearAsc(Taxi[] taxis) {
        int counterForLength = 1;
        boolean unsortedCasesExists = true;

        while (unsortedCasesExists) {
            unsortedCasesExists = false;
            for (int i = 0; i < taxis.length - counterForLength - 1; i++) {
                if (taxis[i].getYear() > taxis[i + 1].getYear()) {
                    Taxi temp = taxis[i];
                    taxis[i] = taxis[i + 1];
                    taxis[i + 1] = temp;
                    unsortedCasesExists = true;
                }
            }
            counterForLength++;
        }

        for (Taxi taxi : taxis) {
            taxi.printInfo();
        }

    }


}
