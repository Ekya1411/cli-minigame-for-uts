package controller;

import model.Customer;
import model.Restaurant;

public class AutoGenerateCustomer implements Runnable {
    private Restaurant restaurant;

    public AutoGenerateCustomer(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        while (true) {
            int index = -1;

            index = checkAvaibleSeat();

            handleAddOutsideToInsideCustomer(index);

            index = checkAvaibleSeat();

            try {
                Thread.sleep(GameInitiation.generateRandomCustomerInterval());
                handleCustomerArrival(index);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public int checkAvaibleSeat() {
        for (int i = 0; i < restaurant.getSeatedCustomers().length; i++) {
            if (restaurant.getSeatedCustomers()[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public void handleCustomerArrival(int index) {
        synchronized (restaurant) {
            if (index < 0) {
                Customer cs = new Customer(GameInitiation.generateRandomName());
                restaurant.addWaitingOutsideCustomer(cs);
            } else {
                Customer cs = new Customer(index, GameInitiation.generateRandomName());
                restaurant.setSeatedCustomers(index, cs);
            }
        }
    }

    public void handleAddOutsideToInsideCustomer(int index) {
        synchronized (restaurant) {
            if (restaurant.getWaitingOutsideCustomer() != null && !restaurant.getWaitingOutsideCustomer().isEmpty()) {
                if (index >= 0 && index < restaurant.getSeatedCustomers().length) {
                    Customer cs = restaurant.getWaitingOutsideCustomer().poll();
                    restaurant.setSeatedCustomers(index, cs);
                }
            }
        }
    }

}