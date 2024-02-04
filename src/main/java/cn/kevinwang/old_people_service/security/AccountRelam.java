package cn.kevinwang.old_people_service.security;

import cn.kevinwang.old_people_service.common.Constance;
import cn.kevinwang.old_people_service.exception.OldPeopleException;
import cn.kevinwang.old_people_service.model.po.User;
import cn.kevinwang.old_people_service.service.UserService;
import cn.kevinwang.old_people_service.util.JwtUtil;
import cn.kevinwang.old_people_service.util.RedisUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.jsonwebtoken.Claims;
import jakarta.annotation.Resource;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

/**
 * @author wang
 * @create 2024-01-30-13:58
 */
@Component("accountRealm")
public class AccountRelam extends AuthorizingRealm {
    @Resource
    private UserService userService;

    @Resource
    private RedisUtil redisUtil;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String jwt = (String)authenticationToken.getPrincipal();
        String username  = JwtUtil.getClaimsByToken(jwt).getSubject();

        User user = userService.getOne(new LambdaQueryWrapper<User>().eq(User::getUsername, username));
        if(null == user){
            throw new OldPeopleException("用户不存在");
        }

        if ( null != redisUtil.get(username+jwt)) {
            throw new OldPeopleException("token已过期，请重新登录");
        }
        redisUtil.set(username+jwt,username, Constance.EXPIRE_TIME);
        return new SimpleAuthenticationInfo(user,jwt,this.getName());
    }
}
