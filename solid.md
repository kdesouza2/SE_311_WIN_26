🧱 S — Single Responsibility Principle (SRP) (Cohesion)

A class should have only one reason to change.
Each class or module should do one thing and do it well.

Example:
A ReportGenerator shouldn’t also handle saving the report to a file. That’s a separate responsibility.

🧱 O — Open/Closed Principle (OCP)

Software entities should be open for extension, but closed for modification.
You should add new behavior without modifying existing tested code.

Example:
Use interfaces/polymorphism instead of long if/else blocks.

🧱 L — Liskov Substitution Principle (LSP)

Subtypes must be usable in place of their base types without breaking the program.
A subclass should behave like its parent class in a predictable, consistent way.

Example:
If Bird has a fly() method, a subtype like Penguin should not inherit it if it can’t fly — that violates LSP.

🧱 I — Interface Segregation Principle (ISP)

Clients should not be forced to depend on interfaces they do not use.
Instead of a huge “god” interface, create smaller, focused interfaces.

Example:
Don’t make IMachine with print(), scan(), and fax() if a simple printer only needs print().

🧱 D — Dependency Inversion Principle (DIP)

Depend on abstractions (interfaces), not concrete implementations.
High-level modules should not depend directly on low-level modules.

Example:
NotificationService depends on a MessageService interface, not EmailService directly.
