package healthCenter.entity;

import lombok.*;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;

/**
 * @author ania
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {

    @NotEmpty(message = "Country must not be empty")
    private String country;
    @NotEmpty(message = "City must not be empty")
    private String city;
    @NotEmpty(message = "Street must not be empty")
    private String street;
}
