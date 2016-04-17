package com.ming.chenxi.controller;

import com.alibaba.fastjson.JSON;
import com.ming.chenxi.config.CommonSting;
import com.ming.chenxi.domain.MobileUser;
import com.ming.chenxi.domain.User;
import com.ming.chenxi.domain.UserProfile;
import com.ming.chenxi.repository.UserProfileRepository;
import com.ming.chenxi.service.UserServiceI;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private Log log = LogFactory.getLog(UserController.class);
    @Autowired
    private UserServiceI userServiceI;

    @Autowired
    protected UserProfileRepository userProfileRepository;

    private final  String key = "secretkey";

    private final Map<String, List<String>> userDb = new HashMap<>();

    public UserController() {
        userDb.put("user", Arrays.asList("user"));
        userDb.put("userAndAdmin", Arrays.asList("user", "admin"));
    }

    /**
     * 登陆成功，设置sub,是claim 默认的字段，并且设置自定义的roles 字段
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public MobileUser login(@RequestBody  User loginUser)
        throws ServletException {
        MobileUser mobileUser = new MobileUser();

        String phone = loginUser.getPhone();
        if(StringUtils.isEmpty(phone)){
            mobileUser.setResult(CommonSting.MissingParam.getCode());
            return  mobileUser;
        }

        User getUserByUserName = userServiceI.getUserByPhone(phone);

        if(getUserByUserName==null){
            mobileUser.setResult(CommonSting.UserNotExist.getCode());
            return mobileUser;
        }

        if (!getUserByUserName.getPassword().equals(loginUser.getPassword())) {
            mobileUser.setResult(CommonSting.WrongPassword.getCode());
            return mobileUser;
        }

        UserProfile userProfile = userProfileRepository.getUserProfileByPhone(phone);

        String token = Jwts.builder().setSubject(phone)
                .claim("roles", userDb.get("user")).setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, key).compact();

        mobileUser.setResult(CommonSting.LoginSuccess.getCode());
        mobileUser.setPhone(phone);
        mobileUser.setToken(token);

        if(userProfile!=null)
            BeanUtils.copyProperties(userProfile,mobileUser);

        log.info("--登陆成功"+ JSON.toJSONString(mobileUser));
        return mobileUser;
    }

    /**
     * 注册成功后也返回token
     */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public MobileUser register(@RequestBody   User registerUser)throws ServletException{

        MobileUser mobileUser = new MobileUser();

        String phone = registerUser.getPhone();

        if(StringUtils.isEmpty(registerUser.getPassword())
                ||StringUtils.isEmpty(phone)){
            mobileUser.setResult(CommonSting.MissingParam.getCode());
            return  mobileUser;
        }

        User getUserByUserName = userServiceI.getUserByPhone(registerUser.getPhone());

        if(getUserByUserName!=null) {
            mobileUser.setResult(CommonSting.UserIsExist.getCode());
            return  mobileUser;
        }

        userServiceI.addUser(registerUser);

        String token = Jwts.builder().setSubject(phone)
                .claim("roles", userDb.get(phone)).setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, key).compact();

        mobileUser.setResult(CommonSting.LoginSuccess.getCode());
        mobileUser.setPhone(phone);
        mobileUser.setToken(token);

        return mobileUser;
    }

    @RequestMapping(value = "/test")
    public User a(){
        System.out.println("测试响应");
        return  new User("kkk","hh");
    }

}
