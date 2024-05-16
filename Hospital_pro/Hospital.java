import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private List<User> users;
    private List<Doctor> doctors;

    public Hospital() {
        this.users = new ArrayList<>();
        this.doctors = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
        if (user instanceof Doctor) {
            doctors.add((Doctor) user);
        }
    }

    public User login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.checkPassword(password)) {
                return user;
            }
        }
        return null;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }
}
