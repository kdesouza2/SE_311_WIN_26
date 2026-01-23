## Actor: Student 
**Action:** <br>
The student logs into the Transcript System and selects the “View Transcript” option.

**System Response:** <br>
The system authenticates the student, retrieves the student’s academic record from the database, and displays the complete transcript, including completed courses, grades, term GPAs, cumulative GPA, and academic history.

**Action:** <br>
The student submits a request for an official transcript through the Transcript System.

**System Response:** <br>
The system validates the request, records it for processing, and notifies University Administration that an official transcript request has been submitted.

**Action:** <br>
The student selects the “Print Transcript” option.

**System Response:** <br>
The system generates a printable version of the transcript and sends it to the student’s browser or connected printer.

**Action:** <br>
The student selects “View GPA”.

**System Response:** <br>
The system calculates and displays the student’s current term GPA and cumulative GPA.

**Action:** <br>
The student selects “View Academic History.”

**System Response:** <br>
The system displays a chronological list of the student’s completed and in-progress courses, including grades, credits, and academic standing by term.

## Actor: University Administrator
**Action:** <br>
The administrator selects a pending transcript request and chooses “Release Official Transcript.”

**System Response:** <br>
The system generates an official transcript, marks it as released, and delivers it to the designated recipient (electronically or by mail, depending on system rules).

**Action:** <br>
The administrator updates a student’s academic record (e.g., correcting grades, credits, or status).

**System Response:** <br>
The system validates the changes, updates the database, and ensures the updated information is reflected in all future transcript views and GPA calculations.

**Action:** <br>
The administrator selects “Generate Transcript” for a student.

**System Response:** <br>
The system compiles the student’s academic data into an official transcript format and stores it for viewing, printing, or release.

## Actor: Professor
**Action:** <br>
The instructor submits final grades for a course.

**System Response:** <br>
The system records the grades, updates student records, and recalculates term and cumulative GPAs.

**Action:** <br>
The instructor selects “View Class Roster.”

**System Response:** <br>
The system displays a list of enrolled students for the selected course, including names and student identifiers.

## Actor: Advisor
**Action:** <br>
The advisor logs into the Transcript System and navigates to the student's profile and selects the “View Transcript” option.

**System Response:** <br>
The system authenticates the advisor, retrieves the student’s academic record from the database, and displays the complete transcript, including completed courses, grades, term GPAs, cumulative GPA, and academic history.

**Action:** <br>
The advisor selects “Evaluate Degree Progress” for a student.

**System Response:** <br>
The system analyzes completed and in-progress coursework against degree requirements and displays the student’s progress toward graduation.

```plantuml

@startuml
left to right direction

actor Student
actor Professor
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

  Professor --> (Submit Grades)
  Professor --> (View Class Roster)

  Advisor --> (View Transcript)
  Advisor --> (Evaluate Degree Progress)

}

@enduml

