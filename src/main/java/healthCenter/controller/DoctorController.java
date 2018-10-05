package healthCenter.controller;

import healthCenter.Dto.*;
import healthCenter.entity.Doctor;
import healthCenter.mapper.DoctorMapper;
import healthCenter.service.DoctorService;
import healthCenter.service.SpecializationService;
import healthCenter.service.UserUtil;
import healthCenter.service.VisitService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ania
 */
@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DoctorController {

    private DoctorService doctorService;
    private SpecializationService specializationService;
    private PasswordEncoder passwordEncoder;
    private VisitService visitService;


    @GetMapping(value = "/doctorOptions")
    public String doctorOptions() {
        return "doctorOptions";
    }

    @GetMapping(value = "/doctors")
    public String showDoctors(Model model) {
        List<Doctor> collect = doctorService.findAllDoctorsSortedList();
        model.addAttribute("doctors", collect);
        return "showDoctors";
    }

    @GetMapping(value = "/doctorDetails/{id}")
    public String showDoctorDetails(@PathVariable("id") Long id,
                                    Model model) {
        model.addAttribute("doctor", doctorService.findById(id));
        return "doctorDetails";
    }

    @GetMapping(value = "/changeDoctorDetails/{id}")
    public String changeDoctorDetails(@PathVariable("id") Long id,
                                      Model model) {
        model.addAttribute("doctor", doctorService.findById(id));
        model.addAttribute("doctorDto", new DoctorDto());
        model.addAttribute("specializations", specializationService.findAll());
        return "changeDoctorDetails";
    }

    @PostMapping(value = "/changeDoctorDetails/changeDetails")
    public String changeDoctorDetails(@Valid @ModelAttribute("doctorDto") DoctorDto doctorDto,
                                      BindingResult bindingResult,
                                      Model model) {
        model.addAttribute("specializations", specializationService.findAll());
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            errors.forEach(err -> System.out.println(err.getDefaultMessage()));
            return "changeDoctorDetails";
        } else {
            Doctor doctor = doctorService.findById(doctorDto.getId());
            doctor = DoctorMapper.toEntity(doctor, doctorDto, specializationService);
            doctorService.saveDoctor(doctor);
            model.addAttribute("doctor", doctor);

            return "doctorDetails";
        }
    }

    @GetMapping(value = "/deleteDoctor/{id}")
    public String deleteDoctor(@PathVariable("id") Long id,
                               Model model) {
        Doctor doctor = doctorService.findById(id);
        if (visitService.findByDoctorId(id).isEmpty()) {
            doctorService.deleteDoctor(id);
            model.addAttribute("doctors", doctorService.findAllDoctorsSortedList());
            return "showDoctors";
        } else {
            model.addAttribute("doctor", doctor);
            model.addAttribute("doctors", doctorService.findAllDoctorsSortedList());
            return "showDoctorsWithErrors";
        }
    }

    @GetMapping(value = "/findBySpecialization")
    public String findBySpecialization(Model model) {
        model.addAttribute("specialization", new SpecializationForm());
        model.addAttribute("specializations", specializationService.findAll());
        return "findDoctorBySpecialization";
    }

    @PostMapping(value = "/findBySpecialization")
    public String findBySpecialization(@Valid @ModelAttribute("specialization") SpecializationForm specializationForm,
                                       BindingResult bindingResult,
                                       Model model) {
        model.addAttribute("doctors", doctorService.findBySpecialization(specializationForm.getName()).stream().sorted().collect(Collectors.toList()));
        return "showDoctors";
    }

    @GetMapping(value = "/findDoctorByNameAndSurname")
    public String findDoctorByNameAndSurname(Model model) {
        model.addAttribute("doctor", new ByNameAndSurnameForm());
        return "findDoctorByNameAndSurname";
    }

    @PostMapping(value = "/findDoctorByNameAndSurname")
    public String findDoctorByNameAndSurname(@Valid @ModelAttribute("doctor") ByNameAndSurnameForm byNameAndSurnameForm,
                                             BindingResult bindingResult,
                                             Model model) {
        if (bindingResult.hasErrors()) {
            return "findDoctorByNameAndSurname";
        } else {
            model.addAttribute("doctors", doctorService.findByNameAndSurname(byNameAndSurnameForm.getName(),
                    byNameAndSurnameForm.getSurname()));
            return "showDoctors";
        }
    }


    @GetMapping(value = "/createDoctorAccount")
    public String createDoctorAccount(Model model) {
        model.addAttribute("specializations", specializationService.findAll());
        model.addAttribute("doctorDto", new DoctorDtoForNewAccount());
        return "doctorAccount";
    }

    @PostMapping(value = "/createDoctorAccount")
    public String createDoctorAccount(@Valid @ModelAttribute("doctorDto") DoctorDtoForNewAccount dto,
                                      BindingResult bindingResult,
                                      Model model) {
        model.addAttribute("specializations", specializationService.findAll());

        if (bindingResult.hasErrors()) {
            return "doctorAccount";
        } else {
            Doctor doctor = DoctorMapper.doctorDtoForNewAccountToAccount(dto, specializationService, passwordEncoder);
            doctorService.saveDoctor(doctor);
            model.addAttribute("doctor", doctor);
            return "doctorDetails";
        }
    }

    @GetMapping(value = "/showDoctorDetails")
    public String showDoctorDetails(Model model) {

        model.addAttribute("doctor", doctorService.findByLogin(UserUtil.findLoggedUser()));
        return "doctorPersonalDetails";
    }

    @GetMapping(value = "/changeDetailsDoctor")
    public String changeDetailsDoctor(Model model) {
        model.addAttribute("doctorForm", new DoctorFormToChangeDetailsByDoctor());
        model.addAttribute("specializations", specializationService.findAll());
        model.addAttribute("doctor", doctorService.findByLogin(UserUtil.findLoggedUser()));
        return "changeDoctor";
    }

    @PostMapping(value = "/changeDetailsDoctor")
    public String changeDetailsDoctor(@Valid @ModelAttribute("doctorForm") DoctorFormToChangeDetailsByDoctor doctorForm,
                                      BindingResult bindingResult,
                                      Model model) {
        model.addAttribute("specializations", specializationService.findAll());
        if (bindingResult.hasErrors()) {
            return "changeDoctor";
        } else {
            Doctor doctor = doctorService.findByLogin(UserUtil.findLoggedUser());
            doctor = DoctorMapper.doctorFormToEntity(doctor, doctorForm, specializationService);
            doctorService.saveDoctor(doctor);
            model.addAttribute("doctor", doctor);
        }
        return "doctorPersonalDetails";
    }
}
