package healthCenter.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author ania
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Visit {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    @Column(nullable = false)
    private LocalDate date;
    @NotNull
    @Column(nullable = false)
    private LocalTime timeFrom;
    @NotNull
    @Column(nullable = false)
    private LocalTime timeTo;
    private String doctorAnnotation;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    @ManyToOne
    @JoinColumn(name = "office_id")
    private Office office;


}





































