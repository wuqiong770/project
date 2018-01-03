package com.example.demo.service; 

import com.example.demo.module.Person;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/** 
* PersonService Tester. 
* 
* @author <Authors name> 
* @since <pre>十二月 8, 2017</pre> 
* @version 1.0 
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceTest { 

    @Autowired
    private PersonService personService;
    @Before
    public void before() throws Exception { 
    } 

    @After
    public void after() throws Exception { 
    } 

    /** 
* 
* Method: getPerson() 
* 
*/ 
    @Test
    public void testGetPerson() throws Exception {
        List<Person> personList = personService.getPerson();
        personList.forEach(person -> {
            System.out.println(person.getName()+" "+person.getCreatedAt());
        });
    }


    @Test
    public void testInsertPerson(){
        Person person = new Person("test","12",1);
        personService.insertPerson(person);
    }
    
    }
