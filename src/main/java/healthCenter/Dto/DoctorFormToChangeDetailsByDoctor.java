package healthCenter.Dto;

import healthCenter.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author ania
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorFormToChangeDetailsByDoctor {

    @NotEmpty(message = "Name must not be empty")
    private String name;
    @NotEmpty(message = "Surname must not be empty")
    private String surname;
    @Valid
    private Address address;

    private List<String> specializations;

}
