import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    private List<Contact> contacts;
    private int contactCount;

    public PhoneBook() {
        this.contacts = new ArrayList<>();
        this.contactCount = 0;
    }

    public boolean addContact(Contact contact) {
        for (Contact c : contacts) {
            if (c.toString().equals(contact.toString())) {
                return false;
            }
        }
        contacts.add(contact);
        contactCount++;
        return true;
    }

    public boolean deleteContact(String firstName, String lastName) {
        for (Contact c : contacts) {
            if (c.toString().contains(firstName) && c.toString().contains(lastName)) {
                contacts.remove(c);
                contactCount--;
                return true;
            }
        }
        return false;
    }

    public Contact[] findContact(String inputStr) {
        List<Contact> result = new ArrayList<>();
        for (Contact c : contacts) {
            if (c.toString().contains(inputStr)) {
                result.add(c);
            }
        }
        return result.toArray(new Contact[0]);
    }

    public Contact[] findContacts(String searchType) {
        List<Contact> result = new ArrayList<>();
        for (Contact c : contacts) {
            if (c.toString().contains(searchType)) {
                result.add(c);
            }
        }
        return result.toArray(new Contact[0]);
    }

    public void printContacts() {
        for (Contact c : contacts) {
            System.out.println(c);
        }
    }
}
