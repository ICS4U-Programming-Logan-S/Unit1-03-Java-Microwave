import java.util.Scanner;

/**
* This program gets input from the user of 
* what they want to eat and how many they want.
* It then calculates the time to cook the food 
* based on the item and quantity.
*
* @author  Logan S
* @version 1.0
*
* @since   2023-02-22
*/

public final class Microwave {

    /**
     * This is a private constructor.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private Microwave() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int item = 0;
        int quantity = 0;

        // Get user input for item and validate input
        boolean isValidInput = false;
        do {
            try {
                System.out.print("Enter the item (1 - sub, 2 - pizza, 3 - soup): ");
                item = scanner.nextInt();
                if (item >= 1 && item <= 3) {
                    isValidInput = true;
                } else {
                    System.out.println("Invalid item selection. Please select 1, 2, or 3.");
                }
            } catch (Exception e) {
                System.out.println("Invalid item selection. Please select 1, 2, or 3.");
                scanner.next(); // clear the scanner buffer
            }
        } while (!isValidInput);

        // Get user input for quantity and validate input
        isValidInput = false;
        do {
            try {
                System.out.print("Enter the quantity (max 3): ");
                quantity = scanner.nextInt();
                if (quantity >= 1 && quantity <= 3) {
                    isValidInput = true;
                } else {
                    System.out.println("Invalid quantity. Please enter a value between 1 and 3.");
                }
            } catch (Exception e) {
                System.out.println("Invalid quantity. Please enter a value between 1 and 3.");
                scanner.next(); // clear the scanner buffer
            }
        } while (!isValidInput);

        // Calculate and display heating time
        int heatingTime = 0;
        switch (item) {
            case 1:
                heatingTime = 60;
                break;
            case 2:
                heatingTime = 45;
                break;
            case 3:
                heatingTime = 105;
                break;
        }
        if (quantity == 2) {
            heatingTime = (int) (heatingTime * 1.5);
        } else if (quantity == 3) {
            heatingTime = heatingTime * 2;
        }
        System.out.printf("Heating time: %d seconds", heatingTime);

        // Closing scanner
        scanner.close();
    }
}
