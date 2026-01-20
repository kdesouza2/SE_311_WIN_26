import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class DescendingAlphabetizer implements Alphabetizer {

    @Override
    public List<String> sort(List<String> lines) {
        List<String> sorted = new ArrayList<>(lines); 
        sorted.sort(Collections.reverseOrder());
        return sorted;
    }
}

