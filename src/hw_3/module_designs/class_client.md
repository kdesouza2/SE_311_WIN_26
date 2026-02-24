```plantuml

@startuml KWIC_Client

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
    +sendCommand(command: String)
    +receiveResults(): List<String>
}

class Output {
    +printOutput(lines: List<String>)
}

Main --> KWICClient
Main --> CommandValidator
Main --> Output
KWICClient --> SocketConnection

@enduml