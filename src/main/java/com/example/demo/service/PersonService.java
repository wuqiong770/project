package com.example.demo.service;

import com.example.demo.mapper.PersonMapper;
import com.example.demo.model.Person;
import com.github.pagehelper.PageHelper;
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

//按照id 排序，获取第person.getPage()页的前person.getRows()行的。。。。。
    @Transactional
    public List<Person> getPerson(Person person) {
        if (person.getPage() != null && person.getRows() != null) {
            PageHelper.startPage(person.getPage(), person.getRows(), "id");
        }
        return personMapper.select(person);
    }

}
