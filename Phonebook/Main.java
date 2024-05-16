import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Parser parser = new Parser(phoneBook);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String command = scanner.nextLine();
            parser.parseCommand(command);
        }
    }
}
