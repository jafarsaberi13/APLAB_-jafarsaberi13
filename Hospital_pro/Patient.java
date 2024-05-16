public class Patient extends User {

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
