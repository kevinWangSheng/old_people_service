package cn.kevinwang.old_people_service.handler;

import cn.kevinwang.old_people_service.common.Result;
import cn.kevinwang.old_people_service.exception.OldPeopleException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/** 全局异常处理
 * @author wang
 * @create 2024-01-30-12:07
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(OldPeopleException.class)
    @ResponseBody
    public Result handleOldPeopleException(OldPeopleException e){
        log.error("老人服务异常：----------------{}",e.getMessage());
        return Result.fail(e.getMessage());
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public Result handleNullPointerException(NullPointerException e){
        log.error("空指针异常：----------------{}",e.getMessage());
        return Result.fail(e.getMessage());
    }
}
