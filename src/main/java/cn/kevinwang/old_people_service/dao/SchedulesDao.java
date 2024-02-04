package cn.kevinwang.old_people_service.dao;

import cn.kevinwang.old_people_service.model.po.Schedules;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
* @author wang sheng hui
* @description 针对表【schedules】的数据库操作Mapper
* @createDate 2024-02-04 19:59:53
* @Entity cn.kevinwang.old_people_service.model.po.Schedules
*/
public interface SchedulesDao extends BaseMapper<Schedules> {

    boolean
    updateStatusById(@Param("id") Long id, @Param("nextStatus") String nextStatus);
}




