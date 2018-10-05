package healthCenter.controller;

import healthCenter.Dto.UserDto;
import healthCenter.entity.Patient;
import healthCenter.mapper.PatientMapper;
import healthCenter.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static org.springframework.security.web.context.HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY;

/**
 * @author ania
 */

@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CreateNewPatientAccountController {

    private DaoAuthenticationProvider authManager;
    private PasswordEncoder passwordEncoder;
    private PatientService patientService;

    @GetMapping(value = "register")
    public String createNewPatientAccount(Model model) {
        model.addAttribute("patient",new UserDto());
        return "registrationForm";
    }

    @PostMapping(value = "/register")
    public String createNewPatientAccount(@Valid @ModelAttribute("patient") UserDto patientDto,
                                          BindingResult bindingResult,
                                          HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "registrationForm";
        } else {
            Patient patient =  PatientMapper.userDtoToEntityPatient(patientDto);
            String password = patient.getPassword();
            patient.setPassword(passwordEncoder.encode(patientDto.getPassword()));
            patientService.savePatient(patient);

            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(patient.getLogin(), password);
            Authentication authentication = authManager.authenticate(authenticationToken);
            SecurityContext securityContext = SecurityContextHolder.getContext();
            securityContext.setAuthentication(authentication);
            HttpSession session = request.getSession(true);
            session.setAttribute(SPRING_SECURITY_CONTEXT_KEY, securityContext);
        }

        return "registerSuccessful";
    }
}
