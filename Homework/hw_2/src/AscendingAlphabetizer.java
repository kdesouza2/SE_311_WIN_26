package homework.hw_2.src;

import java.util.Collections;
import java.util.List;

public class AscendingAlphabetizer implements Alphabetizer {

    public AscendingAlphabetizer() {
    }

    @Override
    public List<String> sort(List<String> lines) {
        Collections.sort(lines);
        return lines;
    }
    
}
