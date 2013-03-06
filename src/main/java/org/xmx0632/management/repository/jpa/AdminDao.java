package org.xmx0632.management.repository.jpa;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.xmx0632.management.entity.Admin;

public interface AdminDao extends PagingAndSortingRepository<Admin, Long>,
		JpaSpecificationExecutor<Admin> {

	Admin findByName(String name);

	Admin findByLoginName(String loginName);
}
