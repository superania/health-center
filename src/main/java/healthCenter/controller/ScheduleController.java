package healthCenter.controller;

import healthCenter.Dto.DateForm;
import healthCenter.Dto.OfficeDto;
import healthCenter.Dto.ScheduleForm;
import healthCenter.entity.Doctor;
import healthCenter.entity.Schedule;
import healthCenter.mapper.ScheduleMapper;
import healthCenter.service.DoctorService;
import healthCenter.service.OfficeService;
import healthCenter.service.ScheduleService;
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
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


/**
 * @author ania
 */

@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ScheduleController {

    private OfficeService officeService;
    private DoctorService doctorService;
    private ScheduleService scheduleService;

    @GetMapping(value = "/schedule")
    public String schedule() {
        return "schedule";
    }

    @GetMapping(value = "/addSchedule")
    public String addSchedule(Model model) {
        model.addAttribute("scheduleForm", new ScheduleForm());
        return "addSchedule";
    }

    @PostMapping(value = "/addSchedule")
    public String addSchedule(@Valid @ModelAttribute("scheduleForm") ScheduleForm scheduleForm,
                              BindingResult bindingResult,
                              Model model) {
        if (bindingResult.hasErrors()) {
            return "addSchedule";
        }
        if (!scheduleForm.getTimeFrom().isBefore(scheduleForm.getTimeTo())) {
            return "addScheduleWithError";
        }

        LocalTime timeFrom = scheduleForm.getTimeFrom();
        LocalTime timeTo = timeFrom.plusMinutes(20);
        while (!timeTo.isAfter(scheduleForm.getTimeTo())) {
            ScheduleForm form = ScheduleForm.builder()
                    .date(scheduleForm.getDate())
                    .timeFrom(timeFrom)
                    .timeTo(timeTo)
                    .build();
            timeTo = timeTo.plusMinutes(20);
            timeFrom = timeFrom.plusMinutes(20);
            Schedule schedule = ScheduleMapper.toEntity(form);
            schedule.setDoctor(doctorService.findByLogin(UserUtil.findLoggedUser()));
            scheduleService.saveSchedule(schedule);

            model.addAttribute("offices", officeService
                    .findFreeOffices(scheduleForm.getTimeFrom(),
                            scheduleForm.getTimeTo(),
                            scheduleForm.getDate()));
            OfficeDto officeDto = new OfficeDto();
            officeDto.setScheduleId(schedule.getId());
            model.addAttribute("officeId", officeDto);
        }

        return "findOffice";
    }


    @PostMapping(value = "/saveSchedule")
    public String saveSchedule(@ModelAttribute("officeId") OfficeDto officeDto) {
        Schedule byId = scheduleService.findById(officeDto.getScheduleId());
        byId.setOffice(officeService.findById(officeDto.getOfficeId()));
        scheduleService.saveSchedule(byId);
        return "schedule";
    }

    @GetMapping(value = "/showSchedule")
    public String showSchedule(Model model) {
        Doctor doctor = doctorService.findByLogin(UserUtil.findLoggedUser());
        model.addAttribute("schedule", scheduleService.findByDoctorId(doctor.getId()));
        return "allSchedules";
    }

    @GetMapping(value = "/findScheduleByDate")
    public String findScheduleByDate(Model model) {
        model.addAttribute("date",new DateForm());
        return "findScheduleByDate";
    }

    @PostMapping(value = "/findScheduleByDate")
    public String findScheduleByDate(@ModelAttribute("date") DateForm dateForm,
                                     Model model) {
        model.addAttribute("schedule",scheduleService.findByDate(dateForm.getDate()));
        return "allSchedules";
    }
}
