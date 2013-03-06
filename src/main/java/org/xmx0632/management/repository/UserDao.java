package org.xmx0632.management.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.xmx0632.management.entity.User;

public interface UserDao extends PagingAndSortingRepository<User, Long> {
	User findByLoginName(String loginName);
}
