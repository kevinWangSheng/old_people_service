package cn.kevinwang.old_people_service.model.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

/**
 * @author wang
 * @create 2024-02-04-20:09
 */
public class ServiceRecordDto {
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 护工信息表
     */
    private Long caregiverId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 服务日期
     */
    private Date serviceDate;

    /**
     * 服务时间
     */
    private Date serviceTime;

    /**
     * 服务内容
     */
    private String serviceContent;

    /**
     * 服务状态
     */
    private String status;

    /**
     * 用户反馈
     */
    private String feedback;
}
