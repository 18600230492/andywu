package com.imooc.repository;

import com.imooc.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by andywu on 2017/11/21.
 */
public interface GirlRepository extends JpaRepository<Girl,Integer> {
    //通过年龄来查询
    //public List<Girl> findByAge(Integer age);
}
