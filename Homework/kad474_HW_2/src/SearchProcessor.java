
import java.util.ArrayList;
import java.util.List;

public class SearchProcessor extends CommandProcessor {
    private final String command;

    public SearchProcessor(LineStorage originalLines, Output output, String command) {
        super(originalLines, output);
        this.command = command;
    }

    public void execute() {
        String[] parts = parseCommand(command);
        String keyword = parts[1].toLowerCase();

        List<String> foundLines = new ArrayList<>();

        int currNum = 1;
        for (String line : originalLines.getLines()) {
            if (line.contains(keyword)) {
                foundLines.add(String.format("%d  |  %s  | %d", currNum, line.replace(keyword, String.format("**%s**", keyword)), originalLines.getLines().indexOf(line) + 1));
                currNum++;
            }
        }

        if (foundLines.isEmpty()) {
            System.out.println(String.format("[%s] not found.", keyword));
        } else {
            System.out.println("Index  |  Line with Keyword Bolded  | Original Line Index");
            System.out.println(String.format("%d sentence(s) found:", foundLines.size()));
            output.printOutput(foundLines);
        }

    }

    
}
