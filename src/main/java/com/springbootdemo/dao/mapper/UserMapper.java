package com.springbootdemo.dao.mapper;

import com.springbootdemo.domain.entity.User;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by hanzhipan on 2018/2/24.
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USER WHERE PHONE = #{phone}")
    User findUserByPhone(@Param("phone") String phone);

    @Insert("INSERT INTO USER(NAME, PHONE) VALUES(#{name}, #{phone})")
    int insert(@Param("name") String name, @Param("phone") String phone);

}
