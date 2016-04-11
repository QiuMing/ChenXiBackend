import com.alibaba.fastjson.JSON;
import com.ming.chenxi.domain.User;
import com.ming.chenxi.domain.UserProfile;
import com.ming.chenxi.repository.UserProfileRepository;
import com.ming.chenxi.repository.UserRepository;
import com.ming.chenxi.service.UserServiceI;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

/**
 * Created by Ming on 2016/4/6.
 */
public class UserServiceTest extends  AbstractServiceTests {

    @Autowired
    protected UserRepository userRepository;

    @Autowired
    protected UserServiceI UserServiceI;

    @Autowired
    protected UserProfileRepository userProfileRepository;

    @Test
    public void test_findByUsername(){
        System.out.println(JSON.toJSONString(userRepository.findByPhone("admin")));
        System.out.println(JSON.toJSONString(userRepository.findByPhone("测试")));
    }

    @Rollback(false)
    @Test
    public void test_save_user(){
      /*  ShaPasswordEncoder sha = new ShaPasswordEncoder();
        sha.setEncodeHashAsBase64(false);
        String password = sha.encodePassword("123456", null);
        User user  = new User("测试",password);
        System.out.println(userRepository.save(user));*/
    }

    @Rollback(false)
    @Test
    public void test_save_user_profile(){
        UserProfile userProfile = new UserProfile();
        userProfile.setAge(12);
        userProfile.setHeight(12.21);
        userProfile.setUserId(1);
        userProfileRepository.save(userProfile);
    }

    @Test
    public void test_find_by_username(){
        System.out.println(        JSON.toJSONString(userRepository.findByPhone("测试")));
    }

    @Test
    public void getUserProfileByUserName(){
       // System.out.println(JSON.toJSONString(userProfileRepository.getUserProfileByUserProfileId(1)));
        System.out.println(JSON.toJSONString(userProfileRepository.getUserProfileByPhone("测试")));
    }
    public static void main(String[] args) {
        final User user = new User("aaa","aaa");
        System.out.println(JSON.toJSONString(user));

        System.out.printf(user.getPhone());
        System.out.printf(user.getPhone());
    }
}
