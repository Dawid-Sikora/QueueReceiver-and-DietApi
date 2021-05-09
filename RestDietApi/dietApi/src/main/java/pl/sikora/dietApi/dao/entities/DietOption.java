package pl.sikora.dietApi.dao.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class DietOption {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer dietOptionId;
    private String name;
    private String abbreviation;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonBackReference
    private Diet diet;

    @OneToMany(mappedBy = "dietOption", fetch = FetchType.EAGER)
    @Column(nullable = true)
    @JsonManagedReference
    @EqualsAndHashCode.Exclude
    private Set<DietCalories> dietCalories;


}
