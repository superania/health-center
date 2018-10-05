package healthCenter.Dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

/**
 * @author ania
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto  {


    private Long id;
    @NotEmpty(message = "Name must not be empty")
    private String name;
    @NotEmpty(message = "Surname must not be empty")
    private String surname;
    @Size(max = 11, min = 11,message = "Id number must consists of 11 digits")
    private String idNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Date must be mot empty")
    @Past(message = "Date must be past")
    private LocalDate dateOfBirth;
    @NotEmpty(message = "Country must not be empty")
    private String country;
    @NotEmpty(message = "City must not be empty")
    private String city;
    @NotEmpty(message = "Street must not be empty")
    private String street;

    private List<String> specializations;

}
