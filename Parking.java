import java.util.Scanner;
/** 
   This program will 
*/

public class Parking
{ 
   public static void main(String[] args)
   {
  
  
   double standardRate, discountRate, baseFee, taxRate, useRate, subtotal, totalMinutes, finalTotal;
      taxRate = .0475;
      baseFee = 5.99;
      standardRate = .07;
      discountRate = .05;

   String licTags, promoCode, codeEntry;
   String parkingType;
   parkingType = " ";
   
   Scanner keyboard = new Scanner(System.in);
   
   System.out.println("Welcome to the CPCC Parking Service" +"\n");
   
   System.out.println("Enter the number of minutes the vehicle was parked:");
      totalMinutes = keyboard.nextDouble();
      keyboard.nextLine();
      
      if (totalMinutes < 60)
         {
         parkingType = "Under 1 hour";
         }
        else if (totalMinutes <= 1339)
         {
         parkingType = "Short term";
         }
        else if (totalMinutes >= 1440)
         {
         parkingType = "Long term";
         }
         else
         {
         System.out.print("Invalid parking time");
         }
      
   
   System.out.println( "\n"+"Enter the vehicle's License Tag Number: ");
      licTags = keyboard.nextLine();
      
   System.out.println("If you have a discount, oose from one of the types below:\nA - Promo Code"
                     + "\nB - No Discount" + "\nEnter your choice (A or B):");
      promoCode = keyboard.nextLine();
   if (promoCode.equals("A"))
      {
      
      System.out.println(" Please enter the promo code ");
         codeEntry = keyboard.nextLine();
         if (codeEntry.equals("ParkDiscount23!"))
            {
            useRate = .05;
            
            double subTotal = (totalMinutes * useRate) + baseFee;
         subTotal = (double) Math.round(subTotal * 100) / 100;
      
      double durationHours = totalMinutes / 60;
         durationHours = (double) Math.round(durationHours * 100) / 100;
      double durationDays = ((totalMinutes / 60) / 24);
         durationDays = (double) Math.round(durationDays * 100) / 100;
      
      double salesTax = subTotal * taxRate;
         salesTax =  (double) Math.round(salesTax * 100) / 100;
      
       finalTotal = salesTax + subTotal;
         finalTotal = (double) Math.round(finalTotal * 100) / 100;
      
      System.out.println(" Your Parking Bill: ");
         System.out.println("Vehicle License Tag Number: " +licTags);
      
      System.out.println("Parking Duration: "  + durationDays + " day(s)" 
                         + durationHours + " hour(s)" + totalMinutes + " minute(s)");
     
     
      System.out.println("Subtotal: $" + subTotal);
      System.out.println("Sales Tax: $" + salesTax);
      System.out.println("Final Total: $" + finalTotal);
      System.out.println("Parking Type: " + parkingType);
      
      

            }
         
          else 
            {
            System.out.println( "Invalid promo code entered. Standard parking rate of $0.07 / minute applied!");
            useRate = .07;
            
            double subTotal = (totalMinutes * useRate) + baseFee;
         subTotal = (double) Math.round(subTotal * 100) / 100;
      
      double durationHours = totalMinutes / 60;
         durationHours = (double) Math.round(durationHours * 100) / 100;
      double durationDays = ((totalMinutes / 60) / 24);
         durationDays = (double) Math.round(durationDays * 100) / 100;
      
      double salesTax = subTotal * taxRate;
         salesTax =  (double) Math.round(salesTax * 100) / 100;
      
       finalTotal = salesTax + subTotal;
         finalTotal = (double) Math.round(finalTotal * 100) / 100;
      
      System.out.println(" Your Parking Bill: ");
         System.out.println("Vehicle License Tag Number: " +licTags);
      
      System.out.println("Parking Duration: "  + durationDays + " day(s)" 
                         + durationHours + " hour(s)" + totalMinutes + " minute(s)");
     
     
      System.out.println("Subtotal: $" + subTotal);
      System.out.println("Sales Tax: $" + salesTax);
      System.out.println("Final Total: $" + finalTotal);
      System.out.println("Parking Type: " + parkingType);
      
      

            }
      }
      else if (promoCode.equals("B"))
        {
        System.out.print("No discount will be applied");
        useRate = .07;
        
        double subTotal = (totalMinutes * useRate) + baseFee;
         subTotal = (double) Math.round(subTotal * 100) / 100;
      
      double durationHours = totalMinutes / 60;
         durationHours = (double) Math.round(durationHours * 100) / 100;
      double durationDays = ((totalMinutes / 60) / 24);
         durationDays = (double) Math.round(durationDays * 100) / 100;
      
      double salesTax = subTotal * taxRate;
         salesTax =  (double) Math.round(salesTax * 100) / 100;
      
       finalTotal = salesTax + subTotal;
         finalTotal = (double) Math.round(finalTotal * 100) / 100;
      
      System.out.println(" Your Parking Bill: ");
         System.out.println("Vehicle License Tag Number: " +licTags);
      
      System.out.println("Parking Duration: "  + durationDays + " day(s)" 
                         + durationHours + " hour(s)" + totalMinutes + " minute(s)");
     
     
      System.out.println("Subtotal: $" + subTotal);
      System.out.println("Sales Tax: $" + salesTax);
      System.out.println("Final Total: $" + finalTotal);
      System.out.println("Parking Type: " + parkingType);
      
      

        }
 
      
            
      
      
      
      
      
      
      
      
      
      
 
      

   }
}