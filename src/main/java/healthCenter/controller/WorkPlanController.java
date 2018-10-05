package healthCenter.controller;

import healthCenter.entity.Doctor;
import healthCenter.entity.Visit;
import healthCenter.service.DoctorService;
import healthCenter.service.UserUtil;
import healthCenter.service.VisitService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * @author ania
 */

@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class WorkPlanController {

    private DoctorService doctorService;
    private VisitService visitService;

    @GetMapping(value = "/workPlan")
    public String showWorkPlan(Model model) {
        Doctor doctor = doctorService.findByLogin(UserUtil.findLoggedUser());
        model.addAttribute("workPlan",visitService.findByDoctorId(doctor.getId()).stream()
                .sorted(Comparator.comparing(Visit::getDate))
                .collect(Collectors.toList()));
        return "workPlan";

    }
}
