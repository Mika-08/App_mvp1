import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Lift {
    private String name;
    private int attempts;
    private List<Athlete> leaderboardMale;
    private List<Athlete> leaderboardFemale;
    private List<Athlete> leaderboardTeen;
    private boolean snatch;

    /**
     * Constructor for a new lift
     *
     * @param name     name
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
    public void sortLeaderboard(Enum<League> leagueEnum) {
        List<Athlete> sorted;
        if (snatch) {
            sorted = Competition.getAthleteList().stream()
                    .filter(athlete -> athlete.getLeague().equals(leagueEnum))
                    .sorted(Comparator.comparingDouble(Athlete::getHighestScoreSnatch).reversed())
                    .collect(Collectors.toList());
        } else {
            sorted = Competition.getAthleteList().stream()
                    .filter(athlete -> athlete.getLeague().equals(leagueEnum))
                    .sorted(Comparator.comparingDouble(Athlete::getHighestScoreCleanAndJerk).reversed())
                    .collect(Collectors.toList());
        }

        if (leagueEnum == League.MALE) {
            leaderboardMale = sorted;
        } else if (leagueEnum == League.FEMALE) {
            leaderboardFemale = sorted;
        } else {
            leaderboardTeen = sorted;
        }

    }


    /**
     * Get name
     *
     * @return name
     */

    public String getName() {
        return name;
    }

    /**
     * Get amount of attempts
     *
     * @return amount of attempts
     */

    public int getAttempts() {
        return attempts;
    }

    /**
     * Get leaderboard male
     *
     * @return leaderboard male
     */

    public List<Athlete> getLeaderboardMale() {
        return leaderboardMale;
    }

    /**
     * Get leaderboard female
     *
     * @return leaderboard female
     */

    public List<Athlete> getLeaderboardFemale() {
        return leaderboardFemale;
    }

    /**
     * Get leaderboard teen
     *
     * @return leaderboard teen
     */

    public List<Athlete> getLeaderboardTeen() {
        return leaderboardTeen;
    }
}
