package com.ming.chenxi.controller;

import com.alibaba.fastjson.JSONObject;
import com.ming.chenxi.domain.Nutrition;
import com.ming.chenxi.domain.UserProfile;
import com.ming.chenxi.repository.NutritionRepository;
import com.ming.chenxi.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Ming on 2016/4/6.
 */
@Controller
public class BackendController {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private NutritionRepository nutritionRepository;

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index ()
    {
        return "index";
    }


    @RequestMapping(value = "userProfile", method = RequestMethod.GET)
    public String userProfile(){
        return "userProfile";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login ()
    {
        return "login";
    }

    @RequestMapping(value = "dologin", method = RequestMethod.POST)
    public String dologin ()
    {
        System.out.println("先假装登录==||");
        return "index";
    }

    @RequestMapping(value = "nutritionList", method = RequestMethod.GET)
    public String nutritionList()
    {
        return "nutritionList";
    }

    @RequestMapping(value = "userProfileList", method = RequestMethod.GET)
    public String userProfileList()
    {
        return "userProfileList";
    }

    @RequestMapping(value = "getUserProfileList", method = RequestMethod.GET)
    public @ResponseBody JSONObject userList (@RequestParam(value="pageNumber",defaultValue="0",required=true)Integer page,
                         @RequestParam(value="pageSize",defaultValue="10",required=true)Integer pageSize){
        Pageable pageable = new PageRequest(page, pageSize);
        Page<UserProfile> pages = userProfileRepository.findAll(pageable);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("total",pages.getTotalElements());
        jsonObject.put("rows", pages.getContent());

        return jsonObject;
    }

    @RequestMapping(value = "getNutritionList", method = RequestMethod.GET)
    public @ResponseBody JSONObject nutritionList (@RequestParam(value="pageNumber",defaultValue="0",required=true)Integer page,
                            @RequestParam(value="pageSize",defaultValue="10",required=true)Integer pageSize){

        Pageable pageable = new PageRequest(page, pageSize);
        Page<Nutrition> pages = nutritionRepository.findAll(pageable);
        System.out.println(JSONObject.toJSONString(pages));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("total",pages.getTotalElements());
        jsonObject.put("rows", pages.getContent());

        return jsonObject;
    }
}
