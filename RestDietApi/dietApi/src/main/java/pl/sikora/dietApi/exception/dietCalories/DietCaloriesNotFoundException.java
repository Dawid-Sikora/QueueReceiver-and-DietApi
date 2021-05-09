package pl.sikora.dietApi.exception.dietCalories;

public class DietCaloriesNotFoundException extends RuntimeException{

    public DietCaloriesNotFoundException(Integer id) {
        super("DietCalories with id:"+id+ " not found");
    }
}
