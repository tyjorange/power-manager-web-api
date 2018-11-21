package com.im.controller;

import com.im.resp.RespResult;
import com.im.pojo.Dogs;
import com.im.resp.RespResultEnum;
import com.im.service.DogService;
import com.im.resp.RespResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by vostor on 2018/10/25.
 */
@RestController
public class DogController {
    @Autowired
    private DogService dogService;


    /**
     * 条件查询
     *
     * @param dog      条件值
     * @param page     当前页
     * @param pageSize 每页条数
     * @return HTTP返回值封装对象
     */
    @GetMapping(value = "/query_dog")
    public RespResult queryDog(Dogs dog,
                               @RequestParam(value = "page", required = false) Integer page,
                               @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        if (dog == null) {
            dog = new Dogs();
        }
        if (page == null) {
            page = 1;
        }
        if (pageSize == null) {
            pageSize = 5;
        }
        return dogService.queryDogList(dog, page, pageSize);
    }

    /**
     * 通过ID查询
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/query_dog/{id}")
    public RespResult queryDogID(@PathVariable("id") Integer id) {
        return dogService.queryDogById(id);
    }


    /**
     * 添加一条数据(使用对象代替参数列表)
     *
     * @param dog           参数
     * @param bindingResult 表单验证
     * @return
     */
    @PostMapping(value = "/add_dog")
    public RespResult addDog(@Valid Dogs dog, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return RespResultUtil.customError(RespResultEnum.WRONG_PARAMETER_VALUE, bindingResult.getFieldError().getDefaultMessage());//TODO
        }
        return dogService.saveDog(dog);
    }


    /**
     * 通过ID更新
     *
     * @param id
     * @param dog
     * @return
     */
    @PutMapping(value = "/dog/{id}")
    public RespResult updateOne(@PathVariable("id") Integer id, Dogs dog) {
        dog.setDogId(id);
        return dogService.updateDog(dog);
    }

    /**
     * 通过ID删除
     *
     * @param id
     */
    @DeleteMapping(value = "/dog/{id}")
    public RespResult deleteOne(@PathVariable("id") Integer id) {
        return dogService.deleteDog(id);
    }

    /**
     * 查询一条记录，并对年龄进行判断
     * TEST
     *
     * @param id
     */
    @GetMapping(value = "/dog/judgeAge/{id}")
    public void judgeAge(@PathVariable("id") Integer id) throws Exception {
        dogService.judgeAge(id);
    }
}
