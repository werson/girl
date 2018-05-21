package com.werson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by wersom on 2017/6/4 0004.
 */
@Controller
@ResponseBody
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @GetMapping(value = "/girls")
    public List<Girl> getGirlList(){
        return girlRepository.findAll();
    }

    @GetMapping(value = "/add")
    public Girl addGirl(@RequestParam(value = "cupsize") String cupSize,
                        @RequestParam(value = "age") Integer age){
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    @GetMapping(value = "/find")
    public List<Girl> girlListFindByAge(@RequestParam(value = "age") Integer age){
        return girlRepository.findByAge(age);
    }

}
