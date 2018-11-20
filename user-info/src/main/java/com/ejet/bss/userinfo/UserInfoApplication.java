package com.ejet.bss.userinfo;

import com.ejet.CommWebApplication;
import com.ejet.bss.userinfo.comm.LoadResourceUtils;
import com.ejet.bss.userinfo.global.GlobalUserInfo;
import com.ejet.bss.userinfo.interceptor.TokenAuthInterceptor;
import com.ejet.comm.redis.CommWebRedisApplication;
import com.ejet.context.CoApplicationContext;
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
public class UserInfoApplication extends SpringBootServletInitializer {
    private static final Logger logger = LoggerFactory.getLogger(UserInfoApplication.class);

    //每一个模块，都可以有自己的启动回调实现接口，只需要将实现类添加进去即可
    static {
        logger.info("======== [comm-bss-bss-userinfo] init ======");
        BssUserInfoAppCallback callback = new BssUserInfoAppCallback();
        CoApplicationContext.getInstance().addApplicationBootCallback(callback);

        GlobalUserInfo tokenConf = LoadResourceUtils.loadTokenAuth();
        if(tokenConf.isTokenAuth()) {
            TokenAuthInterceptor tokenInterceptor = new TokenAuthInterceptor();
            tokenInterceptor.setName("authToken");
            tokenInterceptor.setExcludePath(tokenConf.getAuthTokenIgnoreURL());
            CoApplicationContext.addInterceptor(tokenInterceptor);
        }
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(UserInfoApplication.class);
    }

    public static void main(String[] args) {
        List<Class> list  = new ArrayList<>();
        list.add(UserInfoApplication.class);        //本项目
        list.add(CommWebApplication.class);         //基础项目
        list.add(CommWebRedisApplication.class);    //redis项目
        SpringApplication.run(list.toArray(new Class[list.size()]), args);
        logger.info("======== start ======");
    }



}
