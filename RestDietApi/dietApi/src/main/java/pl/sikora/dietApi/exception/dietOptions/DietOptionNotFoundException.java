package pl.sikora.dietApi.exception.dietOptions;

public class DietOptionNotFoundException extends RuntimeException {

    public DietOptionNotFoundException(Integer id) {
        super("DietOption with id:"+id+ " not found");
    }
}
