package model;

import controller.CookingThread;
import controller.BuyThread;

import view.Template;

public class Chef {
    private int id;
    private int timeUntilAvaible;
    private String name;
    private String status;
    private boolean isAvaible;

    private static int count = 0;

    public Chef(String name) {
        this.id = count;
        this.name = name;
        this.timeUntilAvaible = 0;
        this.isAvaible = true;
        this.status = "avaible";
        count++;
    }

    public synchronized void cookMenu(int id, Restaurant restaurant, int quantity) {
        if (id >= restaurant.getMenuList().length || id < 0) {
            return;
        }
        for (int i = 0; i < restaurant.getMenuList()[id].getIngredients().length; i++) {
            if (restaurant.getIngredientList()[restaurant.getMenuList()[id].getIngredients()[i]].getQuantity() == 0) {
                Template.deleteElement();
                System.out.println("You don't have enough ingredients!");
                Template.deleteElement();
                return;
            }
            restaurant.getIngredientList()[restaurant.getMenuList()[id].getIngredients()[i]].setQuantity(
                    restaurant.getIngredientList()[restaurant.getMenuList()[id].getIngredients()[i]].getQuantity()
                            - quantity);
        }

        restaurant.getMenuList()[id].setQuantity(restaurant.getMenuList()[id].getQuantity() + quantity);

        // Set status and initialize cooking time
        setStatus("cooking " + restaurant.getMenuList()[id].getName());
        setAvaible(false);
        setTimeUntilAvaible(restaurant.getMenuList()[id].getCookingTime() * quantity);

        // Create a new thread to cook
        Thread cookingThread = new Thread(new CookingThread(this));
        cookingThread.start();
    }

    public void buyIngredient(int id, int quantity, Restaurant restaurant) {
        if (id >= restaurant.getIngredientList().length || id < 0) {
            return;
        }

        // Set status and initialize buying time
        setStatus("buying " + restaurant.getIngredientList()[id].getName());
        setAvaible(false);
        setTimeUntilAvaible(15000);

        Thread buyThread = new Thread(new BuyThread(this, restaurant, id, quantity));
        buyThread.start();
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
