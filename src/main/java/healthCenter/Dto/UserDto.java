package healthCenter.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * @author ania
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Valid
public class UserDto {
    @NotEmpty(message = "Login must be not empty")
    private String login;
    @NotEmpty(message = "Password must be not empty")
    private String password;
    @NotEmpty(message = "Name must be not empty")
    private String name;
    @NotEmpty(message = "Surname must be not empty")
    private String surname;
    @Size(min = 11,max = 11,message = "Id number must consists of 11 digits")
    private String idNumber;
    @NotNull(message = "Date must be not null")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    @NotEmpty(message = "Country must be not empty")
    private String country;
    @NotEmpty(message = "City must be not empty")
    private String city;
    @NotEmpty(message = "Street must be not empty")
    private String street;

}
