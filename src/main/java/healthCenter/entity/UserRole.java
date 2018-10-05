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
public class UserRole {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String role;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole = (UserRole) o;
        return Objects.equals(role, userRole.role);
    }

    @Override
    public int hashCode() {

        return Objects.hash(role);
    }
}
