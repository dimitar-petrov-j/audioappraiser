package com.audioappraiser.audioapp;

import com.audioappraiser.audioapp.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping(value="/")
    public String index(){
        return "index";
    }

    @RequestMapping(value="/usertest")
    public User user()
    {
        return new User("jimmy","Dimitar Petrov", false);
    }

}
