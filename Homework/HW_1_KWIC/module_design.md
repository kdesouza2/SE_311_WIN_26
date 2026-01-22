How to address changes in:
○ Major classes --> I tried my best to abstract where I can so you'll just need to create another concrete class
○ Key attributes and methods --> Refactor my code to adapt to the change
○ Relationships among modules --> Refactor my code to adapt to the change


```plantuml

@startuml KWIC

class Main {
    -commandProcessor: CommandProcessor
    -input: Input
    -storage: LineStorage
    -commandValidator: CommandValidator
    +Main()
    +start()
}

class CommandValidator {
    -VALID_COMMANDS: List<String>
    +validateCommand()
}

class LineStorage {
    -lines: List<String>
    +LineStorage()
}

class CommandProcessor {
    #storage: LineStorage
    #output: Output
    +CommandProcessor()
    +parseCommand()
    +processCommand()
}

class KWICProcessor {
    -command: String
    -alphabetizer: Alphabetizer
    +KWICProcessor()
    +circularShift()
    +alphabetize()
    +execute()
}

class SearchProcessor {
    -keyword: String
    +SearchProcessor()
    +execute()

}

class IndexProcessor {
    -command: String
    -alphabetizer: Alphabetizer
    +IndexProcessor()
    +execute()
}

class QuitProcessor {
    -command: String
    +QuitProcessor()
    +execute()
}

interface Input {
    +readInput()
}

class TxtIn {
    +readInput()
}

interface Output {
    +printOutput(lines: List<String>)
    +printOutput(line: String)
}

class ConsoleOut {
    +printOutput(lines: List<String>)
    +printOutput(line: String)
}

interface Alphabetizer {
    +sort(lines: List<String>)
 
}

class AscendingAlphabetizer {
    +sort(lines: List<String>)

}

class DescendingAlphabetizer {
    +sort(lines: List<String>)

}

' Relationships
Main o-- CommandProcessor
Main o-- CommandValidator
Main o-- Input

CommandProcessor <|-- KWICProcessor
CommandProcessor <|-- SearchProcessor
CommandProcessor <|-- IndexProcessor
CommandProcessor <|-- QuitProcessor
Input <|..TxtIn
Output <|.. ConsoleOut
Alphabetizer <|.. AscendingAlphabetizer
Alphabetizer <|.. DescendingAlphabetizer

KWICProcessor --> Alphabetizer
IndexProcessor --> Alphabetizer
CommandProcessor --> LineStorage
CommandProcessor --> Output




@enduml
