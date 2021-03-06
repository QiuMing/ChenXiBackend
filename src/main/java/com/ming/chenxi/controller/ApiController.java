package com.ming.chenxi.controller;

import com.ming.chenxi.domain.Nutrition;
import com.ming.chenxi.domain.User;
import com.ming.chenxi.domain.UserProfile;
import com.ming.chenxi.repository.NutritionRepository;
import com.ming.chenxi.service.UserServiceI;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Ming on 2016/4/7.
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private UserServiceI userServiceI;

    @Autowired
    private NutritionRepository nutritionRepository;

    /**
     * 从claims  提取数据
     */
    @RequestMapping(value = "role/{role}", method = RequestMethod.GET)
    public Boolean login(@PathVariable final String role,
                         final HttpServletRequest request) throws ServletException {
        final Claims claims = (Claims) request.getAttribute("claims");

        return ((List<String>) claims.get("roles")).contains(role);
    }

    @RequestMapping(value = "user/{username}", method = RequestMethod.GET)
    public UserProfile getUserProfile(@PathVariable final String username,
                                      final HttpServletRequest request) throws ServletException {
        User user = userServiceI.getUserByPhone(username);
        if(user==null)
            return null;

        UserProfile userProfile = userServiceI.getUserProfileByUserId(user.getUserId());
        return userProfile;
    }

    @RequestMapping(value="getByName")
    public @ResponseBody
    Nutrition getByNameWithoutJwt(@RequestParam(value="name")String name){

        return nutritionRepository.findByName(name);
    }
}
