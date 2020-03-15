package com.hdn.zp.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.hdn.zp.model.Resume;
import com.hdn.zp.model.User;
import com.hdn.zp.service.UserService;
import com.hdn.zp.utils.R;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
  @RequestMapping(value = "getselectListUser",method = RequestMethod.GET)
  public R getselectListUser(User  user){
    return R.ok(userService.selectList(user));
  }

  /**
   * 新增
   * @param user
   * @return R
   */

  @RequestMapping(value = "getinsertUser",method = RequestMethod.POST)
  public  R  getinsertUser(@RequestBody User  user){
    List<User>  list =new ArrayList<>();
    list.add(user);
    return  R.ok(userService.insertUser(list));
  }
  /**
   * 修改
   * @param user
   * @return R
   */

  @RequestMapping(value = "getupdateUser",method = RequestMethod.POST)
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
