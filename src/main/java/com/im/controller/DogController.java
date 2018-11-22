package com.im.controller;

import com.im.pojo.Admin;
import com.im.resp.RespResult;
import com.im.resp.RespResultEnum;
import com.im.service.AdminService;
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
    private AdminService adminService;


    /**
     * 条件查询
     *
     * @param dog      条件值
     * @param page     当前页
     * @param pageSize 每页条数
     * @return HTTP返回值封装对象
     */
    @GetMapping(value = "/query_dog")
    public RespResult queryDog(Admin dog,
                               @RequestParam(value = "page", required = false) Integer page,
                               @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        if (dog == null) {
            dog = new Admin();
        }
        if (page == null) {
            page = 1;
        }
        if (pageSize == null) {
            pageSize = 5;
        }
        return adminService.queryDogList(dog, page, pageSize);
    }

    /**
     * 通过ID查询
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/query_dog/{id}")
    public RespResult queryDogID(@PathVariable("id") Integer id) {
        return adminService.queryDogById(id);
    }


    /**
     * 添加一条数据(使用对象代替参数列表)
     *
     * @param dog           参数
     * @param bindingResult 表单验证
     * @return
     */
    @PostMapping(value = "/add_dog")
    public RespResult addDog(@Valid Admin dog, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return RespResultUtil.customError(RespResultEnum.WRONG_PARAMETER_VALUE, bindingResult.getFieldError().getDefaultMessage());//TODO
        }
        return adminService.saveDog(dog);
    }


    /**
     * 通过ID更新
     *
     * @param id
     * @param dog
     * @return
     */
    @PutMapping(value = "/dog/{id}")
    public RespResult updateOne(@PathVariable("id") String id, Admin dog) {
        dog.setId(id);
        return adminService.updateDog(dog);
    }

    /**
     * 通过ID删除
     *
     * @param id
     */
    @DeleteMapping(value = "/dog/{id}")
    public RespResult deleteOne(@PathVariable("id") Integer id) {
        return adminService.deleteDog(id);
    }

    /**
     * 查询一条记录，并对年龄进行判断
     * TEST
     *
     * @param id
     */
    @GetMapping(value = "/dog/judgeAge/{id}")
    public void judgeAge(@PathVariable("id") Integer id) throws Exception {
        adminService.judgeAge(id);
    }
}
