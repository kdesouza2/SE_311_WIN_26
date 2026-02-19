package homework.hw_3.src;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class TxtOut implements Output {
    private String filename;

    public TxtOut() {
    }

    @Override
    public void printOutput(List<String> lines) {
        System.out.println("Writing to: " + filename);

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (String line : lines) {
                writer.println(line);
            }
        } catch (IOException ex) {
            System.out.println("Error saving output");
        }
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}