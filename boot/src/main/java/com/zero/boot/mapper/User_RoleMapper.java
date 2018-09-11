package com.zero.boot.mapper;

import com.zero.boot.po.User_Role;
import com.zero.boot.po.User_RoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @authon yuan
 * @date 2018/1/25 0025
 * @time 10:42
 **/

public interface User_RoleMapper {
    long countByExample(User_RoleExample example);

    int deleteByExample(User_RoleExample example);

    int deleteByPrimaryKey(String id);

    int insert(User_Role record);

    int insertSelective(User_Role record);

    List<User_Role> selectByExample(User_RoleExample example);

    User_Role selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") User_Role record, @Param("example") User_RoleExample example);

    int updateByExample(@Param("record") User_Role record, @Param("example") User_RoleExample example);

    int updateByPrimaryKeySelective(User_Role record);

    int updateByPrimaryKey(User_Role record);
}