package com.ming.chenxi.repository;


import com.ming.chenxi.domain.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Ming on 2016/4/8.
 */
public interface UserProfileRepository  extends JpaRepository<UserProfile,Integer> {

     @Query(value = "select userProfile from  UserProfile userProfile  where useId=?")
    UserProfile getUserProfileByUserId(Integer id);


    //待解决的，两个都尝试失败
    //
    //@Query(value = "select userProfile from  UserProfile userProfile   left  join  com.ming.chenxi.domain.User  user on userProfile.userId = user.userId where user.username=?")
    @Query(value = "select userProfile from  User  user left JOIN user.userProfile userProfile  where user.phone=?")
    UserProfile getUserProfileByPhone(String phone);
}
