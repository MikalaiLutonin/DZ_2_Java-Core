
// Написать метод «Шифр Цезаря», с булевым параметром зашифрования и расшифро- вания и числовым ключом;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите сообщение: ");
        String message = scanner.nextLine();

        System.out.print("Введите ключ: ");
        int key = scanner.nextInt();

        System.out.print("Зашифровать или расшифровать? (1 - зашифровать, 2 - расшифровать): ");
        int choice = scanner.nextInt();

        boolean encrypt = false;
        if (choice == 1) {
            encrypt = true;
        }

        String result = caesarCipher(message, key, encrypt);
        System.out.println("Результат: " + result);
    }

    public static String caesarCipher(String message, int key, boolean encrypt) {
        StringBuilder result = new StringBuilder();

        if (!encrypt) {
            key = -key;
        }

        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);

            if (Character.isLetter(ch)) {
                char shifted = (char) (ch + key);

                if (Character.isUpperCase(ch) && shifted > 'Z') {
                    shifted = (char) (shifted - 26);
                } else if (Character.isLowerCase(ch) && shifted > 'z') {
                    shifted = (char) (shifted - 26);
                } else if (shifted < 'A' && Character.isUpperCase(ch)) {
                    shifted = (char) (shifted + 26);
                } else if (shifted < 'a' && Character.isLowerCase(ch)) {
                    shifted = (char) (shifted + 26);
                }

                result.append(shifted);
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }
}

