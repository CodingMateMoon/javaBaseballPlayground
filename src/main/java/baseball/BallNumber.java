package baseball;


public class BallNumber {

    public static final int MIN_NO = 1;
    public static final int MAX_NO = 9;

    private  int no;

    /*
    객체지향 생활체조 원칙 - 원시값을 객체로 포장하면 생성자에서 예외 처리 가능. 생성시 1~9라는 값 보장.
    */
    public BallNumber(int no) {
        if (MIN_NO <= no && no <= MAX_NO) {
            throw new IllegalArgumentException("볼 숫자는 1부터 9의 값이어야 합니다.");
        }
        this.no = no;
    }
}
