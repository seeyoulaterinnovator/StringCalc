import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        var expression = new Scanner(System.in).nextLine();
        char sign;
        String[] entexp;
        if (expression.contains(" + ")) {
            entexp = expression.split(" \\+ ");
            sign = '+';
        } else if (expression.contains(" - ")) {
            entexp = expression.split(" - ");
            sign = '-';
        } else if (expression.contains(" * ")) {
            entexp = expression.split(" \\* ");
            sign = '*';
        } else if (expression.contains(" / ")) {
            entexp = expression.split(" / ");
            sign = '/';
        } else {
            throw new Exception("Некорректный знак действия");
        }
        if (sign == '*' || sign == '/') {
            if (entexp[1].contains("\"")) throw new Exception("Строчку можно делить или умножать только на число");
        }
        for (int i = 0; i < entexp.length; i++) {
            entexp[i] = entexp[i].replace("\"", "");
        }

        if (sign == '+') {
            System.out.println("\"" + entexp[0] + entexp[1] + "\"");

        } else if (sign == '-') {
            int index = entexp[0].indexOf(entexp[1]);
            if (index == -1) {
                System.out.println("\"" + entexp[0] + "\"");

            } else {
                String result = entexp[0].substring(0, index);
                result += entexp[0].substring(index + entexp[1].length());
                System.out.println("\"" + result + "\"");

            }
        } else if (sign == '*') {
            int multiplier = Integer.parseInt(entexp[1]);
            String result = "";
            for (int i = 0; i < multiplier; i++) {
                result += entexp[0];
            }
            System.out.println("\"" + result + "\"");

        } else {
            int newLeng = entexp[0].length() / Integer.parseInt(entexp[1]);
            String result = entexp[0].substring(0, newLeng);
            System.out.println("\"" + result + "\"");
        }

    }

}
