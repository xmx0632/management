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

import org.xmx0632.management.entity.FruitCategory;
import org.xmx0632.management.repository.FruitCategoryDao;

//Spring Bean的标识.
@Component
// 默认将类中的所有public函数纳入事务管理.
@Transactional(readOnly = true)
public class FruitCategoryService {

	private static Logger log = LoggerFactory
			.getLogger(FruitCategoryService.class);

	private FruitCategoryDao fruitCategoryDao;

	public FruitCategory getFruitCategory(Long id) {
		return fruitCategoryDao.findOne(id);
	}

	public List<FruitCategory> getAllFruitCategory() {
		return (List<FruitCategory>) fruitCategoryDao.findAll();
	}

	@Transactional(readOnly = false)
	public void saveFruitCategory(FruitCategory entity) {
		fruitCategoryDao.save(entity);
	}

	@Transactional(readOnly = false)
	public void deleteFruitCategory(Long id) {
		fruitCategoryDao.delete(id);
	}

	public Page<FruitCategory> getFruitCategorys(
			Map<String, Object> filterParams, int pageNumber, int pageSize,
			String sortType) {
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize,
				sortType);
		Specification<FruitCategory> spec = buildSpecification(filterParams);

		return fruitCategoryDao.findAll(spec, pageRequest);
	}

	/**
	 * 创建分页请求.
	 */
	private PageRequest buildPageRequest(int pageNumber, int pagzSize,
			String sortType) {
		Sort sort = null;
		if ("auto".equals(sortType)) {
			sort = new Sort(Direction.DESC, "id");
		}
		/*
		 * else if ("title".equals(sortType)) { sort = new Sort(Direction.ASC,
		 * "title"); }
		 */

		return new PageRequest(pageNumber - 1, pagzSize, sort);
	}

	/**
	 * 创建动态查询条件组合.
	 */
	private Specification<FruitCategory> buildSpecification(
			Map<String, Object> filterParams) {
		Map<String, SearchFilter> filters = SearchFilter.parse(filterParams);
		// filters.put("user.id", new SearchFilter("user.id", Operator.EQ,
		// userId));
		Specification<FruitCategory> spec = DynamicSpecifications
				.bySearchFilter(filters.values(), FruitCategory.class);
		return spec;
	}

	// -----------------//
	// Setter methods //
	// -----------------//

	@Autowired(required = true)
	public void setFruitCategoryDao(FruitCategoryDao fruitCategoryDao) {
		this.fruitCategoryDao = fruitCategoryDao;
	}
}
