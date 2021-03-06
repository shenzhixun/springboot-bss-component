package com.ejet.bss.userflow;

import com.ejet.CommWebApplication;
import com.ejet.bss.userinfo.UserInfoApplication;
import com.ejet.bss.userrights.UserRightsApplication;
import com.ejet.comm.redis.CommWebRedisApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class UserFlowApplication extends SpringBootServletInitializer {
    private static final Logger logger = LoggerFactory.getLogger(UserFlowApplication.class);


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(UserFlowApplication.class);
    }

    public static void main(String[] args) {

        //每一个模块，都可以有自己的启动回调实现接口，只需要将实现类添加进去即可
        // DynamicServiceCallback callbackImpl = new DynamicServiceCallback();
        // //设置启动回调接口
        // CoApplicationContext.getInstance().addApplicationBootCallback(callbackImpl);

        //增加拦截器
        //CoApplicationContext.addInterceptor(new DynamicURLInterceptor());

        //每个模块都可以有自己的拦截器，过滤器，只需要将相关接口加进去。
        List<Class> list  = new ArrayList<>();
        list.add(UserFlowApplication.class);       //本项目
        list.add(CommWebApplication.class);         //基础项目
        list.add(CommWebRedisApplication.class);     //redis项目
        list.add(UserInfoApplication.class);         //userinfo项目
        list.add(UserRightsApplication.class);        //userrights项目

        SpringApplication.run(list.toArray(new Class[list.size()]), args);

        logger.info("======== start  ======");
    }



}