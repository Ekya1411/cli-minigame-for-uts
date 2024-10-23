package controller;

import model.Restaurant;
import view.Template;

import java.util.Scanner;

public class Controller {

    static Restaurant restaurant = GameInitiation.initiateRestaurant();
    AutoGenerateCustomer generateCustomer = new AutoGenerateCustomer(restaurant);
    static Scanner scanner = new Scanner(System.in);
    Template template = new Template();

    public void start() {
        Thread generateCustomerThread = new Thread(generateCustomer);
        generateCustomerThread.start();
        Template.welcomeTemplate();

        home();
    }


    public void home() {
        Template.deleteElement();
        Template.homeOption();
        int pointer = scanner.nextInt();
        Template.deleteElement();
        switch (pointer) {
            case 1:
                kitchen();
                break;
            case 2:
                diningArea();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                Template.deleteElement();
                System.out.println("Invalid input!");
                Template.deleteElement();
                home();
                break;
        }
    }

    // For Chef
    public void kitchen() {
        template.kitchenOption(restaurant);
        int pointer = scanner.nextInt();
        Template.deleteElement();
        switch (pointer) {
            case 1:
                checkAvailableChefToCook();
                break;
            case 2:
                checkAvailableChefToBuyIngredient();
                break;
            case 0:
                home();
                break;
            default:
                Template.deleteElement();
                System.out.println("Invalid input!");
                Template.deleteElement();
                kitchen();
                break;
        }
    }

    public void checkAvailableChefToCook() {
        boolean chefAvailable = false;

        for (int i = 0; i < restaurant.getChefList().length; i++) {
            if (restaurant.getChefList()[i].isAvaible() == true) {
                chefAvailable = true;
                template.menuList(restaurant);
                System.out.println("=====================================");
                System.out.println("Enter the menu number you want to cook");
                System.out.print("Your option: ");
                int pointer = scanner.nextInt();
                if (pointer == 0) {
                    kitchen();
                }
                System.out.println("Enter the quantity you want to cook: ");
                int quantity = scanner.nextInt();
                restaurant.getChefList()[i].cookMenu(pointer - 1, restaurant, quantity);
                break;
            }
        }

        if (!chefAvailable) {
            Template.deleteElement();
            System.out.println("No chefs available at the moment!");
            Template.deleteElement();
        }

        kitchen();
    }

    public void checkAvailableChefToBuyIngredient() {
        boolean chefAvailable = false;

        for (int i = 0; i < restaurant.getChefList().length; i++) {
            if (restaurant.getChefList()[i].isAvaible() == true) {
                chefAvailable = true;
                template.ingredientList(restaurant);
                System.out.println("=====================================");

                System.out.println("Enter the ingredient number you want to buy");
                System.out.print("Your option: ");
                int pointer = scanner.nextInt();
                if (pointer == 0) {
                    kitchen();
                }
                System.out.print("Enter the quantity you want to buy: ");
                int quantity = scanner.nextInt();
                restaurant.getChefList()[i].buyIngredient(pointer - 1, quantity, restaurant);
                break;
            }
        }

        if (!chefAvailable) {
            Template.deleteElement();
            System.out.println("No chefs available at the moment!");
            Template.deleteElement();
        }

        kitchen();
    }

    // For Waiter
    public void diningArea() {
        
    }

}