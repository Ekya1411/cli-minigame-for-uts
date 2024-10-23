package controller;

import java.util.Random;

import model.*;

public class GameInitiation {

    // this section is for object instantiation and data insertion

    public static Restaurant initiateRestaurant() {
        return new Restaurant(
                "Halalun Burjer",
                10,
                initiateIngredient(),
                initiateMenu(),
                initiateChef(),
                initiateWaiter());
    }

    public static Chef[] initiateChef() {
        return new Chef[] {
                new Chef("Mahmud"),
                new Chef("Abdul"),
        };
    }

    public static Waiter[] initiateWaiter() {
        return new Waiter[] {
                new Waiter("Abu Bakr"),
                new Waiter("Ahmed"),
        };
    }

    public static Ingredient[] initiateIngredient() {
        return new Ingredient[] {
                new Ingredient("Chicken", 3000),
                new Ingredient("Bread", 500),
                new Ingredient("Beef", 5000),
                new Ingredient("Fish", 2500),
                new Ingredient("Pork", 4500),
                new Ingredient("Rice", 1000),
                new Ingredient("Noodles", 2000),
                new Ingredient("Egg", 1000),
                new Ingredient("Potato", 2000),
                new Ingredient("Cucumber", 1500),
                new Ingredient("Carrot", 1500),
                new Ingredient("Onion", 500),
                new Ingredient("Tomato", 700),
                new Ingredient("Cabbage", 500),
                new Ingredient("Ice Cube", 600),
                new Ingredient("Cola", 5000),
                new Ingredient("Lemon", 100),
                new Ingredient("Orange", 300)
        };
    }

    public static Menu[] initiateMenu() {
        return new Menu[] {
                new Menu("Chicken Burger", 30000, new int[] { 0, 1, 11, 12, 13 }, 15000), // 15 detik
                new Menu("Beef Burger", 40000, new int[] { 2, 1, 11, 12, 13 }, 18000), // 18 detik
                new Menu("Fish Burger", 25000, new int[] { 3, 1, 11, 12, 13 }, 12000), // 12 detik
                new Menu("Pork Burger", 45000, new int[] { 4, 1, 11, 12, 13 }, 20000), // 20 detik
                new Menu("Rice", 10000, new int[] { 5 }, 10000), // 10 detik
                new Menu("Noodle Burger", 20000, new int[] { 6, 1, 11, 12, 13 }, 15000), // 15 detik
                new Menu("Egg Burger", 10000, new int[] { 7, 1, 11, 12, 13 }, 8000), // 8 detik
                new Menu("Potato Burger", 20000, new int[] { 8, 1, 11, 12, 13 }, 15000), // 15 detik
                new Menu("Ice Cola", 15000, new int[] { 15, 14 }, 5000), // 5 detik
                new Menu("Ice Lemon", 13500, new int[] { 16, 14 }, 5000), // 5 detik
                new Menu("Ice Orange", 10000, new int[] { 17, 14 }, 5000) // 5 detik
        };
    }

    public static String generateRandomName() {
        final String[] firstNameList = {
                "Ahmed", "Ali", "Amira", "Amina", "Hassan", "Fatima", "Khalid", "Layla",
                "Mohammed", "Sara", "Omar", "Nadia", "Ibrahim", "Zainab", "Yusuf", "Huda",
                "Rami", "Samira", "Salim", "Jasmine", "Laila", "Noor", "Sami", "Yasmin",
                "Fahad", "Aisha", "Zayd", "Hana", "Ranya", "Mariam", "Walid", "Maha",
                "Anwar", "Ranya", "Nabil", "Rania", "Tariq", "Zara", "Lina", "Khalida",
                "Bilal", "Rashid", "Rami", "Dalia", "Zahra", "Samir", "Nour", "Asim",
                "Dina", "Aseel"
        };

        final String[] lastNameList = {
                "Al-Farsi", "Al-Mansoori", "Al-Zahrani", "Al-Otaibi", "Al-Hashimi",
                "Al-Khalifa", "Al-Saleh", "Al-Hamadi", "Al-Jabari", "Al-Qasim",
                "Al-Muhtadi", "Al-Said", "Al-Aziz", "Al-Muhtar", "Al-Hassan",
                "Al-Mahmoud", "Al-Badawi", "Al-Din", "Al-Sharif", "Al-Jabir",
                "Al-Naqi", "Al-Majid", "Al-Hadi", "Al-Fahd", "Al-Amin",
                "Al-Nasr", "Al-Ansari", "Al-Bukhari", "Al-Ghamdi", "Al-Khayyat",
                "Al-Mahdi", "Al-Rashid", "Al-Masri", "Al-Sultan", "Al-Rajhi",
                "Al-Dhaheri", "Al-Hamza", "Al-Muhajir", "Al-Shahrani", "Al-Qudsi",
                "Al-Farouq", "Al-Jasmi", "Al-Sahrawi", "Al-Mujahid", "Al-Basri"
        };

        Random random = new Random();
        String firstName = firstNameList[random.nextInt(firstNameList.length)];
        String lastName = lastNameList[random.nextInt(lastNameList.length)];

        return firstName + " " + lastName;
    }

    // this section is for generate random number

    public static int generateRandomCustomerInterval() {
        return new Random().nextInt(15001);
    }
}
