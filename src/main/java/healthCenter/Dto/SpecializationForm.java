package healthCenter.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

/**
 * @author ania
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Valid
public class SpecializationForm {

    private Long id;
    @NotEmpty(message = "Specialization must be not empty")
    private String name;

}
