package homework.hw_2.src;

import java.util.ArrayList;
import java.util.List;

public class KWICProcessor extends CommandProcessor {
    private final LineStorage kwic;

    public KWICProcessor (LineStorage originalLines, Output output) {
        super(originalLines, output);
        this.kwic = new LineStorage();
    }

    private void createKWICTable() {
        List<String> kwicTable = new ArrayList<>();
        kwicTable.add("Index  |  Circular Shifted Lines  | Original Line Index");
        
        List<String> circularLines = circularShift(originalLines);
        circularLines = alphabetize(circularLines);

        int currNum = 1;

        for (String line : circularLines) {
            kwicTable.add(String.format("%d  |  %s", currNum, line));
            currNum++;
        }

        kwic.setLines(kwicTable);
    }

    private List<String> alphabetize(List<String> lines) {

        String typeOfSorter = OptionReader.getString("Order");
        Alphabetizer alphabetizer = (Alphabetizer) OptionReader.getObjectFromKey(typeOfSorter);

        return (alphabetizer.sort(lines));
    }

    private List<String> circularShift(LineStorage originalLines) {
        List<String> circularLines = new ArrayList<>();

        for (String line : originalLines.getLines()) {
            String[] words = line.split(" ");
            
            for (int i = 0; i < words.length; i++) {
                StringBuilder sb = new StringBuilder();
                
                for (int j = 0; j < words.length; j++) {
                    sb.append(words[(i + j) % words.length]);
                    if (j != words.length - 1) {
                        sb.append(" ");
                    }
                }
                
                circularLines.add(String.format("%s  |  %d", sb.toString(), originalLines.getLines().indexOf(line) + 1));
            }
        }

        return circularLines;
    }

    public void execute(){
        
        if (kwic.isEmpty()) {
            createKWICTable();
        }

        output.printOutput(kwic.getLines());
    }
    
}
