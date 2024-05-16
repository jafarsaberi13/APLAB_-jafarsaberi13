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

class Doctor extends User {
    private List<String> availability;

    public Doctor(String username, String password, double balance) {
        super(username, password, balance);
        this.availability = new ArrayList<>();
    }

    public void addAvailability(String timeSlot) {
        availability.add(timeSlot);
    }

    public List<String> getAvailability() {
        return availability;
    }

    @Override
    public void showServices() {
        System.out.println("Services for Doctor:");
        System.out.println("1. View Schedule");
        System.out.println("2. Add Availability");
    }
}

class Patient extends User {
    public Patient(String username, String password, double balance) {
        super(username, password, balance);
    }

    @Override
    public void showServices() {
        System.out.println("Services for Patient:");
        System.out.println("1. Book Appointment");
        System.out.println("2. View Balance");
        System.out.println("3. Charge Account");
    }
}

public class HospitalSimulation {
    private List<User> users;
    private Scanner scanner;

    public HospitalSimulation() {
        this.users = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.checkPassword(password)) {
                return user;
            }
        }
        return null;
    }

    public void register() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Are you a doctor (yes/no)? ");
        String isDoctor = scanner.nextLine();

        if (isDoctor.equalsIgnoreCase("yes")) {
            Doctor doctor = new Doctor(username, password, 0);
            users.add(doctor);
        } else {
            Patient patient = new Patient(username, password, 0);
            users.add(patient);
        }

        System.out.println("Registration successful.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HospitalSimulation hospital = new HospitalSimulation();

        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
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
                hospital.register();
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}
