```plantuml

@startuml
title US3 - Successful Calculation Sent to Server

actor User

participant "CalculatorClient" as GUI
participant "SimpleCalculator" as Calc
participant "SocketConnection" as Socket
participant "CalculatorServer" as Server

User -> GUI : press "="
GUI -> Calc : processInput("=")

Calc -> Calc : calculate()

Calc -> Socket : notifyObservers(expression + result)

Socket -> Server : send expression result

Server -> Server : store equation
Server -> Server : update calculation list



@enduml