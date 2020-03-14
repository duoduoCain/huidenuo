package com.hdn.zp.service.lmpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdn.zp.dao.UserMapper;
import com.hdn.zp.model.User;
import com.hdn.zp.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 
 *
 * @author pigx code generator
 * @date 2020-03-10 10:30:06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
