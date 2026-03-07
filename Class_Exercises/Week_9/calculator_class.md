```plantuml

@startuml

@startuml

' =====================
' CLIENT SIDE
' =====================

class MasterControl
class CalculatorClient
class SimpleCalculator <<Subject>> <<Context>>
interface CalculatorObserver
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

class MultDivExpr <<Composite>>
class AddSubExpr <<Composite>>
class AtomExpr <<Leaf>>

Expression <|-- MultDivExpr
Expression <|-- AddSubExpr
Expression <|-- AtomExpr

MultDivExpr *-- Expression
AddSubExpr *-- Expression

' =====================
' VISITOR PATTERN
' =====================

interface ExpressionVisitor <<Visitor>>

class EvaluationVisitor <<ConcreteVisitor>>
class ValidationVisitor <<ConcreteVisitor>>

Expression --> ExpressionVisitor : accept()

ExpressionVisitor <|-- EvaluationVisitor
ExpressionVisitor <|-- ValidationVisitor

EvaluationVisitor --> Expression
ValidationVisitor --> Expression

' =====================
' STATE PATTERN
' =====================

interface CalculatorState <<AbstractState>>

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

' =====================
' SERVER SIDE
' =====================

class CalculatorServer
class ServerLogger

SocketConnection --> CalculatorServer
CalculatorServer --> ValidationVisitor
CalculatorServer --> ServerLogger

@enduml


@enduml