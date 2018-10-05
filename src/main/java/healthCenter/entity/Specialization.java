package healthCenter.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * @author ania
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Specialization implements Comparable<Specialization> {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false,unique = true)
    private String name;

    @ManyToMany
    @JoinTable(name = "doctor_specialization",
            joinColumns = {@JoinColumn(name = "specialization")},
            inverseJoinColumns = {@JoinColumn(name = "doctor")})
    private List<Doctor> doctors;


    @Override
    public int compareTo(Specialization o) {
        return this.name.compareTo(o.name);
    }
}
































