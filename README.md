Password Manager

 Overview
This Java-based Password Manager securely stores and retrieves passwords for different websites or services using Base64 encryption. Passwords are saved in a text file for persistence.

Features
- Add Passwords: Encrypts and stores passwords securely.
- Retrieve Passwords: Decrypts and displays stored passwords.
- File-based Storage: Saves data in `passwords.txt` for future access.

Technologies Used
- Java
- File I/O (BufferedReader, BufferedWriter)
- Base64 Encoding/Decoding
- HashMap for storing passwords in memory

How to Run
1. Ensure you have Java installed.
2. Compile the Java file:
 javac PasswordManager.java
  
3. Run the program:

   java PasswordManager

4. Follow the menu options to add or retrieve passwords.

Example Usage

Password Manager
1. Add Password
2. Retrieve Password
3. Exit
Enter choice: 1
Enter website/service: Gmail
Enter password: mySecurePass
Password saved!

Enter choice: 2
Enter website/service: Gmail
Password: mySecurePass

 License
This project is open-source and free to use.

