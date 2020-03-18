package com.hdn.zp.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hdn.zp.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author pigx code generator
 * @date 2020-03-10 10:30:06
 */
public interface UserMapper extends BaseMapper<User> {

    public List<User> selectList( User user);

    public int insertUser( List<User> user);

    public int updateUser( List<User> user);

    public int deleteUser( Long id);

}
