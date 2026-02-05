```plantuml

@startuml

title: Pipe-and-Filter Diagram of KWIC

component Input
component CircularShifter
component Alphabetizer
component Output

Input -> CircularShifter : provide original lines
CircularShifter -> Alphabetizer : generate circular shifts
Alphabetizer -> Output : sort shifts and output result
@enduml