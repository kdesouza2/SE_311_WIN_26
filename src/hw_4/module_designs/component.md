```plantuml

@startuml
title Calculator System Component Diagram (Black Box)

component "calculator_client" as Client
component "calculator_server" as Server

interface "Calculation Results" as Results

Client --> Results
Results --> Server

@enduml