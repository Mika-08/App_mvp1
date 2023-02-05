import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lift {
    private String name;
    private int attempts;
    private ArrayList<Athlete> leaderboardMale;
    private ArrayList<Athlete> leaderboardFemale;
    private ArrayList<Athlete> leaderboardTeen;
    private boolean snatch;

    /**
     * Constructor for a new lift
     * @param name name
     * @param attempts amount of attempts
     */

    public Lift(String name, int attempts, boolean snatch) {
        this.name = name;
        this.attempts = attempts;
        this.snatch = snatch;
    }

    /**
     * Sort the leaderboards based on the highest scores
     */

    // TODO: Find a way to optimize this approach

    public void sortLeaderboard(Enum<League> leagueEnum){
        ArrayList<Athlete> sorted = null;
        if (snatch) {
            sorted =
                (ArrayList<Athlete>) Competition.getAthleteList().stream().
                    filter(athlete -> athlete.getLeague().equals(leagueEnum)).
                    sorted(Comparator.comparingDouble(Athlete::getHighestScoreSnatch)).collect(
                        Collectors.toList());
        }

        else {
            sorted =
                (ArrayList<Athlete>) Competition.getAthleteList().stream().
                    filter(athlete -> athlete.getLeague().equals(leagueEnum)).
                    sorted(Comparator.comparingDouble(Athlete::getHighestScoreCleanAndJerk)).collect(
                        Collectors.toList());
        }

        if (leagueEnum == League.MALE){
            leaderboardMale = sorted;
        }

        else if (leagueEnum == League.FEMALE){
            leaderboardFemale = sorted;
        }

        else {
            leaderboardTeen = sorted;
        }

    }




    /**
     * Get name
     * @return name
     */

    public String getName() {
        return name;
    }

    /**
     * Get amount of attempts
     * @return amount of attempts
     */

    public int getAttempts() {
        return attempts;
    }

    /**
     * Get leaderboard male
     * @return leaderboard male
     */

    public ArrayList<Athlete> getLeaderboardMale() {
        return leaderboardMale;
    }

    /**
     * Get leaderboard female
     * @return leaderboard female
     */

    public ArrayList<Athlete> getLeaderboardFemale() {
        return leaderboardFemale;
    }

    /**
     * Get leaderboard teen
     * @return leaderboard teen
     */

    public ArrayList<Athlete> getLeaderboardTeen() {
        return leaderboardTeen;
    }
}
