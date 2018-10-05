package healthCenter.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author ania
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Office implements Comparable<Office>{

    @Id
    @GeneratedValue
    private Long id;
    private String number;
    private String name;
    @OneToMany(mappedBy = "office")
    private List<Visit> visits;

    @Override
    public int compareTo(Office o) {
        return this.getNumber().compareTo(o.number);
    }
}




























