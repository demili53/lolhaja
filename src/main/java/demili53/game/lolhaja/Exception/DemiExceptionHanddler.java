package demili53.game.lolhaja.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestClientException;

import javax.servlet.http.HttpServletRequest;

/**
 * Error 핸들러
 */
@ControllerAdvice
public class DemiExceptionHanddler{

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RestClientException.class)
    @ResponseBody
    public ExceptionResult handleBadRequest(HttpServletRequest req, Exception ex) {
        return new ExceptionResult(req.getRequestURL().toString(), ex);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public String illegalArgumentException(HttpServletRequest req, Exception ex) {
        return "error/error500";
    }

}
