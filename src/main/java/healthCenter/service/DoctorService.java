package healthCenter.service;

import healthCenter.entity.*;
import healthCenter.repository.DoctorRepository;
import healthCenter.repository.SpecializationRepository;
import healthCenter.repository.UserRoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ania
 */

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DoctorService {

    private DoctorRepository doctorRepository;
    private UserRoleRepository userRoleRepository;


    public List<Doctor> findAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor findById(Long id) {
        return doctorRepository.findById(id);
    }

    public List<Doctor> findAllDoctorsSortedList() {
        return  doctorRepository
                .findAll()
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    @Transactional
    public void saveDoctor(Doctor doctor) {
        Set<UserRole> roles = new HashSet<>();
        roles.add(userRoleRepository.findByRole("ROLE_DOCTOR"));
        doctor.setRoles(roles);
        doctorRepository.save(doctor);
    }

    public void deleteDoctor(Long id) {
        doctorRepository.delete(id);
    }

    public List<Doctor> findBySpecialization(String name) {
        return doctorRepository.findBySpecialization(name);
    }

    public List<Doctor> findByNameAndSurname(String  name,String surname) {
        return doctorRepository.findByNameAndSurname(name,surname);
    }

    public Doctor findByLogin(String login) {
        return doctorRepository.findByLogin(login);
    }

}










































