package cn.zhangyou710.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色权限关联表实体
 *
 * @author ZhangYou
 * @date 2023/10/12
 */
@Data
@TableName("sys_role_permission")
@EqualsAndHashCode(callSuper = true)
public class RolePermission extends Model<RolePermission> {

    /**
     * 自增id
     */
    @TableId
    private Long id;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 权限id
     */
    private Long PermissionId;
}
