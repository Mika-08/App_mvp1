import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class AttemptExecutions {
    private Map<Integer, Attempt> attemptList = new LinkedHashMap<>();
    double highestScore = 0.0;

    public void addPlan(int round, double weight) {
        attemptList.put(round, new Attempt(round, weight, null));
    }

    /**
     * Check if the attempt was successfully lifted
     * @param round round
     * @param isSuccessful true or false
     */
    public void validateAttempt(int round, boolean isSuccessful) {
        Attempt attempt = attemptList.computeIfAbsent(round, integer -> {
            throw new IllegalStateException("No round was planned for '" + round + ";");
        });
        attempt.setIsSuccessful(isSuccessful);

        highestScore = isSuccessful && attempt.getWeight() > highestScore
                ? attempt.getWeight()
                : highestScore;
    }

    /**
     * Return the amount inserted for a given round
     * @param round round
     * @return either the weight of the attempt of 0.0 if the attempt was successfully inserted
     * @throws IllegalArgumentException when the attempt list has no value for a given round
     */

    public double getAttemptWeightForRound(int round) throws IllegalArgumentException{
        Attempt attempt = attemptList.computeIfAbsent(round, integer -> {
            throw new IllegalStateException("No round was planned for '" + round + ";");
        });

        /*
        return Boolean.TRUE.equals(attempt.getIsSuccessful())
                ? attempt.getWeight() :
                0.0;

         */
        return attempt.getWeight();
    }
}
