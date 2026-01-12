# Software Design Patterns – Overview with UML

---

## 1. Facade Pattern

**Description:**  
The Facade pattern provides a simplified interface to a complex subsystem, making it easier to use without exposing internal complexity.

**Real-life Example:**  
A hotel concierge who handles reservations, transportation, and dining so guests don’t need to interact with each department individually.

**UML Diagram:**  
![Facade UML](https://upload.wikimedia.org/wikipedia/commons/5/57/Example_of_Facade_design_pattern_in_UML.png)

---

## 2. Adapter Pattern

**Description:**  
The Adapter pattern allows incompatible interfaces to work together by converting one interface into another expected by the client.

**Real-life Example:**  
A power plug adapter that allows a U.S. plug to fit into a European outlet.

**UML Diagram:**  
![Adapter UML](https://circle.visual-paradigm.com/wp-content/uploads/2017/08/GoF-Design-Patterns-Structural-Patterns-Adapter.png)

---

## 3. Strategy Pattern

**Description:**  
The Strategy pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable at runtime.

**Real-life Example:**  
Choosing different navigation routes in Google Maps (fastest, shortest, avoid tolls).

**UML Diagram:**  
![Strategy UML](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSGFDsYNO2Md7jo2-_a4dr-RBPQBLaVOi3niw&s)

---

## 4. Bridge Pattern

**Description:**  
The Bridge pattern separates an abstraction from its implementation so they can evolve independently.

**Real-life Example:**  
A remote control (abstraction) that works with different TVs (implementations).

**UML Diagram:**  
![Bridge UML](https://refactoring.guru/images/patterns/diagrams/bridge/solution-en.png?id=b72caae18c400d6088072f2f3adda7cd)

---

## 5. Factory Method Pattern

**Description:**  
The Factory Method pattern defines an interface for creating objects but lets subclasses decide which class to instantiate.

**Real-life Example:**  
A restaurant kitchen deciding which dish to prepare based on the order.

**UML Diagram:**  
![Factory Method UML](https://www.oodesign.com/images/stories/factory%20method%20implementation%20-%20uml%20class%20diagram.gif)

---

## 6. Abstract Factory Pattern

**Description:**  
The Abstract Factory pattern provides an interface for creating families of related or dependent objects without specifying their concrete classes.

**Real-life Example:**  
A furniture store offering modern or Victorian furniture sets (chairs, sofas, tables).

**UML Diagram:**  
![Abstract Factory UML](https://upload.wikimedia.org/wikipedia/commons/thumb/9/9d/Abstract_factory_UML.svg/1200px-Abstract_factory_UML.svg.png)

---

## 7. Decorator Pattern

**Description:**  
The Decorator pattern dynamically adds new behavior to objects without modifying their structure.

**Real-life Example:**  
Adding toppings to a coffee (milk, caramel, whipped cream).

**UML Diagram:**  
![Decorator UML](https://circle.visual-paradigm.com/wp-content/uploads/2017/08/GoF-Design-Patterns-Structural-Patterns-Decorator.png)

---

## 8. Observer Pattern

**Description:**  
The Observer pattern defines a one-to-many dependency so that when one object changes state, all its dependents are notified.

**Real-life Example:**  
YouTube subscribers receiving notifications when a channel uploads a video.

**UML Diagram:**  
![Observer UML](https://www.cs.uah.edu/~rcoleman/CS307/DesignPatterns/Images/Behavioral/Observer.jpg)

---

## 9. Singleton Pattern

**Description:**  
The Singleton pattern ensures a class has only one instance and provides a global point of access to it.

**Real-life Example:**  
A printer spooler that manages all print jobs in a system.

**UML Diagram:**  
![Singleton UML](https://refactoring.guru/images/patterns/diagrams/singleton/structure-en.png?id=4e4306d3a90f40d74c7a4d2d2506b8ec)

---

## 10. Command Pattern

**Description:**  
The Command pattern encapsulates a request as an object, allowing parameterization and undo/redo functionality.

**Real-life Example:**  
A TV remote where each button represents a command (power, volume, channel).

**UML Diagram:**  
![Command UML](https://reactiveprogramming.io/_next/image?url=%2Fbooks%2Fpatterns%2Fimg%2Fpatterns-articles%2Fcommand-diagram.png&w=3840&q=75)

---

## 11. Iterator Pattern

**Description:**  
The Iterator pattern provides a way to access elements of a collection sequentially without exposing its underlying structure.

**Real-life Example:**  
Scrolling through a playlist one song at a time.

**UML Diagram:**  
![Iterator UML](https://reactiveprogramming.io/_next/image?url=%2Fbooks%2Fpatterns%2Fimg%2Fpatterns-articles%2Fiterator-diagram.png&w=3840&q=75)

---

## 12. Template Method Pattern

**Description:**  
The Template Method pattern defines the skeleton of an algorithm while allowing subclasses to redefine specific steps.

**Real-life Example:**  
A cooking recipe where steps like “bake” or “boil” vary depending on the dish.

**UML Diagram:**  
![Template Method UML](https://www.drawio.com/assets/img/blog/class-diagram-example.png)

---

## 13. Builder Pattern

**Description:**  
The Builder pattern constructs complex objects step by step, allowing different representations using the same construction process.

**Real-life Example:**  
Building a custom sandwich by choosing bread, fillings, and sauces.

**UML Diagram:**  
![Builder UML](https://reactiveprogramming.io/_next/image?url=%2Fbooks%2Fpatterns%2Fimg%2Fpatterns-articles%2Fbuilder-diagram.png&w=3840&q=75)

---
