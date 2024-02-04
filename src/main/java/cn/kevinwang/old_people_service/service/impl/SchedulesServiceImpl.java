package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.kevinwang.old_people_service.model.po.Schedules;
import cn.kevinwang.old_people_service.service.SchedulesService;
import cn.kevinwang.old_people_service.dao.SchedulesMapper;
import org.springframework.stereotype.Service;

/**
* @author wang sheng hui
* @description 针对表【schedules】的数据库操作Service实现
* @createDate 2024-02-04 19:59:53
*/
@Service
public class SchedulesServiceImpl extends ServiceImpl<SchedulesMapper, Schedules>
    implements SchedulesService{

}




