<!-- In this exercise, you will design Java classes to model the sample transcript shown in the attached file. -->

```plantuml

@startuml Transcript

class Grade {
    -grade: int
    +getGrade(): int
}

class Course {
    -className: String
    -classId: String
    -credits: int
    +getClassName(): String
    +getClassId(): String
    +getCredits(): int
}

class CourseEnrollment {
    -course: Course
    -grade: Grade
    +assignGrade(): void
}

class Term {
    -term: String
    -coursesEnrolled: List<CourseEnrollment>
    -termGPA: int
    +addCourse(): void
    +dropCourse(): void
    +calcTermGPA(): int
}

class Student {
    -name: String
    -studentId: int
    -program: String
    -admitTerm: String
    -status: String
    -gradDate: String
    -address: Address
    -transcript: Transcript
    -printTranscript(): void
}

class Address {
    -houseNumber: int
    -zipcode: int
    -streetName: String
    +changeAddress(): void
}

class Transcript {
    -dateIssued: LocalDate
    -terms: List<Term>
    -calcTotalCredits(): int
    -calcCumulativeGPA(): int
    -printCummSummary(): void
    -printTerms(): voidß
}

Student o-- Transcript
Student o-- Address

Transcript o-- Term

Term o-- CourseEnrollment

CourseEnrollment --> Course
CourseEnrollment o-- Grade


@enduml