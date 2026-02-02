
import java.util.List;

public class CommandValidator {
    private static final List<String> VALID_COMMANDS = List.of("kwic", "search", "index", "quit");

    public CommandValidator() {
    }

    public boolean validateCommand(String command) {

        for (String validCommand : VALID_COMMANDS) {
            if (command.contains(validCommand)) {
                return true;
            }
        }

        return false;
    }
    
}
