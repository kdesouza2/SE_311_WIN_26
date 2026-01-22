# KWIC Processor

### How to Run Program
Navigate to HW_1_KWIC folder, open terminal and run java -cp out src/Main.java inputs/sample.txt

### How to Use Console Commands
This program accepts 4 commands: "kwic", "index", "search [keyword]", "quit"
This program is case-sensitive so leave all commands and keywords in lowercase 

**kwic**
Given an input file containing multiple sentences, the system shall:
● Generate all circular shifts of each sentence.
● Output all circularly shifted sentences in alphabetical order.
● Append the original line number to each shifted line.

**index**
Given the list of input sentences, the system shall generate a keyword index with the following
properties:
● All keywords are listed in alphabetical order.
● Each keyword is followed by the line number(s) of the original sentence(s) in which it appears.
● If a keyword appears in multiple lines, all corresponding line numbers must be listed.

**search [keyword]**
The system shall support interactive keyword search:
● The user enters a keyword via the console.
● The system returns all original sentences containing the keyword.
● In each returned sentence, the keyword must be highlighted.
● The system also reports the total number of lines containing the keyword

**quit**
Quits the program instantly

### Files and their Purpose
**Alphabetizer.java**
Interface to give the blueprint for future alphabetizer (ascending, descending, etc.)

**AscendingAlphabetizer.java**
Implements Alphabetizer.java to sort sentences in ascending order

**CommandProcessor.java**
Hub to delegate specific command processor based off given command

**CommandValidator.java**
Validates incoming command

**ConsoleOut.java**
Implements Output.java and handles STDOUT

**DescendingAlphabetizer.java**
Implements Alphabetizer.java to sort sentences in descending order

**IndexProcessor.java**
Handles index command functionality

**Input.java**
Interface to give the blueprint for future input types (.txt, .csv etc.)

**KWICProcessor.java**
Handles kwic command functionality

**LineStorage.java**
Handles storing multiple sentences for easy reference

**Main.java**
Master Control

**Output.java**
Interface to give the blueprint for future output types (STDOUT, .txt etc.)

**QuitProcessor.java**
Handles quit command functionality

**SearchProcessor.java**
Handles search command functionality

**TxtIn.java**
Implements Input.java and handles reading from a .txt file




