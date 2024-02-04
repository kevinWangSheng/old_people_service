package cn.kevinwang.old_people_service.dao;

import cn.kevinwang.old_people_service.model.po.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author wang
 * @create 2024-01-29-22:44
 */
public interface UserDao extends BaseMapper<User> {
    User getUsernameAndPasswordByUsername(@Param("username") String username);

    User getPhoneAndPasswordByPhone(@Param("phone") String phone);

    User getEmailAndPasswordByEmail(@Param("email") String email);
}
