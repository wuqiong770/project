package com.example.demo.service;

import com.example.demo.DemoApplication;
import com.example.demo.mapper.PersonMapper;
import com.example.demo.module.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Joana on 17/11/16.
 */
@Service
public class PersonService {
    private final static Logger logger = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    private PersonMapper personMapper;

//    public Person createPerson(String name){
//        Person person = new Person();
//        person.setName(name);
//        person.setAge(18);
//        person.setGender("女");
//        return person;
//    }
    @Transactional
    public List<Person> getPerson(){
       return personMapper.selectAll();
    }

    @Transactional
    public String insertPerson(Person person){
        personMapper.insert(person);
        return "{message:ok}";
    }

    @Transactional
    public Person findById(Long id){
       return personMapper.selectOne(id);
    }

}
