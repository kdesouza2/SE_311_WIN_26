
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class IndexProcessor extends CommandProcessor {
    private final Map<String, Integer> index;

    public IndexProcessor (LineStorage originalLines, Output output) {
        super(originalLines, output);
        this.index = new TreeMap<>();
    }

    private void createIndex() {
        List<String> keywords = new ArrayList<>();
        String trivialWords = "";

        if (OptionReader.getString("WordFiltering").equals("Yes")) {
            trivialWords = OptionReader.getString("TrivialWords");
        }

        for (String line : originalLines.getLines()) {
            String[] words = parseCommand(line);

            for (String word : words) {
                if (!keywords.contains(word) && !trivialWords.contains(word)) {
                    keywords.add(word);
                }
            }
        }

        for (String word : keywords) {
            for (String line : originalLines.getLines()) {
                if (line.contains(word)) {
                    if (!index.containsKey(word)) {
                        index.put(word, 0);
                    }
                    index.merge(word, 1, Integer::sum);
                }
            }
        }
    }
    
    public void execute() {
        if (index.isEmpty()) {
            createIndex();
        }

        List<String> table = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : index.entrySet()) {
            String keyword = entry.getKey();
            Integer value = entry.getValue();
        
            StringBuilder sb = new StringBuilder();
            sb.append(keyword).append(", ").append(value);
        
            table.add(sb.toString());
        }

        output.printOutput(table);

    }

    
}
