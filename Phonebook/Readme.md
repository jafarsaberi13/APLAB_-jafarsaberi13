
Phone Book Mini Project

This is a simple phone book application written in Java that allows users to manage their contacts. Users can add, remove, and search for contacts within the phone book.

Features

- **Add Contact**: Add a new contact with details such as group, email, first name, last name, phone number, and address.
- **Remove Contact**: Remove an existing contact by specifying the first and last name.
- **Show Contacts**: Display all contacts or search for contacts by group or specific criteria.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed on your system.

### Installation

1. **Clone the repository** (or download the source code):

    ```sh
    git clone https://github.com/your-username/phone-book-mini-project.git
    cd phone-book-mini-project
    ```

2. **Save the following classes into separate `.java` files**:
    - `Address.java`
    - `PhoneNumber.java`
    - `Contact.java`
    - `PhoneBook.java`
    - `Parser.java`
    - `Main.java`

### Compilation

Compile all the Java files using the following command:

```sh
javac Address.java PhoneNumber.java Contact.java PhoneBook.java Parser.java Main.java
```

### Running the Program

Run the `Main` class:

```sh
java Main
```

## Usage

Once the program is running, you can interact with it using the following commands:

### Add a Contact

To add a contact, type the command and follow the prompts:

```sh
contacts -a
```

You will be prompted to enter the following details:
- Group
- Email
- First Name
- Last Name
- Country Code
- Phone Number
- Zip Code
- Country
- City

Example:

```
contacts -a
Enter group:
Friends
Enter email:
john.doe@example.com
Enter first name:
John
Enter last name:
Doe
Enter country code:
+1
Enter phone number:
1234567890
Enter zip code:
12345
Enter country:
USA
Enter city:
New York
Ok
```

### Remove a Contact

To remove a contact, use the following command:

```sh
contacts -r <FirstName> <LastName>
```

Example:

```sh
contacts -r John Doe
Ok
```

### Show All Contacts

To display all contacts, use the command:

```sh
show
```

### Find Contacts by Group

To find contacts by group, use the command:

```sh
show -g <GroupName>
```

Example:

```sh
show -g Friends
```

### Find Contacts by Specific Criteria

To find contacts by a specific criterion, use the command:

```sh
show -c <Criterion>
```

Example:

```sh
show -c John
```

### Exit the Program

To exit the program, use the command:

```sh
exit
```
Feel free to modify the README as per your requirements and add any additional sections if necessary.
