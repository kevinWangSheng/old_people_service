package cn.kevinwang.old_people_service.security;

import cn.kevinwang.old_people_service.util.JwtUtil;
import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author wang
 * @create 2024-01-30-13:53
 */
public class JwtToken implements AuthenticationToken {

    private String token;

    private String username;

    public JwtToken(String token) {
        this.token = token;
        this.username = JwtUtil.getClaimFiled(token,"username");
    }

    @Override
    public Object getPrincipal() {
        return username;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
