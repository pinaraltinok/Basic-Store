import java.util.Scanner;

public class BasicStore {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double total = 0;
        int custom1 = 0;
        int custom2 = 0;
        int quantity1 = 0;
        int quantity2 = 0;

        System.out.println("***** Store Inventory *****");
        // Getting the name, quantity, price of the first product

        System.out.print("Enter the name of product 1: ");
        String product1 = input.nextLine();
        product1 = product1.substring(0,1).toUpperCase() + product1.substring(1).toLowerCase();
        System.out.printf("Enter the number of %s we have: ", product1);
        quantity1 += input.nextInt();
        if (quantity1 < 0){
            System.out.println("ERROR: Value cannot be negative. Exiting!..");
            return;
        }
        System.out.print("Enter the price: ");
        double price1 = input.nextDouble();
        if (price1 < 0){
            System.out.println("ERROR: Value cannot be negative. Exiting!..");
            return;
        }

        // Getting the name, quantity, price of the second product
        System.out.print("Enter the name of product 2: ");
        String product2 = input.next();
        product2 = product2.substring(0,1).toUpperCase() + product2.substring(1).toLowerCase();
        System.out.printf("Enter the number of %s we have: ", product2);
        quantity2 += input.nextInt();
        if (quantity2 < 0){
            System.out.println("ERROR: Value cannot be negative. Exiting!..");
            return;
        }
        System.out.print("Enter the price: ");
        double price2 = input.nextDouble();
        if (price2 < 0){
            System.out.println("ERROR: Value cannot be negative. Exiting!..");
            return;
        }

        // User Interface loop
        System.out.println("***** Customer User Interface *****");
        while(true){
            System.out.println("Welcome to our store. We have the following." + "Please enter what you would like:");
            System.out.printf("1 - %s %n" +
                    "2 - %s %n" +
                    "0 - to check-out%n", product1, product2);

            int choice = input.nextInt();

            // Selection menu
            if (choice == 1) {
                System.out.printf("How many %s would yo like %n", product1);
                custom1 = input.nextInt();
                if (custom1 > quantity1)
                    System.out.println("We do not have that many remaining!");
                else if (custom1 < 0)
                    System.out.println("Invalid requested amount!");
                else {
                    total += (price1 * custom1);
                    quantity1 -= custom1;
                }
            }
            else if (choice == 2){
                System.out.printf("How many %s would you like %n", product2);
                custom2 = input.nextInt();
                if (custom2 > quantity2)
                    System.out.println("We do not have that many remaining!");
                else if (custom2 < 0)
                    System.out.println("Invalid requested amount!");
                else {
                    total += (price2 * custom2);
                    quantity2 -= custom2;
                }
            }
            else if (choice == 0)
                break;
            else
                System.out.println("Invalid menu option.");



        }
        // Calculating the prices
        System.out.println("***** Customer Total *****");
        System.out.printf("%s - %d X %.2f = %.2f", product1, custom1, price1, (custom1 * price1));
        System.out.printf("%n%s - %d X %.2f = %.2f %n", product2, custom2, price2, (custom2 * price2));
        System.out.println("--------------------------");
        System.out.printf("Total due - %.2f %n %n", total);

        // Final report of what's remaining
        System.out.println("***** Final Report *****");
        System.out.printf("We now have the remaining amounts of our products:%n" +
                "%s - %d %n" +
                "%s - %d", product1, quantity1, product2, quantity2);


    }
}
