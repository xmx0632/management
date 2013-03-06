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
import org.xmx0632.management.entity.FruitPromotion;
import org.xmx0632.management.repository.FruitPromotionDao;

//Spring Bean的标识.
@Component
@Transactional(readOnly = true)
public class FruitPromotionService {

	private static Logger log = LoggerFactory
			.getLogger(FruitPromotionService.class);

	private FruitPromotionDao fruitPromotionDao;

	public FruitPromotion getFruitPromotion(Long id) {
		return fruitPromotionDao.findOne(id);
	}

	public List<FruitPromotion> getAllFruitPromotion() {
		return (List<FruitPromotion>) fruitPromotionDao.findAll();
	}

	@Transactional(readOnly = false)
	public void saveFruitPromotion(FruitPromotion entity) {
		fruitPromotionDao.save(entity);
	}

	@Transactional(readOnly = false)
	public void deleteFruitPromotion(Long id) {
		fruitPromotionDao.delete(id);
	}

	public Page<FruitPromotion> getFruitPromotions(
			Map<String, Object> filterParams, int pageNumber, int pageSize,
			String sortType) {
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize,
				sortType);
		Specification<FruitPromotion> spec = buildSpecification(filterParams);

		return fruitPromotionDao.findAll(spec, pageRequest);
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

	private Specification<FruitPromotion> buildSpecification(
			Map<String, Object> filterParams) {
		Map<String, SearchFilter> filters = SearchFilter.parse(filterParams);
		// filters.put("user.id", new SearchFilter("user.id", Operator.EQ,
		// userId));
		Specification<FruitPromotion> spec = DynamicSpecifications
				.bySearchFilter(filters.values(), FruitPromotion.class);
		return spec;
	}

	// -----------------//
	// Setter methods //
	// -----------------//

	@Autowired(required = true)
	public void setFruitPromotionDao(FruitPromotionDao fruitPromotionDao) {
		this.fruitPromotionDao = fruitPromotionDao;
	}
}
