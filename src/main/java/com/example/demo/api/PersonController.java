package com.example.demo.api;

import com.example.demo.mapper.PersonMapper;
import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Joana on 17/11/16.
 */

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonMapper personMapper;

    private static Logger logger = LoggerFactory.getLogger(PersonController.class);

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public List<Person> getPerson(){
        try {
            return personService.getPerson();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping(value = "/get2", method = RequestMethod.GET)
    @ResponseBody
    public List<Person> getPerson2(){
        try {
            Person person = new Person();
            person.setPage(1);
            person.setRows(3);
            return personService.getPerson(person);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
    @RequestMapping(value = "/get/one", method = RequestMethod.GET)
    @ResponseBody
    public Person getPersonById(){

        Person person = new Person();
        person.setId(1L);
        person.setName("qiong.wu");
        return  personMapper.selectOne(person);
    }

}
