```plantuml
@startuml
title Client Architecture

' =====================
' CLIENT CONTROLLER
' =====================

class MasterControl
class CalculatorClient
class SimpleCalculator <<Context>> <<Subject>>

interface CalculatorObserver <<Observer>>
class SocketConnection <<ConcreteObserver>>

MasterControl --> CalculatorClient
CalculatorClient --> SimpleCalculator
CalculatorClient --> SocketConnection

SimpleCalculator o-- CalculatorObserver
CalculatorObserver <|-- SocketConnection

' =====================
' COMPOSITE PATTERN
' =====================

interface Expression <<Component>>

class AtomExpr <<Leaf>>
class AddSubExpr <<Composite>>
class MultDivExpr <<Composite>>

Expression <|-- AtomExpr
Expression <|-- AddSubExpr
Expression <|-- MultDivExpr

AddSubExpr *-- Expression
MultDivExpr *-- Expression

' Who USES Expression
SimpleCalculator --> Expression : builds tree
EvaluationVisitor --> Expression : evaluates

' =====================
' VISITOR PATTERN
' =====================

interface ExpressionVisitor <<Visitor>>

class EvaluationVisitor <<ConcreteVisitor>>

Expression --> ExpressionVisitor : accept()

ExpressionVisitor <|-- EvaluationVisitor

' =====================
' STATE PATTERN
' =====================

interface CalculatorState <<State>>

class StartState <<ConcreteState>>
class GettingFirstOperandState <<ConcreteState>>
class WaitingForAddSubOperandState <<ConcreteState>>
class GettingAddSubOperandState <<ConcreteState>>
class WaitingForMulDivOperandState <<ConcreteState>>
class GettingMulDivOperandState <<ConcreteState>>
class CalculateState <<ConcreteState>>

SimpleCalculator o-- CalculatorState

CalculatorState <|-- StartState
CalculatorState <|-- GettingFirstOperandState
CalculatorState <|-- WaitingForAddSubOperandState
CalculatorState <|-- GettingAddSubOperandState
CalculatorState <|-- WaitingForMulDivOperandState
CalculatorState <|-- GettingMulDivOperandState
CalculatorState <|-- CalculateState

@enduml