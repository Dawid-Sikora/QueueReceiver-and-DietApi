package pl.sikora.dietApi.dao.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class DietCalories {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer dietCaloriesId;
    private Integer calories;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonBackReference
    private DietOption dietOption;

}
