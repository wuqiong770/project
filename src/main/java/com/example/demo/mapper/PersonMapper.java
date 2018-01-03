package com.example.demo.mapper;
import com.example.demo.module.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

///**
// * Created by Joana on 17/12/7.
// */
@Mapper
public interface PersonMapper {

    List<Person> selectAll();

    void insert(Person person);

    @Select("select * from `t_person` where `id`=#{personId}")
    Person selectOne(Long personId);

}
