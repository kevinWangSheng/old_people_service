package cn.kevinwang.old_people_service.config;


import cn.kevinwang.old_people_service.security.JwtToken;
import cn.kevinwang.old_people_service.util.JwtUtil;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author wang
 * @create 2024-01-29-23:20
 */
@Component
@Slf4j
public class JwtFilter extends AccessControlFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        log.info("isAccessAllowed");
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServletRequest request = (HttpServletRequest)servletRequest;

        String token = request.getHeader(JwtUtil.HEADER);

        if(null == token){
            return true;
        }

        JwtToken jwtToken = new JwtToken(token);
        try {
            getSubject(servletRequest,servletResponse).login(jwtToken);
        } catch (AuthenticationException e) {
            log.error("login error {}",e.getMessage());
            return false;
        }
        return true;
    }

    private void onLoginFail(ServletResponse response) throws IOException {
        HttpServletResponse httpServletResponse = (HttpServletResponse)response;
        httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        httpServletResponse.getWriter().print("login error");
    }
}
