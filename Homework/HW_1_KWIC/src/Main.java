import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        if (args.length < 1) {
            System.out.println("Usage: java Main <input-file>");
            return;
        }

        String filename = args[0];
        Input input = new TxtIn(filename);

        LineStorage storage = new LineStorage();

        // store original lines
        storage.setLines(input.readLines());

        CommandValidator commandValidator = new CommandValidator();
        
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine();

            if (commandValidator.validateCommand(command)) {
                
            }

        }

    }

}


