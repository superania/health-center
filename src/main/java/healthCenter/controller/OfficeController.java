package healthCenter.controller;

import healthCenter.Dto.DateForm;
import healthCenter.Dto.DateOfficeForm;
import healthCenter.Dto.NewOfficeDto;
import healthCenter.entity.Office;
import healthCenter.mapper.OfficeMapper;
import healthCenter.service.OfficeService;
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


/**
 * @author ania
 */
@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OfficeController {

    private OfficeService officeService;
    private VisitService visitService;

    @GetMapping(value = "/showOfficesPlan")
    public String showAvailableOffices(Model model) {
        model.addAttribute("date", new DateForm());
        return "officeForm";
    }

    @PostMapping(value = "/showOfficesPlan")
    public String showAvailableOffices(@Valid @ModelAttribute("date") DateForm dateForm,
                                       BindingResult bindingResult,
                                       Model model) {
        if (bindingResult.hasErrors()) {
            return "officeForm";
        }
        model.addAttribute("date",dateForm);
        model.addAttribute("visits",officeService.findAllVisitsAndAllOffices(dateForm.getDate()));
        return "showOfficePlan";
    }

    @GetMapping(value = "/showAllOffices")
    public String showAllOffices(Model model) {
        model.addAttribute("offices", officeService.findAll());
        return "allOffices";
    }

    @GetMapping(value = "/officeOption")
    public String officeOption() {
        return "officeOption";
    }

    @GetMapping(value = "/addNewOffice")
    public String addNewOffice(Model model) {
        model.addAttribute("office", new NewOfficeDto());
        return "addOffice";
    }

    @PostMapping(value = "/addNewOffice")
    public String addNewOffice(@Valid @ModelAttribute("officeDto") NewOfficeDto officeDto,
                               BindingResult result,
                               Model model) {
        if (result.hasErrors()) {
            return "addOffice";
        } else {
            Office office = OfficeMapper.toEntity(officeDto);
            officeService.saveOffice(office);
        }
        model.addAttribute("offices", officeService.findAll());
        return "allOffices";
    }

    @GetMapping(value = "/deleteOffice/{id}")
    public String deleteOffice(@PathVariable("id") Long id,
                               Model model) {
        visitService.changeOfficeForNullInVisitBeforeDeletingOffice(id);
        if (!visitService.thereAreVisitsAfterNowForGivenOffice(id)) {
            officeService.deleteOffice(id);
            model.addAttribute("offices", officeService.findAll());
            return "allOffices";
        } else {
            model.addAttribute("offices", officeService.findAll());
            model.addAttribute("id",id);
            return "allOfficeWithError";
        }

    }

    @GetMapping(value = "/showGivenOfficesPlan")
    public String showGivenOfficesPlan(Model model) {
        model.addAttribute("offices",officeService.findAll());
        model.addAttribute("form",new DateOfficeForm());
        return "planForGivenOfficeForm";
    }

    @PostMapping(value = "/showGivenOfficesPlan")
    public String showGivenOfficesPlan(@Valid @ModelAttribute("form") DateOfficeForm form,
                                       BindingResult result,
                                       Model model) {
        if (result.hasErrors()) {
            return "planForGivenOfficeForm";
        }

        model.addAttribute("officeNumber",officeService.findById(form.getOfficeId()).getNumber());
        model.addAttribute("visits",visitService
                .findByOfficeAndDate(officeService.findById(form.getOfficeId()),form.getDate()));
        return "planForGivenOffice";
    }
}
