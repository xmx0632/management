package org.xmx0632.management.global;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;
import org.xmx0632.management.service.ServiceException;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static Logger log = LoggerFactory
			.getLogger(GlobalExceptionHandler.class);

	/**
	 * 全局异常处理:不在页面显示详细错误信息在这里设置
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler
	public ModelAndView handleException(Exception ex) {
		return handleExceptions(ex);
	}

	@ExceptionHandler
	ModelAndView handleMaxUploadSizeExceededException(
			MaxUploadSizeExceededException ex) {
		return handleExceptions(ex);
	}

	@ExceptionHandler
	ModelAndView handleBindException(BindException ex) {
		return handleExceptions(ex);
	}

	@ExceptionHandler
	ModelAndView handleServiceException(ServiceException ex) {
		return handleExceptions(ex);
	}

	private ModelAndView handleExceptions(Exception ex) {
		log.error(ex.getMessage(), ex);
		ModelAndView mav = new ModelAndView("error/exception");
		mav.addObject("exception", ex);
		return mav;
	}
}
