## Final Exam Review

**Week 1**

What is "software design"

    ~ decision-making

    ~ 5 types of decisions

What are the duty, knowledge, and skills needed by a software architect?

4 essential difficulties of software development

    1. Complexity --> Software systems have many interacting parts, making them hard to understand and maintain.

    2. Conformity --> Software must follow external rules and constraints.

    3. Changeability --> Software is constantly being changed after it is built.

    4. Invisibility --> Software cannot be visualized easily.

**Week 2**

Key Word In Context

The origin of OO design

Design principles, information hiding, SOLID, etc.

**Week 3**

Architecture Modeling: 4+1 View

    ~ the purpose of each view

    ~ which view should be used to analyze which QA

Software family

**Week 4**

Design Rule Theory

    ~ design rules and modules

    ~ substitution

Design Structure Matrix

    ~ hierarchical structure

**Week 5**

Architecture style by Garlan and Shaw

Information hiding in DSM

Pipe and Filter

    ~ what are the features of a filter

    ~ what are the features of a pipe

**Week 6**

Pub-Sub Architecture Style

    ~ what are the key features of Pub-Sub, e.g. what is the decoupling effect of pub-sub

Observer Pattern

**Week 7**

Client-Server: *improve scalability*

    ~ what is the key QA of C-S?

Socket

    ~ what is a socket?

**Week 8**

Architectures Styles Summary *9 types*

    ~ representative real-world applications

| # | Style                   | Key Idea                  | Simple real-world example                                                           |
| - | ----------------------- | ------------------------- | ----------------------------------------------------------------------------------- |
| 1 | Data-Centered           | Shared repository         | **Library system** – everyone reads/writes to the same catalog                      |
| 2 | Data Flow (Pipe-Filter) | Step-by-step processing   | **Car wash** – wash → rinse → dry                                                   |
| 3 | Call-Return             | Hierarchy of calls        | **Boss → manager → worker** giving instructions                                     |
| 4 | Object-Oriented         | Objects interact          | **Traffic light system** – each light is an object with its own state               |
| 5 | Layered                 | Stack of layers           | **Restaurant** – customer → waiter → kitchen → supplier                             |
| 6 | Client-Server           | Request / response        | **Bank ATM** – ATM asks bank server for money                                       |
| 7 | Event-Driven            | React to events           | **Doorbell** – button press triggers sound                                          |
| 8 | MVC                     | Model / View / Controller | **Online shopping site** – database (model), webpage (view), app logic (controller) |
| 9 | Microkernel             | Core + plugins            | **Smartphone** – OS core + apps you install                                         |


Composite, Visitor, Interprete

**Week 9**

Styles and Patterns

    1. State pattern

    2. Composite pattern

    3. visitor pattern

    4. iterator pattern

    5. interpreter pattern

    ~ their UML diagrams, decoupling effects, implementations

**Week 10**

Quality Attributes *In software architecture, Quality Attributes describe how well a system works, not what it does. They come from architecture theory used in Software Architecture in Practice*

    ~ the definition of major types of QAs 
    ~ 6 parts of QAS

| Part                | Meaning            | Example            |
| ------------------- | ------------------ | ------------------ |
| 1. Source           | Who causes it      | User               |
| 2. Stimulus         | What happens       | User clicks button |
| 3. Environment      | When it happens    | During normal use  |
| 4. Artifact         | What part affected | Web server         |
| 5. Response         | What system does   | Returns page       |
| 6. Response Measure | How well it works  | < 2 seconds        |

6 parts =

Source → Stimulus → Environment → Artifact → Response → Measure

or

Who → What → When → Where → Action → How well