
```plantuml

@startuml
left to right direction

actor Student
actor Admin

rectangle "University System" {
  Student --> (Enroll in Course)
  Student --> (View Transcript)

  Admin --> (Create Course)
  Admin --> (Assign Instructor)

  (Enroll in Course) ..> (Check Prerequisites) : <<include>>
}

@enduml