public class Main {

    public static void main(String[] args) {
        
        if (args.length < 1) {
            System.out.println("Usage: java Main <input-file>");
            return;
        }

        String filename = args[0];
        Input input = new TxtIn(filename);
        Output output = new ConsoleOut();
        LineStorage storage = new LineStorage();

        // store original lines
        storage.setLines(input.readLines());
        
        
    }

}


