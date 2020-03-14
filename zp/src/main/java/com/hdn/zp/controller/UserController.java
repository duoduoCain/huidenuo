package com.hdn.zp.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.hdn.zp.model.User;
import com.hdn.zp.service.UserService;
import com.hdn.zp.utils.R;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


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
   * @param id id
   * @return R
   */
  @GetMapping("/{id}")
  public R getById(@PathVariable("id") Integer id){
    return new R<>(userService.getById(id));
  }

  /**
   * 新增
   * @param user 
   * @return R
   */

  @PostMapping
  public R save(@RequestBody User user){
    return new R<>(userService.save(user));
  }

  /**
   * 修改
   * @param user 
   * @return R
   */

  @PutMapping
  public R updateById(@RequestBody User user){
    return new R<>(userService.updateById(user));
  }

  /**
   * 通过id删除
   * @param id id
   * @return R
   */

  @DeleteMapping("/{id}")
  public R removeById(@PathVariable Integer id){
    return new R<>(userService.removeById(id));
  }

}
