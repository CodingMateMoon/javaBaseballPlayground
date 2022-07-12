package study;

public class Baseball {

    int checkStrike(String answer, String input) {
        int count = 0;
        for (int i = 0; i < answer.length(); i++) {
            count += checkSameChar(answer.charAt(i), input.charAt(i));
        }

        return count;
    }
    // answer : 713, input : 123 -> 1볼
    int checkBall(String answer, String input) {
        int count = 0;

        for (int i = 0; i < answer.length(); i++) {
            char answerChar = answer.charAt(i);

            count += checkContainSameChar(input, answerChar, i);
        }
        return count;
    }

    int checkSameChar(char a, char b) {
        if(a == b)
            return 1;
        return 0;
    }

    int checkContainSameChar(String input, char answerChar, int index) {
        int count = 0;
        char[] charInput = input.toCharArray();
        for (int i = 0; i < charInput.length; i++) {
            if(i == index)
                continue;
            count += checkSameChar(charInput[i], answerChar);
        }
        return count;
    }

}
