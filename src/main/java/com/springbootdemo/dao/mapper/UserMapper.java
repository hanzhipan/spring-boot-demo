package com.springbootdemo.dao.mapper;

import com.springbootdemo.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by hanzhipan on 2018/2/24.
 */
@Mapper
public interface UserMapper {

    User findByUserName(@Param("username") String username);

    int insert(@Param("username") String username);


}
