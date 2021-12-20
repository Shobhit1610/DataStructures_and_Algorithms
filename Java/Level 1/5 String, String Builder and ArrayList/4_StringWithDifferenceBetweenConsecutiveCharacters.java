import java.io.*;
import java.util.*;

public class Main {

public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        int difference = 0;
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < input.length() - 1; i++) {
            difference = (input.charAt(i + 1) - input.charAt(i));
            result.append(input.charAt(i));
            result.append(difference);

        }
        result.append(input.charAt(input.length() - 1));
        System.out.println(result.toString());
    }

}