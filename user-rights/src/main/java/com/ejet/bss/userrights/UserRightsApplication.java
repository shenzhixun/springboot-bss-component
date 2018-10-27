package com.ejet.bss.userrights;

import com.ejet.CommWebApplication;
import com.ejet.bss.userinfo.UserInfoApplication;
import com.ejet.comm.redis.CommWebRedisApplication;
import com.ejet.global.CoGlobal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.List;

@EnableTransactionManagement // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@SpringBootApplication()
@EnableCaching
public class UserRightsApplication extends SpringBootServletInitializer {
    private static final Logger logger = LoggerFactory.getLogger(UserRightsApplication.class);

    @Autowired
    private static CoGlobal global;

    //每一个模块，都可以有自己的启动回调实现接口，只需要将实现类添加进去即可
    static {
        logger.info("======== [comm-bss-userrights] init ======");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(UserRightsApplication.class);
    }

    public static void main(String[] args) {

        List<Class> list  = new ArrayList<>();
        list.add(UserRightsApplication.class);        //本项目
        list.add(CommWebApplication.class);          //基础项目
        list.add(CommWebRedisApplication.class);     //redis项目
        list.add(UserInfoApplication.class);        //userinfo项目

        SpringApplication.run(list.toArray(new Class[list.size()]), args);

        logger.info("======== [comm-bss-userrights] start  ======");
    }



}