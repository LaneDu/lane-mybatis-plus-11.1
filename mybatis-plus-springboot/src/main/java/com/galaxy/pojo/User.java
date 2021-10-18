package com.galaxy.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lane
 * @date 2021年10月16日 下午4:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User extends Model<User> {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
//    @TableField(select = false) //不想查出该值
    private Integer age;
    @TableField(value = "email") //数据库字段名不一致
    private String mail;
    @TableField(exist = false) //数据库字段不存在
    private String address;

    @TableLogic
    private Integer deleted;

//    @Version  //version乐观锁插件功能
//    @TableField(fill = FieldFill.INSERT) //自动填充功能
//    private Integer version;

}
