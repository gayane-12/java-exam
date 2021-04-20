package model;

public class Taxi {
    private String model;
    private String country;
    private int year;
    private int millage;
    private boolean sport;
    private int weight;
    private int topSpeed;
    private int seats;
    private double cost;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model.isEmpty()) System.out.println("model must not be empty");
        else this.model = model;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if (country.isEmpty()) System.out.println("country must not be empty");
        else this.country = country;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year < 1903 || year > 2020) System.out.println("year must be from 1903 to 2020");
        else this.year = year;
    }

    public int getMillage() {
        return millage;
    }

    public void setMillage(int millage) {
        if (millage < 0 || millage > 999999) System.out.println("millage must be from 0 to 999999");
        else this.millage = millage;
    }

    public boolean isSport() {
        return sport;
    }

    public void setSport(boolean sport) {
        this.sport = sport;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if (weight < 1000 || weight > 3000) System.out.println("weight must be from 1000 KG to 3000 KG");
        else this.weight = weight;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        if (topSpeed < 0) System.out.println("speed must not be negative");
        else this.topSpeed = topSpeed;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        if (seats < 0) System.out.println("seats must not be negative");
        else this.seats = seats;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        if (cost < 0) System.out.println("cost must not be negative");
        else this.cost = cost;
    }

    public void printInfo() {
        System.out.printf("Model: %s, ", model);
        System.out.printf("Country: %s, ", country);
        System.out.printf("Year: %d, ", year);
        System.out.printf("Sport: %s, ", sport ? "Yes" : "No");
        System.out.printf("Cost: %.1f, ", cost);
        System.out.printf("Weight: %d, ", weight);
        System.out.printf("Millage: %d, ", millage);
        System.out.printf("Number of seats: %d, ", seats);
        System.out.printf("Top speed: %d, ", topSpeed);
    }
}
