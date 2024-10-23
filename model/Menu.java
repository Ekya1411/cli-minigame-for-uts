package model;

public class Menu {
    private int id;
    private String name;
    private int price;
    private int quantity;
    private int[] ingredients;
    private int cookingTime;

    private static int count = 0;

    public Menu(String name, int price, int[] ingredients, int cookingTime) {
        this.id = count;
        this.name = name;
        this.price = price;
        this.quantity = 0;
        this.ingredients = ingredients;
        this.cookingTime = cookingTime;
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

    public int[] getIngredients() {
        return ingredients;
    }

    // public String getIngredientList() {
    //     for (int i = 0; i < ingredients.length; i++) {
            
    //     }
    // }

    public int getCookingTime() {
        return cookingTime;
    }
}
