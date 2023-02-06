
import lombok.AllArgsConstructor;
import lombok.Data;



@Data
@AllArgsConstructor
public class Attempt {
    private final int round;
    private final double weight;
    private Boolean isSuccessful;
}
