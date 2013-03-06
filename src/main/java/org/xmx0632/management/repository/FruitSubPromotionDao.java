package org.xmx0632.management.repository;


import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import org.xmx0632.management.entity.FruitSubPromotion;

public interface FruitSubPromotionDao extends PagingAndSortingRepository<FruitSubPromotion, Long>,
	JpaSpecificationExecutor<FruitSubPromotion> {
}

