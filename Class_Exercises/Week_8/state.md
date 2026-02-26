```plantuml

@startuml
hide empty description

[*] --> StartState
StartState --> GettingFirstOperand : 0...9
StartState --> StartState : "+, -, *, /, =, C

GettingFirstOperand --> WaitingForAddSubOperand : "+, -
GettingFirstOperand --> GettingFirstOperand : 0...9


@enduml


