<!-- Note to Self: Strategy Pattern should be used (input/output for instance)
Only represent the major decisions: major classes, data structures, relationship, abstraction, encapsulation, etc
DON'T need return types, all getters and setters, types of parameters, etc. -->

How to address changes in:
○ Major classes --> **Add concrete class**
○ Key attributes and methods
○ Relationships among modules


```plantuml

@startuml KWIC

class Main {
    -commandProcessor: CommandProcessor
    -input: Input
    -lineCollection: LineStorage
    -commandValidator: CommandValidator
    +Main()
    +start()
}

class CommandValidator {
    -validCommands: List<String>
    +validateCommand(): boolean
}

class LineStorage {
    -lines: List<String>
    +LineStorage()
}

class CommandProcessor {
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
    +findMatches(keyword, lines): List<String>
    +execute()
    +highlight(keyword, line): String

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
    +readInput(): List<String>
}

class TxtIn {
    +readInput(): List<String>
}

interface Output {
    +printLines(lines: List<String>)
    +printMessage(message: String)

}

class ConsoleOut {
    +printLines(lines: List<String>)
    +printMessage(message: String)
}

interface Alphabetizer {
    +sort(lines: List<String>): List<String>
 
}

class AscendingAlphabetizer {
    +sort(lines: List<String>): List<String>

}

class DescendingAlphabetizer {
    +sort(lines: List<String>): List<String>

}

' Relationships
Main o-- CommandProcessor
Main o-- CommandValidator
Main o-- Input
Main o-- LineStorage

CommandProcessor <|-- KWICProcessor
CommandProcessor <|-- SearchProcessor
CommandProcessor <|-- IndexProcessor
CommandProcessor <|-- QuitProcessor
Input <|-- TxtIn
Output <|-- ConsoleOut
Alphabetizer <|-- AscendingAlphabetizer
Alphabetizer <|-- DescendingAlphabetizer

KWICProcessor --> Alphabetizer
IndexProcessor --> Alphabetizer
Input --> LineStorage
CommandProcessor --> LineStorage
CommandProcessor --> Output




@enduml
