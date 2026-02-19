package homework.hw_3.src;

import java.util.ArrayList;
import java.util.List;

public class SearchProcessor extends CommandProcessor {
    private final String keyword;

    public SearchProcessor(LineStorage originalLines, Output output, String keyword) {
        super(originalLines, output);
        this.keyword = keyword;
    }

    public void execute() {

        List<String> foundLines = new ArrayList<>();

        int currNum = 1;
        for (String line : originalLines.getLines()) {
            if (line.contains(keyword)) {
                foundLines.add(String.format("%d  |  %s  | %d", currNum, line.replace(keyword, String.format("[%s]", keyword)), originalLines.getLines().indexOf(line) + 1));
                currNum++;
            }
        }

        if (foundLines.isEmpty()) {
            foundLines.add(0, String.format("[%s] not found.", keyword));
        } else {
            foundLines.add(0, String.format("%d sentence(s) found:", foundLines.size()));
            foundLines.add(1, "Index  |  Line with Keyword Bolded  | Original Line Index");
        }

        output.printOutput(foundLines);

    }

    
}
