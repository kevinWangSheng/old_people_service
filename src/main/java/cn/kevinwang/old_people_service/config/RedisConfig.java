package cn.kevinwang.old_people_service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author wang
 * @create 2024-01-30-11:54
 */
@Configuration
public class RedisConfig {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.password}")
    private String password;

    // 配置Jedis
    @Bean
    public Jedis jedis() {
        JedisPoolConfig config = new JedisPoolConfig();

        config.setMaxIdle(8);
        config.setMaxTotal(50);

        JedisPool jedisPool = new JedisPool(config, host, port, 10000, password);

        return jedisPool.getResource();

    }
}
