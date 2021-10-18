package com.galaxy.injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;

import java.util.List;

/**
 * @author lane
 * @date 2021年10月18日 下午12:03
 */
/*
    自定义sql注入器
 */
public class MySqlInjector extends DefaultSqlInjector {


    @Override
    public List<AbstractMethod> getMethodList() {

        List<AbstractMethod> methodList = super.getMethodList();
        // 扩充自定义方法
        methodList.add(new FindAll());

        return methodList;
    }
}