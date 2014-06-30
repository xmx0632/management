package org.xmx0632.management.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.xmx0632.management.entity.IdEntity;

/**
 * Permission.
 */
@Entity
@Table(name="df_permission"
    , uniqueConstraints = @UniqueConstraint(columnNames="name") 
)
public class Permission extends IdEntity {


    private String name;
    private String description;
    private String permissionString;

    public Permission() {
    }

	
    public Permission(String name) {
        this.name = name;
    }
   
    public Permission(Long permissionId) {
    	this.id = permissionId;
	}


	@NotNull
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public String getPermissionString() {
        return this.permissionString;
    }
    
    public void setPermissionString(String permissionString) {
        this.permissionString = permissionString;
    }

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}


