package healthCenter.controller;

import healthCenter.Dto.ByNameAndSurnameForm;
import healthCenter.Dto.FindByIdNumberForm;
import healthCenter.Dto.VisitForm;
import healthCenter.entity.Patient;
import healthCenter.entity.Visit;
import healthCenter.mapper.VisitMapper;
import healthCenter.service.DoctorService;
import healthCenter.service.PatientService;
import healthCenter.service.UserUtil;
import healthCenter.service.VisitService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ania
 */

@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PatientController {

    private PatientService patientService;
    private VisitService visitService;
    private DoctorService doctorService;

    @GetMapping(value = "/findPatientByNameAndSurname")
    public String findPatientByNameAndSurname(Model model) {
        model.addAttribute("findPatient", new ByNameAndSurnameForm());
        return "findPatientByNameAndSurname";
    }

    @PostMapping(value = "/findPatientByNameAndSurname")
    public String findPatientByNameAndSurname(@Valid @ModelAttribute("findPatient") ByNameAndSurnameForm patientForm,
                                              BindingResult bindingResult,
                                              Model model) {
        if (bindingResult.hasErrors()) {
            return "findPatientByNameAndSurname";
        }
        model.addAttribute("type", "byName");
        model.addAttribute("patients", patientService.findByNameAndSurname(patientForm.getName(), patientForm.getSurname()));
        return "patients";
    }

    @GetMapping(value = "/findPatientByIdNumber")
    public String findPatientByIdNumber(Model model) {
        model.addAttribute("idNumber", new FindByIdNumberForm());
        return "findByIdNumber";
    }

    @PostMapping(value = "/findPatientByIdNumber")
    public String findPatientByIdNumber(@Valid @ModelAttribute("idNumber") FindByIdNumberForm findByIdNumberForm,
                                        BindingResult bindingResult,
                                        Model model) {

        if (bindingResult.hasErrors()) {
            return "findByIdNumber";
        }
        List<Patient> patients = new ArrayList<>();
        Patient patient = patientService.findByIdNumber(findByIdNumberForm.getIdNumber());
        if (patient != null) {
            patients.add(patient);
        }
        model.addAttribute("type", "byId");
        model.addAttribute("patients", patients);
        return "patients";
    }

    @GetMapping(value = "/findPatientByIdNumber/{id}")
    public String showResultFindingById(@PathVariable("id") Long id,
                                        Model model) {
        List<Patient> patients = new ArrayList<>();
        Patient patient = patientService.findById(id);
        if (patient != null) {
            patients.add(patient);
        }
        model.addAttribute("type", "byId");
        model.addAttribute("patients", patients);
        return "patients";
    }

    @GetMapping(value = "/showPatientDetails/{id}/{type}")
    public String showPatientDetails(@PathVariable("id") Long id,
                                     @PathVariable("type") String type,
                                     Model model) {
        model.addAttribute("patient", patientService.findById(id));
        model.addAttribute("type", type);
        return "patientDetails";
    }

    @GetMapping(value = "/showPatient/{name}/{surname}/{type}")
    public String showPatient(@PathVariable("name") String name,
                              @PathVariable("surname") String surname,
                              @PathVariable("type") String type,
                              Model model) {
        model.addAttribute("type", type);
        model.addAttribute("patients", patientService.findByNameAndSurname(name, surname));
        return "patients";

    }


    @GetMapping(value = "/showPatientVisits/{id}/{type}")
    public String showPatientVisits(@PathVariable("id") Long id,
                                    @PathVariable("type") String type,
                                    Model model) {
        Patient patient = patientService.findById(id);
        model.addAttribute("patient", patient);
        model.addAttribute("visits", visitService.findVisitByPatient(patient));
        model.addAttribute("type", type);
        return "patientVisit";
    }

    @GetMapping(value = "/addVisit/{id}/{type}")
    public String addVisit(@PathVariable("id") Long id,
                           @PathVariable("type") String type,
                           Model model) {
        model.addAttribute("patientId", id);
        model.addAttribute("visit", new VisitForm());
        model.addAttribute("type", type);
        return "addVisit";
    }

    @PostMapping(value = "/addVisit/{id}/{type}")
    public String addVisit(@Valid @ModelAttribute("visit") VisitForm visitForm,
                           BindingResult bindingResult,
                           @PathVariable("id") Long id,
                           @PathVariable("type") String type,
                           Model model) {
        if (bindingResult.hasErrors()) {
            return "addVisit";
        }


        Visit visit = VisitMapper.visitFormToEntity(visitForm);
        visit.setPatient(patientService.findById(id));

        visit.setDoctor(doctorService.findByLogin(UserUtil.findLoggedUser()));

        visitService.saveVisit(visit);

        model.addAttribute("type", type);
        model.addAttribute("patient", patientService.findById(visitForm.getPatientId()));
        model.addAttribute("visits", visitService.findVisitByPatient(patientService.findById(visitForm.getPatientId())));
        return "patientVisit";

    }

    @GetMapping(value = "/showPatientDetails")
    public String showPatientDetails(Model model) {
        model.addAttribute(patientService.findByLogin(UserUtil.findLoggedUser()));
        return "detailsOfPatient";
    }

    @GetMapping(value = "/showVisitHistory")
    public String showVisitHistory(Model model) {
        model.addAttribute("visits",
                visitService
                        .findAllPastVisit(patientService.findByLogin(UserUtil.findLoggedUser())));
        return "showPatientLastVisits";
    }
}

