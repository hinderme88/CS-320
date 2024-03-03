package Test;

import App.Contact;
import App.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
    // variables to hold our test data. Declare them all here so we don't have to hardcode them in each individual test case
    protected String contactId, firstName, lastName, number, address;
    protected String nullFirstName, nullLastName, nullPhone, nullAddress, invalidContactId, invalidFirstName, invalidLastName, invalidPhone, invalidAddress;

    @BeforeEach
    void setUp() {
        contactId = "1234ABCD";
        firstName = "Bob";
        lastName = "Belcher";
        number = "5554562159";
        address = "6 Ocean Av O City NJ 08223";
        nullFirstName = "";
        nullLastName = "";
        nullPhone = "";
        nullAddress = "";
        invalidContactId = "123456ABCDEFG";
        invalidFirstName = "Michelangelo";
        invalidLastName = "Weatherington";
        invalidPhone = "12345678900";
        invalidAddress = "601 W. Main St, American Fork, UT 84003";
    }

    // test our constructor
   @Test
    void testCreateNewContactConstructor() {
        Contact newContact = new Contact(contactId, firstName, lastName, number, address);
        assertEquals(contactId, newContact.getContactId());
        assertEquals(firstName, newContact.getFirstName());
       assertEquals(lastName, newContact.getLastName());
       assertEquals(number, newContact.getNumber());
       assertEquals(address, newContact.getAddress());
    }

    // test for null values. All fields should throw errors if null
    @Test
    void testNullContactId() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, firstName, lastName, number, address);
        });
    }
    @Test
    void testNullFirstName() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactId, null, lastName, number, address);
        });
    }
    @Test
    void testNullLastName() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactId, firstName, null, number, address);
        });
    }
    @Test
    void testNullNumber() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactId, firstName, lastName, null, address);
        });
    }
    @Test
    void testNullAddress() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactId, firstName, lastName, number, null);
        });
    }

    // test field lengths. Contact ID, First Name, and Last Name cannot be over 10 characters.
    // Phone number must be exactly 10 characters and address cannot be over 30 characters.
    @Test
    void testContactIdLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(invalidContactId, firstName, lastName, number, address);
        });
    }
    @Test
    void testFirstNameLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactId, invalidFirstName, lastName, number, address);
        });

    }
    @Test
    void testLastNameLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactId, firstName, invalidLastName, number, address);
        });

    }
    @Test
    void testPhoneNumberLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactId, firstName, lastName, invalidPhone, address);
        });

    }
    @Test
    void testAddressLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactId, firstName, lastName, number, invalidAddress);
        });

    }

}
