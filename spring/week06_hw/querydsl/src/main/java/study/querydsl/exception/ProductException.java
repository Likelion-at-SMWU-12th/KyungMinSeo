package study.querydsl.exception;

public class ProductException extends RuntimeException {

    private final HttpStatus httpStatus;

    // HTTP 상태 코드와 사용자 정의 메시지를 받는 생성자
    // RuntimeException 부모 클래스를 통해 메시지를 받고, httpStatus를 지정해 생성해준다.
    public ProductException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }

    // 원인까지 포함된 생성자
    public ProductException(HttpStatus httpStatus, String message, Throwable cause) {
        super(message, cause);
        this.httpStatus = httpStatus;
    }

    // Getter : Http 상태 코드 얻기
    public HttpStatus getHttpStatus() { return httpStatus; }

    // HTTP 상태 코드와 메시지를 포함한 문자열 반환
    @Override
    public String toString() {
        return "ProductException {" +
                "httpStatus=" + httpStatus.getCode() + " " + httpStatus.getMessage() +
                ", message='" + getMessage() + '\'' +
                '}';
    }

}
