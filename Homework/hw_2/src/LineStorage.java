package homework.hw_2.src;

import java.util.ArrayList;
import java.util.List;

public class LineStorage {
    private List<String> lines;

    public LineStorage() {
        this.lines = new ArrayList<>();
    }

    public List<String> getLines() {
        return lines;
    }    

    public void setLines(List<String> newInput) {
        this.lines = newInput;
    }

    public boolean isEmpty() {
        return (lines.isEmpty());
    }
}
