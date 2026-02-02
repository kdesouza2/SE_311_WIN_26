
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TxtIn implements Input {
    
    private final String filename;

    public TxtIn(String filename) {
        this.filename = filename;
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
    
}
