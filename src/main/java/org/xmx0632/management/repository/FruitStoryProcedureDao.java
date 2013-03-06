package org.xmx0632.management.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import org.xmx0632.management.entity.FruitStoryProcedure;

public interface FruitStoryProcedureDao extends
		PagingAndSortingRepository<FruitStoryProcedure, Long>,
		JpaSpecificationExecutor<FruitStoryProcedure> {
}
