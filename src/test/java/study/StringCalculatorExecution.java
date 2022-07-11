package study;

import java.io.InputStreamReader;
import java.util.Scanner;

public class StringCalculatorExecution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StringCalculator stringCalculator = new StringCalculator();
        String value = scanner.nextLine();
        String[] values = value.split(" ");

        for (String element:
             values) {
            System.out.println(element);
        }

        int result = 0;
        char calculationType = 0;
        for (int i = 0; i < values.length; i++) {
            if (i == 0) {
                result = Integer.parseInt(values[i]);
                continue;
            }
            if(i == 1) {
                calculationType = values[i].charAt(0);
            }

            if (i % 2 == 0) {
                int element = Integer.parseInt(values[i]);
                switch (calculationType) {

                    case '+':
                        result = stringCalculator.plus(result, element);
                        break;
                    case '-':
                        result = stringCalculator.minus(result, element);
                        break;
                    case '*':
                        result = stringCalculator.multiple(result, element);
                        break;
                    case '/':
                        result = stringCalculator.divide(result, element);
                        break;

                }
            }

            if(i % 2 == 1)
                calculationType = values[i].charAt(0);

        }
        System.out.println(result);
    }
}
