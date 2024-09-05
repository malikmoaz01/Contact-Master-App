**ContactMaster**

A simple Android application for managing contacts. Users can add, update, and delete contacts, and view a list of all saved contacts. The app uses SQLite for data storage and RecyclerView for displaying contacts in a list.

**Features:**
- **Add Contact:** Users can add new contacts with a name and phone number.
- **Update Contact:** Users can update the details of existing contacts.
- **Delete Contact:** Users can delete contacts from the list.
- **View Contacts:** All contacts are displayed in a scrollable list using RecyclerView.
- **Live Data Refresh:** The contact list updates automatically when changes are made.

**Technologies Used:**
- **Android SDK:** For building the Android app.
- **SQLite:** For local database storage.
- **RecyclerView:** For displaying contacts in a list format.
- **Kotlin:** The programming language used for developing the app.

**Installation:**
1. Clone the repository:
   ```bash
   git clone https://github.com/malikmoaz01/Contact-Master-App
   ```
2. Open the project in Android Studio.
3. Build and run the project on an emulator or physical device.

**Usage:**
- **Add a Contact:** Go to the add contact screen, enter the contact's name and phone number, and save.
- **Update a Contact:** Select a contact from the list, update the details, and save.
- **Delete a Contact:** Select a contact from the list and delete it.
- **View Contacts:** All contacts are displayed in a list that updates automatically.

**Code Structure:**
- **DBHelper.kt:** Manages database operations such as adding, updating, deleting, and fetching contacts.
- **MainActivity.kt:** Displays the list of contacts using RecyclerView and provides options to add a new contact.
- **AddContactActivity.kt:** Provides the UI for adding new contacts.
- **UpdateContactActivity.kt:** Provides the UI for updating existing contacts.
- **ContactAdapter.kt:** Adapter for binding contact data to the RecyclerView.
- **XML Layouts:** Define the user interface for various activities (`activity_main.xml`, `activity_add_contact.xml`, `activity_update_contact.xml`).

**Contributing:**
Feel free to fork the repository and submit pull requests for improvements or bug fixes. Ensure to follow the project's coding conventions and provide appropriate documentation for changes.
