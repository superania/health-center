package healthCenter.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ania
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Valid
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "user_role",
        discriminatorType = DiscriminatorType.STRING
)
@Table(name = "users")
public class User implements Comparable<User> {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true,nullable = false)
    private String login;
    private String password;
    private String name;
    private String surname;
    private String idNumber;
    @Embedded
    private Address address;
    private LocalDate dateOfBirth;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
    joinColumns = {@JoinColumn(name = "user_id")},
    inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<UserRole> roles = new HashSet<>();

    @Override
    public int compareTo(User o) {
        if (this.surname.equals(o.surname)) {
            if (this.name.equals(o.name)) {
                return this.dateOfBirth.compareTo(o.dateOfBirth);
            } else {
                return this.name.compareTo(o.name);
            }
        } else {
            return this.surname.compareTo(o.surname);
        }
    }
}
