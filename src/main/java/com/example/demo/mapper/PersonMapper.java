package com.example.demo.mapper;
import com.example.demo.model.MyMapper;
import com.example.demo.model.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

///**
// * Created by Joana on 17/12/7.
// */
//@Mapper
public interface PersonMapper  extends MyMapper<Person>{
//Resulets中的所有行可以来自于不同的表==>将不同表里的条件得到的内容映射成另一个Model对象。

    @Results(id = "selectAll", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "name", column = "name", id = true),
            @Result(property = "age", column = "age", id = true),
            @Result(property = "gender", column = "gender", id = true),
            @Result(property = "createdAt", column = "created_at", id = true),
            @Result(property = "updatedAt", column = "updated_at", id = true)

    })
    @Select("select * from t_person where 1=1")
    List<Person> selectAll();


}
