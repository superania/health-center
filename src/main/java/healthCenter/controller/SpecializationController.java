package healthCenter.controller;

import healthCenter.Dto.SpecializationForm;
import healthCenter.entity.Specialization;
import healthCenter.mapper.SpecializationMapper;
import healthCenter.service.SpecializationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ania
 */
@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SpecializationController {

    private SpecializationService specializationService;

    @GetMapping(value = "/addSpecialization")
    public String addSpecialization(Model model) {
        model.addAttribute("specialization",new SpecializationForm());
        return "addSpecialization";
    }

    @PostMapping(value = "/addSpecialization")
    public String addSpecialization(@Valid @ModelAttribute("specialization") SpecializationForm specializationForm,
                                    BindingResult bindingResult,
                                    Model model) {
        if (bindingResult.hasErrors()) {
            return "addSpecialization";
        }

        if (!specializationService.checkIfExistsReturnBoolean(specializationForm.getName())) {
        specializationService.saveSpecialization(SpecializationMapper.toEntity(specializationForm));
        }

        model.addAttribute("specializations",specializationService.findAll());
        return "specializations";
    }

    @GetMapping(value = "/findSpecialization")
    public String findSpecialization(Model model) {
        model.addAttribute("specialization",new SpecializationForm());
        return "findSpecialization";
    }

    @PostMapping(value = "/findSpecialization")
    public String findSpecialization(@Valid @ModelAttribute("specialization") SpecializationForm specializationForm,
                                     BindingResult bindingResult,
                                     Model model) {
        if (bindingResult.hasErrors()) {
            return "findSpecialization";
        }
        String message = specializationService.checkIfExistsReturnString(specializationForm.getName().toUpperCase());
        model.addAttribute("message",message);
        List<Specialization> collect = specializationService.findAll().stream().sorted().collect(Collectors.toList());
        model.addAttribute("specializations",collect);
        return "findSpecializationResult";
    }
}
