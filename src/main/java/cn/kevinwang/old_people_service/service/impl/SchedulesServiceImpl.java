package cn.kevinwang.old_people_service.service.impl;

import cn.kevinwang.old_people_service.dao.ServiceStatusDao;
import cn.kevinwang.old_people_service.model.dto.SchedulesDto;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.kevinwang.old_people_service.model.po.Schedules;
import cn.kevinwang.old_people_service.service.SchedulesService;
import cn.kevinwang.old_people_service.dao.SchedulesDao;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
* @author wang sheng hui
* @description 针对表【schedules】的数据库操作Service实现
* @createDate 2024-02-04 19:59:53
*/
@Service
public class SchedulesServiceImpl extends ServiceImpl<SchedulesDao, Schedules>
    implements SchedulesService{

    @Resource
    private ServiceStatusDao serviceStatusDao;

    @Resource
    private SchedulesDao schedulesDao;

    @Override
    public boolean updateToNextStatus(SchedulesDto schedulesDto) {
        String nextStatus = serviceStatusDao.selectNextStatusByCurrentStatus(schedulesDto.getStatus());

        return schedulesDao.updateStatusById(schedulesDto.getId(), nextStatus);
    }
}




