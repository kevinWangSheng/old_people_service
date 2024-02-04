package cn.kevinwang.old_people_service.model.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

/**
 * @author wang
 * @create 2024-02-04-20:09
 */
public class ServiceRecordsDto {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCaregiverId() {
        return caregiverId;
    }

    public void setCaregiverId(Long caregiverId) {
        this.caregiverId = caregiverId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public Date getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(Date serviceTime) {
        this.serviceTime = serviceTime;
    }

    public String getServiceContent() {
        return serviceContent;
    }

    public void setServiceContent(String serviceContent) {
        this.serviceContent = serviceContent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
