import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Competition {
    private static String name;
    private static ArrayList<Athlete> athleteList = new ArrayList<>();
    private static ArrayList<Athlete> leaderboardMale = new ArrayList<>();
    private static ArrayList<Athlete> leaderboardFemale = new ArrayList<>();
    private static ArrayList<Athlete> leaderboardTeen = new ArrayList<>();
    private static ArrayList<Lift> liftList = new ArrayList<>();
    private static int snatchAttempts = 0;
    private static int cleanAndJerkAttempts = 0;

    /**
     * Make new competition
     */
    public static void makeCompetition(){
        Scanner competitionInfo = new Scanner(System.in);
        System.out.println("Insert competition name: \n");
        name = competitionInfo.nextLine();
        System.out.println("The name you chose was: " + name + ".");
        makeNewLift();
    }

    /*
    public static void addAthleteNameOnly(){
        Scanner athleteInfo = new Scanner(System.in);
        System.out.println("Insert athlete name: \n");
        String name = athleteInfo.nextLine();
        System.out.println("The name you chose was: " + name + ".");
        Athlete newAthlete = new Athlete(name, 0);
        athleteList.add(newAthlete);

    }

     */

    /**
     * Add and athlete
     * May only be called after the creation of a new competition
     */

    public static void addAthleteTotal(){
        Scanner athleteInfo = new Scanner(System.in);
        System.out.println("Insert athlete name: \n");
        String name = athleteInfo.nextLine();
        System.out.println("The name you chose was: " + name + ".");

        System.out.println("Insert the weight of the athlete: \n");
        double weight = athleteInfo.nextDouble();
        System.out.println("The weight of the athlete is set to "+ weight + ".");

        System.out.println("""
            Choose league
            1 - Male
            2 - Female
            3 - Teen
            """);

        Enum<League> league;
        int leagueOption = athleteInfo.nextInt();

        if (leagueOption == 1){
            league = League.MALE;
        }
        else if (leagueOption == 2){
            league = League.FEMALE;
        }
        else {
            league = League.TEEN;
        }

        Athlete newAthlete = new Athlete(name, weight, league);
        athleteList.add(newAthlete);
        newAthlete.initializeAttemptList(snatchAttempts, cleanAndJerkAttempts);
    }

    /**
     * Print the list of athletes.
     */
    public static void printAthleteList(){
        if (athleteList.size() == 0){
            System.out.println("There are no athletes registered yet.");
        }

        for (Athlete athlete : athleteList) {
            System.out.print(athlete.toString());
        }
    }

    /**
     * Make new lift
     */
    public static void makeNewLift(){
        Scanner amountScanner = new Scanner(System.in);
        System.out.println("Amount of snatch attempts allowed: \n");
        int snatchAmount = amountScanner.nextInt();

        System.out.println("Amount of Clean and Jerk attempts allowed: \n");
        int cleanAndJerkAmount = amountScanner.nextInt();

        Lift snatch = new Lift("Snatch", snatchAmount, true);
        Lift cleanAndJerk = new Lift("Clean and Jerk", cleanAndJerkAmount, false);

        snatchAttempts = snatchAmount;
        cleanAndJerkAttempts = cleanAndJerkAmount;

        liftList.add(snatch);
        liftList.add(cleanAndJerk);

        System.out.println("You made a new competition with " + snatchAmount +
            " attempts for the snatch and " + cleanAndJerkAmount +
            " attempts for the clean and jerk.");
    }

    /**
     * Chance an attribute from an athlete
     */
    public static void changeAthleteAttribute(){
        System.out.println("Choose athlete to change the attribute of: \n");
        for (int i = 0; i < athleteList.size(); i++){
            System.out.println(i+1 + " - " + athleteList.get(i).getName());
        }

        Scanner athleteScanner = new Scanner(System.in);
        int index = athleteScanner.nextInt();

        System.out.println("""
            Choose attribute to change:
            1 - Name
            2 - Weight
            3 - league
            """);

        int choice = athleteScanner.nextInt();

        switch (choice) {
            case 1 -> {
                System.out.println("Provide new name: \n");

                // TODO: Make sure a name consisting of multiple words can be provided.
                String newName = athleteScanner.next();
                athleteList.get(index - 1).setName(newName);
            }
            case 2 -> {
                System.out.println("Provide new weight: \n");
                double newWeight = athleteScanner.nextDouble();
                athleteList.get(index - 1).setWeight(newWeight);
            }
            case 3 -> {
                System.out.println("""
                    Choose league
                    1 - Male
                    2 - Female
                    3 - Teen
                    """);
                int leagueOption = athleteScanner.nextInt();
                if (leagueOption == 1) {
                    athleteList.get(index - 1).setLeague(League.MALE);
                } else if (leagueOption == 2) {
                    athleteList.get(index - 1).setLeague(League.FEMALE);
                } else {
                    athleteList.get(index - 1).setLeague(League.TEEN);
                }
            }
            default -> System.out.println("Not a valid choice, back to menu.");
        }
    }

    /**
     * Delete an athlete from the list
     */
    public static void deleteAthleteRegistration(){
        System.out.println("Choose athlete to remove: \n");
        for (int i = 0; i < athleteList.size(); i++){
            System.out.println(i+1 + " - " + athleteList.get(i).getName());
        }

        Scanner athleteScanner = new Scanner(System.in);
        int index = athleteScanner.nextInt();
        System.out.println("Athlete " + athleteList.get(index - 1).getName() +
            " is deleted from the list. ");

        athleteList.remove(athleteList.get(index - 1));
    }

    /**
     * Start competition method
     * Initialize leaderboards
     *
     */

    public static void startCompetition(){

        // Initialize leaderboards
        for (Lift lift: liftList) {
            for (Athlete a : Competition.getAthleteList()) {
                if (a.getLeague() == League.MALE) {
                    lift.getLeaderboardMale().add(a);
                } else if (a.getLeague() == League.FEMALE) {
                    lift.getLeaderboardFemale().add(a);
                } else {
                    lift.getLeaderboardTeen().add(a);
                }
            }
        }
    }


    /*




    /**
     * Insert new attempt
     * @param round round
     */

    public static void insertAttemptSnatch(int round){
        Scanner attemptScanner = new Scanner(System.in);
        System.out.println("Choose athlete to set attempt amount of \n");
        for (int i = 0; i < athleteList.size(); i++){
            System.out.println(i+1 + " - " + athleteList.get(i).getName());
        }

        System.out.println("Insert amount: \n");
        double amount = attemptScanner.nextDouble();

        int index = attemptScanner.nextInt();
        getAthleteList().get(index - 1).insertAttemptSnatch(amount, round);
    }

    /**
     * Insert new attempt
     * @param round round
     */

    public static void insertAttemptCleanAndJerk(int round){
        Scanner attemptScanner = new Scanner(System.in);
        System.out.println("Choose athlete to set attempt amount of \n");
        for (int i = 0; i < athleteList.size(); i++){
            System.out.println(i+1 + " - " + athleteList.get(i).getName());
        }

        System.out.println("Insert amount: \n");
        double amount = attemptScanner.nextDouble();

        int index = attemptScanner.nextInt();
        getAthleteList().get(index - 1).insertAttemptSnatch(amount, round);
    }

    /**
     * Check if all attempts are filled in
     * @param round round to be checked
     * @return true or false
     */

    public static boolean checkAttemptListSnatch(int round){
        for (Athlete athlete: athleteList){
            if (athlete.getAttemptListSnatch().get(round) == null){
                return false;
            }
        }
        return true;
    }

    /**
     * Check if all attempts are filled in
     * @param round round to be checked
     * @return true or false
     */

    public static boolean checkAttemptListCleanAndJerk(int round){
        for (Athlete athlete: athleteList){
            if (athlete.getAttemptListCleanAndJerk().get(round) == null){
                return false;
            }
        }
        return true;
    }


    public static void saveToFile(){

    }

    /**
     * Get name
     * @return name
     */

    public static String getName() {
        return name;
    }

    /**
     * Get athlete list
     * @return athlete list
     */

    public static ArrayList<Athlete> getAthleteList() {
        return athleteList;
    }

    /**
     * Get leaderboard male
     * @return leaderboard male
     */

    public static ArrayList<Athlete> getLeaderboardMale() {
        return leaderboardMale;
    }

    /**
     * Get leaderboard female
     * @return leaderboard female
     */

    public static ArrayList<Athlete> getLeaderboardFemale() {
        return leaderboardFemale;
    }

    /**
     * Get leaderboard teen
     * @return leaderboard teen
     */

    public static ArrayList<Athlete> getLeaderboardTeen() {
        return leaderboardTeen;
    }

    /**
     * Get list of lifts
     * @return list of lifts
     */

    public static ArrayList<Lift> getLiftList() {
        return liftList;
    }

    /**
     * Get snatch attempts
     * @return amount of attempts for the snatch
     */

    public static int getSnatchAttempts() {
        return snatchAttempts;
    }

    /**
     * Get clean and jerk attempts
     * @return amount of attempts for the clean and jerk
     */

    public static int getCleanAndJerkAttempts() {
        return cleanAndJerkAttempts;
    }

    /**
     * Set name
     * @param name new name
     */

    public static void setName(String name) {
        Competition.name = name;
    }

    /**
     * Set athlete list
     * @param athleteList new list
     */

    public static void setAthleteList(ArrayList<Athlete> athleteList) {
        Competition.athleteList = athleteList;
    }
}
