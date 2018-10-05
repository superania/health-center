package healthCenter.service;

import healthCenter.Dto.UserDto;
import healthCenter.entity.Address;
import healthCenter.entity.Admin;
import healthCenter.entity.UserRole;
import healthCenter.repository.AdminRepository;
import healthCenter.repository.UserRoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ania
 */

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AdminService {

    private AdminRepository adminRepository;

    public Admin findByLogin(String login) {
        return adminRepository.findByLogin(login);
    }

    public void saveAdmin(Admin admin) {
        adminRepository.save(admin);
    }

    public Admin changeAdminDetails(UserDto adminDto) {
        Admin byLogin = findByLogin(UserUtil.findLoggedUser());
        byLogin.setName(adminDto.getName());
        byLogin.setSurname(adminDto.getSurname());
        byLogin.setIdNumber(adminDto.getIdNumber());
        byLogin.setDateOfBirth(adminDto.getDateOfBirth());
        byLogin.setAddress(new Address(adminDto.getCountry(),adminDto.getCity(),adminDto.getStreet()));
        saveAdmin(byLogin);
        return byLogin;
    }



}
