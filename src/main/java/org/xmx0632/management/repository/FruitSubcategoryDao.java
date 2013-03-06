package org.xmx0632.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.xmx0632.management.entity.FruitSubcategory;

public interface FruitSubcategoryDao extends
		PagingAndSortingRepository<FruitSubcategory, Long>,
		JpaSpecificationExecutor<FruitSubcategory> {

	@Query("from FruitSubcategory f where f.fruitCategory is null")
	List<FruitSubcategory> getAllUnSelectedFruitSubcategory();
}
