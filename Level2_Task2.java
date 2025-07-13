import java.util.Scanner;

public class Level2_Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();

        int length;
        String password;

        do {
            System.out.print("Enter your password (minimum 8 characters): ");
            password = scanner.nextLine();
            length = password.length();
            password = password.trim();
            if (password.isEmpty()) {
                System.out.println("Password cannot be Empty ❌. Please enter a valid password.\n");
                continue;
            }
            if (length < 8) {
                System.out.println("Password is too short ❌. Please try again.\n");
            }
        } while (length < 8);

        System.out.println("Accepted ✅ Your password length is: " + length);

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isLowerCase(ch)) hasLower = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else hasSpecial = true;
        }

        int strengthPoints = 0;
        if (hasUpper) strengthPoints++;
        if (hasLower) strengthPoints++;
        if (hasDigit) strengthPoints++;
        if (hasSpecial) strengthPoints++;

        System.out.println("\n====== PASSWORD ANALYSIS ======");
        System.out.println("Length: " + length);
        System.out.println("Contains uppercase letters: " + hasUpper);
        System.out.println("Contains lowercase letters: " + hasLower);
        System.out.println("Contains digits: " + hasDigit);
        System.out.println("Contains special characters: " + hasSpecial);
        System.out.println();

        System.out.println("====== RESULT ======");
        if (strengthPoints <= 2) {
            System.out.println("Your password strength is WEAK ❌. Needs more improvements.");

            System.out.println("\nSuggestions:");
            if (!hasUpper) System.out.println("- Add at least one uppercase letter.");
            if (!hasLower) System.out.println("- Add at least one lowercase letter.");
            if (!hasDigit) System.out.println("- Add at least one digit.");
            if (!hasSpecial) System.out.println("- Add a special character like !@#$.\n");
            if (length == 8) System.out.println("- Tip: A longer password is even more secure.\n");
        }
        else if (strengthPoints == 3) {
            System.out.println("Your password strength is MODERATE ⚠️. Slight improvements needed.");

            System.out.println("\nSuggestions:");
            if (!hasUpper) System.out.println("- Add at least one uppercase letter.");
            if (!hasLower) System.out.println("- Add at least one lowercase letter.");
            if (!hasDigit) System.out.println("- Add at least one digit.");
            if (!hasSpecial) System.out.println("- Add a special character like !@#$.\n");
            if (length == 8) System.out.println("- Tip: A longer password is even more secure.\n");
        }
        else {
            System.out.println("Your password strength is STRONG ✅. Great job!\n");
        }
        System.out.println("\nThank you for using My Password Strength Checker! 🔐");
        System.out.println("=========================================");
        scanner.close();
    }
}
