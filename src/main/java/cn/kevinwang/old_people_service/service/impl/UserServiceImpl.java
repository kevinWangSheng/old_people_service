package cn.kevinwang.old_people_service.service.impl;

import cn.kevinwang.old_people_service.dao.UserDao;
import cn.kevinwang.old_people_service.model.po.User;
import cn.kevinwang.old_people_service.service.UserService;
import cn.kevinwang.old_people_service.util.EcryptUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;

/**
 * @author wang
 * @create 2024-01-29-23:11
 */
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    @Resource
    private UserDao userDao;
    @Override
    public boolean registry(User user) {
        user.setPassword(EcryptUtil.encode(user.getPassword()));
        return save(user);
    }

    @Override
    public User login(String username, String password) {
        User user = userDao.getUsernameAndPasswordByUsername(username);
        // 这里如果涉及到登录不存在就注册的话，应该是用手机号，或者邮箱。
        if(null == user){
            user = new User();
            user.setPassword(password);
            user.setUsername(username);
            if (registry(user)) {
                return user;
            } else {
                throw new RuntimeException("登录并且,注册失败");
            }
        }
        if(EcryptUtil.matches(password,user.getPassword())){
            return user;
        }
        throw new RuntimeException("用户名或者密码错误");
    }

    @Override
    public User loginByPhone(String phone, String password) {
        User user = userDao.getPhoneAndPasswordByPhone(phone);
        if(null == user){
            user = new User();
            user.setPassword(password);
            user.setPhone(phone);
            if (registry(user)) {
                return user;
            } else {
                throw new RuntimeException("登录并且,注册失败");
            }
        }
        if(EcryptUtil.matches(password,user.getPassword())){
            return user;
        }
        throw new RuntimeException("手机号或者密码错误");
    }

    @Override
    public User loginByEmail(String email, String password) {
        User user = userDao.getEmailAndPasswordByEmail(email);
        if(null == user){
            user = new User();
            user.setPassword(password);
            user.setEmail(email);
            if (registry(user)) {
                return user;
            } else {
                throw new RuntimeException("登录并且,注册失败");
            }
        }
        if(EcryptUtil.matches(password,user.getPassword())){
            return user;
        }
        throw new RuntimeException("用户名或者密码错误");
    }
}
