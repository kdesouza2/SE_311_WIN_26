```plantuml

@startuml
title Server Architecture

class CalculatorServer
class SocketConnection

' Server receives expressions from client
SocketConnection --> CalculatorServer

' Server validates expressions
CalculatorServer --> ValidationVisitor

' =====================
' VISITOR PATTERN (Server Validation)
' =====================

interface ExpressionVisitor <<Visitor>>
class ValidationVisitor <<ConcreteVisitor>>

ExpressionVisitor <|-- ValidationVisitor

@enduml