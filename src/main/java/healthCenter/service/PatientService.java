package healthCenter.service;

import healthCenter.entity.Patient;
import healthCenter.entity.UserRole;
import healthCenter.repository.PatientRepository;
import healthCenter.repository.UserRoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ania
 */

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PatientService {

    private UserRoleRepository userRoleRepository;
    private PatientRepository patientRepository;


    @Transactional
    public void savePatient(Patient patient) {

        UserRole role = userRoleRepository.findByRole("ROLE_PATIENT");
        patient.getRoles().add(role);
        patientRepository.save(patient);
    }

    public List<Patient> findByNameAndSurname(String name, String surname) {
        return patientRepository.findByNameAndSurname(name,surname);
    }

    public Patient findByIdNumber(String idNumber) {
        return patientRepository.findByIdNumber(idNumber);
    }

    public Patient findById(Long id) {
        return patientRepository.findById(id);
    }

    public Patient findByLogin(String login) {
        return patientRepository.findByLogin(login);
    }
}
