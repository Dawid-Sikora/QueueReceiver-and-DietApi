package pl.sikora.dietApi.exception.dietOptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DietOptionNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(DietOptionNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String dietOptrionNotFoundHandler(DietOptionNotFoundException ex){
        return ex.getMessage();
    }

}
