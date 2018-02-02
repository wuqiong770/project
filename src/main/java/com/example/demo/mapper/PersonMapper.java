package com.example.demo.mapper;
import com.example.demo.model.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

///**
// * Created by Joana on 17/12/7.
// */
@Mapper
public interface PersonMapper {

    @Select("select * from t_person where 1=1")
    List<Person> selectAll();


}
