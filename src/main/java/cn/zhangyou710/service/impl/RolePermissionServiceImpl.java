package cn.zhangyou710.service.impl;

import cn.dev33.satoken.stp.StpInterface;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.zhangyou710.mapper.RolePermissionMapper;
import cn.zhangyou710.model.RolePermission;
import cn.zhangyou710.service.RolePermissionService;
import cn.zhangyou710.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author ZhangYou
 * @Date: 2023/6/30 10:15
 */
@Service
@RequiredArgsConstructor
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission> implements RolePermissionService, StpInterface {

    private final UserRoleService userRoleService;

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        List<String> roleCodes = getRoleList(loginId, loginType);
        return baseMapper.selectPermissionByRoles(roleCodes);
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        return userRoleService.getRoleByUserId(Long.parseLong(String.valueOf(loginId)));
    }
}
