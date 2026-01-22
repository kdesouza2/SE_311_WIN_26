import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class IndexProcessor extends CommandProcessor {
    private LineStorage originalLines;
    private final Map<String, List<Integer>> index;
    private Output output;

    public IndexProcessor (LineStorage originalLines, Output output) {
        super(originalLines, output);
        this.index = new TreeMap<>();
    }

    private void createIndex() {
        List<String> keywords = new ArrayList<>();

        for (String line : originalLines.getLines()) {
            String[] words = parseCommand(line);

            for (String word : words) {
                if (!keywords.contains(word)) {
                    keywords.add(word);
                }
            }
        }

        for (String word : keywords) {
            for (String line : originalLines.getLines()) {
                if (!index.containsKey(word)) {
                    index.put(word, new ArrayList<>());
                }
                index.get(word).add(originalLines.getLines().indexOf(line));
            }
        }
    }
    
    public void execute() {
        if (index.isEmpty()) {
            createIndex();
        }

        List<String> table = new ArrayList<>();

        for (Map.Entry<String, List<Integer>> entry : index.entrySet()) {
            String keyword = entry.getKey();
            List<Integer> lines = entry.getValue();

            StringBuilder sb = new StringBuilder();
            sb.append(keyword).append(", ");

            for (int i = 0; i < lines.size(); i++) {
                sb.append(lines.get(i));
                if (i < lines.size() - 1) {
                    sb.append(" ");
                }
            }

            table.add(sb.toString());
        }

        output.printOutput(table);

    }
    
    
}
