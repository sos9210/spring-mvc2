package hello.exception.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//BadRequestException이 발생하면 @ResponseStatus에 있는 정보로 오류를 응답한다
//@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "잘못된 요청 오류")
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "error.bad")//messages.properties에서 가져올 수 있음
public class BadRequestException extends RuntimeException{
}
