package com.ming.chenxi.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="user")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "user_id")
    private Integer userId;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String password;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id", nullable=true)
	private UserProfile userProfile ;
	// 建立多对多关系表
	/*@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.LAZY)
	@JoinTable(name="role",
			joinColumns = {@JoinColumn(name="user_id",referencedColumnName ="user_id")},
			inverseJoinColumns = {@JoinColumn(name="role_id",referencedColumnName="role_id")})*/
    //private Set<Role> roles;
	
	public User() {
		super();
	}
    
    public User(Integer userId, String phone) {
    	this.userId = userId;
    	this.phone = phone;
    }

	public User(String phone, String password) {
		this.password = password;
		this.phone = phone;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	/*public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}*/

}
