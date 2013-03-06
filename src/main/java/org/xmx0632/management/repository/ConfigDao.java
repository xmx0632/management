package org.xmx0632.management.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.xmx0632.management.entity.Config;

public interface ConfigDao extends PagingAndSortingRepository<Config, Long>,
		JpaSpecificationExecutor<Config> {

	Config findByName(String name);
}
