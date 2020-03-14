package com.hdn.zp.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.hdn.zp.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 *
 * @author pigx code generator
 * @date 2020-03-10 10:30:06
 */
public interface UserService extends IService<User> {


    public List<User> selectList(@Param("user") User user);

    public int insertUser(@Param("user") List<User> user);

    public int updateUser(@Param("user") List<User> user);

    public int deleteUser(@Param("id") Long id);
}
