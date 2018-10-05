package healthCenter.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;

/**
 * @author ania
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FindByIdNumberForm {

    @Size(min = 11,max=11,message = "Id number must consists of 11 digits")
    private String idNumber;

}
