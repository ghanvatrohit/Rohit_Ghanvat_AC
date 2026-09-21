package Assignment_4;

import java.io.*;
import java.util.Scanner;

public class EncryptionDecryption {

    // Encryption key
    static final int KEY = 5;

    // Method to encrypt the file
    public static void encryptFile(String inputFile, String outputFile) {

        try {
            FileReader fr = new FileReader(inputFile);
            FileWriter fw = new FileWriter(outputFile);

            int ch;

            while ((ch = fr.read()) != -1) {

                // Shift each character by KEY
                char encryptedChar = (char) (ch + KEY);

                fw.write(encryptedChar);
            }

            fr.close();
            fw.close();

            System.out.println("File encrypted successfully.");
            System.out.println("Encrypted file: " + outputFile);

        } catch (IOException e) {
            System.out.println("Error while encrypting file.");
            System.out.println(e.getMessage());
        }
    }

    // Method to decrypt the file
    public static void decryptFile(String inputFile, String outputFile) {

        try {
            FileReader fr = new FileReader(inputFile);
            FileWriter fw = new FileWriter(outputFile);

            int ch;

            while ((ch = fr.read()) != -1) {

                // Reverse the encryption
                char decryptedChar = (char) (ch - KEY);

                fw.write(decryptedChar);
            }

            fr.close();
            fw.close();

            System.out.println("File decrypted successfully.");
            System.out.println("Decrypted file: " + outputFile);

        } catch (IOException e) {
            System.out.println("Error while decrypting file.");
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== FILE ENCRYPTION / DECRYPTION =====");
            System.out.println("1. Encrypt File");
            System.out.println("2. Decrypt File");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter input file name: ");
                    String inputFile = sc.next();

                    System.out.print("Enter encrypted file name: ");
                    String encryptedFile = sc.next();

                    encryptFile(inputFile, encryptedFile);
                    break;

                case 2:
                    System.out.print("Enter encrypted file name: ");
                    String encryptedInput = sc.next();

                    System.out.print("Enter decrypted file name: ");
                    String decryptedFile = sc.next();

                    decryptFile(encryptedInput, decryptedFile);
                    break;

                case 3:
                    System.out.println("Program terminated.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}


