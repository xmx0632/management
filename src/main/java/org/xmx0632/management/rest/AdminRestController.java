package org.xmx0632.management.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.mapper.BeanMapper;
import org.xmx0632.management.entity.Admin;
import org.xmx0632.management.service.account.AdminService;

@Controller
@RequestMapping(value = "/api/v1/admin")
public class AdminRestController {
	@Autowired
	private AdminService adminService;

	/**
	 * 基于ContentNegotiationManager,根据URL的后缀渲染不同的格式 eg. /api/v1/admin/1.xml 返回xml
	 * /api/v1/admin/1.json 返回json /api/v1/admin/1 返回xml(why?)
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public AdminDTO getUser(@PathVariable("id") Long id) {
		Admin admin = adminService.getUser(id);

		// 使用Dozer转换DTO类，并补充Dozer不能自动绑定的属性
		AdminDTO dto = BeanMapper.map(admin, AdminDTO.class);
		dto.setTeamId(admin.getTeam().getId());
		return dto;
	}
}
