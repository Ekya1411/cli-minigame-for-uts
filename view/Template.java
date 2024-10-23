package view;

import model.Restaurant;

public class Template {

    // general template
    public static void welcomeTemplate() {
        deleteElement();
        System.out.println("This game will automaticly started");
        deleteElement();
        for (int i = 3; i > -1; i--) {
            System.out.print("\rStarting game in " + i);
            try {
                // Thread.sleep(1000);
            } catch (Exception e) {
                // TODO: handle exceptionASD
            }
        }

        deleteElement();

        System.out.println(" *     *     *   *****   *         *****      *****     *       *   *****  ");
        System.out.println(" *     *     *   *       *       *          *       *   *  * *  *   *      ");
        System.out.println(" *     *     *   *****   *       *          *       *   *   *   *   *****  ");
        System.out.println(" *     *     *   *       *       *          *       *   *   *   *   *      ");
        System.out.println("  *****  ****    *****    *****    *****      *****     *   *   *   *****  ");

        deleteElement();
    }

    public static void homeOption() {
        System.out.println("=====================================");
        System.out.println("============= Main Menu =============");
        System.out.println("1. Go to the kitchen");
        System.out.println("2. Go to the dining area");
        System.out.println("3. End Game");
        System.out.println("=====================================");
        System.out.print("Your option (1-3) : ");

    }

    public static void deleteElement() {
        // try {
        // Thread.sleep(1000);
        // } catch (InterruptedException e) {
        // e.printStackTrace();
        // }

        // System.out.print("\033[H\033[2J");
    }

    // Menu & Ingredient List
    public void menuList(Restaurant restaurant) {
        System.out.println("=====================================");
        System.out.println("=========== Menu List ===============");
        for (int i = 0; i < restaurant.getMenuList().length; i++) {
            int[] ingredientList = restaurant.getMenuList()[i].getIngredients();
            StringBuilder ingredient = new StringBuilder("("); // Menggunakan StringBuilder untuk efisiensi
            for (int j = 0; j < ingredientList.length; j++) {
                // Menambahkan nama bahan dari ingredientList ke dalam StringBuilder
                ingredient.append(restaurant.getIngredientList()[ingredientList[j]].getName());
                
                ingredient.append("(");
                ingredient.append(restaurant.getIngredientList()[ingredientList[j]].getQuantity());
                ingredient.append(")");
                // Menambahkan koma sebagai pemisah jika bukan bahan terakhir
                if (j < ingredientList.length - 1) {
                    ingredient.append(", ");
                }
            }
            ingredient.append(")");
            System.out.println((i + 1) + ". " + restaurant.getMenuList()[i].getName() + " - "
                    + restaurant.getMenuList()[i].getQuantity() + " pcs" + " - "
                    + ingredient.toString());

        }
        System.out.println("0. Back");
    }

    public void ingredientList(Restaurant restaurant) {
        System.out.println("=====================================");
        System.out.println("========= Ingredient List ==========");
        for (int i = 0; i < restaurant.getIngredientList().length; i++) {
            System.out.println((i + 1) + ". " + restaurant.getIngredientList()[i].getName() + " - "
                    + restaurant.getIngredientList()[i].getQuantity() + " pcs");
        }
        System.out.println("0. Back");
    }

    // Waiter template
    public void diningAreaOption() {
        System.out.println("=====================================");
        
        System.out.println("=========== Dining Area =============");
        System.out.println("1. Serve customer");
        System.out.println("2. Give customer order");
        System.out.println("0. Back");
        System.out.println("=====================================");
        System.out.print("Your option : ");
    }

    // Chef template
    public void kitchenOption(Restaurant restaurant) {
        System.out.println("=====================================");
        System.out.println("- - - - - - Chef Status - - - - - - -");
        for (int i = 0; i < restaurant.getChefList().length; i++) {
            System.out.println("\r" + restaurant.getChefList()[i].getDetailedStatus());
        }
        System.out.println("- - - - - - Kitchen Menu - - - - - - -");
        System.out.println("1. Cook/check available Menu");
        System.out.println("2. Buy/check Ingredient");
        System.out.println("0. Back");
        System.out.println("=====================================");
        System.out.print("Your option : ");
    }
}