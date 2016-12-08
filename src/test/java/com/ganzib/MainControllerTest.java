package com.ganzib;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

/**
 * Created by GanZiB on 16/12/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(RedisApplication.class)
public class MainControllerTest {

    private Jedis jedis = new Jedis("localhost");

    /**
     * 连接测试
     * @throws Exception
     */
    @Test
    public void test() throws Exception {

        System.out.println("连接成功");
        System.out.println("服务正在运行："+jedis.ping());

    }


    /**
     * 字符串测试
     * @throws Exception
     */
    @Test
    public void StringTest() throws Exception{
        System.out.println("连接成功");
        System.out.println("服务正在运行："+jedis.ping());
        jedis.set("GanZiB","${GanZiB.redis}");
        System.out.println("保存的字符串为:"+jedis.get("GanZiB"));
    }

    /**
     * 列表测试
     * @throws Exception
     */
    @Test
    public void ListTest() throws Exception{
        System.out.println("连接成功");
        System.out.println("服务正在运行："+jedis.ping());
        jedis.lpush("tutorial-list", "Redis");
        jedis.lpush("tutorial-list", "Mongodb");
        jedis.lpush("tutorial-list", "Mysql");
        List<String> list = jedis.lrange("tutorial-list", 0 ,5);
        for(String string : list) {
            System.out.println("Stored string in redis:: "+string.toString());
        }

    }

    @Test
    public void jianTest() throws Exception{
        System.out.println("连接成功");
        System.out.println("服务正在运行："+jedis.ping());
        Set<String> set = jedis.keys("*");
        for(int i=0; i<set.size(); i++) {
            System.out.println("List of stored keys:: "+set.size());
        }
    }

}