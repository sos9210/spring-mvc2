package hello.exception.api;

import hello.exception.exception.UserException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ApiExceptionV3Controller {

    //@ExceptionHandler은 위치한 컨트롤러의 메서드에만 적용된다.
    //@ExceptionHandler을 사용해서 예외처리를 하면 기본적으로 200OK로 반환한다.
    //@ExceptionHandler는 기본적으로 가장 디테일한 Exception을 우선 처리한다.
    //@ResponseStatus에서 반환코드를 설정할 수 있다.
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(IllegalArgumentException.class)
//    public ErrorResult illegalExHandler(IllegalArgumentException e) {
//        log.error("[exceptionHandler] ex",e);
//
//        return new ErrorResult("BAD",e.getMessage());
//    }
//
//    //@ExceptionHandler에 예외를 지정하지않으면 파라미터의 예외로 지정된다.
//    @ExceptionHandler
//    public ResponseEntity<ErrorResult> userExHandler(UserException e) {
//        log.error("[exceptionHandler] ex",e);
//        ErrorResult errorResult = new ErrorResult("USER-EX", e.getMessage());
//        return new ResponseEntity<>(errorResult,HttpStatus.BAD_REQUEST);
//
//    }
//
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler
//    public ErrorResult exHandler(Exception e) {
//        log.error("[exceptionHandler] ex",e);
//        return new ErrorResult("EX","내부 오류");
//    }

    @GetMapping("/api2/members/{id}")
    public MemberDto getMember(@PathVariable("id") String id) {
        if(id.equals("ex")) {
            throw new RuntimeException("잘못된 사용자");
        }
        if(id.equals("bad")) {
            throw new IllegalArgumentException("잘못된 입력값");
        }
        if(id.equals("user-ex")) {
            throw new UserException("사용자 오류");
        }

        return new MemberDto(id,"hello " + id);
    }
    @Data
    @AllArgsConstructor
    static class MemberDto {
        private String memberId;
        private String name;
    }

}
