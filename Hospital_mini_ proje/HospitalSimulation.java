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
        System.out.println("Services for Patient:");
        System.out.println("1. View Balance");
        System.out.println("2. Charge Account");
    }
}

class Doctor {
    private String username;
    private String password;
    private double balance;
    private List<String> availability;

    public Doctor(String username, String password, double balance) {
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.availability = new ArrayList<>();
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

    public void addAvailability(String timeSlot) {
        availability.add(timeSlot);
    }

    public List<String> getAvailability() {
        return availability;
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
    private List<User> users;
    private List<Doctor> doctors;
    private Scanner scanner;

    public HospitalSimulation() {
        this.users = new ArrayList<>();
        this.doctors = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public User login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.checkPassword(password)) {
                return user;
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

    public void register(boolean isDoctor) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (isDoctor) {
            Doctor doctor = new Doctor(username, password, 0);
            doctors.add(doctor);
            System.out.println("Doctor registration successful.");
        } else {
            User patient = new User(username, password, 0);
            users.add(patient);
            System.out.println("Patient registration successful.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HospitalSimulation hospital = new HospitalSimulation();

        while (true) {
            System.out.println("1. Login as Patient");
            System.out.println("2. Login as Doctor");
            System.out.println("3. Register as Doctor");
            System.out.println("4. Register as Patient");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();

                User user = hospital.login(username, password);
                if (user != null) {
                    user.showServices();
                } else {
                    System.out.println("Invalid credentials.");
                }
            } else if (choice == 2) {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();

                Doctor doctor = hospital.loginDoctor(username, password);
                if (doctor != null) {
                    doctor.showServices();
                } else {
                    System.out.println("Invalid credentials.");
                }
            } else if (choice == 3) {
                hospital.register(true);
            } else if (choice == 4) {
                hospital.register(false);
            } else if (choice == 5) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}
