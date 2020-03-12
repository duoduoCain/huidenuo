package com.hdn.zp.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

@Getter
@Setter
public class SysRole {
    private static final long serialVersionUID = 1L;

    /** 角色ID */
    private Long roleId;

    /** 角色名称 */
    private String roleName;

    /** 角色权限 */
    private String roleKey;

    /** 角色排序 */
    private String roleSort;

    /** 用户类型 */
    private String userType;

    /** 数据范围（1：所有数据权限；2：自定数据权限） */
    private String dataScope;

    /** 角色状态（0正常 1停用） */
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 用户是否存在此角色标识 默认不存在 */
    private boolean flag = false;

    /** 菜单组 */
    private List<Long> menuIds;

    /** 部门组（数据权限） */
    private Long[] deptIds;

    /** 商户ID **/
    private Long mercId;



    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("roleId", getRoleId())
                .append("roleName", getRoleName()).append("roleKey", getRoleKey()).append("roleSort", getRoleSort())
                .append("dataScope", getDataScope()).append("status", getStatus()).append("delFlag", getDelFlag())
                .toString();
    }

}

