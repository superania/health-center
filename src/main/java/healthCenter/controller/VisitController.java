package healthCenter.controller;

import healthCenter.Dto.AppointmentForm;
import healthCenter.entity.Schedule;
import healthCenter.entity.Visit;
import healthCenter.service.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


/**
 * @author ania
 */
@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class VisitController {

    private VisitService visitService;
    private PatientService patientService;
    private DoctorService doctorService;
    private ScheduleService scheduleService;

    @GetMapping(value = "/visitDetails/{id}")
    public String visitDetails(@PathVariable("id") Long id,
                               Model model) {
        model.addAttribute("visit",visitService.findById(id));
        return "visitDetails";
    }

    @GetMapping(value = "/showPlannedVisits")
    public String showPlannedVisits(Model  model) {
        model.addAttribute("visits",visitService
                .showPlannedVisits(patientService.findByLogin(UserUtil.findLoggedUser())));
        return "plannedVisits";
    }

    @GetMapping(value = "/deleteVisit/{id}")
    public String deleteVisit(@PathVariable("id") Long id,
                              Model model) {
        Visit visit = visitService.findById(id);
        scheduleService.saveSchedule(Schedule.builder()
        .date(visit.getDate())
        .timeFrom(visit.getTimeFrom())
        .timeTo(visit.getTimeTo())
        .doctor(visit.getDoctor())
        .office(visit.getOffice())
        .build());
        visitService.deleteVisit(id);
        model.addAttribute("visits",visitService
                .showPlannedVisits(patientService.findByLogin(UserUtil.findLoggedUser())));
        return "plannedVisits";
    }

    @GetMapping(value = "/makeAppointment")
    public String makeAppointment(Model model) {
        model.addAttribute("doctors",doctorService.findAllDoctorsSortedList());
        model.addAttribute("appointmentForm",new AppointmentForm());
        return "makeAppointmentChooseDoctor";
    }

    @PostMapping(value = "/makeAppointment")
    public String makeAppointment(@ModelAttribute("doctorId") Long doctorId,
                                  @ModelAttribute("appointmentForm") AppointmentForm appointmentForm,
                                  Model model) {
        model.addAttribute("doctor",doctorService.findById(doctorId));
        model.addAttribute("doctorSchedule",scheduleService.findByDoctorId(doctorId));
        return "makeAppointmentChooseDate";
    }

    @GetMapping(value = "/addVisit/{scheduleId}")
    public String addVisit(@PathVariable("scheduleId") Long id) {
        Schedule schedule = scheduleService.findById(id);
        Visit visit = Visit.builder()
                .date(schedule.getDate())
                .timeFrom(schedule.getTimeFrom())
                .timeTo(schedule.getTimeTo())
                .doctor(schedule.getDoctor())
                .patient(patientService.findByLogin(UserUtil.findLoggedUser()))
                .office(schedule.getOffice())
                .build();
        visitService.saveVisit(visit);
        scheduleService.deleteSchedule(id);
        return "plannedVisits";

    }



}
