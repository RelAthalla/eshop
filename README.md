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
   

