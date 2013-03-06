package org.xmx0632.management.api.v1.interceptor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springside.modules.utils.Encodes;
import org.xmx0632.management.api.v1.Constant;
import org.xmx0632.management.entity.UserAccount;
import org.xmx0632.management.service.UserAccountService;

public class RequestValidationInterceptor implements HandlerInterceptor {

	private static Logger log = LoggerFactory
			.getLogger(RequestValidationInterceptor.class);

	@Autowired
	private UserAccountService userAccountService;


	public RequestValidationInterceptor() {
	}

	/**
	 * 在业务处理器处理请求之前被调用 如果返回false 从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
	 * 
	 * 如果返回true 执行下一个拦截器,直到所有的拦截器都执行完毕 再执行被拦截的Controller 然后进入拦截器链,
	 * 从最后一个拦截器往回执行所有的postHandle() 接着再从最后一个拦截器往回执行所有的afterCompletion()
	 * 
	 * @throws IOException
	 * @throws ServletException
	 * 
	 * @throws Exception
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HttpStatus status = isValidUser(request);
		if (HttpStatus.OK.equals(status)) {
			return true;
		}
		response.sendError(status.value());
		return false;
	}

	private HttpStatus isValidUser(HttpServletRequest request) {
		String auth = request.getHeader(Constant.AUTH);
		log.debug("auth in head:{}", auth);
		try {
			if (auth == null) {
				log.debug("auth is null in header");
				return HttpStatus.UNAUTHORIZED;
			}

			byte[] decodeBase64 = Encodes.decodeBase64(auth);
			String usernameAndPassword = new String(decodeBase64, "utf-8");
			log.debug("usernameAndPassword:{}", usernameAndPassword);
			String[] s = usernameAndPassword.split("\\:");
			if (s == null || s.length != 2) {
				log.debug("invalid auth [{}] in header", usernameAndPassword);
				return HttpStatus.UNAUTHORIZED;
			}

			String username = s[0];
			String password = s[1];
			if (StringUtils.isBlank(password)) {
				log.info("blank password with username:{},maybe attack request!");
				return HttpStatus.UNAUTHORIZED;
			}

			UserAccount userAccount = userAccountService
					.findByUsername(username);
			if (userAccount != null) {
				if (isValid(password, userAccount)) {
					if (userAccount.isNormal()) {
						request.setAttribute(Constant.CURRENT_USER, userAccount);
						return HttpStatus.OK;
					} else {
						log.debug("banned user:{} attempt login", username);
						return HttpStatus.FORBIDDEN;
					}
				}
			}
		} catch (Exception e) {
			log.error("auth error for [" + auth + "]. " + e.getMessage(), e);
		}
		return HttpStatus.UNAUTHORIZED;
	}

	private boolean isValid(String password, UserAccount userAccountFromErp) {
		String passwordMd5 = DigestUtils.md5Hex(password);
		log.debug("passwordMd5:{}", passwordMd5);
		return passwordMd5.equals(userAccountFromErp.getPassword());
		// return password.equals(userAccountFromErp.getPassword());
	}

	/**
	 * 在业务处理器处理请求执行完成后,生成视图之前执行的动作
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	/**
	 * 在DispatcherServlet完全处理完请求后被调用
	 * 
	 * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}