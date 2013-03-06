package org.xmx0632.management.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.google.common.collect.Lists;

/**
 * 开发团队.
 * 
 * @author calvin
 */
@Entity
@Table(name = "df_team")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Team extends IdEntity {

	private String name;
	private Admin master;
	private List<Admin> userList = Lists.newArrayList();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotNull
	@OneToOne
	@JoinColumn(name = "master_id")
	public Admin getMaster() {
		return master;
	}

	public void setMaster(Admin master) {
		this.master = master;
	}

	@OneToMany(mappedBy = "team")
	public List<Admin> getUserList() {
		return userList;
	}

	public void setUserList(List<Admin> userList) {
		this.userList = userList;
	}
}
