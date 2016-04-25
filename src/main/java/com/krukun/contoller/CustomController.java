package com.krukun.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Eugeniy Krukun on 25.04.2016.
 */
@Controller
@RequestMapping("/controller")
public class CustomController  {
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    @ResponseBody
    public String getInfo(ModelMap model){
        return "Some info";
    }
}
