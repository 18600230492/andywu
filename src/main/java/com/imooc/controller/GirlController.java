package com.imooc.controller;

import com.imooc.domain.Girl;
import com.imooc.domain.Result;
import com.imooc.repository.GirlRepository;
import com.imooc.service.GirlService;
import com.imooc.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by andywu on 2017/11/20.
 */

@RestController
public class GirlController {

    private final static Logger logger= LoggerFactory.getLogger(GirlController.class);
    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;

    //查询所有女生列表
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        logger.info("查询所有女生列表");
        return girlRepository.findAll();
    }

    //添加一个女生
    @PostMapping(value = "/girlAdd")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            logger.info("添加失败");
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setAge(girl.getAge());
        girl.setCupSize(girl.getCupSize());
        girl.setMoney(girl.getMoney());
        return ResultUtil.success(girlRepository.save(girl));
    }

    //查询一个女生---id
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }

    //更新一个女生信息
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,@Valid Girl girl){
        girl.setId(id);
        girl.setMoney(girl.getMoney());
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        return girlRepository.save(girl);
    }

    /*
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age,
                           @RequestParam("money") Integer money){
        Girl girl=new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        girl.setMoney(money);
        return girlRepository.save(girl);
    }
    */

    @DeleteMapping(value = "girls/{id}")
//    public void girlDelete(@PathVariable("id") Integer id){
//        girlRepository.delete(id);
//    }
    public Result<Girl> girlDelete(@PathVariable("id") Integer id){
        girlRepository.delete(id);
        return ResultUtil.success();
    }

    //添加2个女生
    @PostMapping(value = "girls/AddTwo")
    public void girAddTwo(){
        girlService.AddTwo();
    }
}
