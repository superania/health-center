package healthCenter.Dto;

import lombok.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @author ania
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDtoForNewAccount  extends DoctorDto {

    @NotEmpty(message = "Login must not be empty")
    private String login;
    @NotEmpty(message = "Password must not be empty")
    @Size(min = 4,message = "Password must consists minimum 4 character")
    private String password;

}
