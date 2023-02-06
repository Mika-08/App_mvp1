import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LiftTest {

    @Test
    void sortLeaderboard() {
        Athlete athlete = new Athlete("Bob", 85, League.MALE);
        Athlete athlete2 = new Athlete("Mike", 85, League.MALE);
        Athlete athlete3 = new Athlete("George", 85, League.FEMALE);
        Athlete athlete4 = new Athlete("Jake", 85, League.MALE);
        Athlete athlete5 = new Athlete("Finn", 85, League.MALE);

        Lift clean = new Lift("Clean and Jerk", 3, false);

        athlete.getCleanAndJerkAttempts().setHighestScore(50);
        athlete2.getCleanAndJerkAttempts().setHighestScore(75);
        athlete3.getCleanAndJerkAttempts().setHighestScore(80);
        athlete4.getCleanAndJerkAttempts().setHighestScore(90);
        athlete5.getCleanAndJerkAttempts().setHighestScore(100);

        ArrayList<Athlete> list = new ArrayList<>();
        list.add(athlete5);
        list.add(athlete4);
        list.add(athlete2);
        list.add(athlete);

        Competition.setAthleteList(list);

        clean.sortLeaderboard(League.MALE);

        assertEquals(list, clean.getLeaderboardMale());

        Competition.getAthleteList().clear();

    }
}