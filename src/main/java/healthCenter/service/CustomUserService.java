package healthCenter.service;

import healthCenter.entity.User;
import healthCenter.entity.UserRole;
import healthCenter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;


/**
 * @author ania
 */
@Service("customUserDetailsService")
@Transactional
public class CustomUserService implements UserDetailsService {


    private UserRepository userRepository;


    @Autowired
    public CustomUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(login);

        if(user==null) throw new UsernameNotFoundException("User not found");

        return new org.springframework.security.core.userdetails.User(
                user.getLogin(),
                user.getPassword(),
                convertAuthorities(user.getRoles()));
    }

    private Set<GrantedAuthority> convertAuthorities(Set<UserRole> userRoles) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        for (UserRole userRole: userRoles) {
            authorities.add(new SimpleGrantedAuthority(userRole.getRole()));
        }
        return authorities;
        }

    }





























