import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;
    private String emailAddress;

    public Contact(String name, String phoneNumber, String emailAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}

class AddressBook {
    private List<Contact> contacts;

    public AddressBook() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void removeContact(String name) {
        contacts.removeIf(contact -> contact.getName().equals(name));
    }

    public Contact searchContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                return contact;
            }
        }
        return null;
    }

    public void displayAllContacts() {
        for (Contact contact : contacts) {
            System.out.println("Name: " + contact.getName());
            System.out.println("Phone Number: " + contact.getPhoneNumber());
            System.out.println("Email Address: " + contact.getEmailAddress());
            System.out.println();
        }
    }
}

public class AddressBookSystem {
    private AddressBook addressBook;

    public AddressBookSystem() {
        addressBook = new AddressBook();
    }

    public void displayMenu() {
        System.out.println("Welcome to Address Book System!");
        System.out.println("1. Add Contact");
        System.out.println("2. Remove Contact");
        System.out.println("3. Search Contact");
        System.out.println("4. Display All Contacts");
        System.out.println("5. Exit");
    }

    public void executeOption(int option) {
        Scanner scanner = new Scanner(System.in);

        switch (option) {
            case 1:
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                System.out.print("Enter phone number: ");
                String phoneNumber = scanner.nextLine();
                System.out.print("Enter email address: ");
                String emailAddress = scanner.nextLine();
                Contact newContact = new Contact(name, phoneNumber, emailAddress);
                addressBook.addContact(newContact);
                System.out.println("Contact added successfully.");
                break;
            case 2:
                System.out.print("Enter name of contact to remove: ");
                String contactToRemove = scanner.nextLine();
                addressBook.removeContact(contactToRemove);
                System.out.println("Contact removed successfully.");
                break;
            case 3:
                System.out.print("Enter name of contact to search: ");
                String contactToSearch = scanner.nextLine();
                Contact foundContact = addressBook.searchContact(contactToSearch);
                if (foundContact != null) {
                    System.out.println("Contact found:");
                    System.out.println("Name: " + foundContact.getName());
                    System.out.println("Phone Number: " + foundContact.getPhoneNumber());
                    System.out.println("Email Address: " + foundContact.getEmailAddress());
                } else {
                    System.out.println("Contact not found.");
                }
                break;
            case 4:
                addressBook.displayAllContacts();
                break;
            case 5:
                System.out.println("Exiting Address Book System. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option!");
                break;
        }
    }

    public static void main(String[] args) {
        AddressBookSystem addressBookSystem = new AddressBookSystem();
        Scanner scanner = new Scanner(System.in);

        int option;
        do {
            addressBookSystem.displayMenu();
            System.out.print("Enter option: ");
            option = scanner.nextInt();
            scanner.nextLine(); // consume newline
            addressBookSystem.executeOption(option);
        } while (option != 5);

        scanner.close();
    }
}
