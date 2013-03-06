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
import org.xmx0632.management.entity.FruitStoryMenu;
import org.xmx0632.management.repository.FruitStoryMenuDao;

//Spring Bean的标识.
@Component
// 默认将类中的所有public函数纳入事务管理.
@Transactional(readOnly = true)
public class FruitStoryMenuService {

	private static Logger log = LoggerFactory
			.getLogger(FruitStoryMenuService.class);

	private FruitStoryMenuDao fruitStoryMenuDao;

	public FruitStoryMenu getFruitStoryMenu(Long id) {
		return fruitStoryMenuDao.findOne(id);
	}

	public List<FruitStoryMenu> getAllFruitStoryMenu() {
		return (List<FruitStoryMenu>) fruitStoryMenuDao.findAll();
	}

	@Transactional(readOnly = false)
	public void saveFruitStoryMenu(FruitStoryMenu entity) {
		fruitStoryMenuDao.save(entity);
	}

	@Transactional(readOnly = false)
	public void deleteFruitStoryMenu(Long id) {
		fruitStoryMenuDao.delete(id);
	}

	public Page<FruitStoryMenu> getFruitStoryMenus(
			Map<String, Object> filterParams, int pageNumber, int pageSize,
			String sortType) {
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize,
				sortType);
		Specification<FruitStoryMenu> spec = buildSpecification(filterParams);

		return fruitStoryMenuDao.findAll(spec, pageRequest);
	}

	public List<FruitStoryMenu> getFruitStoryMenus(
			Map<String, Object> filterParams) {

		Specification<FruitStoryMenu> spec = buildSpecification(filterParams);

		return fruitStoryMenuDao.findAll(spec);
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
	private Specification<FruitStoryMenu> buildSpecification(
			Map<String, Object> filterParams) {
		Map<String, SearchFilter> filters = SearchFilter.parse(filterParams);
		// filters.put("user.id", new SearchFilter("user.id", Operator.EQ,
		// userId));
		Specification<FruitStoryMenu> spec = DynamicSpecifications
				.bySearchFilter(filters.values(), FruitStoryMenu.class);
		return spec;
	}

	// -----------------//
	// Setter methods //
	// -----------------//

	@Autowired(required = true)
	public void setFruitStoryMenuDao(FruitStoryMenuDao fruitStoryMenuDao) {
		this.fruitStoryMenuDao = fruitStoryMenuDao;
	}
}
