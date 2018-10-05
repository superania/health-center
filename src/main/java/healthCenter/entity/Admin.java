package healthCenter.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author ania
 */
@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends User {

}
