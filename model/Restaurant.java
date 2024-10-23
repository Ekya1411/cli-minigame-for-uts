package model;
import java.util.LinkedList;
import java.util.Queue;

public class Restaurant {
    private String name;
    private int money;
    private int table;
    private int rating;

    private static int totalCustomer = 0;

    private Ingredient [] ingredientList;
    private Menu [] menuList;
    private Chef [] chefList;
    private Waiter [] waiterList;

    private Customer [] seatedCustomers;
    private Queue <Customer> waitingOutsideCustomers;

    public Restaurant(String name, int table, Ingredient [] ingredientList, Menu [] menuList , Chef [] chefList, Waiter [] waiterList) {
        this.name = name;
        this.money = 1000000;
        this.table = table;
        this.rating = 0;

        this.ingredientList = ingredientList;
        this.menuList = menuList;
        this.chefList = chefList;
        this.waiterList = waiterList;

        this.seatedCustomers = new Customer[table];

        this.waitingOutsideCustomers = new LinkedList<>();
    }
    
    public void addWaitingOutsideCustomer(Customer cs) {
        this.waitingOutsideCustomers.add(cs);
    }

    public Queue <Customer> getWaitingOutsideCustomer() {
        return waitingOutsideCustomers;
    }

    public Customer[] getSeatedCustomers() {
        return seatedCustomers;
    }

    public void setSeatedCustomers(int index, Customer cs) {
        this.seatedCustomers [index]= cs;
    }

    public synchronized Chef[] getChefList() {
        return chefList;
    }

    public Menu[] getMenuList() {
        return menuList;
    }

    public Ingredient[] getIngredientList() {
        return ingredientList;
    }
}   
