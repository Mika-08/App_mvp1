import java.util.LinkedHashMap;

public class Athlete {
    private String name;
    private double weight;
    private Enum<League> league;

    private AttemptExecutions snatchAttempts = new AttemptExecutions();
    private AttemptExecutions cleanAndJerkAttempts = new AttemptExecutions();

    /**
     * Constructor for a new athlete
     * @param name name
     * @param weight weight
     * @param league league
     */

    public Athlete(String name, double weight, Enum<League> league) {
        this.name = name;
        this.weight = weight;
        this.league = league;
    }

    /**
     * Based on the amount of attempts provided, make new linkedHashmaps
     * @param totalSnatchRounds amount of snatches
     * @param totalCleanAndJerkRounds amount of clean and jerks
     */

    public void initializeAttemptList(int totalSnatchRounds, int totalCleanAndJerkRounds) {
        initialize(totalSnatchRounds, snatchAttempts);
        initialize(totalCleanAndJerkRounds, cleanAndJerkAttempts);
    }

    private void initialize(int totalRounds, AttemptExecutions executions) {
        for (int i = 0; i < totalRounds; i++) {
            executions.addPlan(i + 1, 0.0);
        }
    }

    /**
     * Insert new attempt amount for snatch
     *
     * @param round   round in which it needs to be inserted
     * @param weight amount
     */

    public void addSnatchPlannedAttempt(int round, double weight) {
        snatchAttempts.addPlan(round, weight);
    }


    /**
     * Inset new attempts amount for clean and jerk
     *
     * @param round   round in which it needs to be inserted
     * @param weight amount
     */
    public void addCleanAndJerkPlannedAttempt(int round, double weight) {
        cleanAndJerkAttempts.addPlan(round, weight);
    }

    /**
     * Validate score
     * @param round round in which the score needs to be validated
     * @param isSuccessful fail or pass
     */

    public void validateSnatchExecution(int round, boolean isSuccessful) {
        snatchAttempts.validateExecution(round, isSuccessful);
    }

    /**
     * Validate score
     * @param round round in which the score needs to be validated
     * @param isSuccessful fail or pass
     */

    public void validateCleanAndJerkExecution(int round, boolean isSuccessful) {
        cleanAndJerkAttempts.validateExecution(round, isSuccessful);
    }


    /**
     * Calculate sinclair total
     * @return sinclair total
     */

    public double calculateSinclair(){
        double totalWeight = snatchAttempts.getHighestScore() + cleanAndJerkAttempts.getHighestScore();
        double womenCoefficientA = 0.783497476;
        double menCoefficientA = 0.751945030;
        double womenCoefficientB = 153.655;
        double menCoefficientB = 175.508;
        double sinclairTotal = 0;

        if (this.league == League.MALE){
            sinclairTotal = totalWeight * Math.pow(10, menCoefficientA *
                Math.pow(Math.log(this.weight/menCoefficientB)/Math.log(10),2));
        }

        else if(this.league == League.FEMALE){
            sinclairTotal = totalWeight * Math.pow(10, womenCoefficientA *
                Math.pow(Math.log(this.weight/womenCoefficientB)/Math.log(10),2));
        }

        else {
            sinclairTotal = totalWeight * Math.pow(10, womenCoefficientA *
                Math.pow(Math.log(this.weight/womenCoefficientB)/Math.log(10),2));
        }

        return sinclairTotal;
    }

    /**
     * Get name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Get weight
     * @return weight
     */

    public double getWeight() {
        return weight;
    }

    /**
     * Get fail and achieve list for the snatch
     *
     * @return list
     */

    public AttemptExecutions getSnatchAttempts() {
        return snatchAttempts;
    }

    /**
     * Get fail and achieve list for the clean and jerk
     *
     * @return list
     */
    public AttemptExecutions getCleanAndJerkAttempts() {
        return cleanAndJerkAttempts;
    }

    /**
     * Get league
     * @return league
     */

    public Enum<League> getLeague() {
        return league;
    }

    /**
     * Get the highest score snatch
     * @return highest score
     */
    public double getHighestScoreSnatch() {
        return snatchAttempts.getHighestScore();
    }

    /**
     * Get the highest score clean and jerk
     * @return highest score
     */

    public double getHighestScoreCleanAndJerk() {
        return snatchAttempts.getHighestScore();
    }

    /**
     * Set name
     * @param name new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set weight
     * @param weight new weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    // TODO: Make these be changeable separately

    /**
     * Set league
     * @param league league
     */

    public void setLeague(Enum<League> league) {
        this.league = league;
    }


    /**
     * To string method
     * @return string representation of the athlete
     */

    @Override
    public String toString() {
        return "Name athlete: " + name +" (" + league + ") \n" +
            "Weight of the athlete: " + weight + " kg. \n" +
            "Highest score snatch: " + snatchAttempts.getHighestScore() + ".\n" +
            "Highest score Clean and Jerk: " + cleanAndJerkAttempts.getHighestScore() + ".\n\n";
    }
}
