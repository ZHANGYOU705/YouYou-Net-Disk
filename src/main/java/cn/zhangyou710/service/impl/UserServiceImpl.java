package cn.zhangyou710.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.zhangyou710.common.constant.CommonConstant;
import cn.zhangyou710.common.exception.BusinessException;
import cn.zhangyou710.mapper.RoleMapper;
import cn.zhangyou710.mapper.UserMapper;
import cn.zhangyou710.mapper.UserRoleMapper;
import cn.zhangyou710.model.Role;
import cn.zhangyou710.model.User;
import cn.zhangyou710.model.UserRole;
import cn.zhangyou710.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 用户业务接口实现
 *
 * @author ZhangYou
 * @date 2023/10/16
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final UserMapper userMapper;
    private final UserRoleMapper userRoleMapper;

    private final RoleMapper roleMapper;

    @Override
    public boolean doLogin(String username, String password, boolean rememberMe) {
        User u = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUsername, username));
        if (u == null) {
            throw new BusinessException("用户不存在");
        }
        if (!SaSecureUtil.sha256(password).equals(u.getPassword())) {
            throw new BusinessException("密码不正确");
        }
        StpUtil.login(u.getId(), rememberMe);
        return true;
    }

    @Override
    public boolean addUser(User user) {
        if (userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUsername, user.getUsername())) != null) {
            throw new BusinessException("用户名已存在");
        }
        user.setPassword(SaSecureUtil.sha256(user.getPassword()));
        if (baseMapper.insert(user) <= 0) {
            throw new BusinessException("用户新增失败");
        }
        //给用户设置基本角色
        UserRole ur = new UserRole();
        ur.setUserId(user.getId());
        ur.setRoleId(roleMapper.selectOne(new LambdaQueryWrapper<Role>().eq(Role::getRoleCode, CommonConstant.ROLE_USER)).getId());
        if (userRoleMapper.insert(ur) <= 0) {
            throw new BusinessException("用户新增失败");
        }
        return true;
    }
}
