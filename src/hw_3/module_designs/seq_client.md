```plantuml

@startuml KWIC_Client_Sequence
actor User
participant Main
participant KWICClient
participant SocketConnection
participant Output

User -> Main: enter keyword / command
Main -> KWICClient: sendCommand(command)
KWICClient -> SocketConnection: sendCommand(command)
SocketConnection -> SocketConnection: transmit over socket
SocketConnection --> KWICClient: ACK (optional)
KWICClient -> SocketConnection: receiveResults()
SocketConnection --> KWICClient: List<String> response (return)
KWICClient --> Main: List<String> response
Main -> Output: printOutput(response)
Output --> Main: done
Main --> User: display output
@enduml