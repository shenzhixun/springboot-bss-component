package com.ejet.bss.userinfo.interceptor;

import com.ejet.bss.userinfo.comm.TokenHelper;
import com.ejet.bss.userinfo.global.GlobalUserInfo;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.comm.exception.ExceptionCode;
import com.ejet.comm.redis.RedisServiceHelper;
import com.ejet.context.CoApplicationContext;
import com.ejet.interceptor.InterceptorBase;
import com.ejet.utils.HttpServletResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
/**
 * 用户Token验证拦截器
 *
 */
@Component
public class TokenAuthInterceptor extends InterceptorBase {
    Logger logger = LoggerFactory.getLogger(TokenAuthInterceptor.class);
    @Autowired
    RedisServiceHelper redis;
    @Autowired
    GlobalUserInfo globalUserInfo;

    private List<String> excludePath = new ArrayList<>();
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {

	}

    @Override
    public String[] excludePathPatterns() {
        return excludePath.toArray(new String[excludePath.size()]);
        //return new String[]{};
    }

	//拦截请求是否携带token
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		try {
			if (redis == null) {
			    redis = CoApplicationContext.getBean(RedisServiceHelper.class);
			}
			if (globalUserInfo == null) {
                globalUserInfo = CoApplicationContext.getBean(GlobalUserInfo.class);
			}
            String authToken = TokenHelper.getToken(request, globalUserInfo.getAuthTokenKey());
			if(null == authToken || "".equals(authToken)){
				HttpServletResponseUtils.responseJson(response, new CoBusinessException(ExceptionCode.SYS_TOKEN_TIMEOUT));
				return false;
			}
			//从redis中查看token是否存在
			Object obj = redis.get(authToken);
			if(null == obj){
                HttpServletResponseUtils.responseJson(response, new CoBusinessException(ExceptionCode.SYS_TOKEN_TIMEOUT));
				return false;
			}
			//刷新token
			redis.refresh(authToken , globalUserInfo.getAuthTokenTimeout()); ;

		} catch (CoBusinessException e) {
            HttpServletResponseUtils.responseJson(response, new CoBusinessException(ExceptionCode.SYS_ERROR, e));
			return false;
		}
		return true;
	}

    public void setExcludePath(List<String> excludePath) {
	    if(excludePath !=null && excludePath.size()>0) {
            this.excludePath = excludePath;
        }
    }

}
