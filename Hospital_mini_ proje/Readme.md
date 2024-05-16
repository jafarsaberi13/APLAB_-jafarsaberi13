## Hospital Simulation - README

This code simulates a basic hospital user management system. It allows users to register as either a doctor or a patient, login, and access limited functionalities based on their role.

**Features:**

* User Registration (Doctor or Patient)
* User Login
* Role-based User Menu (Doctor vs. Patient)
* Doctor can view their availability schedule (empty by default)
* Patient can view their account balance
* User can charge their account (functionality not implemented)

**Running the Simulation:**

1. Compile the Java code using a Java compiler (e.g., javac HospitalSimulation.java).
2. Run the compiled class using the command line: `java HospitalSimulation`

**User Interaction:**

The program presents a menu with three options:

1. Login: Enter username and password to login as an existing user.
2. Register: Create a new user account (doctor or patient).
3. Exit: Terminate the program.

Based on the user's choice, the program guides them through the login or registration process and displays a role-specific menu upon successful login.

**Note:**

* The `chargeAccount` functionality is not implemented yet.
* Doctors cannot add availability slots yet (functionality is included but not implemented).

**Further Development:**

* Implement the `chargeAccount` functionality for both doctors and patients.
* Allow doctors to add availability slots to their schedule.
* Integrate appointment booking functionality for patients.
* Enhance the user interface with more informative messages and error handling.

This code provides a basic framework for a hospital user management system simulation. You can extend it to include additional functionalities and features.
