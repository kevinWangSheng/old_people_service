package cn.kevinwang.old_people_service.dao;

import cn.kevinwang.old_people_service.model.po.ServiceRecords;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
* @author wang sheng hui
* @description 针对表【service_records(护工服务记录表)】的数据库操作Mapper
* @createDate 2024-02-04 19:59:53
* @Entity cn.kevinwang.old_people_service.model.po.ServiceRecords
*/
public interface ServiceRecordsDao extends BaseMapper<ServiceRecords> {

    boolean updateToNextStatusById(@Param("id") Long id, @Param("nextStatus") String nextStatus);
}




