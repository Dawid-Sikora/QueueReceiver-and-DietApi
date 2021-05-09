package pl.sikora.dietApi.exception.dietCalories;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DietCaloriesNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(DietCaloriesNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String DietCaloriesNotFoundHandler(DietCaloriesNotFoundException ex){
        return ex.getMessage();
    }
}
