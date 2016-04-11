package com.ming.chenxi.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Ming on 2016/4/7.
 */
@Entity
@Table(name="user_profile")
public class UserProfile  implements Serializable {

    @Column(name="user_id")
    private Integer  userId;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="user_profile_id")
    private Integer userProfileId;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private Double height;

    public UserProfile(){
        super();
    }

    public UserProfile(Integer userId, Integer age, Double height) {
        this.userId = userId;
        this.age = age;
        this.height = height;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileId(Integer userProfileId) {
        this.userProfileId = userProfileId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }
}
