// ✅ Problem 1: Square Root Calculation (Easy Level)
// Description:
// Write a Java program to calculate the square root of a number.

// Use try-catch to handle invalid inputs (negative numbers or non-numeric
// values).
// Example Input:

// Enter a number: -16
// Example Output:

// Error: Cannot calculate the square root of a negative number.

import java.util.Scanner;

public class SquareRootCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter a number: ");
            double number = Double.parseDouble(scanner.nextLine());

            if (number < 0) {
                throw new IllegalArgumentException("Cannot calculate the square root of a negative number.");
            }

            double result = Math.sqrt(number);
            System.out.println("Square root: " + result);

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input. Please enter a numeric value.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
