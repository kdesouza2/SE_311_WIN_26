```plantuml

@startuml KWIC_Server_Sequence
actor Client
participant KWICServer
participant ClientHandler
participant SocketConnection
participant CommandProcessor
participant SearchProcessor

Client -> KWICServer: connect()
KWICServer -> ClientHandler: start thread(client socket)
ClientHandler -> SocketConnection: receiveCommand()
SocketConnection --> ClientHandler: command string
ClientHandler -> CommandProcessor: processCommand(args)
CommandProcessor -> SearchProcessor: execute()
SearchProcessor --> CommandProcessor: List<String> searchResults
CommandProcessor --> ClientHandler: List<String> processedResults
ClientHandler -> SocketConnection: sendResults(List<String>)
SocketConnection --> ClientHandler: ACK (optional)
ClientHandler --> KWICServer: done (thread ends)
ClientHandler --> Client: List<String> response
@enduml