package com.example.demo.model;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by Joana on 18/1/2.
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
