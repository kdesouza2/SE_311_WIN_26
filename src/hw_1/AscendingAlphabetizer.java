package src.hw_1;
import java.util.Collections;
import java.util.List;

public class AscendingAlphabetizer implements Alphabetizer {

    @Override
    public List<String> sort(List<String> lines) {
        Collections.sort(lines);
        return lines;
    }
    
}
