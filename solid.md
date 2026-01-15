# SOLID

**🧱 S — Single Responsibility Principle (SRP) (Cohesion)**

A class should have only <u>one<u> reason to change.
Each class or module should do <u>one<u> thing and do it well.

*Example:*
A ReportGenerator shouldn’t also handle saving the report to a file. That’s a separate responsibility.

**🧱 O — Open/Closed Principle (OCP)**

Software entities should be <u>open for extension, but closed for modification.<u>
You should <u>add<u> new behavior without modifying existing tested code.

*Example:*
Use interfaces/polymorphism instead of long if/else blocks.

**🧱 L — Liskov Substitution Principle (LSP)**

Subtypes must be usable in place of their base types without breaking the program.
A subclass should behave like its parent class in a <u>predictable, consistent way.<u>

*Example:*
If Bird has a fly() method, a subtype like Penguin should not inherit it if it can’t fly — that violates LSP.

**🧱 I — Interface Segregation Principle (ISP)**

Clients should not be forced to <u>depend<u> on interfaces they do not use.
Instead of a huge “god” interface, create <u>smaller, focused interfaces.<u>

*Example:*
Don’t make IMachine with print(), scan(), and fax() if a simple printer only needs print().

**🧱 D — Dependency Inversion Principle (DIP)**

Depend on <u>abstractions (interfaces), not concrete implementations.<u>
High-level modules should not depend directly on low-level modules.

*Example:*
NotificationService depends on a MessageService interface, not EmailService directly.
