package com.example.demo.api;

import com.example.demo.module.Person;
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

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public String insertPerson(@RequestBody Person person){
        try {
            return personService.insertPerson(person);
        }catch (Exception e){
            e.printStackTrace();
            return "{\"message\":\"failed\"}";
        }
    }

//
//    @RequestMapping(value = "/home", method = RequestMethod.GET)
//    public ModelAndView home() {
//        logger.info("跳转到home界面");
//        ModelAndView result = new ModelAndView("person/home");
//        List<Person> personList = personService.getPerson();
//        result.addObject("person",personList);
//        return result;
//    }

//
//    @RequestMapping(value = "add",method = RequestMethod.GET)
//    public ModelAndView add(Long id){
//        ModelAndView mv = new ModelAndView("person_add");
//        Person person;
//        if (id == null){
//            person = new Person();
//        }else {
//            person = personService.findById(id);
//        }
//        mv.addObject("model",person);
//        return mv;
//    }

//    @ExceptionHandler(NotFindException.class)
//    public String handleException(){
//        return "error";
//    }
}
