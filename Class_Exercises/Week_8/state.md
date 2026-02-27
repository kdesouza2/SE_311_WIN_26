```plantuml

@startuml
hide empty description

[*] --> StartState

StartState --> GettingFirstOperand : 0...9
StartState --> IgnoreInput : +, -, *, /, =
StartState --> ResetState : C

GettingFirstOperand --> GettingFirstOperand : 0...9
GettingFirstOperand --> WaitingForOperator : +, -, *, /
GettingFirstOperand --> ShowingResult : =
GettingFirstOperand --> ResetState : C
GettingFirstOperand --> IgnoreInput : other non-digit

WaitingForOperator --> GettingSecondOperand : 0...9
WaitingForOperator --> IgnoreInput : other non-digit
WaitingForOperator --> ResetState : C

GettingSecondOperand --> GettingSecondOperand : 0...9
GettingSecondOperand --> ShowingResult : =
GettingSecondOperand --> WaitingForOperator : +, -, *, /
GettingSecondOperand --> ResetState : C
GettingSecondOperand --> IgnoreInput : other non-digit

ShowingResult --> GettingFirstOperand : 0...9
ShowingResult --> IgnoreInput : other non-digit
ShowingResult --> ResetState : C
ShowingResult --> ShowingResult : =

IgnoreInput --> IgnoreInput : other non-digit
IgnoreInput --> ResetState : C
IgnoreInput --> GettingFirstOperand : 0...9

ResetState --> StartState

@enduml




