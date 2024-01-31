import java.util.ArrayList;
import java.util.Scanner;

/**
  *The purpose of this program is to allow users to purchase honey based
  *on type and number of pounds. The program then gives price and number
  *of jars for given weight.
 */


/**
 * Represents a honey bottle with a specific size and amount.
 */
class HoneyBottle {
    private int size;
    private int count;


    /**
     * Creates HoneyBottle objects with size and count.
     *
     * @param size  the size of the honey bottle in pounds
     * @param count the number of honey bottles
     */
    public HoneyBottle(int size, int count) {
        this.size = size;
        this.count = count;
    }

    public int getSize() {
        return size;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return count + " - " + size + "lb bottle";
    }
}

/**
 * Represents a honey order with a specific type of honey, quantity, and price.
 */
class HoneyOrder {
    private String type;
    private int quantity;
    private double price;


    /**
     * Calculates the price of honey based on honey orders.
     *
     * @param type     the type of honey (Orange Blossom, Wildflower, or Clover)
     * @param quantity the quantity of honey in pounds
     */
    public HoneyOrder(String type, int quantity) {
        this.type = type;
        this.quantity = quantity;
        calculatePrice();
    }

    private void calculatePrice() {
        if (quantity >= 36) {
            if (type.equals("Orange Blossom")) {
                price = quantity * 1.15;
            } else if (type.equals("Wildflower")) {
                price = quantity * 1.05;
            } else if (type.equals("Clover")) {
                price = quantity * 0.97;
            }
        } else {
            if (type.equals("Orange Blossom")) {
                price = quantity * 1.25;
            } else if (type.equals("Wildflower")) {
                price = quantity * 1.10;
            } else if (type.equals("Clover")) {
                price = quantity * 1.00;
            }
        }
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }
}


/**
 * Represents honey orders and uses methods for collecting and displaying sales data.
 */
class HoneySales {
    private ArrayList<HoneyOrder> orders;

    public HoneySales() {
        orders = new ArrayList<>();
    }

    public void addOrder(HoneyOrder order) {
        orders.add(order);
    }

    public void displaySalesReport() {
        System.out.println("\nHoney Sales Report");
        for (HoneyOrder order : orders) {
            //System.out.println("\nHoney Sales Report");
            System.out.println();
            System.out.println("Type of honey: " + order.getType());
            System.out.println("Amount (lb): " + order.getQuantity());
            System.out.printf("Price: $%.2f\n", order.getPrice());

            ArrayList<HoneyBottle> bottles = calculateBottles(order.getQuantity());
            int sixPoundBottles = 0, threePoundBottles = 0, onePoundBottles = 0;

            for (HoneyBottle bottle : bottles) {
                if (bottle.getSize() == 6) {
                    sixPoundBottles += bottle.getCount();
                } else if (bottle.getSize() == 3) {
                    threePoundBottles += bottle.getCount();
                } else if (bottle.getSize() == 1) {
                    onePoundBottles += bottle.getCount();
                }
            }

            System.out.println("No. 6lb bottles: " + sixPoundBottles);
            System.out.println("No. 3lb bottles: " + threePoundBottles);
            System.out.println("No. 1lb bottles: " + onePoundBottles);
            System.out.println();
        }
    }

    private ArrayList<HoneyBottle> calculateBottles(int totalPounds) {
        ArrayList<HoneyBottle> bottleList = new ArrayList<>();
        int sixPoundBottles = totalPounds / 6;
        totalPounds %= 6;
        int threePoundBottles = totalPounds / 3;
        totalPounds %= 3;
        int onePoundBottles = totalPounds;

        if (sixPoundBottles > 0) {
            bottleList.add(new HoneyBottle(6, sixPoundBottles));
        }
        if (threePoundBottles > 0) {
            bottleList.add(new HoneyBottle(3, threePoundBottles));
        }
        if (onePoundBottles > 0) {
            bottleList.add(new HoneyBottle(1, onePoundBottles));
        }

        return bottleList;
    }
}


/**
 * The main program managing honey sales and the displaying of information for sales.
 */
public class Honeyordering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HoneySales honeySales = new HoneySales();

            while (true) {
               System.out.print("Type of Honey: \n\t1. Orange Blossom \n\t2. Wildflower \n\t3. Clover \nSelect the type of honey: ");
               String typeInput = scanner.nextLine();

             if (typeInput.equalsIgnoreCase("quit")) {
                 break;
             }

             String type;
             switch (typeInput) {
                 case "1":
                   type = "Orange Blossom";
                   break;
                 case "2":
                   type = "Wildflower";
                   break;
                 case "3":
                   type = "Clover";
                   break;
                 default:
                   System.out.println("Invalid input. Please enter a valid option.");
                   continue;
    }

            System.out.print("Enter the number of pounds ordered: ");
            while (!scanner.hasNextInt()) {
                System.out.print("You must enter a whole number. Try again: ");
                scanner.next(); // clear the invalid input
            }
            int quantity = scanner.nextInt();
            scanner.nextLine(); // clear the newline character from the input buffer

            if (quantity < 1) {
                quantity = 0;
            }

            HoneyOrder order = new HoneyOrder(type, quantity);
            honeySales.addOrder(order);

            System.out.print("\nDo you want to enter another order? (Y/N):");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("Y")) {
                break;
            }
            System.out.print("\n");
        }

        honeySales.displaySalesReport();
        scanner.close();
    }
}
