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
    
}


@enduml