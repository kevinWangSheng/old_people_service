package cn.kevinwang.old_people_service.model.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;

/**
 * @author wang
 * @create 2024-01-29-22:40
 */
@TableName("users")
public class Users {
    @TableId
    private Long id;

    @TableField("username")
    private String username;

    @TableField("password")
    private String password;

    @TableField("email")
    private String email;

    @TableField("phone")
    private String phone;


    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime registeredAt;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime lastLoginAt;

}
