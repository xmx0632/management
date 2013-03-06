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
import org.xmx0632.management.entity.FruitSubPromotion;
import org.xmx0632.management.repository.FruitSubPromotionDao;

//Spring Bean的标识.
@Component
@Transactional(readOnly = true)
public class FruitSubPromotionService {

	private static Logger log = LoggerFactory
			.getLogger(FruitSubPromotionService.class);

	private FruitSubPromotionDao fruitSubPromotionDao;

	public FruitSubPromotion getFruitSubPromotion(Long id) {
		return fruitSubPromotionDao.findOne(id);
	}

	public List<FruitSubPromotion> getAllFruitSubPromotion() {
		return (List<FruitSubPromotion>) fruitSubPromotionDao.findAll();
	}

	@Transactional(readOnly = false)
	public void saveFruitSubPromotion(FruitSubPromotion entity) {
		fruitSubPromotionDao.save(entity);
	}

	@Transactional(readOnly = false)
	public void deleteFruitSubPromotion(Long id) {
		fruitSubPromotionDao.delete(id);
	}

	public Page<FruitSubPromotion> getFruitSubPromotions(
			Map<String, Object> filterParams, int pageNumber, int pageSize,
			String sortType) {
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize,
				sortType);
		Specification<FruitSubPromotion> spec = buildSpecification(filterParams);

		return fruitSubPromotionDao.findAll(spec, pageRequest);
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

	private Specification<FruitSubPromotion> buildSpecification(
			Map<String, Object> filterParams) {
		Map<String, SearchFilter> filters = SearchFilter.parse(filterParams);
		// filters.put("user.id", new SearchFilter("user.id", Operator.EQ,
		// userId));
		Specification<FruitSubPromotion> spec = DynamicSpecifications
				.bySearchFilter(filters.values(), FruitSubPromotion.class);
		return spec;
	}

	// -----------------//
	// Setter methods //
	// -----------------//

	@Autowired(required = true)
	public void setFruitSubPromotionDao(
			FruitSubPromotionDao fruitSubPromotionDao) {
		this.fruitSubPromotionDao = fruitSubPromotionDao;
	}
}
