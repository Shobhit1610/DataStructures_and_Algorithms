import java.util.Scanner;

public class GradingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int marks = scanner.nextInt();
        scanner.close();

        if (marks > 90)
            System.out.println("excellent");
        else if (marks > 80)
            System.out.println("good");
        else if (marks > 70)
            System.out.println("fair");
        else if (marks > 60)
            System.out.println("meets expectations");
        else
            System.out.println("below par");
    }
}
