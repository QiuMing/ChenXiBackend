package com.ming.chenxi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Ming on 2016/4/6.
 */
@Controller
public class BackendController {

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index ()
    {
        return "index";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login ()
    {
        return "login";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register()
    {
        return "register";
    }

    @RequestMapping(value = "userList", method = RequestMethod.GET)
    public String userList ()
    {
        return "userList";
    }


}
