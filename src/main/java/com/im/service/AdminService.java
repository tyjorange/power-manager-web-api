package com.im.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.im.mapper.first.AdminMapper;
import com.im.pojo.first.Admin;
import com.im.resp.RespResult;
import com.im.resp.RespResultEnum;
import com.im.resp.RespResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

/**
 * Created by vostor on 2018/10/26.
 */
@Service
public class AdminService {
    @Autowired
    private AdminMapper mapper;

    /**
     * 添加
     *
     * @param admin
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public RespResult saveDog(Admin admin) {
        int insert = mapper.insert(admin);
        if (insert == 0) {
            return RespResultUtil.success(RespResultEnum.ADD_UPDATE_FAILED);
        }
        return RespResultUtil.success(RespResultEnum.ADD_UPDATE_SUCCESS, admin);
    }

    /**
     * 修改
     *
     * @param admin
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public RespResult updateDog(Admin admin) {
        int update = mapper.updateByPrimaryKeySelective(admin);
        if (update == 0) {
            return RespResultUtil.success(RespResultEnum.ADD_UPDATE_FAILED);
        }
        return RespResultUtil.success(RespResultEnum.ADD_UPDATE_SUCCESS, admin);
    }

    /**
     * 删除
     *
     * @param id
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public RespResult deleteDog(Integer id) {
        int i = mapper.deleteByPrimaryKey(id);
        if (i == 0) {
            return RespResultUtil.success(RespResultEnum.DEL_FAILED);
        }
        return RespResultUtil.success(RespResultEnum.DEL_SUCCESS);
    }

    /**
     * 主键查询
     *
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public RespResult queryDogById(Integer id) {
        Admin admin = mapper.selectByPrimaryKey(id);
        if (admin == null) {
            return RespResultUtil.success(RespResultEnum.EMPTY_RESULT);
        }
        return RespResultUtil.success(RespResultEnum.QUERY_SUCCESS, admin);
    }

    /**
     * 列表查询
     *
     * @param admin    条件值
     * @param page     当前页
     * @param pageSize 每页条数
     * @return HTTP返回值封装对象
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public RespResult queryDogList(Admin admin, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        Example example = new Example(Admin.class);
        Example.Criteria criteria = example.createCriteria();
        if (admin.getUsername() != null) {
            criteria.andLike("dogName", "%" + admin.getUsername() + "%");
        }
        example.orderBy("dogId").desc();
        PageInfo<Admin> pageInfo = new PageInfo<>(mapper.selectByExample(example));
        long total = pageInfo.getTotal();
        if (total == 0) {
            return RespResultUtil.success(RespResultEnum.EMPTY_RESULT);
        }
        return RespResultUtil.success(RespResultEnum.QUERY_SUCCESS, pageInfo.getList(), total);
    }

    /**
     * 查询一条记录，并对年龄进行判断
     * TEST
     *
     * @param id
     */
    public void judgeAge(Integer id) throws Exception {
//        Admin dog = mapper.selectByPrimaryKey(id);
//        Integer age = dog.getId();
//        if (age < 10) {
//            throw new CustomException(RespResultEnum.WRONG_PARAMETER_VALUE);
//        } else if (age > 10 && age < 16) {
//            throw new CustomException(RespResultEnum.WRONG_PARAMETER_FORMAT);
//        }
    }
}
