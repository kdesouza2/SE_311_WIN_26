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

    @Override
    public void printOutput(String line) {
        System.out.println(line);
    }
    
}
