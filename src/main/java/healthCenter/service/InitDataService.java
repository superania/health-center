package healthCenter.service;

import healthCenter.entity.*;
import healthCenter.repository.AdminRepository;
import healthCenter.repository.SpecializationRepository;
import healthCenter.repository.UserRoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

/**
 * @author ania
 */
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class InitDataService {

    private UserRoleRepository userRoleRepository;
    private AdminRepository adminRepository;
    private SpecializationRepository specializationRepository;
    private DoctorService doctorService;
    private PatientService patientService;
    private VisitService visitService;
    private OfficeService officeService;


    @PostConstruct
            public void initData() {
        userRoleRepository.save(UserRole.builder()
                .role("ROLE_ADMIN")
                .build());

        userRoleRepository.save(UserRole.builder()
                .role("ROLE_PATIENT")
                .build());

        userRoleRepository.save(UserRole.builder()
                .role("ROLE_DOCTOR")
                .build());


        Address address3 = new Address();
        address3.setCountry("Polska");
        address3.setCity("Lublin");
        address3.setStreet("Zimowa 1");
        Admin admin = new Admin();
        admin.setLogin("admin");
        admin.setPassword("$2a$10$xD1s.606luoXhe3lweL5p.jADHznTAYPcn95a6PlfaBudDfdd0d2S");
        admin.setName("Marek");
        admin.setSurname("Kowalski");
        admin.setAddress(address3);
        admin.setIdNumber("12121212724");
        admin.setDateOfBirth(LocalDate.of(1982, 12, 4));
        Set<UserRole> roleSet = new HashSet<>();
        roleSet.add(userRoleRepository.findByRole("ROLE_ADMIN"));
        admin.setRoles(roleSet);

        adminRepository.save(admin);

        Doctor doctor = new Doctor();
        doctor.setLogin("doctor");
        doctor.setPassword("$2a$10$O4l4zwVE9bv/NbUGxV1Aues1fBuCcBUKg3j1XPXa5YYR8zaAnMg0a");
        doctor.setName("Tomasz");
        doctor.setSurname("Kolski");
        doctor.setIdNumber("99999999999");
        doctor.setDateOfBirth(LocalDate.of(1976, 11, 12));
        doctor.setAddress(Address.builder()
                .country("Polska")
                .city("Lublin")
                .street("Zimna")
                .build());
        doctor.setMedicalAdvices(new ArrayList<>());
        Specialization doctorSpecialization = new Specialization();
        doctorSpecialization.setName("PLASTIC SURGEON");
        specializationRepository.save(doctorSpecialization);
        Specialization doctorSpecialization1 = new Specialization();
        doctorSpecialization1.setName("GENERAL SURGEON");
        specializationRepository.save(doctorSpecialization1);
        List<Specialization> specializations = new ArrayList<>();
        specializations.add(doctorSpecialization);
        specializations.add(doctorSpecialization1);
        doctor.setSpecializations(specializations);
        doctorService.saveDoctor(doctor);

        Doctor doctor2 = new Doctor();
        doctor2.setLogin("doctor2");
        doctor2.setPassword("$2a$10$O4l4zwVE9bv/NbUGxV1Aues1fBuCcBUKg3j1XPXa5YYR8zaAnMg0a");
        doctor2.setName("Tomasz");
        doctor2.setSurname("Kolski");
        doctor2.setIdNumber("99999999111");
        doctor2.setDateOfBirth(LocalDate.of(1966, 11, 12));
        doctor2.setAddress(Address.builder()
                .country("Polska")
                .city("Lublin")
                .street("Chopina")
                .build());
        doctor2.setMedicalAdvices(new ArrayList<>());
        Specialization specialization3 = new Specialization();
        specialization3.setName("NEPHROLOGIST");
        specializationRepository.save(specialization3);
        List<Specialization> specializations2 = new ArrayList<>();
        specializations2.add(doctorSpecialization);
        specializations2.add(specialization3);
        doctor2.setSpecializations(specializations2);
        doctorService.saveDoctor(doctor2);

        Doctor doctor1 = new Doctor();
        doctor1.setLogin("doctor1");
        doctor1.setPassword("$2a$10$O4l4zwVE9bv/NbUGxV1Aues1fBuCcBUKg3j1XPXa5YYR8zaAnMg0a");
        doctor1.setName("Adam");
        doctor1.setSurname("Kowalski");
        doctor1.setIdNumber("19999999991");
        doctor1.setDateOfBirth(LocalDate.of(1986, 12, 2));
        doctor1.setAddress(Address.builder()
                .country("Polska")
                .city("Lublin")
                .street("Polna")
                .build());
        doctor1.setMedicalAdvices(new ArrayList<>());
        Specialization doctorSpecialization2 = new Specialization();
        doctorSpecialization2.setName("GASTROENTEROLOGIST");
        specializationRepository.save(doctorSpecialization2);
        List<Specialization> specializations1 = new ArrayList<>();
        specializations1.add(doctorSpecialization2);
        specializations1.add(doctorSpecialization1);
        doctor1.setSpecializations(specializations1);
        doctorService.saveDoctor(doctor1);

        Address address1 = new Address();
        address1.setCountry("Polska");
        address1.setCity("Lublin");
        address1.setStreet("Głęboka 1");
        Patient ania = new Patient();
        ania.setLogin("ania");
        ania.setPassword("$2a$10$rPzzwMo1pCjE/wP.ezK73e2nKRLb2ttFhvnv7QG59tVN4GIt1cN7O");
        ania.setName("Ania");
        ania.setSurname("Malinowska");
        ania.setAddress(address1);
        ania.setIdNumber("12121212121");
        ania.setDateOfBirth(LocalDate.of(1982, 12, 4));
        ania.setVisits(new ArrayList<>());

        patientService.savePatient(ania);


        Address address2 = new Address();
        address2.setCountry("Polska");
        address2.setCity("Lublin");
        address2.setStreet("Głęboka 1");
        Patient ania2 = new Patient();
        ania2.setLogin("ania2");
        ania2.setPassword("$2a$10$rPzzwMo1pCjE/wP.ezK73e2nKRLb2ttFhvnv7QG59tVN4GIt1cN7O");
        ania2.setName("Ania");
        ania2.setSurname("Malinowska");
        ania2.setAddress(address1);
        ania2.setIdNumber("12121212133");
        ania2.setDateOfBirth(LocalDate.of(1980, 2, 14));
        ania2.setVisits(new ArrayList<>());

        patientService.savePatient(ania2);

        Office office1 = new Office();
        office1.setNumber("1");
        office1.setName("Gabinet lekarski");

        officeService.saveOffice(office1);



        Office office2 = new Office();
        office2.setNumber("2");
        office2.setName("Gabinet lekarski");

        officeService.saveOffice(office2);


        Office office3 = new Office();
        office3.setNumber("3");
        office3.setName("Gabinet lekarski");

        officeService.saveOffice(office3);

        Office office4 = new Office();
        office4.setNumber("4");
        office4.setName("Gabinet lekarski");

        officeService.saveOffice(office4);

        Visit visit1 = Visit.builder()
                .date(LocalDate.of(2018, 9, 03))
                .timeFrom(LocalTime.of(10, 00))
                .timeTo(LocalTime.of(10, 20))
                .doctorAnnotation("Pacjentka ma odstające uszy. Bardzo brzydko wygląda. A fuj!" +
                        "Będę ją musiał zoperować.")
                .doctor(doctor1)
                .patient(ania)
                .office(office2)
                .build();

       visitService.saveVisit(visit1);

        Visit visit2 = Visit.builder()
                .date(LocalDate.of(2018, 8, 13))
                .timeFrom(LocalTime.of(10, 00))
                .timeTo(LocalTime.of(10, 20))
                .doctorAnnotation("Pacjentka po operacji. Rany goją się dobrze i co najważniejsze pacjentka " +
                        "wygląda obłędnie.")
                .doctor(doctor1)
                .patient(ania)
                .office(office2)
                .build();
        visitService.saveVisit(visit2);

        Visit visit3 = Visit.builder()
                .date(LocalDate.of(2018, 8, 13))
                .timeFrom(LocalTime.of(10, 20))
                .timeTo(LocalTime.of(10, 40))
                .doctorAnnotation("Pacjentka po operacji. Rany goją się dobrze i co najważniejsze pacjentka " +
                        "wygląda obłędnie.")
                .doctor(doctor1)
                .patient(ania)
                .office(office3)
                .build();
        visitService.saveVisit(visit3);

        Visit visit4 = Visit.builder()
                .date(LocalDate.of(2018, 9, 13))
                .timeFrom(LocalTime.of(11, 0))
                .timeTo(LocalTime.of(11, 20))
                .doctor(doctor2)
                .patient(ania)
                .office(office2)
                .build();

        visitService.saveVisit(visit4);

        Visit visit5 = Visit.builder()
                .date(LocalDate.of(2018, 9, 23))
                .timeFrom(LocalTime.of(11, 0))
                .timeTo(LocalTime.of(11, 20))
                .doctor(doctor2)
                .patient(ania)
                .office(office2)
                .build();

        visitService.saveVisit(visit5);









    }
}
