package cn.kevinwang.old_people_service.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 护工服务记录表
 * @TableName service_records
 */
@TableName(value ="service_records")
@Data
public class ServiceRecords implements Serializable {
    /**
     * 主键id
     */
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

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ServiceRecords other = (ServiceRecords) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCaregiverId() == null ? other.getCaregiverId() == null : this.getCaregiverId().equals(other.getCaregiverId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getServiceDate() == null ? other.getServiceDate() == null : this.getServiceDate().equals(other.getServiceDate()))
            && (this.getServiceTime() == null ? other.getServiceTime() == null : this.getServiceTime().equals(other.getServiceTime()))
            && (this.getServiceContent() == null ? other.getServiceContent() == null : this.getServiceContent().equals(other.getServiceContent()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getFeedback() == null ? other.getFeedback() == null : this.getFeedback().equals(other.getFeedback()))
            && (this.getCreatedAt() == null ? other.getCreatedAt() == null : this.getCreatedAt().equals(other.getCreatedAt()))
            && (this.getUpdatedAt() == null ? other.getUpdatedAt() == null : this.getUpdatedAt().equals(other.getUpdatedAt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCaregiverId() == null) ? 0 : getCaregiverId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getServiceDate() == null) ? 0 : getServiceDate().hashCode());
        result = prime * result + ((getServiceTime() == null) ? 0 : getServiceTime().hashCode());
        result = prime * result + ((getServiceContent() == null) ? 0 : getServiceContent().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getFeedback() == null) ? 0 : getFeedback().hashCode());
        result = prime * result + ((getCreatedAt() == null) ? 0 : getCreatedAt().hashCode());
        result = prime * result + ((getUpdatedAt() == null) ? 0 : getUpdatedAt().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", caregiverId=").append(caregiverId);
        sb.append(", userId=").append(userId);
        sb.append(", serviceDate=").append(serviceDate);
        sb.append(", serviceTime=").append(serviceTime);
        sb.append(", serviceContent=").append(serviceContent);
        sb.append(", status=").append(status);
        sb.append(", feedback=").append(feedback);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}