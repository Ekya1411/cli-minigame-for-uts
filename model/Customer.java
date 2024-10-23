package model;
import java.util.Map;
import java.util.Random;

public class Customer {
    private int id;
    private int patienceLevel;
    private String name;
    private String status;
    private Map <Integer, Integer> orders;

    // for customer that has a table
    public Customer(int id, String name) {
        this.id = id;
        this.patienceLevel = generatePatienceLevel();
        this.name = name;
        this.status = "free";
    }

    // for waiting in outside customer
    public Customer(String name) {
        this.patienceLevel = generatePatienceLevel();
        this.name = name;
        this.status = "free";
    }

    public void startWaitingService() {
        this.status = "waiting service";
    }

    public void startWaitingFood() {
        this.status = "waiting food";
    }

    public void startEating() {

    }

    public String getStatus() {
        return status;
    }

    public int generatePatienceLevel() {
        return new Random().nextInt(15001) + 15000;
    }
}
