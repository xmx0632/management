package org.xmx0632.management.utilities.email;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * MIME邮件服务类.
 * 
 * 演示由Freemarker引擎生成的的html格式邮件, 并带有附件.
 * 
 * @author calvin
 */
public class MimeMailService {

	private static final String DEFAULT_ENCODING = "utf-8";

	private static Logger logger = LoggerFactory
			.getLogger(MimeMailService.class);

	private JavaMailSender mailSender;

	private Template template;

	/**
	 * 发送MIME格式的通知邮件.
	 */
	public void sendNotificationMail(
			SendNotificationMailParameter... mailParams) {
		try {
			List<MimeMessage> mimeMessages = new ArrayList<MimeMessage>();
			for (SendNotificationMailParameter param : mailParams) {
				MimeMessage msg = mailSender.createMimeMessage();
				MimeMessageHelper helper = new MimeMessageHelper(msg, true,
						DEFAULT_ENCODING);
				helper.setTo(param.getTo());
				helper.setFrom(param.getFrom());
				helper.setSubject(param.getSubject());

				String content = generateContent(param.getUserName(),
						param.getResetUrl());
				helper.setText(content, true);
				mimeMessages.add(msg);
				logger.info("HTML版邮件已经准备好发送至{}", param.getTo());
			}
			logger.debug("start send mail");
			mailSender.send(mimeMessages.toArray(new MimeMessage[mimeMessages
					.size()]));
			logger.debug("end send mail");

		} catch (MessagingException e) {
			logger.error("构造邮件失败", e);
		} catch (Exception e) {
			logger.error("发送邮件失败", e);
		}
	}

	/**
	 * 使用Freemarker生成html格式内容.
	 * 
	 */
	private String generateContent(String userName, String resetUrl)
			throws MessagingException {

		try {
			Map<String, String> context = new HashMap<String, String>();
			context.put("userName", userName);
			context.put("url", resetUrl);

			return FreeMarkerTemplateUtils.processTemplateIntoString(template,
					context);
		} catch (IOException e) {
			logger.error("生成邮件内容失败, FreeMarker模板不存在", e);
			throw new MessagingException("FreeMarker模板不存在", e);
		} catch (TemplateException e) {
			logger.error("生成邮件内容失败, FreeMarker处理失败", e);
			throw new MessagingException("FreeMarker处理失败", e);
		}
	}

	/**
	 * Spring的MailSender.
	 */
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	/**
	 * 注入Freemarker引擎配置,构造Freemarker 邮件内容模板.
	 */
	public void setFreemarkerConfiguration(Configuration freemarkerConfiguration)
			throws IOException {
		// 根据freemarkerConfiguration的templateLoaderPath载入文件.
		template = freemarkerConfiguration.getTemplate("mailTemplate.ftl",
				DEFAULT_ENCODING);
	}

}
