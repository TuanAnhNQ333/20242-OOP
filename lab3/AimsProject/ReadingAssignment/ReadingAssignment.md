Reading Assignment: Polymorphism and Inheritance in Java

1. What are the advantages of Polymorphism?
Polymorphism allows objects of different classes to be treated as objects of a common superclass or interface, enabling flexible and reusable code. Its advantages include:

- Flexibility and Extensibility: New subclasses can be added without modifying existing code, as long as they adhere to the common interface or superclass. For example, in the AIMS project, new media types (e.g., Book, CompactDisc) can be added to the Cart without changing its methods.

- Code Reusability: Polymorphic behavior allows methods to operate on a superclass type, reducing code duplication. For instance, the Cart class uses ArrayList<Media> to handle DigitalVideoDisc, Book, and CompactDisc uniformly.

- Simplified Maintenance: Changes to a superclass or interface propagate to all subclasses, making updates easier.

- Dynamic Behavior: Runtime polymorphism (via method overriding) enables the appropriate method to be called based on the actual object type, as seen in the toString() method of Media subclasses.

2. How is Inheritance useful to achieve Polymorphism in Java?
Inheritance is a key mechanism for achieving polymorphism, particularly runtime (dynamic) polymorphism:

- Superclass as a Common Type: Inheritance allows subclasses to inherit fields and methods from a superclass, enabling them to be treated as instances of the superclass. In the AIMS project, Book, DigitalVideoDisc, and CompactDisc extend Media, allowing a Cart to store them as Media objects.

- Method Overriding: Subclasses can override superclass methods to provide specific implementations. For example, the toString() method in Book, DigitalVideoDisc, and CompactDisc provides type-specific output, but can be called polymorphically on a Media reference.

- Interface Implementation: Inheritance from interfaces (via implements) allows classes to share a contract. The Playable interface in AIMS ensures that DigitalVideoDisc, CompactDisc, and Track implement play(), enabling polymorphic calls to play().

- Type Safety: Inheritance ensures that subclasses conform to the superclass's contract, allowing safe polymorphic operations.

3. What are the differences between Polymorphism and Inheritance in Java?
While related, polymorphism and inheritance serve distinct purposes:

- Definition:

    - Polymorphism: The ability of different classes to be treated as instances of a common superclass or interface, with behavior determined at runtime (via method overriding) or compile-time (via method overloading).

    - Inheritance: A mechanism where a class (subclass) inherits fields and methods from another class (superclass), promoting code reuse and hierarchical relationships.

- Purpose:

    - Polymorphism: Enables flexible and dynamic behavior, allowing a single interface to represent multiple implementations. For example, calling toString() on a Media reference invokes the appropriate subclass implementation.

    - Inheritance: Facilitates code reuse and establishes an "is-a" relationship. For instance, DigitalVideoDisc inherits id, title, category, and cost from Media.

- Mechanism:

    - Polymorphism: Achieved through method overriding (runtime) or overloading (compile-time), often relying on inheritance or interfaces. In AIMS, Media subclasses override toString() for polymorphic behavior.

    - Inheritance: Achieved through the extends keyword for classes or implements for interfaces, without necessarily involving polymorphic behavior.

- Scope:

    - Polymorphism: Focuses on behavior and how objects are used (e.g., calling play() on a Playable object).

    - Inheritance: Focuses on structure and code sharing (e.g., Disc provides length and director to DigitalVideoDisc and CompactDisc).

- Example in AIMS:

    - Polymorphism: Iterating over an ArrayList<Media> and calling toString() produces different outputs based on the actual object type (Book, DigitalVideoDisc, or CompactDisc).


    - Inheritance: The Media class provides common fields (id, title, category, cost) to its subclasses, reducing code duplication.