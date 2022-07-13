package study;

import java.util.Scanner;

public class BaseballExecution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        Baseball baseball = new Baseball();
        boolean flag = true;
        while (flag) {
            if("X".equals(input))
                break;
            String answer = "";
            for (int i = 0; i < 3; i++) {
                answer += (int) (Math.random() * 10);
            }
            System.out.print("숫자를 입력해주세요 : ");
            input = scanner.nextLine();



        }

    }
}
