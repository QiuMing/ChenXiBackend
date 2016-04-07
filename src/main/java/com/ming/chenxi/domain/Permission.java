package com.ming.chenxi.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * 权限
 * @author guhao
 *
 */
@Entity
public class Permission implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String permissionName;

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.LAZY, mappedBy="permissions")    
    private Set<Role> roles;
    
    protected Permission() {

    }

	public Permission(Integer id, String permissionName) {
		this.id = id;
		this.permissionName = permissionName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
