package cn.kevinwang.old_people_service.dao;

import cn.kevinwang.old_people_service.model.po.ServiceStatus;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
* @author wang sheng hui
* @description 针对表【service_status(护工流程记录)】的数据库操作Mapper
* @createDate 2024-02-04 19:59:53
* @Entity cn.kevinwang.old_people_service.model.po.ServiceStatus
*/
public interface ServiceStatusDao extends BaseMapper<ServiceStatus> {

    String selectNextStatusByCurrentStatus(@Param("status") String status);
}




