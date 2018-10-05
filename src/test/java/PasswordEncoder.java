import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author ania
 */
public class PasswordEncoder {

    @Test
    public void encodePassword() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = "admin";
        System.out.println(encoder.encode(password));
    }
}
