package com.example.demo.service;

import com.example.demo.mapper.PersonMapper;
import com.example.demo.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Transactional
    public List<Person> getPerson(){
       return personMapper.selectAll();
    }


}
