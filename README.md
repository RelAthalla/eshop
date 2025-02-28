# Module 1: Coding Standard

Reflection 1
 
These are some Clean Code and Secure Code principles that I have implemented in my code:

Clean Code

1. SRP & Separation of Concerns – Classes are separated according to their responsibilities (Controller, Service, Repository).
2. Keterbacaan – Descriptive variable and method names (editProductPage, ProductService).
3. Dependency Injection – Using @Autowired for dependency management.
4. Reusability – Thymeleaf is used as a template engine.

Secure Coding

1. UUID for Product IDs – Prevents easily guessable IDs.
2. Restricting HTTP Methods – Use GET only for reading data, POST for modifications.
3. XSS Protection – Thymeleaf automatically performs escaping.
4. Redirect After Operations – Prevents duplication when refreshing the page.

Reflection 2 

1. **My Thought After Writing Unit Tests**

   Writing unit tests provides confidence that the program behaves as expected. However, it takes time and effort to test various scenarios.
   
   **How Many Unit Tests Are Needed?**

   Each public method should be tested at least once, along with tests for Boundary scenarios, Negative scenarios, and Edge cases.
   
   **How to Ensure Unit Tests Are Sufficient?**

    - Use code coverage tools (e.g., Jacoco) to measure the percentage of tested code.
    - However, 100% coverage ≠ bug-free, as unanticipated logic paths may still contain bugs.


2. **Code Cleanliness in New Functional Tests**

   **Problem**: Jf each test suite repeats the same setup, it leads to:
    - **Code duplication** (e.g., navigation, driver setup).
    - **Decreased code quality** due to maintainability issues and inefficiency.
   
  **Solution**:
  - Use  **Page Object Model (POM)** to separate UI elements from test logic.
  - Abstract setup & navigation into a **base class** to avoid repetition.
  - Create  **utility classes** for common actions (e.g., clicking buttons, filling input fields).
  - Use **parameterized tests** to avoid duplicating similar test scenarios.


# Module 2: CI/CD & DevOps

1. **List of code quality issue that i've fixed**

   1. Unused Import
      I fixed some unused import issues.
      Since, according to code quality standards, I included unnecessary imports, I simply removed them.

   2. Unnecessary Modifier
      Since, according to code quality standards, I used unnecessary modifiers, for example, in ProductService inside the service package,
      I removed the public modifier because it was not needed.

2. **Does my current implementation met the definition of Continuous Integration and Continuous Deployment?**

   Yes, my current CI/CD implementation meets the definition of Continuous Integration (CI) and Continuous Deployment (CD) to a 
   certain extent. The CI aspect is fulfilled as my workflow automatically runs tests and performs code quality analysis (using tools like JaCoCo and PMD) 
   on every push to ensure code integrity. Additionally, the pipeline helps detect and fix issues early, promoting better code maintainability.

   For Continuous Deployment, I have implemented an auto-deploy mechanism to a PaaS, the one that I use is Koyeb with push based approach, 
   allowing the latest code changes to be deployed automatically upon successful pipeline execution. 
   However, the current setup could be improved by adding automated rollback mechanisms or canary deployments to enhance deployment reliability. 
   Overall, the workflow supports CI/CD principles by automating testing, quality checks, and deployment, but there is always room for further optimization.

# Module 3: Maintainability & OO Principles

SOLID Principles Applied on my project
1. Single Responsibility Principle (SRP)
   Each class is assigned a clear and specific responsibility:
   CarController was moved into its own file instead of being inside ProductController.
   The Car model stores data related to a car.
   The CarController handles HTTP requests related to car operations.
   The CarReadService and CarWriteService encapsulate business logic for reading and writing car data.
2. Dependency Inversion Principle (DIP)
   The CarController depends on abstractions (CarReadService and CarWriteService) instead of concrete implementations.
   This allows the underlying implementation (e.g., switching from an in-memory repository to a database) to be changed without modifying the controller or business logic.
3. Open/Closed Principle (OCP)
   The system is open for extension but closed for modification.
   By using interfaces for the service layer, new behaviors or validations can be added without modifying the CarController.
4. Interface Segregation Principle (ISP)
   The CarReadService (for read operations) and CarWriteService (for write operations) ensure that classes only depend on the methods they need.
   This keeps interfaces focused and prevents unnecessary dependencies.
5. Liskov Substitution Principle (LSP)
   The CarController interacts with interfaces, ensuring that any implementation of CarReadService or CarWriteService can replace the existing one without breaking functionality.
   This makes it easy to use test doubles or future service implementations.

Advantages of Applying SOLID Principles

✅ Modularity and Maintainability
Each component of the Car domain is well-separated.
For example, if the data retrieval method changes, only CarReadService or CarRepository needs modification—CarController remains unaffected.

✅ Improved Testability
With DIP, unit tests can easily mock CarReadService and CarWriteService, allowing isolated testing of CarController without relying on real services.

✅ Flexibility and Extensibility
Following OCP, new features (e.g., complex car validation, logging) can be added without altering existing code, reducing the risk of introducing bugs.


✅ Reduced Coupling
By applying ISP, each part of the Car domain only interacts with the methods it needs, minimizing dependencies and making refactoring easier.

Disadvantages of Not Applying SOLID Principles

❌ Tight Coupling and Inflexibility
Without DIP, if CarController depended directly on a concrete CarService, migrating to a new persistence layer would require modifying multiple components.

❌ Difficult Maintenance and Extension
Without SRP, a controller that handles both request processing and business logic would become bloated and harder to maintain.
Example: Mixing validation and persistence logic in CarController would make debugging and future enhancements more error-prone.

❌ Harder Unit Testing
Violating ISP could lead to tests requiring unnecessary dependencies, making setup complex.
Without DIP, testing CarController might inadvertently trigger database access or other side effects.

❌ Reduced Reusability
Without OCP and ISP, a monolithic interface could force components to include unnecessary functionality, increasing the risk of unintended side effects when modifying code.
By implementing SOLID principles—through separation of CarReadService, CarWriteService, CarRepository, and a dedicated CarController—the Car domain becomes more flexible, maintainable, and testable. Ignoring these principles leads to a tightly coupled, rigid architecture that is difficult to modify as business requirements evolve.