package com.zero.boot.mapper;

import com.zero.boot.po.Role;
import com.zero.boot.po.RoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @authon yuan
 * @date 2018/1/25 0025
 * @time 10:42
 **/

public interface RoleMapper {
    long countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(String id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(String id);
    
    List<Role> selectAllRole();

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}