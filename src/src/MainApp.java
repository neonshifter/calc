import java.io.IOException;
import java.util.Scanner;

class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите арифметическое выражение: ");
        String input = scanner.nextLine();
        try {
            String result = calc(input);
            System.out.println("Результат: " + result);
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    static String calc(String input) throws IOException {
        String[] tokens = input.split(" ");
        if (tokens.length != 3) {
            throw new IOException("т.к. строка не является математической операцией");
        }

        int a, b;
        try {
            a = Integer.parseInt(tokens[0]);
            b = Integer.parseInt(tokens[2]);
            if (a<1 || a>10 || b<1 || b>10) {
                throw new IOException("Калькулятор должен принимать на вход числа от 1 до 10 включительно");
            }

        } catch (NumberFormatException e) {
            throw new IOException("Неверный формат чисел");
        }

        int result;
        switch (tokens[1]) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                if (b == 0) {
                    throw new IOException("Деление на ноль");
                }
                result = a / b;
                break;
            default:
                throw new IOException("Неверная операция");
        }

        return String.valueOf(result);
    }
}