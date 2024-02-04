package cn.kevinwang.old_people_service.service.impl;

import cn.kevinwang.old_people_service.dao.ServiceStatusDao;
import cn.kevinwang.old_people_service.model.dto.ServiceRecordsDto;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.kevinwang.old_people_service.model.po.ServiceRecords;
import cn.kevinwang.old_people_service.service.ServiceRecordsService;
import cn.kevinwang.old_people_service.dao.ServiceRecordsDao;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
* @author wang sheng hui
* @description 针对表【service_records(护工服务记录表)】的数据库操作Service实现
* @createDate 2024-02-04 19:59:53
*/
@Service
public class ServiceRecordsServiceImpl extends ServiceImpl<ServiceRecordsDao, ServiceRecords>
    implements ServiceRecordsService{

    @Resource
    private ServiceRecordsDao serviceRecordsDao;

    @Resource
    private ServiceStatusDao serviceStatusDao;

    @Override
    public boolean updateToNextStatus(ServiceRecordsDto serviceRecordDto) {
        String nextStatus = serviceStatusDao.selectNextStatusByCurrentStatus(serviceRecordDto.getStatus());

        return serviceRecordsDao.updateToNextStatusById(serviceRecordDto.getId(), nextStatus);
    }
}




