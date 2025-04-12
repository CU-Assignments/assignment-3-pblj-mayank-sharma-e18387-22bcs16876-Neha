// ✅ Problem 2: ATM Withdrawal System (Medium Level)
// Description:
// Simulate an ATM withdrawal system:

// Ask the user to enter PIN
// Allow withdrawal if the PIN is correct and balance is sufficient
// Throw exceptions for invalid PIN or insufficient balance
// Ensure the system always displays the remaining balance even after an
// exception.
// Example Input:

// Enter PIN: 1234
// Withdraw Amount: 5000
// Example Output:

// Error: Insufficient balance. Current Balance: 3000

import java.util.Scanner;

public class ATM {
    private static final int PIN = 1234;
    private static double balance = 3000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter PIN: ");
            int enteredPin = Integer.parseInt(scanner.nextLine());

            if (enteredPin != PIN) {
                throw new SecurityException("Invalid PIN.");
            }

            System.out.print("Withdraw Amount: ");
            double amount = Double.parseDouble(scanner.nextLine());

            if (amount > balance) {
                throw new Exception("Insufficient balance.");
            }

            balance -= amount;
            System.out.println("Withdrawal successful. Remaining Balance: " + balance);

        } catch (SecurityException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input. Enter a numeric value.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " Current Balance: " + balance);
        } finally {
            System.out.println("Final Balance: " + balance);
            scanner.close();
        }
    }
}
