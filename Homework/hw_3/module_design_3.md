```plantuml

@startuml KWIC_With_Config_Client_Server

class Main {
    -commandProcessor: CommandProcessor
    -commandValidator: CommandValidator
    -input: Input
    -output: Output
    +start()
}

class OptionReader {
    +readOptions()
    +getObjectFromKey(key: String): Object
}

class KWICObjectLoader {
    +loadObject(className: String): Object
}

OptionReader --> KWICObjectLoader
Main --> OptionReader


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

interface Input {
    +readInput()
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

KWICProcessor --> Alphabetizer
IndexProcessor --> Alphabetizer
Main --> Input
Main --> Output

class KWICServer {
    +startServer()
}

class ClientHandler {
    +processSearch(keyword)
}

class SocketConnection  {
    +send()
    +receive()
}

class Logger {
    +logRequest()
    +logSuccess()
}

KWICServer --> ClientHandler
ClientHandler --> SocketConnection
ClientHandler --> SearchProcessor
ClientHandler --> Logger

@enduml