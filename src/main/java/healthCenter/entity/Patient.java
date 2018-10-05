package healthCenter.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ania
 */
@Setter
@Getter
@Entity
@DiscriminatorValue("PATIENT")
public class Patient extends User {
    @OneToMany(mappedBy = "patient")
    private List<Visit> visits = new ArrayList<>();

}
