import java.util.Scanner;
import java.util.Random;

public class Level1_Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String specialChars = "!@#$%^&*()-_=+<>?";

        String characterPool = "";

        int length = 0;
        while (true) {
            System.out.print("Enter the Desired Password Length (Positive Integer Only): ");
            if (scanner.hasNextInt()) {
                length = scanner.nextInt();
                scanner.nextLine();

                if (length > 0) {
                    break;
                }
                else {
                    System.out.println();
                    System.out.println("Invalid Input. Please Enter a Positive Integer Greater Than Zero.\n");
                }
            }
            else {
                System.out.println();
                System.out.println("Invalid Input. Please Enter a Positive Integer.\n");
                scanner.nextLine();
            }
        }
        System.out.println();
        String includeLower = "";
        while (true) {
            System.out.print("Include Lowercase Letters? (yes/no): ");
            includeLower = scanner.nextLine().trim().toLowerCase();

            if (includeLower.equals("yes") || includeLower.equals("no")) {
                break;
            }
            else {
                System.out.println();
                System.out.println("Invalid Input. Please Enter 'yes' or 'no'.");
            }
        }

        String includeUpper = "";
        while (true) {
            System.out.print("Include Uppercase Letters? (yes/no): ");
            includeUpper = scanner.nextLine().trim().toLowerCase();

            if (includeUpper.equals("yes") || includeUpper.equals("no")) {
                break;
            }
            else {
                System.out.println();
                System.out.println("Invalid Input. Please Enter 'yes' or 'no'.");
            }
        }

        String includeNumbers = "";
        while (true) {
            System.out.print("Include the Numbers? (yes/no): ");
            includeNumbers = scanner.nextLine().trim().toLowerCase();

            if (includeNumbers.equals("yes") || includeNumbers.equals("no")) {
                break;
            }
            else {
                System.out.println();
                System.out.println("Invalid Input. Please Enter 'yes' or 'no'.");
            }
        }

        String includeSpecial = "";
        while (true) {
            System.out.print("Include Special Characters? (yes/no): ");
            includeSpecial = scanner.nextLine().trim().toLowerCase();

            if (includeSpecial.equals("yes") || includeSpecial.equals("no")) {
                break;
            }
            else {
                System.out.println();
                System.out.println("Invalid Input. Please Enter 'yes' or 'no'.");
            }
        }

        if (includeLower.equals("yes")) {
            characterPool += lowercase;
        }
        if (includeUpper.equals("yes")) {
            characterPool += uppercase;
        }
        if (includeNumbers.equals("yes")) {
            characterPool += numbers;
        }
        if (includeSpecial.equals("yes")) {
            characterPool += specialChars;
        }

        if (characterPool.isEmpty()) {
            System.out.println();
            System.out.println("No Character Types were Selected. Cannot Generate the Password.");
            return;
        }

        StringBuilder password = new StringBuilder();

        if (includeLower.equals("yes")) {
            password.append(lowercase.charAt(random.nextInt(lowercase.length())));
        }
        if (includeUpper.equals("yes")) {
            password.append(uppercase.charAt(random.nextInt(uppercase.length())));
        }
        if (includeNumbers.equals("yes")) {
            password.append(numbers.charAt(random.nextInt(numbers.length())));
        }
        if (includeSpecial.equals("yes")) {
            password.append(specialChars.charAt(random.nextInt(specialChars.length())));
        }

        int remainingLength = length - password.length();

        for (int i = 0; i < remainingLength; i++) {
            password.append(characterPool.charAt(random.nextInt(characterPool.length())));
        }

        char[] passArray = password.toString().toCharArray();
        for (int i = 0; i < passArray.length; i++) {
            int swapWith = random.nextInt(passArray.length);
            char temp = passArray[i];
            passArray[i] = passArray[swapWith];
            passArray[swapWith] = temp;
        }

        System.out.println("\nThe Generated Password: " + new String(passArray));
    }
}

