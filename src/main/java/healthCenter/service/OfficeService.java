package healthCenter.service;

import com.sun.java.swing.plaf.windows.WindowsTreeUI;
import healthCenter.entity.Office;
import healthCenter.entity.Visit;
import healthCenter.repository.OfficeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ania
 */
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OfficeService {

    private OfficeRepository officeRepository;
    private VisitService visitService;

    public void saveOffice(Office office) {
        officeRepository.save(office);
    }

    public List<Office> findAll() {

        return officeRepository
                .findAll()
                .stream()
                .sorted(Comparator.comparing(Office::getNumber))
                .collect(Collectors.toList());
    }

    public Set<Office> findFreeOffices(LocalTime timeFrom,LocalTime timeTo,LocalDate date) {
        Set<Office> officeSet = new HashSet<>();
        List<Office> offices = findAll();

        for (Office office : offices) {

            if (!isVisitWithDate(date,office)) {
                officeSet.add(office);
            }



            if (isNotOfficeBusy(office,date,timeFrom,timeTo))
                    officeSet.add(office);
                }
            return officeSet;
        }

    private boolean isNotOfficeBusy(Office office,LocalDate date,LocalTime timeFrom, LocalTime timeTo) {
        Optional<LocalTime> min = findMinTimeFromForDate(date, office);
        Optional<LocalTime> max = findMaxTimeToForDate(date, office);
        return min.isPresent() && max.isPresent() && (!(min.get().isBefore(timeTo)) || !(max.get().isAfter(timeFrom)));
    }

    private Optional<LocalTime> findMaxTimeToForDate(LocalDate date, Office office) {
        return visitService
                .findByOffice(office)
                .stream()
                .filter(visit -> date.equals(visit.getDate()))
                .map(Visit::getTimeTo)
                .max(LocalTime::compareTo);
    }

    private Optional<LocalTime> findMinTimeFromForDate(LocalDate date,Office office) {
        return visitService
                .findByOffice(office)
                .stream()
                .filter(visit -> date.equals(visit.getDate()))
                .map(Visit::getTimeFrom)
                .min(LocalTime::compareTo);
    }


    private boolean isVisitWithDate(LocalDate date,Office office) {
        List<LocalDate> dateList = visitService
                .findByOffice(office)
                .stream()
                .map(Visit::getDate)
                .collect(Collectors.toList());
        return dateList.contains(date);
    }

    public Office findById(Long id) {
        return officeRepository.findById(id);
    }

    public void deleteOffice(Long id) {
        officeRepository.delete(id);
    }

    public Map<Office,List<Visit>> findAllVisitsAndAllOffices(LocalDate date) {
        Map<Office,List<Visit>> officeVisits = new HashMap<>();
        for (Office office : officeRepository.findAll()) {
            officeVisits.put(office,visitService.findByOfficeAndDate(office,date));
        }
        return officeVisits;
    }


}
