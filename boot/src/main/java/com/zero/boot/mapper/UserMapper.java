package com.zero.boot.mapper;

import com.zero.boot.po.User;
import com.zero.boot.po.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @authon yuan
 * @date 2018/1/25 0025
 * @time 10:42
 **/

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(String id);
    
    List<User> selectAllUser();

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
