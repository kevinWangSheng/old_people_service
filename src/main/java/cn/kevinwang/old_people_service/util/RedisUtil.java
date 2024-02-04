package cn.kevinwang.old_people_service.util;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

/**
 * @author wang
 * @create 2024-02-03-10:38
 */
@Component
public class RedisUtil {
    @Resource
    private Jedis jedis;

    public void set(String key,String value){
        jedis.set(key,value);
    }

    public String get(String key){
        return jedis.get(key);
    }

    public void del(String key){
        jedis.del(key);
    }

    public void expire(String key,int seconds){
        jedis.expire(key,seconds);
    }

    public void set(String key,String value,long seconds){
        jedis.setex(key,seconds,value);
    }

    public void hset(String key,String field,String value){
        jedis.hset(key,field,value);
    }

    public String hget(String key,String field){
        return jedis.hget(key,field);
    }

    public void hdel(String key,String field){
        jedis.hdel(key,field);
    }

    public void hset(String key,String field,String value,int seconds){
        jedis.hset(key,field,value);
        jedis.expire(key,seconds);
    }
}
