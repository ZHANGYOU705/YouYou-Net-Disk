package cn.zhangyou710.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.zhangyou710.mapper.UserRoleMapper;
import cn.zhangyou710.model.UserRole;
import cn.zhangyou710.service.UserRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZhangYou
 * @Date: 2023/6/30 10:20
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

    @Override
    public List<String> getRoleByUserId(Long userId) {
        return baseMapper.selectRoleByUserId(userId);
    }
}
