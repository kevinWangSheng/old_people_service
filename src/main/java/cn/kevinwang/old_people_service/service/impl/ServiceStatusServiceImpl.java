package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.kevinwang.old_people_service.model.po.ServiceStatus;
import cn.kevinwang.old_people_service.service.ServiceStatusService;
import cn.kevinwang.old_people_service.dao.ServiceStatusMapper;
import org.springframework.stereotype.Service;

/**
* @author wang sheng hui
* @description 针对表【service_status(护工流程记录)】的数据库操作Service实现
* @createDate 2024-02-04 19:59:53
*/
@Service
public class ServiceStatusServiceImpl extends ServiceImpl<ServiceStatusMapper, ServiceStatus>
    implements ServiceStatusService{

}




