package healthCenter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * @author ania
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("DOCTOR")
public class Doctor extends User{

    @Column(nullable = false)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "doctor_specialization",
            joinColumns = {@JoinColumn(name = "doctor")},
            inverseJoinColumns = {@JoinColumn(name = "specialization")})
    private List<Specialization> specializations;
    @OneToMany(mappedBy = "doctor")
    private List<Visit> medicalAdvices;
    @OneToMany(mappedBy = "doctor")
    private List<Schedule> schedules;



}
