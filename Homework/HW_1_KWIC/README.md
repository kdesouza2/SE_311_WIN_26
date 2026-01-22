# KWIC Processor

### How to Run Program
Navigate to HW_1_KWIC folder, open terminal and run java -cp out src/Main.java inputs/sample.txt

### How to Use Console Commands
This program accepts 4 commands: "kwic", "index", "search [keyword]", "quit" <br>
This program is case-sensitive so leave all commands and keywords in lowercase 

**kwic** <br>
Given an input file containing multiple sentences, the system shall: <br>
● Generate all circular shifts of each sentence. <br>
● Output all circularly shifted sentences in alphabetical order. <br>
● Append the original line number to each shifted line. 

**index** <br>
Given the list of input sentences, the system shall generate a keyword index with the following properties: <br>
● All keywords are listed in alphabetical order. <br>
● Each keyword is followed by the line number(s) of the original sentence(s) in which it appears. <br>
● If a keyword appears in multiple lines, all corresponding line numbers must be listed. 

**search [keyword]** <br>
The system shall support interactive keyword search: <br>
● The user enters a keyword via the console.<br>
● The system returns all original sentences containing the keyword.<br>
● In each returned sentence, the keyword must be highlighted.<br>
● The system also reports the total number of lines containing the keyword

**quit** <br>
Quits the program instantly

### Files and Their Purpose
**Alphabetizer.java** <br>
Interface to give the blueprint for future alphabetizer (ascending, descending, etc.)

**AscendingAlphabetizer.java** <br>
Implements Alphabetizer.java to sort sentences in ascending order

**CommandProcessor.java** <br>
Hub to delegate specific command processor based off given command

**CommandValidator.java** <br>
Validates incoming command

**ConsoleOut.java** <br>
Implements Output.java and handles STDOUT

**DescendingAlphabetizer.java** <br>
Implements Alphabetizer.java to sort sentences in descending order

**IndexProcessor.java** <br>
Handles index command functionality

**Input.java** <br>
Interface to give the blueprint for future input types (.txt, .csv etc.)

**KWICProcessor.java** <br>
Handles kwic command functionality

**LineStorage.java** <br>
Handles storing multiple sentences for easy reference

**Main.java** <br>
Master Control

**Output.java** <br>
Interface to give the blueprint for future output types (STDOUT, .txt etc.)

**QuitProcessor.java** <br>
Handles quit command functionality

**SearchProcessor.java** <br>
Handles search command functionality

**TxtIn.java** <br>
Implements Input.java and handles reading from a .txt file

### Contact
Contact me at kad474@drexel.edu with any questions 


