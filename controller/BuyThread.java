package controller;

import model.Chef;
import model.Restaurant;

public class BuyThread implements Runnable {
    private Chef chef;
    private Restaurant restaurant;
    private int id;
    private int quantity;

    public BuyThread(Chef chef, Restaurant restaurant, int id, int quantity) {
        this.chef = chef;
        this.restaurant = restaurant;
        this.id = id;
        this.quantity = quantity;
    }

    @Override
    public void run() {
        // Mengurangi waktu yang tersisa sampai chef tersedia
        while (chef.getTimeUntilAvaible() > 0) {
            try {
                Thread.sleep(1000); // Tidur selama 1 detik
                chef.setTimeUntilAvaible(chef.getTimeUntilAvaible() - 1000); // Kurangi waktu yang tersisa
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        // Setelah selesai memasak
        synchronized (restaurant){
            restaurant.getIngredientList()[id].setQuantity(restaurant.getIngredientList()[id].getQuantity() + quantity);
        }
        synchronized (chef){
            chef.setStatus("avaible");
            chef.setAvaible(true);
        }
    }
}
