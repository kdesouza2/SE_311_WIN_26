```plantuml

@startuml KWIC_Component

' =========================
' CLIENT COMPONENTS
' =========================
package "KWIC Client" {
    [Main] --> [KWICClient]
    [Main] --> [CommandValidator]
    [Main] --> [Output]

    [KWICClient] --> [SocketConnection]
    [KWICClient] --> [Output]
}

' =========================
' SERVER COMPONENTS
' =========================
package "KWIC Server" {
    [Main] --> [KWICServer]
    [KWICServer] --> [ClientHandler]

    [ClientHandler] --> [SocketConnection]
    [ClientHandler] --> [CommandProcessor]

    [CommandProcessor] --> [SearchProcessor]
    [CommandProcessor] --> [KWICProcessor]
    [CommandProcessor] --> [IndexProcessor]
    [CommandProcessor] --> [LineStorage]
    [CommandProcessor] --> [Output]

    [KWICProcessor] --> [Alphabetizer]
    [IndexProcessor] --> [Alphabetizer]

    [OptionReader] --> [KWICObjectLoader]
}

' =========================
' SHARED / INTERFACE COMPONENTS
' =========================
[SocketConnection] <-- [ClientHandler] : server side
[SocketConnection] <-- [KWICClient] : client side
[Output] <-- [ClientHandler] : server output
[Output] <-- [Main] : client output

@enduml