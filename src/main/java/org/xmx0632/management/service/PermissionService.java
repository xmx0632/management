package org.xmx0632.management.service;

import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.persistence.DynamicSpecifications;
import org.springside.modules.persistence.SearchFilter;

import org.xmx0632.management.entity.Permission;
import org.xmx0632.management.repository.PermissionDao;

@Component
// all public method will be managed by transaction as default.
@Transactional(readOnly = true)
public class PermissionService {

	private static Logger log = LoggerFactory.getLogger(PermissionService.class);
	
	private PermissionDao permissionDao;

	public Permission getPermission(Long id) {
		return permissionDao.findOne(id);
	}

	public List<Permission> getAllPermission() {
		return (List<Permission>)permissionDao.findAll();
	}
	
	@Transactional(readOnly = false)
	public void savePermission(Permission entity) {
		permissionDao.save(entity);
	}

	@Transactional(readOnly = false)
	public void deletePermission(Long id) {
		permissionDao.delete(id);
	}

	public Page<Permission> getPermissions(Map<String, Object> filterParams,
			int pageNumber, int pageSize, String sortType) {
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
		Specification<Permission> spec = buildSpecification(filterParams);
		
		return permissionDao.findAll(spec, pageRequest);
	}
	

	/**
	 * create pagination request.
	 */
	private PageRequest buildPageRequest(int pageNumber, int pagzSize, String sortType) {
		Sort sort = null;
		if ("auto".equals(sortType)) {
			sort = new Sort(Direction.DESC, "id");
		} 
		/*
		else if ("title".equals(sortType)) {
			sort = new Sort(Direction.ASC, "title");
		}
		*/

		return new PageRequest(pageNumber - 1, pagzSize, sort);
	}
	
	/**
	 * create dynamic query criteria.
	 */
	private Specification<Permission> buildSpecification(Map<String, Object> filterParams) {
		Map<String, SearchFilter> filters = SearchFilter.parse(filterParams);
		// filters.put("user.id", new SearchFilter("user.id", Operator.EQ, userId));
		Specification<Permission> spec = DynamicSpecifications.bySearchFilter(filters.values(), Permission.class);
		return spec;
	}
	
	// -----------------//
	// Setter methods   //
	// -----------------//
	
	@Autowired(required = true)
	public void setPermissionDao(PermissionDao permissionDao) {
		this.permissionDao = permissionDao;
	}
}

