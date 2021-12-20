import java.io.*;
import java.util.*;

public class Main {

public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder result = new StringBuilder("");
        char c;

        for (int i = 0; i < input.length(); i++) {
            c = input.charAt(i);
            if (c >= 65 && c <= 90)
                result.append(Character.toLowerCase(c));
            else if (c >= 97 && c <= 122)
                result.append(Character.toUpperCase(c));

        }
        System.out.println(result.toString());
        scanner.close();
    }

}