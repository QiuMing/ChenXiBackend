package com.ming.chenxi.repository;


import com.ming.chenxi.domain.UserProfile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Ming on 2016/4/8.
 */
public interface UserProfileRepository  extends JpaRepository<UserProfile,Integer> {

    Page<UserProfile> findAll(Pageable pageable);

    List<UserProfile> findAll();

    @Query(value = "select userProfile from  UserProfile userProfile  where useId=?")
    UserProfile getUserProfileByUserId(Integer id);

    @Query(value = "select userProfile from  User  user left JOIN user.userProfile userProfile  where user.phone=?")
    UserProfile getUserProfileByPhone(String phone);

}
