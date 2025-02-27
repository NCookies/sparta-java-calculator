package exception;

// NumberFormatException과 동일하게 (같은 계층) IllegalArgumentException를 상속받는 커스텀 exception
public class InvalidOperatorException extends IllegalArgumentException {
    public InvalidOperatorException(String msg) {
        super(msg);
    }
}
