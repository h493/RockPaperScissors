import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    private static final int ROCK = 1;
    private static final int PAPER = 2;
    private static final int SCISSORS = 3;
    private static final int NUM_CHOICES = 3;

    private int playerChoice;
    private int computerChoice;

    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();


    public void playGame() {
        while (true) {
            System.out.println("Choose your action:");
            System.out.println("1. Rock");
            System.out.println("2. Paper");
            System.out.println("3. Scissors");
            System.out.println("4. Quit");

            playerChoice = getChoice();
            if (playerChoice == 4) {
                break;
            }
            computerChoice = getComputerChoice();
            System.out.println("You chose " + getChoiceName(playerChoice) + " and the computer chose " + getChoiceName(computerChoice) + ".");
            int result = getResult();
            System.out.println(getResultDescription(result));
        }
        System.out.println("Thank you for playing!");
    }

    private  int getChoice() {
        while (true) {
            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();
            if (choice >= 1 && choice <= NUM_CHOICES + 1) {
                return choice;
            }
            System.out.println("Invalid choice. Please enter a number between 1 and " + (NUM_CHOICES + 1) + ".");
        }
    }

    private int getComputerChoice() {
        return random.nextInt(NUM_CHOICES) + 1;
    }

    private String getChoiceName(int choice) {
        switch (choice) {
            case ROCK:
                return "Rock";
            case PAPER:
                return "Paper";
            case SCISSORS:
                return "Scissors";
            default:
                return "Invalid choice";
        }
    }

    private int getResult() {
        if (playerChoice == computerChoice) {
            return 0;
        }
        switch (playerChoice) {
            case ROCK:
                return (computerChoice == SCISSORS ? 1 : -1);
            case PAPER:
                return (computerChoice == ROCK ? 1 : -1);
            case SCISSORS:
                return (computerChoice == PAPER ? 1 : -1);
            default:
                return 0;
        }
    }

    private String getResultDescription(int result) {
        switch (result) {
            case 1:
                return "You win!";
            case -1:
                return "You lose.";
            case 0:
                return "It's a draw.";
            default:
                return "Invalid result";
        }
    }
}