import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final String[] CHOICES = {"rock", "paper", "scissors"};
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static int userScore = 0;
    private static int computerScore = 0;

    public static void main(String[] args) {
        printWelcome();
        
        do {
            playRound();
        } while (wantToPlayAgain());

        printGameSummary();
        scanner.close();
    }

    private static void printWelcome() {
        System.out.println("Welcome to Rock, Paper, Scissors!");
        System.out.println("Win conditions: Rock crushes Scissors, Scissors cuts Paper, Paper covers Rock");
        System.out.println("------------------------------------------------------------------");
    }

    private static void playRound() {
        String userChoice = getUserChoice();
        String computerChoice = getComputerChoice();
        
        System.out.println("\nYou chose " + userChoice + ".");
        System.out.println("Computer chose " + computerChoice + ".");
        
        determineWinner(userChoice, computerChoice);
        printCurrentScore();
    }

    private static String getUserChoice() {
        String choice;
        while (true) {
            System.out.println("\nEnter your choice (rock/paper/scissors):");
            choice = scanner.nextLine().toLowerCase().trim();
            
            if (isValidChoice(choice)) {
                return choice;
            }
            System.out.println("Invalid choice! Please try again.");
        }
    }

    private static boolean isValidChoice(String choice) {
        for (String validChoice : CHOICES) {
            if (validChoice.equals(choice)) {
                return true;
            }
        }
        return false;
    }

    private static String getComputerChoice() {
        return CHOICES[random.nextInt(CHOICES.length)];
    }

    private static void determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            System.out.println("It's a tie!");
            return;
        }

        if ((userChoice.equals("rock") && computerChoice.equals("scissors")) ||
            (userChoice.equals("paper") && computerChoice.equals("rock")) ||
            (userChoice.equals("scissors") && computerChoice.equals("paper"))) {
            System.out.println("You win this round!");
            userScore++;
        } else {
            System.out.println("Computer wins this round!");
            computerScore++;
        }
    }

    private static void printCurrentScore() {
        System.out.println("\nCurrent Score:");
        System.out.println("You: " + userScore + " | Computer: " + computerScore);
    }

    private static boolean wantToPlayAgain() {
        while (true) {
            System.out.println("\nWould you like to play again? (y/n):");
            String response = scanner.nextLine().toLowerCase().trim();
            
            if (response.equals("y") || response.equals("n")) {
                return response.equals("y");
            }
            System.out.println("Please enter 'y' for yes or 'n' for no.");
        }
    }

    private static void printGameSummary() {
        System.out.println("\n=== Game Summary ===");
        System.out.println("Final Score:");
        System.out.println("You: " + userScore + " | Computer: " + computerScore);
        
        if (userScore > computerScore) {
            System.out.println("Congratulations! You won the game!");
        } else if (userScore < computerScore) {
            System.out.println("Better luck next time! Computer won the game!");
        } else {
            System.out.println("It's a tie game!");
        }
        
        System.out.println("\nThanks for playing!");
    }
}