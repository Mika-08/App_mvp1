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

        athlete.setHighestScoreCleanAndJerk(50);
        athlete2.setHighestScoreCleanAndJerk(75);
        athlete3.setHighestScoreCleanAndJerk(80);
        athlete4.setHighestScoreCleanAndJerk(90);
        athlete5.setHighestScoreCleanAndJerk(100);

        ArrayList<Athlete> list = new ArrayList<>();
        list.add(athlete5);
        list.add(athlete4);
        list.add(athlete3);
        list.add(athlete2);
        list.add(athlete);

        Competition.setAthleteList(list);

        ArrayList<Athlete> test = new ArrayList<>();
        test.add(athlete);
        test.add(athlete2);
        test.add(athlete4);
        test.add(athlete5);
        clean.sortLeaderboard(League.MALE);


        assertEquals(test, clean.getLeaderboardMale());

        Competition.getAthleteList().clear();

    }
}