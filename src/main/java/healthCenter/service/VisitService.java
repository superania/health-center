package healthCenter.service;

import healthCenter.entity.Office;
import healthCenter.entity.Patient;
import healthCenter.entity.Visit;
import healthCenter.repository.VisitRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ania
 */
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class VisitService {

    private VisitRepository visitRepository;

    public void saveVisit(Visit visit) {

        visitRepository.save(visit);
    }

    public List<Visit> findVisitByPatient(Patient patient) {
        return visitRepository.findByPatient(patient);
    }

    public List<Visit> findByOffice(Office office) {
        return visitRepository.findByOffice(office);
    }

    public List<Visit> findByDoctorId(Long id) {
        return visitRepository.findByDoctor_Id(id);
    }

    @Transactional
    public void changeOfficeForNullInVisitBeforeDeletingOffice(Long id) {
        visitRepository
                .findByOffice_Id(id)
                .stream()
                .filter(visit -> visit.getDate().isBefore(LocalDate.now()))
                .forEach(visit -> visit.setOffice(null));

        visitRepository
                .findByOffice_Id(id)
                .forEach(visit -> visitRepository.save(visit));
    }

    public boolean thereAreVisitsAfterNowForGivenOffice(Long id) {
        List<Visit> collect = visitRepository
                .findByOffice_Id(id)
                .stream()
                .filter(visit -> !(visit.getDate().isBefore(LocalDate.now())))
                .collect(Collectors.toList());

        return !collect.isEmpty();
    }

    public List<Visit> findByOfficeAndDate(Office office,LocalDate date) {
        return visitRepository.findByOfficeAndDate(office,date);
    }

    public List<Visit> findAllPastVisit(Patient patient) {
        return visitRepository.findByPatient(patient)
                .stream()
                .filter(visit -> visit.getDate().isBefore(LocalDate.now()))
                .collect(Collectors.toList());
    }

    public Visit findById(Long id) {
        return visitRepository.findById(id);
    }

    public List<Visit> showPlannedVisits(Patient patient) {
        return visitRepository.findByPatient(patient)
                .stream()
                .filter(visit -> visit.getDate().isAfter(LocalDate.now()))
                .collect(Collectors.toList());
    }

    public void deleteVisit(Long id) {
        visitRepository.delete(id);
    }


}
