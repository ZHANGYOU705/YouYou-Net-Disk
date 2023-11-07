package cn.zhangyou710.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.zhangyou710.model.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户角色关联表mapper接口
 *
 * @author ZhangYou
 * @date 2023/10/12
 */
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {

    /**
     * 根据用户id查询角色code码集合
     *
     * @param userId 用户id
     * @return
     */
    List<String> selectRoleByUserId(@Param("userId") Long userId);
}
