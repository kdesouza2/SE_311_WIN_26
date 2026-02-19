package src.hw_2;

import java.util.List;

public class CommandValidator {
    private static final List<String> VALID_COMMANDS = List.of("kwic-processing", "keyword-search", "index-generation");

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
