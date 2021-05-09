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
public class Diet {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer dietId;
    private String name;
    private String description;

    @OneToMany(mappedBy = "diet", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @Column(nullable = true)
    @JsonManagedReference
    @EqualsAndHashCode.Exclude
    private Set<DietOption> dietOptions;

}
