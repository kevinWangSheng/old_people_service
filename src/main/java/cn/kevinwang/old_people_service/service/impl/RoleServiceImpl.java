package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.kevinwang.old_people_service.model.po.Role;
import cn.kevinwang.old_people_service.service.RoleService;
import cn.kevinwang.old_people_service.dao.RoleMapper;
import org.springframework.stereotype.Service;

/**
* @author wang sheng hui
* @description 针对表【role(用户角色表)】的数据库操作Service实现
* @createDate 2024-02-04 19:59:53
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

}




