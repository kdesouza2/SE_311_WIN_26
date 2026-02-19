package src.hw_3;
public class Main {

    public static void main(String[] args) {


        // 1. Load configuration
        OptionReader.readOptions();

        // 2. Create objects from config
        String typeOfInput = OptionReader.getString("Input");
        Input input = (Input) OptionReader.getObjectFromKey(typeOfInput);
        String typeOfOutput = OptionReader.getString("Output");
        Output output = (Output) OptionReader.getObjectFromKey(typeOfOutput);

        // 3. Inject runtime data (filename)
        if (input instanceof TxtIn txtIn) {
            txtIn.setFilename(OptionReader.getString("InputFileName"));
        } 

        if (input instanceof CsvIn csvIn) {
            csvIn.setFilename(OptionReader.getString("InputFileName"));
        }

        if (output instanceof TxtOut txtOut) {
            String outputFile = OptionReader.getString("OutputFileName");
            txtOut.setFilename(outputFile);
        }

        LineStorage storage = new LineStorage();
        CommandValidator commandValidator = new CommandValidator();

        // store original lines
        storage.setLines(input.readLines());

        CommandProcessor commandProcessor = new CommandProcessor(storage, output);

        System.out.println("\nKWIC System Processing Command:");

        if (!commandValidator.validateCommand(args[0])) {
            System.out.println("Invalid Command");
        } else {
            commandProcessor.processCommand(args);
        }
        
    }
}
    

