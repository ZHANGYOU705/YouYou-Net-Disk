package cn.zhangyou710.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.zhangyou710.model.Permission;
import org.apache.ibatis.annotations.Mapper;

/**
 * 权限表mapper接口
 *
 * @author ZhangYou
 * @date 2023/10/12
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {
}
