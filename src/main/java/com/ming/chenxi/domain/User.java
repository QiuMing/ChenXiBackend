package com.ming.chenxi.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
/**
 * 用户
 * @author guhao
 *
 */
@Entity
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

	// 建立多对多关系表
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.LAZY)
	@JoinTable(name="user_role", 
			joinColumns = {@JoinColumn(name="user_id",referencedColumnName ="id")},
			inverseJoinColumns = {@JoinColumn(name="role_id",referencedColumnName="id")})    
    private Set<Role> roles;
	
	protected User() {
		super();
	}
    
    public User(Integer id, String username) {
    	this.id = id;
    	this.username = username;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
