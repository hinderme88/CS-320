package App;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ContactService {
    // define a new Array List of Contact objects
    public static List<Contact> contactList = new ArrayList<Contact>();

   // Check to see if the contact ID is already in use by looping through
    // the array list of contact IDs and comparing the passed in ID.
    // If we find that the ID already exists, we do not add it to the list.
    public void addContact(String contactId,  String firstName, String lastName, String number, String address) {
        Contact newContact = new Contact(contactId, firstName, lastName, number, address);
        if (contactList.isEmpty()) {
            contactList.add(newContact);
        } else {
            for (Contact ID : contactList) {
                if (Objects.equals(ID.getContactId(), contactId)) {
                    throw new IllegalArgumentException("That ID already exists!");
                } else {
                    contactList.add(newContact);
                }
            }

        }

    }

    // Loop through our contact list and find the passed in ID. If it exists, delete
    // the contact from the list.
    public void deleteContact(String contactId) {
        if (contactList.isEmpty()) {
            throw new IllegalArgumentException("Contact list is empty, nothing to delete.");
        } else {
            for (int i = 0; i < contactList.size(); i++) {
                if (Objects.equals(contactList.get(i).getContactId(), contactId)) {
                    contactList.remove(i);
                    break;
                }
            }
        }

    }

    // For first name, last name, phone, and address, we will loop through
    // our IDs until we find a match. Then we will update the passed in value.
    public void updateContactFirstName(String contactId, String firstName) {
        for (int i = 0; i < contactList.size(); i++) {
            if (Objects.equals(contactList.get(i).getContactId(), contactId)) {
                contactList.get(i).setFirstName(firstName);
            }
        }
    }

    public void updateContactLastName(String contactID, String lastName) {
        for (Contact contact : contactList) {
            if (Objects.equals(contact.getContactId(), contactID)) {
                contact.setLastName(lastName);
            }
        }
    }

    public void updateContactPhone(String contactId, String phone) {
        for (Contact contact : contactList) {
            if (Objects.equals(contact.getContactId(), contactId)) {
                contact.setNumber(phone);
            }
        }
    }

    public void updateContactAddress(String contactId, String address) {
        for (Contact contact : contactList) {
            if (Objects.equals(contact.getContactId(), contactId)) {
                contact.setAddress(address);
            }
        }
    }
}