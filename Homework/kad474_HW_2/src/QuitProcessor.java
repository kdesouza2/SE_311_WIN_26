
public class QuitProcessor extends CommandProcessor {

    public QuitProcessor(LineStorage originalLines, Output output) {
        super(originalLines, output);
    }

    public void execute() {
        System.out.println("You've successfully exited the program.");
    }
    
}
