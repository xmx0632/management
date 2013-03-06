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
import org.xmx0632.management.entity.FruitStoryMaterial;
import org.xmx0632.management.repository.FruitStoryMaterialDao;

//Spring Bean的标识.
@Component
// 默认将类中的所有public函数纳入事务管理.
@Transactional(readOnly = true)
public class FruitStoryMaterialService {

	private static Logger log = LoggerFactory
			.getLogger(FruitStoryMaterialService.class);

	private FruitStoryMaterialDao fruitStoryMaterialDao;

	public FruitStoryMaterial getFruitStoryMaterial(Long id) {
		return fruitStoryMaterialDao.findOne(id);
	}

	public List<FruitStoryMaterial> getAllFruitStoryMaterial() {
		return (List<FruitStoryMaterial>) fruitStoryMaterialDao.findAll();
	}

	@Transactional(readOnly = false)
	public void saveFruitStoryMaterial(FruitStoryMaterial entity) {
		fruitStoryMaterialDao.save(entity);
	}

	@Transactional(readOnly = false)
	public void deleteFruitStoryMaterial(Long id) {
		fruitStoryMaterialDao.delete(id);
	}

	public List<FruitStoryMaterial> getFruitStoryMaterials(
			Map<String, Object> filterParams) {

		Specification<FruitStoryMaterial> spec = buildSpecification(filterParams);

		return fruitStoryMaterialDao.findAll(spec);
	}

	public Page<FruitStoryMaterial> getFruitStoryMaterials(
			Map<String, Object> filterParams, int pageNumber, int pageSize,
			String sortType) {
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize,
				sortType);
		Specification<FruitStoryMaterial> spec = buildSpecification(filterParams);

		return fruitStoryMaterialDao.findAll(spec, pageRequest);
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
	private Specification<FruitStoryMaterial> buildSpecification(
			Map<String, Object> filterParams) {
		Map<String, SearchFilter> filters = SearchFilter.parse(filterParams);
		// filters.put("user.id", new SearchFilter("user.id", Operator.EQ,
		// userId));
		Specification<FruitStoryMaterial> spec = DynamicSpecifications
				.bySearchFilter(filters.values(), FruitStoryMaterial.class);
		return spec;
	}

	// -----------------//
	// Setter methods //
	// -----------------//

	@Autowired(required = true)
	public void setFruitStoryMaterialDao(
			FruitStoryMaterialDao fruitStoryMaterialDao) {
		this.fruitStoryMaterialDao = fruitStoryMaterialDao;
	}
}
