<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>

<html>
<head>
<title><s:message code="userAccount"/><s:message code="common.management"/></title>

<script>
	$(document).ready(function() {
		
		//聚焦第一个输入框
		$("#userAccount_customerId").focus();
		//为inputForm注册validate函数
		$("#inputForm").validate();
	});
</script>
</head>

<body>
	<div class="row-fluid sortable">
		<div class="box span12">
			<div class="box-header well" data-original-title>
				<h2><i class="icon-edit"></i> <s:message code="common.management"/><s:message code="config"/></h2>
				<div class="box-icon">
				</div>
			</div>
			<div class="box-content">
				<form:form id="inputForm" modelAttribute="userAccount" action="${ctx}/admin/userAccount/${action}" method="post"
					class="form-horizontal">
					<input type="hidden" name="id" value="${userAccount.id}" />
					<fieldset>
						<div class="control-group">
							<label for="userAccount_customerId" class="control-label"><s:message code="userAccount.customerId"/>:</label>
							<div class="controls">
							<input type="text" id="userAccount_customerId" name="customerId"
								value="${userAccount.customerId}" 
								class="input-large required" /> 
							</div>
						</div>
						<div class="control-group">
							<label for="userAccount_customerName" class="control-label"><s:message code="userAccount.customerName"/>:</label>
							<div class="controls">
							<input type="text" id="userAccount_customerName" name="customerName"
								value="${userAccount.customerName}" 
								class="input-large required" /> 
							</div>
						</div>
						<div class="control-group">
							<label for="sex" class="control-label"><s:message code="userAccount.sex"/>:</label>
							<div class="controls">
							<form:bsradiobuttons path="sex" items="${allGender}" labelCssClass="inline"/>
							</div> 
						</div>
						<div class="control-group">
							<label for="userAccount_mobile" class="control-label"><s:message code="userAccount.mobile"/>:</label>
							<div class="controls">
							<input type="text" id="userAccount_mobile" name="mobile"
								value="${userAccount.mobile}" 
								class="input-large required" /> 
							</div>
						</div>
						<div class="control-group">
							<label for="userAccount_telephone" class="control-label"><s:message code="userAccount.telephone"/>:</label>
							<div class="controls">
							<input type="text" id="userAccount_telephone" name="telephone"
								value="${userAccount.telephone}" 
								class="input-large " />
							</div>
						</div>
						<div class="control-group">
							<label for="userAccount_province" class="control-label"><s:message code="userAccount.province"/>:</label>
							<div class="controls">
							<input type="text" id="userAccount_province" name="province"
								value="${userAccount.province}" 
								class="input-large " />
							</div>
						</div>
						<div class="control-group">
							<label for="userAccount_city" class="control-label"><s:message code="userAccount.city"/>:</label>
							<div class="controls">
							<input type="text" id="userAccount_city" name="city"
								value="${userAccount.city}" 
								class="input-large required" /> 
							</div>
						</div>
						<div class="control-group">
							<label for="userAccount_district" class="control-label"><s:message code="userAccount.district"/>:</label>
							<div class="controls">
							<input type="text" id="userAccount_district" name="district"
								value="${userAccount.district}" 
								class="input-large required" /> 
							</div>
						</div>
						<div class="control-group">
							<label for="userAccount_county" class="control-label"><s:message code="userAccount.county"/>:</label>
							<div class="controls">
							<input type="text" id="userAccount_county" name="county"
								value="${userAccount.county}" 
								class="input-large required" /> 
							</div>
						</div>
						<div class="control-group">
							<label for="userAccount_address" class="control-label"><s:message code="userAccount.address"/>:</label>
							<div class="controls">
							<input type="text" id="userAccount_address" name="address"
								value="${userAccount.address}" 
								class="input-large " />
							</div>
						</div>
						<div class="control-group">
							<label for="userAccount_area" class="control-label"><s:message code="userAccount.area"/>:</label>
							<div class="controls">
							<input type="text" id="userAccount_area" name="area"
								value="${userAccount.area}" 
								class="input-large " />
							</div>
						</div>
						<div class="control-group">
							<label for="userAccount_zipCode" class="control-label"><s:message code="userAccount.zipCode"/>:</label>
							<div class="controls">
							<input type="text" id="userAccount_zipCode" name="zipCode"
								value="${userAccount.zipCode}" 
								class="input-large " />
							</div>
						</div>
						<div class="control-group">
							<label for="userAccount_email" class="control-label"><s:message code="userAccount.email"/>:</label>
							<div class="controls">
							<input type="email" id="userAccount_email" name="email"
								value="${userAccount.email}" 
								class="input-large required" /> 
							</div>
						</div>
						<div class="control-group">
							<label for="userAccount_birthday" class="control-label"><s:message code="userAccount.birthday"/>:</label>
							<div class="controls">
							<input type="text" id="userAccount_birthday" name="birthday"
								value="<fmt:formatDate value="${userAccount.birthday}" pattern="yyyy年MM月dd日" />" 
								class="input-large required" /> 
							</div>
						</div>
						<div class="control-group">
							<label for="platform" class="control-label"><s:message code="userAccount.platform"/>:</label>
							<div class="controls">
							<form:bsradiobuttons path="platform" items="${allPlatform}" labelCssClass="inline"/>
							</div>
						</div>
						<div class="control-group">
							<label for="userAccount_username" class="control-label"><s:message code="userAccount.username"/>:</label>
							<div class="controls">
							<input type="text" id="userAccount_username" name="username"
								value="${userAccount.username}" 
								class="input-large required" /> 
							</div>
						</div>
						<div class="control-group">
							<label for="userAccount_password" class="control-label"><s:message code="userAccount.password"/>:</label>
							<div class="controls">
							<input type="password" id="userAccount_password" name="password"
								value="${userAccount.password}" 
								class="input-large required" /> 
							</div>
						</div>
						<div class="control-group">
							<label for="userAccount_account" class="control-label"><s:message code="userAccount.account"/>:</label>
							<div class="controls">
								<div class="input-append">
									<input id="userAccount_account" name="account" size="16" type="text" value="${userAccount.account}" ><span class="add-on">$</span>
								</div>
							</div>
						</div>
						<div class="control-group">
							<label for="userAccount_credit" class="control-label"><s:message code="userAccount.credit"/>:</label>
							<div class="controls">
								<div class="input-prepend input-append">
									<input id="userAccount_credit" name="credit" size="10" type="text" value="${userAccount.credit}" ><span class="add-on">$</span>
								</div>
							</div>
						</div>
						<div class="control-group">
							<label for="userAccount_groupInfo" class="control-label"><s:message code="userAccount.groupInfo"/>:</label>
							<div class="controls">
							<input type="text" id="userAccount_groupInfo" name="groupInfo"
								value="${userAccount.groupInfo}" 
								class="input-large " />
							</div>
						</div>
						<div class="control-group">
							<label for="userAccount_remark" class="control-label"><s:message code="userAccount.remark"/>:</label>
							<div class="controls">
							<textarea id="userAccount_remark" name="remark" rows="3">${userAccount.remark}</textarea>
							</div>
						</div>
						<div class="control-group">
							<label for="userAccount_registerDate" class="control-label"><s:message code="userAccount.registerDate"/>:</label>
							<div class="controls">
							<span class="input-xlarge uneditable-input"><fmt:formatDate value="${userAccount.registerDate}"
											pattern="yyyy年MM月dd日  HH时mm分ss秒" /></span>
							</div>
						</div>
						<div class="control-group">
							<label for="userAccount_status" class="control-label"><s:message code="userAccount.status"/>:</label>
							<div class="controls">
								<form:bsradiobuttons path="status" items="${allStatus}" labelCssClass="inline"/>
							</div>
						</div>
						<div class="form-actions">
						<%-- <input id="submit_btn" class="btn btn-primary" type="submit" value="<s:message code="common.submit"/>" />&nbsp; --%>
						 <input id="cancel_btn" class="btn"	type="button" value="<s:message code="common.return"/>" onclick="history.back()" />
						</div>
					</fieldset>
				</form:form>
			</div>
		</div><!--/span-->
	</div><!--/row-->
</body>
</html>

