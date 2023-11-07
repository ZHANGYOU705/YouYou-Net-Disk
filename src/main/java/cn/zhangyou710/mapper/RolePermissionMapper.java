package cn.zhangyou710.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.zhangyou710.model.RolePermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色权限关联表mapper接口
 *
 * @author ZhangYou
 * @date 2023/10/12
 */
@Mapper
public interface RolePermissionMapper extends BaseMapper<RolePermission> {

    /**
     * 根据角色code码集合查询所有权限标识
     *
     * @param roleCodes 角色code码集合
     * @return
     */
    List<String> selectPermissionByRoles(@Param("roleCodes") List<String> roleCodes);
}
