package com.galaxy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.galaxy.pojo.User;

import java.util.List;

/**
 * @author lane
 * @date 2021年10月16日 下午4:45
 */
public interface UserMapper extends BaseMapper<User> {


    List<User> findAll();

}
