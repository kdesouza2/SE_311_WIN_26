```plantuml

@startuml 

@startuml KWIC_Client_Server
skinparam componentStyle rectangle

' =========================
' CLIENT COMPONENT (White Box)
' =========================
component "Client" {

    class Main
    interface Input
    interface Output
    class CommandValidator
    class SocketClient

    Main --> Input
    Main --> Output
    Main o-- CommandValidator
    Main --> SocketClient

    SocketClient --> CP
}

interface "KWIC Socket Interface" as ISocket
CP ..> ISocket : requires


' =========================
' SERVER COMPONENT (Black Box / Hybrid)
' =========================
component "Server" {


    class CommandProcessor
    class LineStorage
    class KWICProcessor
    class SearchProcessor
    class IndexProcessor
    interface Alphabetizer
    class SocketServer

    SocketServer --> SP

    CommandProcessor --> LineStorage
    CommandProcessor <|-- KWICProcessor
    CommandProcessor <|-- SearchProcessor
    CommandProcessor <|-- IndexProcessor
    KWICProcessor --> Alphabetizer
}

SP -- ISocket : provides


' =========================
' COMMUNICATION LINK
' =========================
CP --> SP : TCP/IP Socket

@enduml

@endmul