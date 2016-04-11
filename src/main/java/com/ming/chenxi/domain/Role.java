package com.ming.chenxi.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 角色
 * @author guhao
 *
 */
@Entity
@Table(name="role")
public class Role implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "role_id")
    private Integer roleId;

    @Column(name="role_name",nullable = false)
    private String roleName;

	// 建立多对多关系表
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.LAZY)
	@JoinTable(name="role_permission", 
			joinColumns = {@JoinColumn(name="role_id",referencedColumnName ="role_id")},
			inverseJoinColumns = {@JoinColumn(name="permission_id",referencedColumnName="id")})    
    private List<Permission> permissions;
    
	//@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.LAZY, mappedBy="roles")
    //private Set<User> users;
    
    public Role() {
		super();
    }

	public Role(Integer roleId, String roleName) {
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	/*public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}*/

	/**
	 * 获取Shiro需要的permission string格式
	 * @return
	 */
	public List<String> getStringPermissions(){
		if(permissions==null || permissions.size()<=0) return null;
		List<String> permissionStrs = new ArrayList<String>();
		for(Permission permission:permissions){
			permissionStrs.add(String.valueOf(permission.getId()));
		}
		return permissionStrs;
	}

}
