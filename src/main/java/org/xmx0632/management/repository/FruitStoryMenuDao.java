package org.xmx0632.management.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import org.xmx0632.management.entity.FruitStoryMenu;

public interface FruitStoryMenuDao extends
		PagingAndSortingRepository<FruitStoryMenu, Long>,
		JpaSpecificationExecutor<FruitStoryMenu> {
}
