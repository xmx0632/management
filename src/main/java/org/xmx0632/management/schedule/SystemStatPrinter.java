package org.xmx0632.management.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xmx0632.management.api.v1.helper.ApiStatService;

/**
 * 系统状态信息打印
 * 
 * @author xmx0632
 */
@Component
public class SystemStatPrinter {

	private static Logger logger = LoggerFactory
			.getLogger(SystemStatPrinter.class);

	@Autowired
	private ApiStatService apiStat;

	// 被Spring的Quartz MethodInvokingJobDetailFactoryBean反射执行
	public void executeByQuartzLocalJob() {
		String infos = apiStat.getApiInvokeInfo();
		logger.info("==== api invoked stat ====\n"+infos);
	}

}
