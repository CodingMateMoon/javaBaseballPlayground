package baseball;

public class ValidationUtils {

    public static final int MIN_NO = 1;
    public static final int MAX_NO = 9;

    public static boolean validNo(int no) {
        return MIN_NO <= no && no <= MAX_NO;
    }
}
