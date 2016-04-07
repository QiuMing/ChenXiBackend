import com.ming.chenxi.repository.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Ming on 2016/4/6.
 */
public class UserServiceTest extends  AbstractServiceTests {

    @Autowired
    protected UserRepository userRepository;


    @Test
    public void just_test(){
        System.out.println("-----"+userRepository.findByUsername("admin"));
    }

}
