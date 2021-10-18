package com.galaxy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.galaxy.pojo.User;

import java.util.List;

/**
 * @author lane
 * @date 2021年10月18日 下午12:01
 */
/*
    通用mapper接口，以后创建其他mapper接口时，不再继承BaseMapper，而是继承MyBaseMapper
 */
public interface MyBaseMapper<T> extends BaseMapper<T> {

    /*
            查询所有用户
    */
    public List<User> findAll();

}
