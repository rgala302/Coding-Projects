import java.util.Scanner;


/**
 * The following code is a banking application where users can input
 * account information and view account details
 */


public class AtmProject {
    private static Scanner input = new Scanner(System.in);


    /**
     * Main method to execute banking application
     */
    public static void main(String[] args) {
        int accountNumber = getAccountNumber();
        String accountType = getAccountType();
        String customerName = getCustomerName();
        double accountBalance = getCustomerBalance();
        double accountFees = calcFees(accountBalance);

        displayInfo(accountNumber, accountType, customerName, accountBalance, accountFees);
    }


    /**
     * Request user to enter the account number
     */
    public static int getAccountNumber() {
        System.out.print("Please enter the Account Number: ");
        return input.nextInt();
    }


    /**
     * Requests user to select an account type (checking/savings)
     */
    public static String getAccountType() {
        System.out.print("\n   1.Checking \n   2.Savings\n");
        System.out.print("\nSelect an Account Type from the menu above:");
        int accountTypeNum = input.nextInt();

        if (accountTypeNum == 1) {
            return "Checkings";
        } else if (accountTypeNum == 2) {
            return "Savings";
        }
        
        return "Unknown"; 
    }


    /**
     * Requests user to enter the customers name
     */
    public static String getCustomerName() {
        input.nextLine(); 
        System.out.print("\nPlease enter the Customer's Name:");
        return input.nextLine();
    }


    /**
     * Requests user to enter the account balance
     */
    public static double getCustomerBalance() {
        System.out.print("\nPlease enter the Account Balance:");
        return input.nextDouble();
    }


    /**
     * Calculates account fees based on the given account balance
     */
    public static double calcFees(double accountBalance) {
        double feePercent = 0.1;
        return accountBalance * feePercent;
    }

    /**
     * Displays account information (account number, account type,
     * customer name, account balance, and account fees)
     */
    public static void displayInfo(int accountNumber, String accountType, String customerName,
                                   double accountBalance, double accountFees) {
        System.out.print("\nAccount Information:");
        System.out.print("\nAccount Number: " + accountNumber);
        System.out.print("\nAccount Type: " + accountType);
        System.out.print("\nCustomer Name: " + customerName);
        System.out.print("\nAccount Balance:$" + accountBalance);
        System.out.print("\nAccount Fees:$" + accountFees);
    }
}
