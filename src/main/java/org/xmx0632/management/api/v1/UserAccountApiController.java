package org.xmx0632.management.api.v1;

import java.util.Set;

import javax.servlet.ServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.beanvalidator.BeanValidators;
import org.springside.modules.mapper.BeanMapper;
import org.xmx0632.management.api.v1.bo.LoginResponse;
import org.xmx0632.management.api.v1.bo.MobileUser;
import org.xmx0632.management.api.v1.bo.Result;
import org.xmx0632.management.api.v1.bo.UpdateRequest;
import org.xmx0632.management.api.v1.bo.UpdateResponse;
import org.xmx0632.management.api.v1.helper.WebHelper;
import org.xmx0632.management.entity.UserAccount;
import org.xmx0632.management.service.UserAccountService;

/**
 * UserAccount的API的Controller.
 * 
 * @author xmx0632
 */
@Controller
@RequestMapping(value = "/api/v1/user")
public class UserAccountApiController {

	private static Logger log = LoggerFactory
			.getLogger(UserAccountApiController.class);

	@Autowired
	private UserAccountService userAccountService;

	@Autowired
	private Validator validator;

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<LoginResponse> login(ServletRequest request) {

		UserAccount userAccount = getCurrentUser(request);

		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setResult(new Result(Result.SUCCESS, ""));
		loginResponse.setUser(BeanMapper.map(userAccount, MobileUser.class));
		return new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<UpdateResponse> update(
			@RequestBody UpdateRequest updateRequest, ServletRequest request) {
		UserAccount userAccount = getCurrentUser(request);
		log.debug("userAccount:{}", userAccount);

		// 用UpdateRequest决定哪些属性可以被更新
		BeanMapper.copy(updateRequest, userAccount);

		Set<ConstraintViolation<UserAccount>> failures = validator
				.validate(userAccount);
		if (!failures.isEmpty()) {
			UpdateResponse updateResponse = UpdateResponse
					.createFailResponse("invalid property");
			updateResponse.setErr(BeanValidators
					.extractPropertyAndMessage(failures));
			return new ResponseEntity<UpdateResponse>(updateResponse,
					HttpStatus.OK);
		}

		// UpdateRequest
		userAccount.setCustomerName(updateRequest.getCustomerName());
		userAccount.setEmail(updateRequest.getEmail());
		userAccount.setSex(updateRequest.getSex());
		userAccount.setMobile(updateRequest.getMobile());
		userAccountService.saveUserAccount(userAccount);

		UpdateResponse updateResponse = new UpdateResponse();
		updateResponse.setResult(new Result(Result.SUCCESS, ""));

		return new ResponseEntity<UpdateResponse>(updateResponse, HttpStatus.OK);
	}

	private UserAccount getCurrentUser(ServletRequest request) {
		return WebHelper.getCurrentUser(request);
	}

}
