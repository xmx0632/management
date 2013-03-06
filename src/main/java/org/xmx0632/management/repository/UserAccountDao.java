package org.xmx0632.management.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.xmx0632.management.entity.UserAccount;

public interface UserAccountDao extends
		PagingAndSortingRepository<UserAccount, Long>,
		JpaSpecificationExecutor<UserAccount> {

	UserAccount findByUsername(String username);

	@Query("select count(u) from UserAccount u where u.username = ?1")
	long countByUsername(String username);

	@Query("select count(u) from UserAccount u where u.platform = ?1")
	long countByPlatform(String platform);

	@Query("select count(u) from UserAccount u where u.createTime >= ?1 and u.createTime <= ?2 and u.platform = ?3 ")
	long countByPlatformAndCreateTime(Date startDate, Date endDate,
			String platform);

}
