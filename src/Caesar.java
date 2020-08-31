import java.util.Scanner;
import java.util.Random;

public class Caesar {
    public static void main(String[] args) {

        Random fortuna = new Random();
        int chiffre = fortuna.nextInt(26);

        System.out.println("The message:");
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();

        System.out.println("Message get encrypt with " + chiffre + " ...");
        String encyptStr = encrypt(input, chiffre);
        System.out.println(encyptStr);

        System.out.println("------------------------------------------------");
        System.out.println("Do you know the chiffre?(J/N)");
        input = s.nextLine();

        System.out.println("decrypt the message:");
        if (input.toLowerCase().contains("j")) {
            System.out.print("The chiffre is:");
            decryptKey(encyptStr, s.nextInt());
        } else {
            decryptBruteForce(encyptStr);
        }
    }

    public static String encrypt(String message, int chiffre) {
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String abc2 = abc + abc;
        String encryptMessage = "";
        int indexABC = 0;
        message = message.toUpperCase();

        // Verschlüsseln.
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) >= 'A' && message.charAt(i) <= 'Z') {
                indexABC = message.charAt(i) - 'A';
                encryptMessage += abc2.charAt(indexABC + chiffre);
            } else {
                encryptMessage += message.charAt(i);
            }
        }
        return encryptMessage;
    }

    public static void decryptBruteForce(String message) {
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String abc2 = abc + abc;
        int indexABC = 0;
        String decryptMessage = "";
        message = message.toUpperCase();

        for (int i = 1; i < abc.length(); i++) {
            for (int j = 0; j < message.length(); j++) {
                if (message.charAt(j) >= 'A' && message.charAt(j) <= 'Z') {
                    indexABC = message.charAt(j) - 'A';
                    decryptMessage += abc2.charAt(indexABC + i);
                } else {
                    decryptMessage += message.charAt(j);
                }
            }
            System.out.println((i) + ". " + decryptMessage);
            decryptMessage = "";
        }
    }

    public static void decryptKey(String message, int chiffre) {
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String abc2 = abc + abc;
        int helpchiffre = abc.length() - chiffre;
        int indexABC = 0;
        String decryptMessage = "";
        message = message.toUpperCase();

        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) >= 'A' && message.charAt(i) <= 'Z') {
                indexABC = message.charAt(i) - 'A';
                decryptMessage += abc2.charAt(indexABC + helpchiffre);
            } else {
                decryptMessage += message.charAt(i);
            }
        }
        System.out.println(decryptMessage);
    }
}