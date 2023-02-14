
import static org.junit.jupiter.api.Assertions.*;

class AthleteTest {

    @org.junit.jupiter.api.Test
    void calculateSinclair() {
        Athlete athlete = new Athlete("Yue", 55.6, League.FEMALE);
        athlete.getSnatchAttempts().setHighestScore(45);
        athlete.getCleanAndJerkAttempts().setHighestScore(63);

        assertEquals(153.50601950249748, athlete.calculateSinclair());
    }

    @org.junit.jupiter.api.Test
    void calculateSinclair2() {
        Athlete athlete = new Athlete("Yue", 55.6, League.FEMALE);
        athlete.getSnatchAttempts().setHighestScore(45);
        athlete.getCleanAndJerkAttempts().setHighestScore(63);

        double amount = 108*(Math.pow(10,0.7834974*Math.pow(Math.log(55.6/153.655)/Math.log(10),2)));

        assertEquals(153.50601426696542, amount);
    }

    @org.junit.jupiter.api.Test
    void getHighestSnatchScore() {
        Athlete athlete = new Athlete("Yue", 55.6, League.FEMALE);
        athlete.getSnatchAttempts().setHighestScore(45);
        athlete.getCleanAndJerkAttempts().setHighestScore(63);
        double snatch = athlete.getHighestScoreSnatch();

        assertEquals(43, snatch);
    }
    @org.junit.jupiter.api.Test
    void getHighestCleanScore() {
        Athlete athlete = new Athlete("Yue", 55.6, League.FEMALE);
        athlete.getSnatchAttempts().setHighestScore(45);
        athlete.getCleanAndJerkAttempts().setHighestScore(63);

        double clean = athlete.getHighestScoreCleanAndJerk();
        assertEquals(63, clean);

    }

    @org.junit.jupiter.api.Test
    void calculateTotalWeightLifted() {
        Athlete athlete = new Athlete("Yue", 55.6, League.FEMALE);
        athlete.getSnatchAttempts().setHighestScore(45);
        athlete.getCleanAndJerkAttempts().setHighestScore(63);

        double totalWeight = athlete.getHighestScoreSnatch() + athlete.getHighestScoreCleanAndJerk();

        assertEquals(108, totalWeight);
    }


//    @Test
//    void initialiseAttemptListSnatch(){
//        Athlete athlete = new Athlete("Yue", 55.6, League.FEMALE);
//        athlete.initializeAttemptList(3,3);
//
//        LinkedHashMap<Integer, Attempt> test = new LinkedHashMap<Integer, Attempt>();
//        test.put(1, new Attempt<>(0,0));
//        test.put(2, new Attempt<>(0,0));
//        test.put(3, new Attempt<>(0,0));
//
//        assertEquals(test.toString(), athlete.getSnatchAttempts().toString());
//    }
//
//    @Test
//    void updateAttemptListSnatch(){
//        Athlete athlete = new Athlete("Yue", 55.6, League.FEMALE);
//        athlete.initializeAttemptList(3,3);
//
//        athlete.addSnatchPlannedAttempt(1, 60);
//
//        LinkedHashMap<Integer, Attempt> test = new LinkedHashMap<Integer, Attempt>();
//        test.put(1, new Attempt<>(60,0));
//        test.put(2, new Attempt<>(0,0));
//        test.put(3, new Attempt<>(0,0));
//
//        assertEquals(test.toString(), athlete.getSnatchAttempts().toString());
//    }
//
//    @Test
//    void initialiseAttemptListCleanAndJerk(){
//        Athlete athlete = new Athlete("Yue", 55.6, League.FEMALE);
//        athlete.initializeAttemptList(3,3);
//
//        LinkedHashMap<Integer, Attempt<Double, Integer>> test =
//            new LinkedHashMap<Integer, Attempt<Double, Integer>>();
//        test.put(1, new Attempt<>(0,0));
//        test.put(2, new Attempt<>(0,0));
//        test.put(3, new Attempt<>(0,0));
//
//        assertEquals(test.toString(), athlete.getCleanAndJerkAttempts().toString());
//    }
//
//    @Test
//    void updateAttemptListCleanAndJerk(){
//        Athlete athlete = new Athlete("Yue", 55.6, League.FEMALE);
//        athlete.initializeAttemptList(3,3);
//
//        athlete.addCleanAndJerkPlannedAttempt(1, 60);
//
//        LinkedHashMap<Integer, Attempt<Double, Integer>> test =
//            new LinkedHashMap<Integer, Attempt<Double, Integer>>();
//        test.put(1, new Attempt<>(60,0));
//        test.put(2, new Attempt<>(0,0));
//        test.put(3, new Attempt<>(0,0));
//
//        assertEquals(test.toString(), athlete.getCleanAndJerkAttempts().toString());
//    }
//
//    @Test
//    void validationSnatch(){
//        Athlete athlete = new Athlete("Yue", 55.6, League.FEMALE);
//        athlete.initializeAttemptList(3,3);
//
//        athlete.addSnatchPlannedAttempt(1, 60);
//        athlete.validateSnatchExecution(1, true);
//
//        LinkedHashMap<Integer, Attempt<Double, Integer>> test =
//            new LinkedHashMap<Integer, Attempt<Double, Integer>>();
//        test.put(1, new Attempt<>(60,1));
//        test.put(2, new Attempt<>(0,0));
//        test.put(3, new Attempt<>(0,0));
//
//        assertEquals(test.toString(), athlete.getSnatchAttempts().toString());
//    }
//
//    @Test
//    void validationCleanAndJerk(){
//        Athlete athlete = new Athlete("Yue", 55.6, League.FEMALE);
//        athlete.initializeAttemptList(3,3);
//
//        athlete.addCleanAndJerkPlannedAttempt(1, 60);
//        athlete.validateCleanAndJerkExecution(1, true);
//
//        LinkedHashMap<Integer, Attempt<Double, Integer>> test =
//            new LinkedHashMap<Integer, Attempt<Double, Integer>>();
//        test.put(1, new Attempt<>(60,1));
//        test.put(2, new Attempt<>(0,0));
//        test.put(3, new Attempt<>(0,0));
//
//        assertEquals(test.toString(), athlete.getCleanAndJerkAttempts().toString());
//    }
//
//    @Test
//    void updateHighestScoreSnatch(){
//        Athlete athlete = new Athlete("Yue", 55.6, League.FEMALE);
//        athlete.initializeAttemptList(3,3);
//
//        athlete.addSnatchPlannedAttempt(1, 60);
//        athlete.validateSnatchExecution(1, true);
//        assertEquals(60, athlete.getHighestScoreSnatch());
//
//    }
//
//    @Test
//    void updateHighestScoreCleanAndJerk(){
//        Athlete athlete = new Athlete("Yue", 55.6, League.FEMALE);
//        athlete.initializeAttemptList(3,3);
//
//        athlete.addCleanAndJerkPlannedAttempt(1, 60);
//        athlete.validateCleanAndJerkExecution(1, true);
//        assertEquals(60, athlete.getHighestScoreCleanAndJerk());
//
//    }

}