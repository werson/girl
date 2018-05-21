package com.werson;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by wersom on 2017/6/4 0004.
 */
public interface GirlRepository extends JpaRepository<Girl, Integer> {

    //通过年龄查询
    List<Girl> findByAge(Integer age);

}
