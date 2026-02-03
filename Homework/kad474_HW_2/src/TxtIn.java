
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TxtIn implements Input {
    
    private String filename;

    public TxtIn() {
    }

    @Override
    public List<String> readLines() {
        List<String> input = new ArrayList<>();

        try (Scanner myReader = new Scanner(new File(filename))) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                input.add(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred: File not found.");
        }

        return input;
    }

    @Override
    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }
    
}
