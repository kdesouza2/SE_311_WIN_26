package homework.hw_2.src;

import java.util.Collections;
import java.util.List;

class DescendingAlphabetizer implements Alphabetizer {

    public DescendingAlphabetizer() {
    }
    
    @Override
    public List<String> sort(List<String> lines) { 
        Collections.sort(lines.reversed());
        return lines;
    }
}

