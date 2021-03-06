package org.xmx0632.management.service;

import java.util.Date;
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
import org.xmx0632.management.entity.UserAccount;
import org.xmx0632.management.repository.UserAccountDao;

//Spring Bean的标识.
@Component
// 默认将类中的所有public函数纳入事务管理.
@Transactional(readOnly = true)
public class UserAccountService {

	private static Logger log = LoggerFactory
			.getLogger(UserAccountService.class);

	private UserAccountDao userAccountDao;

	public UserAccount getUserAccount(Long id) {
		return userAccountDao.findOne(id);
	}

	public List<UserAccount> getAllUserAccount() {
		return (List<UserAccount>) userAccountDao.findAll();
	}

	@Transactional(readOnly = false)
	public void saveUserAccount(UserAccount entity) {
		userAccountDao.save(entity);
	}

	@Transactional(readOnly = false)
	public void deleteUserAccount(Long id) {
		userAccountDao.delete(id);
	}

	public Page<UserAccount> getUserAccounts(Map<String, Object> filterParams,
			int pageNumber, int pageSize, String sortType) {
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize,
				sortType);
		Specification<UserAccount> spec = buildSpecification(filterParams);

		return userAccountDao.findAll(spec, pageRequest);
	}

	/**
	 * 创建分页请求.
	 */
	private PageRequest buildPageRequest(int pageNumber, int pagzSize,
			String sortType) {
		Sort sort = null;
		if ("auto".equals(sortType)) {
			sort = new Sort(Direction.DESC, "id");
		} else {
			sort = new Sort(Direction.DESC, sortType);
		}
		return new PageRequest(pageNumber - 1, pagzSize, sort);
	}

	/**
	 * 创建动态查询条件组合.
	 */
	private Specification<UserAccount> buildSpecification(
			Map<String, Object> filterParams) {
		Map<String, SearchFilter> filters = SearchFilter.parse(filterParams);
		// filters.put("user.id", new SearchFilter("user.id", Operator.EQ,
		// userId));
		Specification<UserAccount> spec = DynamicSpecifications.bySearchFilter(
				filters.values(), UserAccount.class);
		return spec;
	}

	// -----------------//
	// Setter methods //
	// -----------------//

	@Autowired(required = true)
	public void setUserAccountDao(UserAccountDao userAccountDao) {
		this.userAccountDao = userAccountDao;
	}

	public UserAccount findByUsername(String username) {
		return userAccountDao.findByUsername(username);
	}

	public long getUserCount() {
		return userAccountDao.count();
	}

	public long countByUsername(String username) {
		return userAccountDao.countByUsername(username);
	}

	public long countByPlatform(String platform) {
		return userAccountDao.countByPlatform(platform);
	}

	public long countByPlatformAndCreateTime(Date startDate, Date endDate,
			String platform) {
		return userAccountDao.countByPlatformAndCreateTime(startDate, endDate,
				platform);
	}

	@Transactional(readOnly = false)
	public void changeStatusBy(Long id, String status) {
		UserAccount ua = userAccountDao.findOne(id);
		ua.setStatus(status);
		userAccountDao.save(ua);
	}

}
