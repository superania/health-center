package healthCenter.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

/**
 * @author ania
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ByNameAndSurnameForm {

    @NotEmpty(message = "Name must be not empty")
    private String name;
    @NotEmpty(message = "Surname must be not empty")
    private String surname;

}
