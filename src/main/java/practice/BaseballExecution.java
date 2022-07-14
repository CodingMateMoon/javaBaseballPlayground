package practice;

import java.util.Scanner;

public class BaseballExecution {
    public static void main(String[] args) {

        String input = "";

        boolean flag = true;
        while (flag) {
            if("X".equals(input))
                break;
            String answer = "";
            for (int i = 0; i < 3; i++) {
                answer += (int) (Math.random() * 10);
            }

            int continueGame = startGame(answer);
            if(continueGame == 2) {
                System.out.println("게임 종료!");
                break;
            }
        }
    }

    public static int startGame(String answer) {
        String input = "";
        BaseballPractice baseballPractice = new BaseballPractice();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("숫자를 입력해주세요 : ");
            input = scanner.nextLine();
            String result = baseballPractice.playGame(answer,input);
            System.out.println(result + " : " + answer);
            if ("3스트라이크".equals(result)) {
                System.out.println(result);
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                while(true) {
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    int continueResult = scanner.nextInt();
                    if (continueResult == 1)
                        return 1;
                    else if (continueResult == 2)
                        return 2;
                }
            }
        }
    }
}
