
public class QuitProcessor extends CommandProcessor {

    public QuitProcessor(LineStorage originalLines, Output output) {
        super(originalLines, output);
    }

    public void execute() {
        output.printOutputLine("You've successfully exited the program.");
    }
    
}
