import java.util.Scanner;


public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = getInput(sc, "Enter first number (1-10)");
        int m = getInput(sc, "Enter second number (1-10)");

        System.out.println("Enter operation (+, -, *, /)");
        char operation = sc.next().charAt(0);

        switch (operation) {
            case '+':
                System.out.println(n + m);
                break;
            case '-':
                System.out.println(n - m);
                break;
            case '*':
                System.out.println(n * m);
                break;
            case '/':
                if (m != 0) {
                    System.out.println(n / m);
                } else {
                    System.out.println("Division by zero");
                }
                break;
            default:
                System.out.println("Invalid operation");
                break;
        }

        sc.close();
    }

    private static int getInput(Scanner sc, String prompt) {
        int number;
        while (true) {
            System.out.println(prompt);
            number = sc.nextInt();
            if (number >= 1 && number <= 10) {
                return number;
            } else {
                System.out.println("Number should be between 1 and 10");
            }
        }
    }
}

