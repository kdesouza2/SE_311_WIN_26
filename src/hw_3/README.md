# KWIC Processor

### How to Run Program
Navigate to hw_3 folder in your terminal and run 1 of the following launch commands <br>
1. java -jar hw3_server.jar config.properties local -- for local mode <br>
2. java -jar hw3_server.jar config.properties server -- for server mode

### How to Use Console Commands
This program accepts 4 commands: "kwic-processing", "index-generation", "keyword-search [keyword]", "quit" <br>
This program is case-sensitive so leave all commands and keywords in lowercase 

**kwic-processing** <br>
Given an input file containing multiple sentences, the system shall: <br>
● Generate all circular shifts of each sentence. <br>
● Output all circularly shifted sentences in alphabetical order. <br>
● Append the original line number to each shifted line. 

**index-generation** <br>
Given the list of input sentences, the system shall generate a keyword index with the following properties: <br>
● All keywords are listed in alphabetical order. <br>
● Each keyword is followed by the line number(s) of the original sentence(s) in which it appears. <br>
● If a keyword appears in multiple lines, all corresponding line numbers must be listed. 

**keyword-search [keyword]** <br>
The system shall support interactive keyword search: <br>
● The user enters a keyword via the console.<br>
● The system returns all original sentences containing the keyword.<br>
● In each returned sentence, the keyword must be highlighted.<br>
● The system also reports the total number of lines containing the keyword

**quit** <br>
When you are finished entering commands in either modes, you may quit the program by entering "quit"

### Differences from HW 2
● We added a client/server architecture so classes such as "KWICClient", "SocketConnection", "ClientHandler" and "KWICServer" all support this architecture

### Contact
Contact me at kad474@drexel.edu with any questions 
