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
Main --> OptionReader

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


CommandProcessor <|-- KWICProcessor
CommandProcessor <|-- SearchProcessor
CommandProcessor <|-- IndexProcessor

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
Input <|.. CsvIn
Output <|.. ConsoleOut
Output <|.. TxtOut
Alphabetizer <|.. AscendingAlphabetizer
Alphabetizer <|.. DescendingAlphabetizer

KWICProcessor --> Alphabetizer
Main --> Input
Main --> Output

@enduml
