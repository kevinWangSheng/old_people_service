package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.kevinwang.old_people_service.model.po.ServiceRecords;
import cn.kevinwang.old_people_service.service.ServiceRecordsService;
import cn.kevinwang.old_people_service.dao.ServiceRecordsMapper;
import org.springframework.stereotype.Service;

/**
* @author wang sheng hui
* @description 针对表【service_records(护工服务记录表)】的数据库操作Service实现
* @createDate 2024-02-04 19:59:53
*/
@Service
public class ServiceRecordsServiceImpl extends ServiceImpl<ServiceRecordsMapper, ServiceRecords>
    implements ServiceRecordsService{

}




