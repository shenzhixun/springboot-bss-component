package com.ejet.bss.userinfo.interceptor;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.interceptor.InterceptorBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	Logger logger = LoggerFactory.getLogger(com.ejet.interceptor.TokenAuthInterceptor.class);
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
        List<String> excludePathPatterns = new ArrayList<>();
        return excludePathPatterns.toArray(new String[excludePathPatterns.size()]);
    }

//	//拦截请求是否携带token
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
//		try {
//			if (redis == null) {
//		         BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext()); 
//		         redis = (JedisUtilService) factory.getBean("jedisUtilService"); 
//		      }
//			//拦截请求方式POST/GET，如果是GET则直接返回
//			String token = getToken(request);
//			if(null == token || "".equals(token)){
//				responseJson(response, new CoBusinessException(CoReturnFormat.SYS_TOKEN_TIMEOUT));
//				return false;
//			}
//			//从redis中查看token是否存在
//			Object obj = redis.get(token);
//			if(null == obj){
//				responseJson(response, new CoBusinessException(CoReturnFormat.SYS_TOKEN_TIMEOUT));
//				return false;
//			}
//			
//			redis.updateExpires(token , 20L*60) ;
//			
//		} catch (CoBusinessException e) {
//			responseJson(response, e);
//			return false;
//		}
//		return true;
//	}
//	
//	

}
