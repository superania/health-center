package healthCenter.controller;

import healthCenter.Dto.UserDto;
import healthCenter.entity.Admin;
import healthCenter.service.AdminService;
import healthCenter.service.SpecializationService;
import healthCenter.service.UserUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * @author ania
 */

@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AdminController {

    private AdminService adminService;
    private SpecializationService specializationService;

    @GetMapping(value = "/showAdminDetails")
    public String showAdminDetails(Model model) {
        model.addAttribute("admin",adminService.findByLogin(UserUtil.findLoggedUser()));
        return "adminDetails";


    }

    @GetMapping(value = "/changeAdminDetails")
    public String changeAdminDetails(Model model) {
        model.addAttribute("adminDto",new UserDto());
        model.addAttribute("admin",adminService.findByLogin(UserUtil.findLoggedUser()));
        return "changeAdminDetails";
    }

    @PostMapping(value = "/changeAdminDetails")
    public String changeAdminDetails(@Valid @ModelAttribute("adminDto") UserDto userDto,
                                     BindingResult bindingResult,
                                     Model model) {
        if (bindingResult.hasErrors()) {
            return "changeAdminDetails";
        }

        Admin byLogin = adminService.changeAdminDetails(userDto);
        model.addAttribute("admin",byLogin);
        return "adminDetails";

    }

    @GetMapping(value = "/specializations")
    public String specializations(Model model) {
        model.addAttribute("specializations",specializationService.findAll());
        return "specializations";
    }
}
