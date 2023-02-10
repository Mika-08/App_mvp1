import java.util.InputMismatchException;
import java.util.List;
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

            case 3:
                System.out.println("Shutting down the program...");

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
            case 5 -> {
                System.out.println("Starting the competition now...");
                simulateCompetition();
            }

            default -> System.out.println("That option does not exist, try again.");
        }
    }

    public static void simulateCompetition(){
        System.out.println("""
            Welcome to your competition!
            First insert the chosen attempts.""");

        for (int i = 1; i <= Competition.getSnatchAttempts(); i++) {
            while (!Competition.checkAttemptListSnatch(i)) {
                Competition.insertAttemptSnatch(i);
            }
            System.out.println("Round " + i + " is ready to start!");
            System.out.println("The following attempts will be made in this round: ");

            for (int j = 0; j < Competition.getAthleteList().size(); j++){
                System.out.println(Competition.getAthleteList().get(j).getName()
                    + " will be lifting " + Competition.getAthleteList().get(j).
                    getSnatchAttempts().getAttemptList().get(i).getWeight());
            }

            List<Athlete> order = Competition.orderAthletesByHighestSnatchForRound(i);
            for (Athlete athlete : order) {
                System.out.println("The next lifter is " + athlete.getName() + ".");
                System.out.println("Did " + athlete.getName() + " successfully lift the bar?");
                System.out.println("""
                    1 - Yes
                    2 - No""");
                Scanner validationScanner = new Scanner(System.in);
                int validation = validationScanner.nextInt();
                athlete.validateSnatchExecution(i, validation == 1);
            }
            Competition.getLiftList().get(0).sortLeaderboard(League.MALE);
            List<Athlete> leaderboard = Competition.getLiftList().get(0).getLeaderboardMale();
            System.out.println("The men leaderboard looks as follows: ");
            for (int l = 0; l < leaderboard.size(); l++){
                System.out.println((l + 1)+": " + leaderboard.get(l).getName());
            }

        }

        for (int i = 1; i <= Competition.getCleanAndJerkAttempts(); i++) {
            while (!Competition.checkAttemptListCleanAndJerk(i)) {
                Competition.insertAttemptCleanAndJerk(i);
            }
            System.out.println("Round " + i + " is ready to start!");
            System.out.println("The following attempts will be made in this round: ");

            for (int j = 0; j < Competition.getAthleteList().size(); j++){
                System.out.println(Competition.getAthleteList().get(j).getName()
                    + " will be lifting " + Competition.getAthleteList().get(j).
                    getCleanAndJerkAttempts().getAttemptList().get(i).getWeight());
            }

            List<Athlete> order = Competition.orderAthletesByHighestCleanAndJerkForRound(i);
            for (Athlete athlete : order) {
                System.out.println("The next lifter is " + athlete.getName() + ".");
                System.out.println("Did " + athlete.getName() + " successfully lift the bar?");
                System.out.println("""
                    1 - Yes
                    2 - No""");
                Scanner validationScanner = new Scanner(System.in);
                int validation = validationScanner.nextInt();
                athlete.validateSnatchExecution(i, validation == 1);
            }
            Competition.getLiftList().get(1).sortLeaderboard(League.MALE);
            List<Athlete> leaderboard = Competition.getLiftList().get(1).getLeaderboardMale();
            System.out.println("The men leaderboard looks as follows: ");
            for (int l = 0; l < leaderboard.size(); l++){
                System.out.println((l + 1)+": " + leaderboard.get(l).getName());
            }
        }

        Competition.makeLeaderBoard(League.MALE);
        for (int m = 0; m < Competition.getLeaderboardMale().size(); m++){
            System.out.println((m + 1)+": " + Competition.getLeaderboardMale().get(m).getName());
        }



    }

}