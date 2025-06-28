import java.util.Scanner;

public class Level1_Task3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Number of Grades (In Numbers): ");
        int n = scanner.nextInt();
        System.out.println();

        int[] grades = new int[n];

        int sum = 0;
        System.out.println("The Maximum Grade Should be less than or equal to 100");

        for (int i = 0; i < n; i++) {
            int grade;
            while (true) {
                System.out.println("Enter the Grade " + (i+1) + ":");
                grade = scanner.nextInt();

                if (grade <= 100 && grade >= 0) {
                    break;
                } else {
                    System.out.println("Exceeds the Maximum Limit or Invalid! Please enter a valid grade (0 to 100).");
                    System.out.println();
                }
            }
            grades[i] = grade;
            sum += grade;
        }

        double avg = (double) sum / n;
        System.out.println();
        System.out.println("The Average Grade is : " +avg);

        char Grade;

        if (avg >= 90) {
            Grade = 'O';
        }
        else if (avg >= 80) {
            Grade = 'A';
        }
        else if (avg >= 70) {
            Grade = 'B';
        }
        else if (avg >= 60) {
            Grade = 'C';
        }
        else if (avg >= 50) {
            Grade = 'D';
        }
        else {
            Grade = 'U';
        }
        System.out.println("The Average Grade in Alphabets : " + Grade);

        if (avg >= 50) {
            System.out.println("You have Passed!");
        }
        else {
            System.out.println("You have Failed!");
        }
    }
}