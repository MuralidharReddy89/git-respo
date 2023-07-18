import java.util.Scanner;

public class ATMInterface {
    public static void main(String[] args) {
        double initialBalance = 1000;
        ATM amt = new ATM(initialBalance);
        Scanner scan = new Scanner(System.in);

        while (true) { 
            amt.displayMenu();
        
            System.out.println("Enter your option:");
            int option = scan.nextInt();
            amt.processOption(option);
            System.out.println();
        }
    }
}