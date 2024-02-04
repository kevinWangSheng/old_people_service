package cn.kevinwang.old_people_service.service;

import cn.kevinwang.old_people_service.model.po.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author wang
 * @create 2024-01-29-23:06
 */
public interface UserService extends IService<User> {
    boolean registry(User user);

    User login(String username, String password);

    User loginByPhone(String phone, String password);

    User loginByEmail(String email, String password);

}
