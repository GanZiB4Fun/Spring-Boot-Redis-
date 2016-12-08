package com.ganzib;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by GanZiB on 16/12/6.
 */
@Controller
public class MainController {

    private RedisUtil redisUtil;

    @RequestMapping("/")
    @Cacheable(value="test")
    public String getSessionId(){
        redisUtil.set("123", "测试");
        System.out.println("进入了方法");
        String string= redisUtil.get("123").toString();
        return string;
    }

}
