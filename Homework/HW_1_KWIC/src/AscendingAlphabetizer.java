import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AscendingAlphabetizer implements Alphabetizer {

    @Override
    public List<String> sort(List<String> lines) {
        List<String> sorted = new ArrayList<>(lines);
        Collections.sort(sorted);
        return sorted;
    }
    
}
