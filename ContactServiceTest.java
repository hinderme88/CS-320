package Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import App.ContactService;
import App.Contact;

public class ContactServiceTest {

    // variables to hold our test data. Declare them all here so we don't have to hardcode them in each individual test case
    protected String contactId, firstName, lastName, number, address;
    protected String newFirstName, newLastName, newPhone, newAddress;

    // Clear the contact list after each test
    @AfterEach
    void tearDown() throws Exception {
        ContactService.contactList.clear();
    }

    @BeforeEach
    void setUp() {
        // prepopulate the contact variables
        contactId = "12345678";
        firstName = "Bob";
        lastName = "Belcher";
        number = "5554562159";
        address = "6 Red Dr City NJ 08223";
        newFirstName = "Teddy";
        newLastName = "Roberts";
        newPhone = "5556324900";
        newAddress = "5 Poe St Ocean City NJ 08223";

    }

    @Test
    void testAddContact() {
        // create a new Contact Service
        ContactService testService = new ContactService();
        // use the new contact service to add a new contact
        testService.addContact(contactId, firstName, lastName, number, address);
        assertFalse(ContactService.contactList.isEmpty());
        // assert that the contact was successfully added
        assertEquals(firstName, ContactService.contactList.get(0).getFirstName());
        assertEquals(lastName, ContactService.contactList.get(0).getLastName());
        assertEquals(number, ContactService.contactList.get(0).getNumber());
        assertEquals(address, ContactService.contactList.get(0).getAddress());

    }

    @Test
    void testDeleteContact() {
        // create new object of ContactService
        ContactService testService = new ContactService();
        // add new contact to the contact list
        testService.addContact(contactId, firstName, lastName, number, address);
        // confirm that the contact was added to the list
        assertTrue(!(ContactService.contactList.isEmpty()));
        // if the contact was successfully added, call the delete method

         testService.deleteContact(contactId);

        // now assert that the contact was successfully deleted
        assertTrue(ContactService.contactList.isEmpty());
    }

    @Test
    void testUpdateContact() {
        // create a new contact
        Contact testContact = new Contact(contactId, firstName, lastName, number, address);
        // create a new Contact Service
        ContactService testService = new ContactService();
        // add a new contact using the contact service
        testService.addContact(testContact.getContactId(),
                testContact.getFirstName(),
                testContact.getLastName(),
                testContact.getNumber(),
                testContact.getAddress());
        // update the first name of the new contact
        testService.updateContactFirstName(testContact.getContactId(), newFirstName);
        // update the last name of the new contact
        testService.updateContactLastName(testContact.getContactId(), newLastName);
        // update the phone number of the new contact
        testService.updateContactPhone(testContact.getContactId(), newPhone);
        // update the address of the new contact
        testService.updateContactAddress(testContact.getContactId(), newAddress);

        // now assert that all of the values were successfully updated
        Assertions.assertEquals(newFirstName, ContactService.contactList.get(0).getFirstName());
        Assertions.assertEquals(newLastName, ContactService.contactList.get(0).getLastName());
        Assertions.assertEquals(newPhone, ContactService.contactList.get(0).getNumber());
        Assertions.assertEquals(newAddress, ContactService.contactList.get(0).getAddress());

    }
}


