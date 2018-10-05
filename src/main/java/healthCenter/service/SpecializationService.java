package healthCenter.service;

import healthCenter.entity.Specialization;
import healthCenter.repository.SpecializationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ania
 */
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SpecializationService {

    private SpecializationRepository specializationRepository;

    public List<Specialization> findAll() {
        return specializationRepository.findAll()
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public boolean checkIfExistsReturnBoolean(String name) {
        Specialization byName = specializationRepository.findByName(name);
        return byName != null;
    }

    public String checkIfExistsReturnString(String name) {
        String message = "";
        if (!checkIfExistsReturnBoolean(name)) {
            message = "not ";
        }
        return "Specialization " + name + " is " + message + "on the specialization list";
    }

    public void saveSpecialization(Specialization specialization) {
        specializationRepository.save(specialization);
    }

    public Specialization findByName(String name) {

        return specializationRepository.findByName(name);
    }


}
