import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    /**
     * Main method
     * @param args program argument
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome!");
        showMenu();
        int option;

        // TODO: Works once, but try to find a way to catch the exception multiple times.

        try{
            option = input.nextInt();
            executeMenuOption(option);
        } catch (InputMismatchException e) {
            System.out.println("Please provide an integer.");
            showMenu();
            input.nextLine();
            option = input.nextInt();
            executeMenuOption(option);
        }

    }

    /**
     * Show the main menu
     */

    public static void showMenu(){
        System.out.println("""
            1 - Start new competition
            2 - Load competition from file
            3 - Stop application
            """);
    }

    /**
     * Show the start competition menu
     */

    public static void showStartCompetitionMenu(){
        System.out.println("""
            1 - Add new athlete
            2 - Show list of athletes
            3 - Change attribute of athlete
            4 - Delete athlete registration
            5 - Start competition
            """);
    }

    /**
     * Execute the main menu
     * @param option option chosen by the user
     */

    public static void executeMenuOption(int option){
        switch (option){
            case 1:
                Scanner input = new Scanner(System.in);
                int option2;
                Competition.makeCompetition();

                // TODO: Make this input based function foolproof

                do {
                    showStartCompetitionMenu();
                    option2 = input.nextInt();
                    executeStartCompetitionOption(option2);
                } while (option2 != 5);

                break;

            case 2:

                break;

            default:
                System.out.println("This option does not exist. Try again");
        }
    }

    /**
     * Execute the option for the competition start menu
     * @param option chosen option by the user
     */
    public static void executeStartCompetitionOption(int option){
        switch (option) {
            case 1 -> Competition.addAthleteTotal();
            case 2 -> Competition.printAthleteList();
            case 3 -> Competition.changeAthleteAttribute();
            case 4 -> Competition.deleteAthleteRegistration();
            case 5 -> System.out.println("Starting the competition now...");
            default -> System.out.println("That option does not exist, try again.");
        }
    }

    public static void simulateCompetition(){
        System.out.println("""
            Welcome to your competition!
            First insert the chosen attempts.""");

        for (int i = 1; i < Competition.getSnatchAttempts(); i++) {
            while (!Competition.checkAttemptListSnatch(i)) {
                Competition.insertAttemptSnatch(1);
            }
            System.out.println("Round " + i + " is ready to start!");


        }


    }

}