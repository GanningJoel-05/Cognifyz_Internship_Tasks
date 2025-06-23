import java.util.Scanner;

public class Level1_Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a word or phrase:");
        String input = scanner.nextLine();

        String lowerCaseInput = input.toLowerCase();

        StringBuilder cleaned = new StringBuilder();
        for (char c : lowerCaseInput.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                cleaned.append(c);
            }
        }

        String cleanedStr = cleaned.toString();
        String reversed = new StringBuilder(cleanedStr).reverse().toString();

        if (cleanedStr.equals(reversed)) {
            System.out.println();
            System.out.println("It is a palindrome!");
        }
        else {
            System.out.println();
            System.out.println("Not a palindrome.");
        }

        scanner.close();
    }
}
