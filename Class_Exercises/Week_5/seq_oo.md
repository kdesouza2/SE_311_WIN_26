<!-- The arrow always goes from the object that initiates the action to the object that performs the work.

So if Participant A reads information from Participant B:

    A initiates the read

    B provides the data

That means the arrow goes from A to B, regardless of where they’re placed on the page. -->


```plantuml

@startuml

title: Object-Oriented Diagram of KWIC

actor User

participant ":MasterControl" as MasterControl
participant ":Input" as Input
participant ":LineStorage" as LineStorage
participant ":CircularShifter" as CircularShifter
participant ":Sorter" as Sorter
participant ":Output" as Output

User -> MasterControl : give .txt file

MasterControl -> Input : read input sentences

Input -> LineStorage : save input sentences

LineStorage -> CircularShifter : read lines


CircularShifter -> Sorter : read circular shifted lines

Sorter -> Output : reads sorted lines

Output --> MasterControl : return 

@enduml