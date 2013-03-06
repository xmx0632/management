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
import org.xmx0632.management.api.v1.bo.TerminalType;
import org.xmx0632.management.entity.Config;
import org.xmx0632.management.global.ConfigConstant;
import org.xmx0632.management.repository.ConfigDao;

//Spring Bean的标识.
@Component
// 默认将类中的所有public函数纳入事务管理.
@Transactional(readOnly = true)
public class ConfigService {

	private static Logger log = LoggerFactory.getLogger(ConfigService.class);

	private ConfigDao configDao;

	public Config getConfig(Long id) {
		return configDao.findOne(id);
	}

	public List<Config> getAllConfig() {
		return (List<Config>) configDao.findAll();
	}

	@Transactional(readOnly = false)
	public void saveConfig(Config entity) {
		configDao.save(entity);
	}

	@Transactional(readOnly = false)
	public void deleteConfig(Long id) {
		configDao.delete(id);
	}

	public Page<Config> getConfigs(Map<String, Object> filterParams,
			int pageNumber, int pageSize, String sortType) {
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize,
				sortType);
		Specification<Config> spec = buildSpecification(filterParams);

		return configDao.findAll(spec, pageRequest);
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
	private Specification<Config> buildSpecification(
			Map<String, Object> filterParams) {
		Map<String, SearchFilter> filters = SearchFilter.parse(filterParams);
		Specification<Config> spec = DynamicSpecifications.bySearchFilter(
				filters.values(), Config.class);
		return spec;
	}

	// -----------------//
	// Setter methods //
	// -----------------//

	@Autowired(required = true)
	public void setConfigDao(ConfigDao configDao) {
		this.configDao = configDao;
	}

	public String getByName(ConfigConstant name) {
		Config config = configDao.findByName(name.name().toLowerCase());
		return config.getConfigValue();
	}

	public String getByName(TerminalType name) {
		Config config = configDao.findByName(name.toConfigName().toLowerCase());
		return config.getConfigValue();
	}

	public int getIntByName(ConfigConstant name) {
		String value = getByName(name);
		log.debug("name:{},value:{}", name, value);
		return Integer.valueOf(value);
	}
}
