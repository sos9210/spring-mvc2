package hello.exception.exhandler.advice;

import hello.exception.exception.UserException;
import hello.exception.exhandler.ErrorResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
//@ControllerAdvice(annotations = RestController.class
//@ControllerAdvice("org.example.controllers")
//@ControllerAdvice(assignableTypes = {ControllerInterface.class,AbstractController.class})
@RestControllerAdvice("hello.exception.api") //적용되는 범위를 설정가능하다.(지정을 생략하면 모든 컨트롤러에 적용된다)
public class ExControllerAdvice {

    //@ExceptionHandler은 위치한 컨트롤러의 메서드에만 적용된다.
    //@ExceptionHandler을 사용해서 예외처리를 하면 기본적으로 200OK로 반환한다.
    //@ExceptionHandler는 기본적으로 가장 디테일한 Exception을 우선 처리한다.
    //@ResponseStatus에서 반환코드를 설정할 수 있다.
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorResult illegalExHandler(IllegalArgumentException e) {
        log.error("[exceptionHandler] ex",e);

        return new ErrorResult("BAD",e.getMessage());
    }

    //@ExceptionHandler에 예외를 지정하지않으면 파라미터의 예외로 지정된다.
    @ExceptionHandler
    public ResponseEntity<ErrorResult> userExHandler(UserException e) {
        log.error("[exceptionHandler] ex",e);
        ErrorResult errorResult = new ErrorResult("USER-EX", e.getMessage());
        return new ResponseEntity<>(errorResult,HttpStatus.BAD_REQUEST);

    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler
    public ErrorResult exHandler(Exception e) {
        log.error("[exceptionHandler] ex",e);
        return new ErrorResult("EX","내부 오류");
    }
}
