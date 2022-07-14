package practice;

public class BaseballPractice {

    public int checkStrike(String answer, String input) {
        int count = 0;
        for (int i = 0; i < answer.length(); i++) {
            count += checkSameChar(answer.charAt(i), input.charAt(i));
        }

        return count;
    }
    // answer : 713, input : 123 -> 1볼
    public int checkBall(String answer, String input) {
        int count = 0;

        for (int i = 0; i < answer.length(); i++) {
            char answerChar = answer.charAt(i);

            count += checkContainSameChar(input, answerChar, i);
        }
        return count;
    }

    public int checkSameChar(char a, char b) {
        if(a == b)
            return 1;
        return 0;
    }

    public int checkContainSameChar(String input, char answerChar, int index) {
        int count = 0;
        char[] charInput = input.toCharArray();
        for (int i = 0; i < charInput.length; i++) {
            if(i == index)
                continue;
            count += checkSameChar(charInput[i], answerChar);
        }
        return count;
    }

    public String playGame(String answer, String input) {

        int strikeCount = 0;
        int ballCount = 0;
        strikeCount = checkStrike(answer, input);
        ballCount = checkBall(answer, input);

        if (strikeCount == 0 && ballCount == 0) {
            return "낫싱";
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (ballCount > 0) {
            stringBuilder.append(ballCount + "볼 ");
        }
        if (strikeCount > 0) {
            stringBuilder.append(strikeCount + "스트라이크");
        }
        return stringBuilder.toString();
    }

}
