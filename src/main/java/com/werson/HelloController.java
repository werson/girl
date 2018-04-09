package com.werson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wersom on 2017/6/1 0001.
 */
@Controller
public class HelloController {

    @Value("${cupSize}")
    private String cupSize;

    @Autowired
    private GirlProperties girlProperties;


    //@RequestMapping(value = "/hello", method = RequestMethod.GET)
    @GetMapping(value = "/hello")
    @ResponseBody
    public String sayHi(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id,
                        @RequestParam(value = "name", required = false, defaultValue = "werson") String name){
        return "id = " + id +" and name is " + name;
        //return "index";
    }

    @GetMapping(value = "/index")
    public String index(){
        girlProperties.setCupSize(cupSize);
        return "index";
    }

    @GetMapping(value = "/get_cup")
    @ResponseBody
    public String getCupSize(){
        return girlProperties.getCupSize();
    }

}
