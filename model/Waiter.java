package model;

import controller.CookingThread;
import controller.BuyThread;

import view.Template;

public class Waiter {
    private int id;
    private int timeUntilAvaible;
    private String name;
    private String status;
    private boolean isAvaible;

    private static int count = 0;

    public Waiter(String name) {
        this.id = count;
        this.name = name;
        this.timeUntilAvaible = 0;
        this.isAvaible = true;
        this.status = "avaible";
        count++;
    }

    public boolean isAvaible() {
        return isAvaible;
    }

    public void setAvaible(boolean isAvaible) {
        this.isAvaible = isAvaible;
    }

    public int getTimeUntilAvaible() {
        return timeUntilAvaible;
    }

    public void setTimeUntilAvaible(int timeUntilAvaible) {
        this.timeUntilAvaible = timeUntilAvaible;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public synchronized String getDetailedStatus() {
        return "\r" + (id + 1) + ". " + getName() + " : " + getStatus() + "(" + getTimeUntilAvaible() + "s)";
    }

    public String getName() {
        return name;
    }
}
