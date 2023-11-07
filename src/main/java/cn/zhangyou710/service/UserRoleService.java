package cn.zhangyou710.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.zhangyou710.model.UserRole;

import java.util.List;

/**
 * @author ZhangYou
 * @Date: 2023/6/30 10:19
 */
public interface UserRoleService extends IService<UserRole> {

    List<String> getRoleByUserId(Long userId);
}
