package model;

public class Ingredient {
    private int id;
    private String name;
    private int quantity;
    private int price;

    private static int count = 0;

    public Ingredient(String name, int price) {
        this.id = count;
        this.name = name;
        this.quantity = 0;
        this.price = price;
        count++;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
