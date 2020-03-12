package com.hdn.zp.utils;

import com.hdn.zp.model.SysUser;

/**
 * Created by 多多啦 on 2020/3/12 0012.
 * 时间飞逝
 * time goes by
 * 時間が飛ぶ
 */
public class PasswordUtil {
    public static boolean matches(SysUser user, String newPassword) {
        return user.getPassword().equals(encryptPassword(user.getUsername(), newPassword, user.getSalt()));
    }

    public static String encryptPassword(String username, String password, String salt) {
        return Md5Utils.hash(username + password + salt);
    }
}
