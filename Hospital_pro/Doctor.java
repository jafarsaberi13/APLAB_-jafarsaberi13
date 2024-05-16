import java.util.ArrayList;
import java.util.List;

public class Doctor extends User {
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
        // Add more services as needed
    }
}
