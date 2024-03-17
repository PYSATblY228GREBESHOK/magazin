import java.util.ArrayList;
import java.util.Scanner;

    class Purchase {
        private String fullName, email, phoneNumber;
        private String brand, model;
        private int quantity;

        public Purchase(String fullName, String email, String phoneNumber, String brand, String model, int quantity) {
            this.fullName = fullName;
            this.email = email;
            this.phoneNumber = phoneNumber;
            this.brand = brand;
            this.model = model;
            this.quantity = quantity;
        }

        public String toString() {
            return "\nФИО: " + fullName + "\nПочта: " + email + "\nНомер Телефона: " + phoneNumber +
                    "\nБренд: " + brand + "\nМодель: " + model + "\nКоличество: " + quantity;
        }
}

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] brand = {"Rolex", "Casio", "Baby-G", "Cartier"};
        String[] Marka = {"Datejust", "G-SHOCK", "Hello Kitty", "Cle de Cartier"};
        Object[][] products = new Object[brand.length][2];

        for (int i = 0; i < brand.length; i++) {
            products[i][0] = brand[i];
            products[i][1] = Marka[i];
        }

        ArrayList<Purchase> purchases = new ArrayList<>();

        boolean continueShopping = true;
        while (continueShopping) {
            Purchase purchase = createPurchase(products);
            purchases.add(purchase);

            System.out.println("Желаете продолжить покупки? \nда, нет?");
            String choice = scanner.nextLine();

            if (!choice.equalsIgnoreCase("да")) continueShopping = false;
        }
        displayOrders(purchases);
    }

    private static Purchase createPurchase(Object[][] products) {
        System.out.println("Введите ФИО:");
        String fullName = scanner.nextLine();
        System.out.println("Введите почту:");
        String email = scanner.nextLine();
        System.out.println("Введите номер телефона:");
        String phoneNumber = scanner.nextLine();

        availableProducts(products);
        System.out.println("Выберите бренд часов (введите номер):");
        int productIndex = Integer.parseInt(scanner.nextLine()) - 1;

        System.out.println("Введите количество часов:");
        int quantity = Integer.parseInt(scanner.nextLine());

        String brand = (String) products[productIndex][0];
        String model = (String) products[productIndex][1];

        return new Purchase(fullName, email, phoneNumber, brand, model, quantity);
    }

    private static void availableProducts(Object[][] products) {
        System.out.println("Доступные продукты в магазине:");
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i][0] + " - " + products[i][1]);
        }
    }

    private static void displayOrders(ArrayList<Purchase> purchases) {
        System.out.println("Информация о заказах:");
        for (Purchase purchase : purchases) {
            System.out.println(purchase);
            System.out.println();
        }
    }
}
