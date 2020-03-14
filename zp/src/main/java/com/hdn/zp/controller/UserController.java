package com.hdn.zp.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.hdn.zp.model.Resume;
import com.hdn.zp.model.User;
import com.hdn.zp.service.UserService;
import com.hdn.zp.utils.R;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 *
 *
 * @author pigx code generator
 * @date 2020-03-10 10:30:06
 */
@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

  private final UserService userService;

  /**
   * 分页查询
   * @param page 分页对象
   * @param user
   * @return
   */
  @GetMapping("/page")
  public R getUserPage(Page page, User user) {
    return  new R<>(userService.page(page,Wrappers.query(user)));
  }


  /**
   * 通过id查询
   * @param user id
   * @return R
   */
  @GetMapping
  public List<User> getselectListUser(User  user){
    return userService.selectList(user);
  }

  /**
   * 新增
   * @param user
   * @return R
   */

  @PostMapping
  public  int  getinsertUser(List<User>  user){
    return  userService.insertUser(user);
  }
  /**
   * 修改
   * @param user
   * @return R
   */

  @PutMapping
  public  int  getupdateUser(List<User>  user){
    return  userService.updateUser(user);
  }

  /**
   * 通过id删除
   * @param id id
   * @return R
   */

  @DeleteMapping("/{id}")
  public  int  getdeleteUser(Long id){
    return  userService.deleteUser(id);
  }

}
