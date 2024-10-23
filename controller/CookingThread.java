package controller;

import model.Chef;

public class CookingThread implements Runnable {
    private Chef chef;

    public CookingThread(Chef chef) {
        this.chef = chef;
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
        chef.setStatus("avaible");
        chef.setAvaible(true);
    }
}
