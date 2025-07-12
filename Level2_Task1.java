import java.util.Scanner;

public class Level2_Task1 {
    static char[][] board = new char[3][3];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        System.out.println("\nWELCOME TO MY CONSOLE BASED TIC TAC TOE GAME! 🎮\n");

        while (playAgain) {
            initializeBoard();
            char currentPlayer = 'X';
            boolean gameEnded = false;

            while (!gameEnded) {
                printBoard();

                int row = -1;
                int col = -1;

                while (true) {
                    System.out.print("Hey Player " + currentPlayer +  " 😍" + " ,Enter your move (row [1-3] and column [1-3]): \n");

                    if (scanner.hasNextInt()) {
                        row = scanner.nextInt() - 1;
                    }
                    else {
                        System.out.println("❌ Invalid input! Please enter a number between 1 and 3.");
                        System.out.println();
                        scanner.next();
                        continue;
                    }

                    if (scanner.hasNextInt()) {
                        col = scanner.nextInt() - 1;
                    }
                    else {
                        System.out.println("❌ Invalid input! Please enter a number between 1 and 3.");
                        scanner.next();
                        continue;
                    }

                    if (row >= 0 && row < 3 && col >= 0 && col < 3) {
                        if (isValidMove(row, col)) {
                            break;
                        }
                        else {
                            System.out.println("❌ That cell is already taken. Try again.");
                            System.out.println();
                        }
                    }
                    else {
                        System.out.println("❌ Invalid move! Row and column must be between 1 and 3.");
                        System.out.println();
                    }
                }

                scanner.nextLine();

                board[row][col] = currentPlayer;

                if (checkWin(currentPlayer)) {
                    printBoard();
                    System.out.println("🎉 Player " + currentPlayer + " wins!");
                    System.out.println();
                    gameEnded = true;
                }
                else if (isBoardFull()) {
                    printBoard();
                    System.out.println("🤝 IT'S A DRAW!");
                    System.out.println();
                    gameEnded = true;
                }
                else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            }

            String answer = "";
            while (true) {
                System.out.print("DO YOU WANT TO PLAY ANOTHER ROUND? (yes/no): ");
                answer = scanner.nextLine().trim().toLowerCase();

                if (answer.equals("yes")) {
                    playAgain = true;
                    System.out.println();
                    break;
                }
                else if (answer.equals("no")) {
                    playAgain = false;
                    System.out.println();
                    System.out.println("THANKS FOR PLAYING MY GAME! 🧡");
                    break;
                }
                else {
                    System.out.println("Invalid Input ❌. Please Enter 'yes' or 'no'!\n");
                }
            }
        }

        scanner.close();
    }

    static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    static void printBoard() {
        System.out.println("\n     1    2    3");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + "  ");
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + board[i][j] + " ");
                if (j < 2) System.out.print(" |");
            }
            System.out.println();
            if (i < 2) System.out.println("   ----+----+----");
        }
        System.out.println();
    }

    static boolean isValidMove(int row, int col) {
        return board[row][col] == ' ';
    }

    static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean checkWin(char player) {

        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                    (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }
}
