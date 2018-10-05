package healthCenter.Dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;

/**
 * @author ania
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewOfficeDto {

    @NotEmpty(message = "Number must not be empty")
    private String number;
    @NotEmpty(message = "Office's name must not be empty")
    private String name;
}
