package healthCenter.mapper;

import healthCenter.Dto.UserDto;
import healthCenter.entity.Address;
import healthCenter.entity.Patient;

import java.util.ArrayList;

/**
 * @author ania
 */
public class PatientMapper {

    public static Patient userDtoToEntityPatient(UserDto patientDto) {

        Patient patient = new Patient();
        patient.setLogin(patientDto.getLogin());
        patient.setPassword(patientDto.getPassword());
        patient.setName(patientDto.getName());
        patient.setSurname(patientDto.getSurname());
        patient.setDateOfBirth(patientDto.getDateOfBirth());
        patient.setIdNumber(patientDto.getIdNumber());
        patient.setAddress(Address.builder()
                .country(patientDto.getCountry())
                .city(patientDto.getCity())
                .street(patientDto.getStreet())
                .build());
        patient.setVisits(new ArrayList<>());
        return patient;
        }
}
