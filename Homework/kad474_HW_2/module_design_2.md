```plantuml

@startuml KWIC_With_Config

' =========================
' Main Application
' =========================
class Main {
    -commandProcessor: CommandProcessor
    -commandValidator: CommandValidator
    -input: Input
    -output: Output
    -alphabetizer: Alphabetizer
    +start()
}

' =========================
' Configuration & Loading
' =========================
class OptionReader {
    +readOptions()
    +getObjectFromKey(key: String): Object
}

class KWICObjectLoader {
    +loadObject(className: String): Object
}

OptionReader --> KWICObjectLoader
Main --> OptionReader : uses

' =========================
' Core Processing
' =========================
class CommandProcessor {
    #storage: LineStorage
    #output: Output
    +parseCommand()
    +processCommand()
}

class LineStorage {
    -lines: List<String>
}

class CommandValidator {
    +validateCommand()
}

Main o-- CommandProcessor
Main o-- CommandValidator

CommandProcessor --> LineStorage
CommandProcessor --> Output

' =========================
' Command Processors
' =========================
class KWICProcessor {
    -alphabetizer: Alphabetizer
    +execute()
}

class SearchProcessor {
    +execute()
}

class IndexProcessor {
    -alphabetizer: Alphabetizer
    +execute()
}

class QuitProcessor {
    +execute()
}

CommandProcessor <|-- KWICProcessor
CommandProcessor <|-- SearchProcessor
CommandProcessor <|-- IndexProcessor
CommandProcessor <|-- QuitProcessor

' =========================
' Interfaces
' =========================
interface Input {
    +readInput()
}

interface Output {
    +printOutput(lines: List<String>)
}

interface Alphabetizer {
    +sort(lines: List<String>)
}

' =========================
' Implementations
' =========================
class TxtIn
class ConsoleOut
class AscendingAlphabetizer
class DescendingAlphabetizer

Input <|.. TxtIn
Output <|.. ConsoleOut
Alphabetizer <|.. AscendingAlphabetizer
Alphabetizer <|.. DescendingAlphabetizer

KWICProcessor --> Alphabetizer
IndexProcessor --> Alphabetizer
Main --> Input
Main --> Output
Main --> Alphabetizer

@enduml
