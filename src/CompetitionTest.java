import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CompetitionTest {

    @Test
    void checkAttemptListSnatchTrue() {
        Athlete athlete = new Athlete("Bob", 65, League.MALE);
        Athlete athlete2 = new Athlete("Mark", 65, League.MALE);
        ArrayList<Athlete> list = new ArrayList<>();
        list.add(athlete);
        list.add(athlete2);

        Competition.setAthleteList(list);

        athlete.insertAttemptSnatch(70, 1);
        athlete2.insertAttemptSnatch(75, 1);
        assertTrue(Competition.checkAttemptListSnatch(1));
        Competition.getAthleteList().clear();
    }

    @Test
    void checkAttemptListSnatchFalse() {
        Athlete athlete = new Athlete("Bob", 65, League.MALE);
        Athlete athlete2 = new Athlete("Mark", 65, League.MALE);

        ArrayList<Athlete> list = new ArrayList<>();
        list.add(athlete);
        list.add(athlete2);

        Competition.setAthleteList(list);

        athlete2.insertAttemptSnatch(75, 1);
        assertFalse(Competition.checkAttemptListSnatch(1));
        Competition.getAthleteList().clear();
    }

    @Test
    void makeOrder(){
        Athlete athlete = new Athlete("Mike", 65, League.MALE);
        Athlete athlete2 = new Athlete("Mark", 65, League.MALE);
        Athlete athlete3 = new Athlete("George", 65, League.MALE);

        ArrayList<Athlete> list = new ArrayList<>();
        list.add(athlete);
        list.add(athlete2);
        list.add(athlete3);

        Competition.setAthleteList(list);

        athlete.insertAttemptSnatch(80, 1);
        athlete2.insertAttemptSnatch(75, 1);
        athlete3.initializeAttemptList(90, 1);

        /*
        The attemptList is a linkedHashmap<Integer, MyKey<Double, Integer>>;
        MyKey<Double, Integer> is a class which implements the map.Entry interface
        The idea is that the Competition.makeOrderListSnatch method creates a new (Array)List int
        which the athletes in the competition list are ordered in ascending order of their chosen
        attempts.
         */

        // Order based on ascending attempt amounts in the first round
        ArrayList<Athlete> testOutput = new ArrayList<>();
        testOutput.add(athlete2);
        testOutput.add(athlete);
        testOutput.add(athlete3);

        // Calculated order
        ArrayList<Athlete> order = Competition.makeOrderListSnatch(1);

        assertEquals(testOutput, order);
        Competition.getAthleteList().clear();
    }

}