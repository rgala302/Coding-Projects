import java.util.Scanner;

/**

The purpose of this program is to present the user a menu with shirt option they can purchse, based on the chosen option the user will be presesnted with
   a question of how mnay of the chosen item, and the total price (depending on the total price the user may be given discounts) will be presented. 
   After the program is complete the user will be prompted to if they want to purchse more shirts.

*/

public class ShirtPurchase 
{
    
    public static void main(String[] args) //Main Method.
       {
           Scanner input = new Scanner(System.in);
           char processAnotherPurchase;
           int numberOfShirts;
           double pricePerShirt, purchasePrice, totalCost = 0;
           
           do
            {
               // Display menu and get selection.
               int menuSelection = getMenuSelection(input);
               
               
               // Get price per shirt based on selection.
               pricePerShirt = getPricePerShirt(menuSelection);
               
               
               // Get number of shirts.
               numberOfShirts = getNumberOfShirts(input);
               
               
               // Calculate purchase price.
               purchasePrice = calculatePurchasePrice(pricePerShirt, numberOfShirts);
               
               
               // Add purchase price to total cost.
               totalCost += purchasePrice;
              
              
               // Display purchase price.
               System.out.printf("The total price of your purchase is: $%.2f\n\n", purchasePrice);
              
   
               // Ask whether to process another purchase.
               System.out.print("Do you want to process another purchase? (Y/N) ");
               processAnotherPurchase = input.next().charAt(0);
               input.nextLine(); // Consume remaining newline character(s).
                  System.out.print("\n");
               
   
               
           } 
           while (processAnotherPurchase == 'Y' || processAnotherPurchase == 'y');
           
        // Display discounted total cost of all purchases.
        displayDiscountedTotalCost(totalCost);
       }
    
    
    
    public static int getMenuSelection(Scanner input) //Method 1 (Menu Selection).
        {
           int selection;
           do 
           {
               // Display menu options.
               System.out.println("Shirt Type Menu:\n");
               System.out.println("\t1. T-shirt ");
               System.out.println("\t2. Tank Top ");
               System.out.println("\t3. Long-Sleeve Shirts");
               
               // Get menu selection from the user.
               System.out.print("\nSelect the type of upper-wear from the list above: ");
               selection = input.nextInt();
               input.nextLine(); // Consume remaining newline character(s).
               
                if (selection <= 0) //Determine if invalid ammount entered.
                   {
                         System.out.println("\nERROR: INVALID MENU CHOICE. TRY AGAIN.\n");
                   }
                   else if (selection > 3)
                    {
                         System.out.println("\nERROR: INVALID MENU CHOICE. TRY AGAIN.\n");
                    }
               
           } 
           while (selection < 1 || selection > 3);
           
           return selection;
       }
    
    
    
     public static double getPricePerShirt(int selection) //Method 2 (Price).
        {
             double price;
             if (selection == 1) //Assign menu option(s) with price.
              {
                 price = 9.98;
              } 
             else if (selection == 2) 
              {
                 price = 4.57;
              } 
             else if (selection == 3) 
              {
                 price = 11.95;
              }
             else 
              {
                 price = 0;
              }
             return price;
         }

    
    public static int getNumberOfShirts(Scanner input) //Method 3 Number of Shirts).
       {
           int numberOfShirts;
           do
           {
               System.out.print("Enter the number of shirts that were purchased: ");
               numberOfShirts = input.nextInt();
               input.nextLine(); // Consume remaining newline character(s).
                 
               if (numberOfShirts <= 0) 
                 {
                  System.out.println("\nERROR: AT LEAST 1 SHIRT MUST BE ENTERED. TRY AGAIN.\n ");
                 }
               
           } 
           while (numberOfShirts < 1);
           return numberOfShirts;
       }
    
    
    
    public static double calculatePurchasePrice(double pricePerShirt, int numberOfShirts) //Method 4 (Purchase Price).
        {
           return pricePerShirt * numberOfShirts;
        }
    
    
    
    public static void displayDiscountedTotalCost(double totalCost) //Method 5 (Discount(s)).
       {
           double discountPercent;
              if (totalCost < 90) //Determine if discount is applicable based on totalCost.
               {
                 discountPercent = 0;
               }
              else if (totalCost < 160) 
                {
                  discountPercent = 0.07;
           
                }
                 else 
                  {
                    discountPercent = 0.15;
                  }
           double discountedTotalCost = totalCost * (1 - discountPercent);
           System.out.printf("The discounted total cost of all purchases is: $%.2f\n", discountedTotalCost);
       }
    
}
