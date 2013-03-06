package org.xmx0632.management.api.v1.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.xmx0632.management.api.v1.helper.ApiStatHelper;
import org.xmx0632.management.api.v1.helper.ApiStatService;

@Component
public class ApiStatInterceptor implements HandlerInterceptor {

	private static Logger log = LoggerFactory
			.getLogger(ApiStatInterceptor.class);

	@Autowired
	private ApiStatService apiStatService;

	public void setApiStatService(ApiStatService apiStat) {
		this.apiStatService = apiStat;
	}

	public ApiStatInterceptor() {
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String handlerValue = handler.toString();
		String[] methodStringArray = StringUtils.split(handlerValue);
		String methodName = methodStringArray[methodStringArray.length - 1];
		String apiName = ApiStatHelper.getShortMethodName(methodName);
		int counter = apiStatService.increaseCounter(apiName);
		log.debug("apiName:{} current:{}", apiName, counter);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}