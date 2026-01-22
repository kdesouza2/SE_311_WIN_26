
```plantuml

@startuml
left to right direction

actor Student
actor Instructor
actor UniversityAdmin
actor Advisor

rectangle "Transcript System" {
  Student --> (View Transcript)
  Student --> (Request Official Transcript)
  Student --> (Print Transcript)
  Student --> (View GPA)
  Student --> (View Academic History)

  UniversityAdmin --> (Release Official Transcript)
  UniversityAdmin --> (Update Student Record)
  UniversityAdmin --> (Generate Transcript)

  Instructor --> (Submit Grades)
  Instructor --> (View Class Roster)

  Advisor --> (View Transcript)
  Advisor --> (Evaluate Degree Progress)

}

@enduml