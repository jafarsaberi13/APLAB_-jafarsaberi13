import java.util.Scanner;

public class Parser {
    private PhoneBook phoneBook;

    public Parser(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    public void parseCommand(String command) {
        String[] tokens = command.split(" ");
        switch (tokens[0]) {
            case "contacts":
                if (tokens[1].equals("-a")) {
                    // Assuming input is formatted correctly for simplicity
                    Scanner scanner = new Scanner(System.in);
                    
                    System.out.println("Enter group:");
                    String group = scanner.nextLine();
                    
                    System.out.println("Enter email:");
                    String email = scanner.nextLine();
                    
                    System.out.println("Enter first name:");
                    String firstName = scanner.nextLine();
                    
                    System.out.println("Enter last name:");
                    String lastName = scanner.nextLine();
                    
                    System.out.println("Enter country code:");
                    String countryCode = scanner.nextLine();
                    
                    System.out.println("Enter phone number:");
                    String number = scanner.nextLine();
                    
                    System.out.println("Enter zip code:");
                    String zipCode = scanner.nextLine();
                    
                    System.out.println("Enter country:");
                    String country = scanner.nextLine();
                    
                    System.out.println("Enter city:");
                    String city = scanner.nextLine();
                    
                    PhoneNumber phoneNumber = new PhoneNumber(countryCode, number);
                    Address address = new Address(zipCode, country, city);
                    Contact contact = new Contact(group, email, firstName, lastName, phoneNumber, address);
                    if (phoneBook.addContact(contact)) {
                        System.out.println("Ok");
                    } else {
                        System.out.println("Not added");
                    }
                } else if (tokens[1].equals("-r")) {
                    if (phoneBook.deleteContact(tokens[2], tokens[3])) {
                        System.out.println("Ok");
                    } else {
                        System.out.println("Not found");
                    }
                }
                break;
            case "show":
                if (tokens[1].equals("-g")) {
                    Contact[] contacts = phoneBook.findContacts(tokens[2]);
                    for (Contact contact : contacts) {
                        System.out.println(contact);
                    }
                } else if (tokens[1].equals("-c")) {
                    Contact[] contacts = phoneBook.findContact(tokens[2]);
                    for (Contact contact : contacts) {
                        System.out.println(contact);
                    }
                } else {
                    phoneBook.printContacts();
                }
                break;
            case "exit":
                System.exit(0);
                break;
            default:
                System.out.println("Invalid command");
                break;
        }
    }
}
