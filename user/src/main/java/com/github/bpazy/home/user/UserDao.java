package com.github.bpazy.home.user;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

public interface UserDao {
    @Insert("insert into h_user (USER_ID, USERNAME, NICKNAME, EMAIL) values (#{userId}, #{username}, #{nickname}, #{email})")
    void saveUser(User user);

    @Select("select * from h_user where user_id = #{userId}")
    User findUser(String userId);

    @Delete("delete from h_user where user_id = #{userId}")
    void deleteUser(String userId);
}
