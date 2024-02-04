package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.kevinwang.old_people_service.model.po.Caregivers;
import cn.kevinwang.old_people_service.service.CaregiversService;
import cn.kevinwang.old_people_service.dao.CaregiversMapper;
import org.springframework.stereotype.Service;

/**
* @author wang sheng hui
* @description 针对表【caregivers(护工信息表)】的数据库操作Service实现
* @createDate 2024-02-04 19:59:53
*/
@Service
public class CaregiversServiceImpl extends ServiceImpl<CaregiversMapper, Caregivers>
    implements CaregiversService{

}




