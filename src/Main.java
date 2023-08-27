import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) throws IOException  {
        System.out.println("Для вычисления введите исходные данные в следующем формате: \"a_c_b\", где \"a\" и \"b\" - целые числа от 1 до 10 включительно, \"с\" - знак операции сложения, вычитания, умножения или деления, \"_\" - пробел.)");
        Scanner scan = new Scanner(System.in);
        String input_data = scan.nextLine();
        String regex1 = "\\d?\\d\\s\\W\\s\\d\\d?";
        Pattern pattern1 = Pattern.compile(regex1);
        Matcher matcher1 = pattern1.matcher(input_data);
        boolean b1 = matcher1.matches();
        if (!b1) {
            throw new IOException("Некорректно введено выражение или использованы не целые числа.");
        } else {
            String[] data = input_data.split(" ");
            String operation = data[1];
            String[] numbers = input_data.split("\\D+");

            int[] numArr = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                numArr[i] = Integer.parseInt(numbers[i]);
            }
                int a;
                a = numArr[0];
                int b;
                b = numArr[1];
                if (a < 1 || a > 10 || b < 1 || b > 10) {
                    throw new IOException("Могут исользоваться только целые числа от 1 до 10 включительно");
                } else {
                    char op;
                    op = operation.charAt(0);
                    switch (op) {
                        case '+':
                            System.out.println("Результат = " + (a + b));
                            break;
                        case '-':
                            System.out.println("Результат = " + (a - b));
                            break;
                        case '*':
                            System.out.println("Результат = " + (a * b));
                            break;
                        case '/':
                            System.out.println("Результат = " + (a / b));
                            break;
                        default:
                            throw new IOException("Некорректно указана операция.");

                    }
                }
        }



    }
}