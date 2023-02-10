import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AttemptExecutionsTest {

    @Test
    void getSuccessfulExecutionForRound() {

        Athlete athlete = new Athlete("Mike", 65, League.MALE);
        Athlete athlete2 = new Athlete("Mark", 65, League.MALE);
        Athlete athlete3 = new Athlete("George", 65, League.MALE);

        ArrayList<Athlete> list = new ArrayList<>();
        list.add(athlete);
        list.add(athlete2);
        list.add(athlete3);

        Competition.setAthleteList(list);

        athlete.addSnatchPlannedAttempt(1, 100);
        athlete2.addSnatchPlannedAttempt(1, 75);
        athlete3.addSnatchPlannedAttempt(1, 90);

        assertEquals(100, athlete.getSnatchAttempts().getAttemptWeightForRound(1));
    }
}