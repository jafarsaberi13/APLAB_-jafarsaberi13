import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class User {
    private String username;
    private String password;
    private double balance;

    public User(String username, String password, double balance) {
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public double getBalance() {
        return balance;
    }

    public void chargeAccount(double amount) {
        this.balance += amount;
    }

    public boolean deductFromAccount(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    public void showServices() {
        System.out.println("Services for User:");
        System.out.println("1. View Balance");
        System.out.println("2. Charge Account");
    }
}

class Patient {
    private User user;
    private List<String> discountCodes;

    public Patient(String username, String password, double balance) {
        this.user = new User(username, password, balance);
        this.discountCodes = new ArrayList<>();
    }

    public String getUsername() {
        return user.getUsername();
    }

    public boolean checkPassword(String password) {
        return user.checkPassword(password);
    }

    public double getBalance() {
        return user.getBalance();
    }

    public void chargeAccount(double amount) {
        user.chargeAccount(amount);
    }

    public boolean deductFromAccount(double amount) {
        return user.deductFromAccount(amount);
    }

    public void showServices() {
        user.showServices();
        System.out.println("3. Apply Discount Code");
    }

    public void addDiscountCode(String discountCode) {
        discountCodes.add(discountCode);
    }

    public boolean hasValidDiscountCode(String code) {
        // Check if the discount code is valid based on custom logic
        // Here, you can implement the logic to validate the discount code format and expiration date
        return discountCodes.contains(code);
    }
}

class Doctor {
    private User user;

    public Doctor(String username, String password, double balance) {
        this.user = new User(username, password, balance);
    }

    public String getUsername() {
        return user.getUsername();
    }

    public boolean checkPassword(String password) {
        return user.checkPassword(password);
    }

    public double getBalance() {
        return user.getBalance();
    }

    public void chargeAccount(double amount) {
        user.chargeAccount(amount);
    }

    public boolean deductFromAccount(double amount) {
        return user.deductFromAccount(amount);
    }

    public void showServices() {
        System.out.println("Services for Doctor:");
        System.out.println("1. View Schedule");
        System.out.println("2. Add Availability");
        System.out.println("3. View Balance");
        System.out.println("4. Charge Account");
    }
}

public class HospitalSimulation {
    private List<Patient> patients;
    private List<Doctor> doctors;
    private Scanner scanner;

    public HospitalSimulation() {
        this.patients = new ArrayList<>();
        this.doctors = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public Patient loginPatient(String username, String password) {
        for (Patient patient : patients) {
            if (patient.getUsername().equals(username) && patient.checkPassword(password)) {
                return patient;
            }
        }
        return null;
    }

    public Doctor loginDoctor(String username, String password) {
        for (Doctor doctor : doctors) {
            if (doctor.getUsername().equals(username) && doctor.checkPassword(password)) {
                return doctor;
            }
        }
        return null;
    }

    public void registerPatient() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        Patient patient = new Patient(username, password, 0);
        patients.add(patient);
        System.out.println("Patient registration successful.");
    }

    public void registerDoctor() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        Doctor doctor = new Doctor(username, password, 0);
        doctors.add(doctor);
        System.out.println("Doctor registration successful.");
    }

    public void applyDiscountCode(Patient patient) {
        System.out.print("Enter discount code: ");
        String code = scanner.nextLine();

        // Check if the entered discount code is valid for the patient
        if (patient.hasValidDiscountCode(code)) {
            System.out.println("Discount applied successfully.");
            // Apply the discount
            // You can implement the logic to apply the discount here
        } else {
            System.out.println("Invalid or expired discount code.");
        }
    }

    public void applyDiscountCode(Doctor doctor) {
        System.out.print("Enter discount code: ");
        String code = scanner.nextLine();

        // Check if the entered discount code is valid for the doctor
        // For demonstration purposes, doctors do not have discount codes in this implementation
        System.out.println("Doctors do not have discount codes in this simulation.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HospitalSimulation hospital = new HospitalSimulation();

        while (true) {
            System.out.println("1. Patient Login");
            System.out.println("2. Doctor Login");
            System.out.println("3. Patient Register");
            System.out.println("4. Doctor Register");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String patientUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String patientPassword = scanner.nextLine();

                    Patient patient = hospital.loginPatient(patientUsername, patientPassword);
                    if (patient != null) {
                        patient.showServices();
                        System.out.println("Enter your choice:");
                        int serviceChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        if (serviceChoice == 3) {
                            hospital.applyDiscountCode(patient);
                        } else {
                            System.out.println("Invalid choice.");
                        }
                    } else {
                        System.out.println("Invalid patient credentials.");
                    }
                    break;
                case 2:
                    System.out.print("Enter username: ");
                    String doctorUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String doctorPassword = scanner.nextLine();

                    Doctor doctor = hospital.loginDoctor(doctorUsername, doctorPassword);
                    if (doctor != null) {
                        doctor.showServices();
                    } else {
                        System.out.println("Invalid doctor credentials.");
                    }
                    break;
                case 3:
                    hospital.registerPatient();
                    break;
                case 4:
                    hospital.registerDoctor();
                    break;
                case 5:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
