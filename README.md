1. Project Goal
   The AIMS (An Internet Media Store) project aims to deliver a robust application for managing an online media store. Its core purpose is to provide a comprehensive platform for customers to browse, purchase, and manage media, while empowering store managers with efficient inventory control.

2. Features
   2.1. Customer Application
        * Browse & Shop: View available media, add items to a cart, and filter/search within the cart by ID or title.
        * Media Playback: Play demo versions of DVDs or CDs directly from store listings or the cart.
        * Cart Management: Display cart contents, calculate total cost, and remove items.
        * Order Placement: Finalize purchases, initiating delivery and payment processes.
   2.2. Store Manager Application
        * Inventory Oversight: View all media items in the store.
        * Inventory Management: Add new Books, CDs, or DVDs to the store and remove existing ones.

3. Tech Stack
   3.1. Core
        * Java: Primarily developed using Java, emphasizing Object-Oriented Programming (OOP) principles like encapsulation, inheritance, and polymorphism.
        * JDK 8: Required for JavaFX integration, as it's included in this JDK version
        * Eclipse IDE: Primary development environment
        * UML: Problem modeling and design documented via Use Case and Class Diagrams (Astah recommended)
   3.2. GUI
        * Swing: Used for the initial Store Manager GUI, leveraging standard components like JFrame, JPanel, JTextField[cite: 619, 647, 685].
        * JavaFX: Powers the customer-facing application, with UI design aided by SceneBuilder[cite: 726, 738]. Employs various containers (VBox, HBox, GridPane, AnchorPane, ScrollPane)[cite: 753, 812, 824], data-driven TableView, and property binding for dynamic updates
   3.3. Advanced Techniques
        * Method Overloading: Applied to DigitalVideoDisc constructors and Cart's addDigitalVideoDisc methods
        * Memory Management: Explores String, StringBuilder, and StringBuffer for efficient string handling
        * Exception Handling: Implements custom exceptions (e.g., PlayerException) for runtime error management and data validation
        * Java Collections: Utilizes ArrayList for dynamic lists of authors, tracks, and media items
        * Comparators: Enables flexible sorting of media items by title and cost using the Comparator interface

4. Getting Started
   4.1. Prerequisites
        * Java JDK 8+ (ensure JavaFX SDK is configured for JDK > 8)
        * Eclipse IDE
        * JavaFX Scene Builder (optional, for UI design)
   4.2. Setup
        * Clone: git clone <repository-url>
        * Import to Eclipse: File > Import... > Existing Projects into Workspace
        * Configure JavaFX (if JDK > 8):
          * Download JavaFX SDK from GluonHQ
          * In Eclipse: Window > Preferences > Java > User Libraries > New (name "JavaFX"), then add all JARs from javafx-sdk-<version>/lib
          * Update VM arguments in Run Configurations: --module-path "YOUR_JAVAFX_SDK_PATH\lib" --add-modules javafx.controls,javafx.fxml
        * Configure Scene Builder (optional):
          * Install Scene Builder
          * In Eclipse: Window > Preferences > JavaFX, then point to the Scene Builder executable
   4.3. Running
        * Store Manager: Execute main in hust.soict.dsai.aims.screen.manager.<YourManagerScreenClass>.
        * Customer: Execute main in hust.soict.program.test.screen.customer.store.TestViewStoreScreen.

5. Contribution Workflow
   We follow a modified Release Flow for Git:
   * Branching: Feature, bugfix, hotfix, and refactor branches are created from master (e.g., feature/new-feature
   * Development Cycle:
     1. git pull 
     2. git checkout -b <new-branch> 
     3. Code, git add ., git commit -m "Descriptive commit message
     4. git push origin <new-branch
     5. Create a Pull Request (PR) on GitHub (for team review
     6. Merge PR to master
     7. For assignment submission, a release/labXX branch is created from master

6. Guidelines
   * Individual work is expected
   * Answers to lab questions should be in answers.txt
