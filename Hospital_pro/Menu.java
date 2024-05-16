import java.util.Scanner;

public class Menu {
    private Hospital hospital;
    private Scanner scanner;

    public Menu(Hospital hospital) {
        this.hospital = hospital;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void login() {
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
    }

    private void register() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Are you a doctor (yes/no)? ");
        String isDoctor = scanner.nextLine();

        if (isDoctor.equalsIgnoreCase("yes")) {
            hospital.addUser(new Doctor(username, password, 0));
        } else {
            hospital.addUser(new Patient(username, password, 0));
        }

        System.out.println("Registration successful.");
    }
}
