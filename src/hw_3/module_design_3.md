```plantuml

@startuml KWIC_Client_Server

' =========================
' CLIENT SIDE
' =========================

class Main {
    -client: KWICClient
    -commandValidator: CommandValidator
    +start()
}

class KWICClient {
    -connection: SocketConnection
    +sendCommand(command: String)
    +receiveResponse(): List<String>
}

class CommandValidator {
    +validateCommand()
}

class SocketConnection {
    +send(data: String)
    +receive(): String
}

Main --> KWICClient
Main --> CommandValidator
Main --> Input
KWICClient --> SocketConnection


' =========================
' SERVER SIDE
' =========================

class KWICServer {
    +startServer()
}

class ClientHandler {
    +handleRequest()
}

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

abstract class Processor {
    +execute(): List<String>
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

Processor <|-- SearchProcessor
Processor <|-- IndexProcessor
Processor <|-- KWICProcessor

ClientHandler --> CommandProcessor
CommandProcessor --> Processor
CommandProcessor --> LineStorage


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

CommandProcessor --> Output
KWICProcessor --> Alphabetizer
IndexProcessor --> Alphabetizer


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

Main --> OptionReader
OptionReader --> KWICObjectLoader

@enduml