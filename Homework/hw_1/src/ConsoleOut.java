package homework.hw_1.src;
import java.util.List;

public class ConsoleOut implements Output {

    public ConsoleOut() {
    }

    @Override
    public void printOutput(List<String> lines) {
        for (String line : lines) {
            System.out.println(line);
        }
    }
    
}
