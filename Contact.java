package App;

/* This is the main Contact class */
public class Contact {

    private String contactId;
    private String firstName;
    private String lastName;
    private String number;
    private String address;

    // set up our constructor for the Contacts.Contact class
    public Contact(String contactId, String firstName, String lastName, String number, String address) {
        // we will check contact ID first. This must be a unique value, 10 characters or less, and cannot be blank.
        if (contactId == null || contactId.isEmpty()) {
            throw new IllegalArgumentException("Contacts.Contact ID is required.");
        } else if (contactId.length() > 10) {
            throw new IllegalArgumentException("Contacts.Contact ID must be 10 characters or less.");
        } else {
            this.contactId = contactId;
        }
        // call the specific setters for the other values
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setNumber(number);
        this.setAddress(address);

    }
    // getters
    public String getContactId() {
        return contactId;
    }
    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getNumber() {
        return this.number;
    }

    public String getAddress() {
        return this.address;
    }

    // first name cannot be blank and must be 10 characters or less
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("First name is required.");
        } else if (firstName.length() > 10) {
            throw new IllegalArgumentException("First name must be 10 characters or less.");
        } else {
            this.firstName = firstName;
        }
    }

    // last name cannot be blank and must be 10 characters or less
    public void setLastName(String lastName) {
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name is required.");
        } else if (lastName.length() > 10) {
            throw new IllegalArgumentException("Last name must be 10 characters or less.");
        } else {
            this.lastName = lastName;
        }
    }

    // phone number cannot be blank and must be exactly 10 characters
    public void setNumber(String number) {
        if(number == null) {
            throw new IllegalArgumentException("Phone number is required.");
        } else if (number.length() != 10) {
            throw new IllegalArgumentException("Phone number must be 30 characters or less.");
        } else {
            this.number = number;
        }
    }

   // address cannot be blank and must be 30 characters or less
    public void setAddress(String address) {
        if(address == null) {
            throw new IllegalArgumentException("Address is required.");
        } else if (address.length() >= 30) {
            throw new IllegalArgumentException("Address must be 30 characters or less.");
        } else {
            this.address = address;
        }

    }
}
