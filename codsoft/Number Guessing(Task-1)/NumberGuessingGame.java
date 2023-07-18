import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) 
    {
        Random random = new Random();// generate a random number between 0 and 100
        Scanner scanner = new Scanner(System.in);
        int score= 0;
        boolean playAgain=true;
        while(playAgain)
        {
            System.out.println("Welcome to the Number Gussing Game!");
            System.out.println("I have generated a random number between 0 and 100.");
            int secretNumber=random.nextInt(100)+1;
            System.out.println("Random number is:"+secretNumber);
            int attempts=0;

        while (true) 
        {
            System.out.println("Enter your guess:");
            int userGuess = scanner.nextInt();
            attempts++;
            if (userGuess == secretNumber) {
                System.out.println("Conguratulations! your guess is correct");
                score++;
                break;
            } else if (userGuess < secretNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too High! Try again.");
            }
            if(attempts==5){
                System.out.println("Oops! you have reached maximum number of attempts.");
                System.out.println("The correct number was "+secretNumber);
                break;
            }
        }
            System.out.print("Do you want play again?(yes/no):");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }
            System.out.println("Game over!");
            System.out.println("Your score is "+score);

    }

}