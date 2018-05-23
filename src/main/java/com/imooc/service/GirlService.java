package com.imooc.service;

import com.imooc.domain.Girl;
import com.imooc.domain.Result;
import com.imooc.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by andywu on 2017/11/23.
 */

@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void AddTwo() {
        Girl girlA=new Girl();
        girlA.setMoney(19);
        girlA.setAge(20);
        girlA.setCupSize("M");
        girlRepository.save(girlA);

        Girl girlB=new Girl();
        girlB.setMoney(33);
        girlB.setCupSize("D");
        girlB.setAge(90);
        girlRepository.save(girlB);
    }
}
