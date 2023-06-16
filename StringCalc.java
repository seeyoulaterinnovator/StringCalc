import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String exp = scn.nextLine();
        char action;
        String[] data;
        if (exp.contains(" + ")) {
            data = exp.split(" \\+ ");
            action = '+';
        } else if (exp.contains(" - ")) {
            data = exp.split(" - ");
            action = '-';
        } else if (exp.contains(" * ")) {
            data = exp.split(" \\* ");
            action = '*';
        } else if (exp.contains(" / ")) {
            data = exp.split(" / ");
            action = '/';
        } else {
            throw new Exception("Некорректный знак действия");
        }
        if (action == '*' || action == '/') {
            if (data[1].contains("\"")) throw new Exception("Строчку можно делить или умножать только на число");
        }
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].replace("\"", "");
            if (data[i].length() > 10) {
                throw new IllegalArgumentException("Калькулятор может принимать строки длиной от 1 до 10 символов");
            }
        }

        if (action == '+') {
            printInQuotes(data[0] + data[1]);
        } else if (action == '*') {
            if (!data[1].matches("[1-9]|10")) {
                throw new IllegalArgumentException("числа дожны быть от 1 до 10");
            }
            int multiplier = Integer.parseInt(data[1]);
            String result = "";
            for (int i = 0; i < multiplier; i++) {
                result += data[0];
            }
            printInQuotes(result);
        } else if (action == '-') {
            int index = data[0].indexOf(data[1]);
            if (index == -1) {
                printInQuotes(data[0]);
            } else {
                String result = data[0].substring(0, index);
                result += data[0].substring(index + data[1].length());
                printInQuotes(result);
            }
        } else {
            if (!data[1].matches("[1-9]|10")) {
                throw new IllegalArgumentException("числа дожны быть от 1 до 10");
            }
            int newLen = data[0].length() / Integer.parseInt(data[1]);
            String result = data[0].substring(0, newLen);
            printInQuotes(result);
        }

    }

    static void printInQuotes(String text) throws Exception {
        if (text.length() > 40) {
            System.out.println("\"" + text.substring(0, 40) + "..." + "\"");
        } else {
            System.out.println("\"" + text + "\"");
        }
    }
}
