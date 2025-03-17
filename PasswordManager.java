import java.util.*;
import java.io.*;
import java.util.Base64;

public class PasswordManager {
    private static final String FILE_NAME = "passwords.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> passwordMap = loadPasswords();

        while (true) {
            System.out.println("\nPassword Manager");
            System.out.println("1. Add Password\n2. Retrieve Password\n3. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter website/service: ");
                String site = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                passwordMap.put(site, encrypt(password));
                savePasswords(passwordMap);
                System.out.println("Password saved!");
            } else if (choice == 2) {
                System.out.print("Enter website/service: ");
                String site = scanner.nextLine();
                if (passwordMap.containsKey(site)) {
                    System.out.println("Password: " + decrypt(passwordMap.get(site)));
                } else {
                    System.out.println("No password found!");
                }
            } else {
                break;
            }
        }
        scanner.close();
    }

    private static Map<String, String> loadPasswords() {
        Map<String, String> passwords = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                passwords.put(parts[0], parts[1]);
            }
        } catch (IOException e) {
            System.out.println("No saved passwords found.");
        }
        return passwords;
    }

    private static void savePasswords(Map<String, String> passwords) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Map.Entry<String, String> entry : passwords.entrySet()) {
                bw.write(entry.getKey() + ":" + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving passwords.");
        }
    }

    private static String encrypt(String text) {
        return Base64.getEncoder().encodeToString(text.getBytes());
    }

    private static String decrypt(String encryptedText) {
        return new String(Base64.getDecoder().decode(encryptedText));
    }
}
