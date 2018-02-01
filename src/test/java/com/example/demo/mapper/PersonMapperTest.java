package com.example.demo.mapper;

import com.example.demo.model.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * Created by Joana on 17/12/7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonMapperTest {
    private static SqlSessionFactory sqlSessionFactory;
//    @BeforeClass
//    public static void init(){
//        try{
//            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
//            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//            reader.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//    }

    private void printPensonList(List<Person> personList){
        personList.forEach( person -> {
            System.out.println(person.getName());
        });
    }
    @Test
    public void testSelectAll(){
        SqlSession sqlSession = null;
        Reader reader = null;
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {

            reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlSession = sqlSessionFactory.openSession();


            List<Person> personList = sqlSession.selectList("selectAll");
            printPensonList(personList);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                sqlSession.close();
                reader.close();
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }

}