import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TxtOut implements Output {
    private String filename;

    public TxtOut() {
    }

    @Override
    public void printOutput(List<String> lines) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (String line : lines) {
                writer.write(line + System.lineSeparator());
            }
        } catch (IOException e) {
        }
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}