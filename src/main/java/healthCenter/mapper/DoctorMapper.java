package healthCenter.mapper;

import healthCenter.Dto.DoctorDto;
import healthCenter.Dto.DoctorDtoForNewAccount;
import healthCenter.Dto.DoctorFormToChangeDetailsByDoctor;
import healthCenter.entity.Address;
import healthCenter.entity.Doctor;
import healthCenter.service.SpecializationService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.stream.Collectors;

/**
 * @author ania
 */
public class DoctorMapper {


    public static Doctor toEntity(Doctor doctor, DoctorDto doctorDto, SpecializationService specializationService) {
        doctor.setId(doctorDto.getId());
        doctor.setName(doctorDto.getName());
        doctor.setSurname(doctorDto.getSurname());
        doctor.setIdNumber(doctorDto.getIdNumber());
        doctor.setDateOfBirth(doctorDto.getDateOfBirth());
        doctor.setAddress(new Address(doctorDto.getCountry(),
                doctorDto.getCity(),
                doctorDto.getStreet()));
        if (doctorDto.getSpecializations().size() != 0) {
            doctor.setSpecializations(doctorDto.getSpecializations()
                    .stream()
                    .map(specializationService::findByName)
                    .collect(Collectors.toList()));
        }
        return doctor;

    }

    public static Doctor doctorDtoForNewAccountToAccount(DoctorDtoForNewAccount dto, SpecializationService specializationService, PasswordEncoder passwordEncoder) {
        Doctor doctor = new Doctor();
        doctor.setLogin(dto.getLogin());
        doctor.setPassword(passwordEncoder.encode(dto.getPassword()));
        doctor.setName(dto.getName());
        doctor.setSurname(dto.getSurname());
        doctor.setIdNumber(dto.getIdNumber());
        doctor.setDateOfBirth(dto.getDateOfBirth());
        doctor.setAddress(new Address(dto.getCountry(), dto.getCity(), dto.getStreet()));
        doctor.setSpecializations(dto
                .getSpecializations()
                .stream()
                .map(specializationService::findByName)
                .collect(Collectors.toList()));
        return doctor;

    }

    public static Doctor doctorFormToEntity(Doctor doctor, DoctorFormToChangeDetailsByDoctor doctorForm, SpecializationService specializationService) {
        doctor.setName(doctorForm.getName());
        doctor.setSurname(doctorForm.getSurname());
        doctor.setAddress(new Address(doctorForm.getAddress().getCountry(),
                doctorForm.getAddress().getCity(),
                doctorForm.getAddress().getStreet()));
        if (doctorForm.getSpecializations().size() != 0) {
            doctor.setSpecializations(doctorForm
                    .getSpecializations()
                    .stream()
                    .map(specializationService::findByName)
                    .collect(Collectors.toList()));
        }
        return doctor;
    }


}
