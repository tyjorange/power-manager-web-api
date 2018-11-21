package com.im.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.im.resp.RespResult;
import com.im.resp.RespResultEnum;
import com.im.exception.CustomException;
import com.im.mapper.DogsMapper;
import com.im.pojo.Dogs;
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
public class DogService {
    @Autowired
    private DogsMapper mapper;

    /**
     * 添加
     *
     * @param dog
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public RespResult saveDog(Dogs dog) {
        int insert = mapper.insert(dog);
        if (insert == 0) {
            return RespResultUtil.success(RespResultEnum.ADD_UPDATE_FAILED);
        }
        return RespResultUtil.success(RespResultEnum.ADD_UPDATE_SUCCESS, dog);
    }

    /**
     * 修改
     *
     * @param dog
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public RespResult updateDog(Dogs dog) {
        int update = mapper.updateByPrimaryKeySelective(dog);
        if (update == 0) {
            return RespResultUtil.success(RespResultEnum.ADD_UPDATE_FAILED);
        }
        return RespResultUtil.success(RespResultEnum.ADD_UPDATE_SUCCESS, dog);
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
        Dogs dog = mapper.selectByPrimaryKey(id);
        if (dog == null) {
            return RespResultUtil.success(RespResultEnum.EMPTY_RESULT);
        }
        return RespResultUtil.success(RespResultEnum.QUERY_SUCCESS, dog);
    }

    /**
     * 列表查询
     *
     * @param dog      条件值
     * @param page     当前页
     * @param pageSize 每页条数
     * @return HTTP返回值封装对象
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public RespResult queryDogList(Dogs dog, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        Example example = new Example(Dogs.class);
        Example.Criteria criteria = example.createCriteria();
        if (dog.getDogName() != null) {
            criteria.andLike("dogName", "%" + dog.getDogName() + "%");
        }
        if (dog.getDogAge() != null) {
            criteria.andLike("dogAge", "%" + dog.getDogAge() + "%");
        }
        example.orderBy("dogId").desc();
        PageInfo<Dogs> pageInfo = new PageInfo<>(mapper.selectByExample(example));
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
        Dogs dog = mapper.selectByPrimaryKey(id);
        Integer age = dog.getDogAge();
        if (age < 10) {
            throw new CustomException(RespResultEnum.WRONG_PARAMETER_VALUE);
        } else if (age > 10 && age < 16) {
            throw new CustomException(RespResultEnum.WRONG_PARAMETER_FORMAT);
        }
    }
}
