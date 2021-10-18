package com.galaxy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.galaxy.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author lane
 * @date 2021年10月16日 下午4:45
 */
public interface UserMapper extends BaseMapper<User> {


    List<User> findAll();
    User findById(int id);

}
