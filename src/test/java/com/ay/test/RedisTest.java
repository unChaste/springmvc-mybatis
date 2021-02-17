package com.ay.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

public class RedisTest extends BaseJUnit4Test {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testRedis() {
        redisTemplate.opsForValue().set("cat:kitty", "hello redis");
        String greeting = (String) redisTemplate.opsForValue().get("hello");
        System.out.println("value of greeting is:" + greeting);
    }

    @Test
    public void testRedisTwo() {
        Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
//Jedis Cluster will attempt to discover cluster nodes automatically
        jedisClusterNodes.add(new HostAndPort("47.105.232.231", 6379));
        JedisCluster jc = new JedisCluster(jedisClusterNodes);
        jc.set("foo", "bar");
        String value = jc.get("foo");
    }

    @Test
    public void testRedisSet() {
        redisTemplate.opsForSet().add("fruit", "apple", "pear", "cherry");
        boolean isMember = redisTemplate.opsForSet().isMember("fruit", "apple");
        System.out.println("apple is member Of set fruit?" + isMember);
        Long apple = redisTemplate.opsForSet().remove("fruit", "apple");
        System.out.println("remove result :" + apple);
        Set fruit = redisTemplate.opsForSet().members("praise:2");
        System.out.println(fruit);
    }
}
