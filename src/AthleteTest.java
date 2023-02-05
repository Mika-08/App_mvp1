import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.*;

class AthleteTest {

    @org.junit.jupiter.api.Test
    void calculateSinclair() {
        Athlete athlete = new Athlete("Yue", 55.6, League.FEMALE);
        athlete.setHighestScoreSnatch(43);
        athlete.setHighestScoreCleanAndJerk(63);

        assertEquals(153.50601950249748, athlete.calculateSinclair());
    }

    @Test
    void initialiseAttemptListSnatch(){
        Athlete athlete = new Athlete("Yue", 55.6, League.FEMALE);
        athlete.initializeAttemptList(3,3);

        LinkedHashMap<Integer, MyKey> test = new LinkedHashMap<Integer, MyKey>();
        test.put(1, new MyKey<>(0,0));
        test.put(2, new MyKey<>(0,0));
        test.put(3, new MyKey<>(0,0));

        assertEquals(test.toString(), athlete.getAttemptListSnatch().toString());
    }

    @Test
    void updateAttemptListSnatch(){
        Athlete athlete = new Athlete("Yue", 55.6, League.FEMALE);
        athlete.initializeAttemptList(3,3);

        athlete.insertAttemptSnatch(60,1);

        LinkedHashMap<Integer, MyKey> test = new LinkedHashMap<Integer, MyKey>();
        test.put(1, new MyKey<>(60,0));
        test.put(2, new MyKey<>(0,0));
        test.put(3, new MyKey<>(0,0));

        assertEquals(test.toString(), athlete.getAttemptListSnatch().toString());
    }

    @Test
    void initialiseAttemptListCleanAndJerk(){
        Athlete athlete = new Athlete("Yue", 55.6, League.FEMALE);
        athlete.initializeAttemptList(3,3);

        LinkedHashMap<Integer, MyKey<Double, Integer>> test =
            new LinkedHashMap<Integer, MyKey<Double, Integer>>();
        test.put(1, new MyKey<>(0,0));
        test.put(2, new MyKey<>(0,0));
        test.put(3, new MyKey<>(0,0));

        assertEquals(test.toString(), athlete.getAttemptListCleanAndJerk().toString());
    }

    @Test
    void updateAttemptListCleanAndJerk(){
        Athlete athlete = new Athlete("Yue", 55.6, League.FEMALE);
        athlete.initializeAttemptList(3,3);

        athlete.insertAttemptCleanAndJerk(60,1);

        LinkedHashMap<Integer, MyKey<Double, Integer>> test =
            new LinkedHashMap<Integer, MyKey<Double, Integer>>();
        test.put(1, new MyKey<>(60,0));
        test.put(2, new MyKey<>(0,0));
        test.put(3, new MyKey<>(0,0));

        assertEquals(test.toString(), athlete.getAttemptListCleanAndJerk().toString());
    }

    @Test
    void validationSnatch(){
        Athlete athlete = new Athlete("Yue", 55.6, League.FEMALE);
        athlete.initializeAttemptList(3,3);

        athlete.insertAttemptSnatch(60,1);
        athlete.validateScoreSnatch(1, true);

        LinkedHashMap<Integer, MyKey<Double, Integer>> test =
            new LinkedHashMap<Integer, MyKey<Double, Integer>>();
        test.put(1, new MyKey<>(60,1));
        test.put(2, new MyKey<>(0,0));
        test.put(3, new MyKey<>(0,0));

        assertEquals(test.toString(), athlete.getAttemptListSnatch().toString());
    }

    @Test
    void validationCleanAndJerk(){
        Athlete athlete = new Athlete("Yue", 55.6, League.FEMALE);
        athlete.initializeAttemptList(3,3);

        athlete.insertAttemptCleanAndJerk(60,1);
        athlete.validateScoreCleanAndJerk(1, true);

        LinkedHashMap<Integer, MyKey<Double, Integer>> test =
            new LinkedHashMap<Integer, MyKey<Double, Integer>>();
        test.put(1, new MyKey<>(60,1));
        test.put(2, new MyKey<>(0,0));
        test.put(3, new MyKey<>(0,0));

        assertEquals(test.toString(), athlete.getAttemptListCleanAndJerk().toString());
    }

    @Test
    void updateHighestScoreSnatch(){
        Athlete athlete = new Athlete("Yue", 55.6, League.FEMALE);
        athlete.initializeAttemptList(3,3);

        athlete.insertAttemptSnatch(60,1);
        athlete.validateScoreSnatch(1, true);
        assertEquals(60, athlete.getHighestScoreSnatch());

    }

    @Test
    void updateHighestScoreCleanAndJerk(){
        Athlete athlete = new Athlete("Yue", 55.6, League.FEMALE);
        athlete.initializeAttemptList(3,3);

        athlete.insertAttemptCleanAndJerk(60,1);
        athlete.validateScoreCleanAndJerk(1, true);
        assertEquals(60, athlete.getHighestScoreCleanAndJerk());

    }

}