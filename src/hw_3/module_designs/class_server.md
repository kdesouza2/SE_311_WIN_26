```plantuml

@startuml KWIC_Server

' =========================
' SERVER SIDE
' =========================

class Main {
    +main(args: String[])
}

class KWICServer {
    +startServer()
}

class ClientHandler {
    +handleRequest()
}

Main --> KWICServer
Main --> Input
Main --> OptionReader
KWICServer --> ClientHandler
ClientHandler --> SocketConnection

' =========================
' PROCESSING CORE
' =========================

class CommandProcessor {
    -storage: LineStorage
    -output: Output
    +processCommand(command: String)
}

class SearchProcessor {
    -keyword: String
    +execute(): List<String>
}

class IndexProcessor {
    +execute(): List<String>
}

class KWICProcessor {
    -alphabetizer: Alphabetizer
    +execute(): List<String>
}

CommandProcessor <|-- SearchProcessor
CommandProcessor <|-- IndexProcessor
CommandProcessor <|-- KWICProcessor

ClientHandler --> CommandProcessor
CommandProcessor --> LineStorage
CommandProcessor --> Output
KWICProcessor --> Alphabetizer
IndexProcessor --> Alphabetizer

' =========================
' STORAGE
' =========================

class LineStorage {
    -lines: List<String>
    +getLines(): List<String>
}

' =========================
' INPUT / OUTPUT
' =========================

interface Input {
    +readLines(): List<String>
}

interface Output {
    +printOutput(lines: List<String>)
}

interface Alphabetizer {
    +sort(lines: List<String>)
}

class TxtIn
class CsvIn
class TxtOut
class ConsoleOut
class AscendingAlphabetizer
class DescendingAlphabetizer

Input <|.. TxtIn
Input <|.. CsvIn
Output <|.. TxtOut
Output <|.. ConsoleOut
Alphabetizer <|.. AscendingAlphabetizer
Alphabetizer <|.. DescendingAlphabetizer

' =========================
' CONFIGURATION
' =========================

class OptionReader {
    +readOptions()
    +getObjectFromKey(key: String): Object
}

class KWICObjectLoader {
    +loadObject(className: String): Object
}

OptionReader --> KWICObjectLoader

@enduml