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
import org.xmx0632.management.entity.FruitStoryProcedure;
import org.xmx0632.management.repository.FruitStoryProcedureDao;

//Spring Bean的标识.
@Component
// 默认将类中的所有public函数纳入事务管理.
@Transactional(readOnly = true)
public class FruitStoryProcedureService {

	private static Logger log = LoggerFactory
			.getLogger(FruitStoryProcedureService.class);

	private FruitStoryProcedureDao fruitStoryProcedureDao;

	public FruitStoryProcedure getFruitStoryProcedure(Long id) {
		return fruitStoryProcedureDao.findOne(id);
	}

	public List<FruitStoryProcedure> getAllFruitStoryProcedure() {
		return (List<FruitStoryProcedure>) fruitStoryProcedureDao.findAll();
	}

	@Transactional(readOnly = false)
	public void saveFruitStoryProcedure(FruitStoryProcedure entity) {
		fruitStoryProcedureDao.save(entity);
	}

	@Transactional(readOnly = false)
	public void deleteFruitStoryProcedure(Long id) {
		fruitStoryProcedureDao.delete(id);
	}

	public List<FruitStoryProcedure> getFruitStoryProcedures(
			Map<String, Object> filterParams) {

		Specification<FruitStoryProcedure> spec = buildSpecification(filterParams);

		return fruitStoryProcedureDao.findAll(spec);
	}

	public Page<FruitStoryProcedure> getFruitStoryProcedures(
			Map<String, Object> filterParams, int pageNumber, int pageSize,
			String sortType) {
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize,
				sortType);
		Specification<FruitStoryProcedure> spec = buildSpecification(filterParams);

		return fruitStoryProcedureDao.findAll(spec, pageRequest);
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
	private Specification<FruitStoryProcedure> buildSpecification(
			Map<String, Object> filterParams) {
		Map<String, SearchFilter> filters = SearchFilter.parse(filterParams);
		// filters.put("user.id", new SearchFilter("user.id", Operator.EQ,
		// userId));
		Specification<FruitStoryProcedure> spec = DynamicSpecifications
				.bySearchFilter(filters.values(), FruitStoryProcedure.class);
		return spec;
	}

	// -----------------//
	// Setter methods //
	// -----------------//

	@Autowired(required = true)
	public void setFruitStoryProcedureDao(
			FruitStoryProcedureDao fruitStoryProcedureDao) {
		this.fruitStoryProcedureDao = fruitStoryProcedureDao;
	}
}
