package com.ming.chenxi.controller;

import com.ming.chenxi.domain.User;
import com.ming.chenxi.service.UserServiceI;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
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

    @Autowired
    private UserServiceI userServiceI;

    private final Map<String, List<String>> userDb = new HashMap<>();

    public UserController() {
        userDb.put("tom", Arrays.asList("user"));
        userDb.put("sally", Arrays.asList("user", "admin"));
    }

    /**
     * 登陆成功，设置sub,是claim 默认的字段，并且设置自定义的roles 字段
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public LoginResponse login(@RequestBody final  User loginUser)
        throws ServletException {

        User getUserByUserName = userServiceI.getUserByPhone(loginUser.getPhone());
        if(getUserByUserName==null){
            throw new ServletException("Invalid userName");
        }


        if (!getUserByUserName.getPassword().equals(loginUser.getPassword())) {
            throw new ServletException("Invalid password");
        }
        return new LoginResponse(Jwts.builder().setSubject(getUserByUserName.getPhone())
            .claim("roles", userDb.get(loginUser.getPhone())).setIssuedAt(new Date())
            .signWith(SignatureAlgorithm.HS256, "secretkey").compact());
    }

    /**
     * 注册成功后也返回token
     */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public LoginResponse register(@RequestBody   User registerUser)throws ServletException{

        System.out.println("jjKKKKKKKKKKKKKKjjjjjjj");

        if(StringUtils.isEmpty(registerUser.getPassword())
                ||StringUtils.isEmpty(registerUser.getPhone())){
            throw new ServletException("Erro data");
        }
        User getUserByUserName = userServiceI.getUserByPhone(registerUser.getPhone());
        if(getUserByUserName!=null) {
            throw new ServletException("Exist user");
        }

        userServiceI.addUser(registerUser);
        return new LoginResponse(Jwts.builder().setSubject(registerUser.getPhone())
                .claim("roles", userDb.get(registerUser.getPassword())).setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact());
    }

    @RequestMapping(value = "a")
    public User a(){
        System.out.println("jjjjjjjjjjjjjjj");
        return  new User("kkk","hh");
    }
    private static class LoginResponse {
        public String token;
        public LoginResponse(final String token) {
            this.token = token;
        }
    }
}
