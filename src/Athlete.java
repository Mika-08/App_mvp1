import java.security.KeyStore;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Athlete {
    private String name;
    private double weight;
    private Enum<League> league;

    private LinkedHashMap<Integer, MyKey<Double, Integer>>
        attemptListSnatch = new LinkedHashMap<>();
    private LinkedHashMap<Integer, MyKey<Double, Integer>>
        attemptListCleanAndJerk = new LinkedHashMap<>();
    private double highestScoreSnatch = 0;
    private double highestScoreCleanAndJerk = 0;

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
     * @param snatchAmount amount of snatches
     * @param cleanAndJerkAmount amount of clean and jerks
     */

    public void initializeAttemptList(int snatchAmount, int cleanAndJerkAmount){
        for (int i = 0; i < snatchAmount; i++){
            attemptListSnatch.put(i+1 , new MyKey<Double, Integer>(0,0));
        }

        for (int j = 0; j < cleanAndJerkAmount; j++){
            attemptListCleanAndJerk.put(j+1 , new MyKey<Double, Integer>(0,0));
        }
    }

    /**
     * Insert new attempt amount for snatch
     * @param attempt amount
     * @param round round in which it needs to be inserted
     */

    public void insertAttemptSnatch(double attempt, int round){
        MyKey<Double, Integer> newAttempt = new MyKey<>(attempt, 0);
        attemptListSnatch.put(round, newAttempt);
    }


    /**
     * Inset new attempts amount for clean and jerk
     * @param attempt amount
     * @param round round in which it needs to be inserted
     */
    public void insertAttemptCleanAndJerk(double attempt, int round){
        MyKey<Double, Integer> newAttempt = new MyKey<>(attempt, 0);
        attemptListCleanAndJerk.put(round, newAttempt);
    }

    /**
     * Validate score
     * @param round round in which the score needs to be validated
     * @param validation fail or pass
     */

    public void validateScoreSnatch(int round, boolean validation){
        if (validation){
            MyKey<Double, Integer> oldNode = attemptListSnatch.get(round);
            oldNode.setValue(1);
            attemptListSnatch.put(round, oldNode);
            highestScoreSnatch = (double) oldNode.getKey();
        }
    }

    /**
     * Validate score
     * @param round round in which the score needs to be validated
     * @param validation fail or pass
     */

    public void validateScoreCleanAndJerk(int round, boolean validation){
        if (validation){
            MyKey<Double, Integer> oldNode = attemptListCleanAndJerk.get(round);
            oldNode.setValue(1);
            attemptListCleanAndJerk.put(round, oldNode);
            highestScoreCleanAndJerk = (double) oldNode.getKey();
        }
    }


    /**
     * Calculate sinclair total
     * @return sinclair total
     */

    public double calculateSinclair(){
        double totalWeight = highestScoreSnatch + highestScoreCleanAndJerk;
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

    public LinkedHashMap<Integer, MyKey<Double, Integer>> getAttemptListSnatch() {
        return attemptListSnatch;
    }

    /**
     * Get fail and achieve list for the clean and jerk
     *
     * @return list
     */
    public LinkedHashMap<Integer, MyKey<Double, Integer>> getAttemptListCleanAndJerk() {
        return attemptListCleanAndJerk;
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
        return highestScoreSnatch;
    }

    /**
     * Get the highest score clean and jerk
     * @return highest score
     */

    public double getHighestScoreCleanAndJerk() {
        return highestScoreCleanAndJerk;
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
     * Set failAchieveSnatch
     * @param attemptListSnatch new list
     */
    public void setAttemptListSnatch(LinkedHashMap<Integer, MyKey<Double, Integer>> attemptListSnatch) {
        this.attemptListSnatch = attemptListSnatch;
    }

    /**
     * Set failAchieveCleanAndJerk
     * @param attemptListCleanAndJerk new list
     */

    public void setAttemptListCleanAndJerk(LinkedHashMap<Integer, MyKey<Double, Integer>> attemptListCleanAndJerk) {
        this.attemptListCleanAndJerk = attemptListCleanAndJerk;
    }


    /**
     * Set highest score snatch
     * @param highestScoreSnatch new highest score
     */
    public void setHighestScoreSnatch(double highestScoreSnatch) {
        this.highestScoreSnatch = highestScoreSnatch;
    }

    /**
     * Set highest score clean and jerk
     * @param highestScoreCleanAndJerk new highest score
     */

    public void setHighestScoreCleanAndJerk(double highestScoreCleanAndJerk) {
        this.highestScoreCleanAndJerk = highestScoreCleanAndJerk;
    }

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
            "Highest score snatch: " + getHighestScoreSnatch() + ".\n" +
            "Highest score Clean and Jerk: " + getHighestScoreCleanAndJerk() + ".\n\n";
    }
}
