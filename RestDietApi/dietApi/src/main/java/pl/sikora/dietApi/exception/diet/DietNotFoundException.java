package pl.sikora.dietApi.exception.diet;

public class DietNotFoundException extends RuntimeException {

    public DietNotFoundException(Integer id) {
        super("Diet with id:"+id+ " not found");
    }
}
