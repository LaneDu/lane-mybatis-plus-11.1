package com.galaxy.mybatisplusspringboot;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.galaxy.mapper.UserMapper;
import com.galaxy.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
class MybatisPlusSpringbootApplicationTests {

	@Autowired
	private UserMapper userMapper;
	/**
	 * 测试查询全部
	 * @author lane
	 * @date 2021/10/17 上午10:55
	 */
	@Test
	public  void testSpringbootMP(){

		List<User> users = userMapper.selectList(null);
		users.forEach(user ->
				System.out.println(user));

		System.out.println(userMapper.findById(1));

	}

	/**
	 * 测试插入
	 * @author lane
	 * @date 2021/10/17 上午10:56
	 */
	@Test
	public  void testInsert(){

		User user = new User();
		user.setAge(29);
		user.setMail("lane29.d@outlook.com");
		user.setName("lane29");
		int i = userMapper.insert(user);
		System.out.println("插入行数为"+i);
		//MP会在插入之后为我们添加ID
		System.out.println("user id ："+user.getId());

	}

	/**
	 * 测试更新ById
	 * @author lane
	 * @date 2021/10/17 上午10:56
	 */
	@Test
	public  void testUpdateById(){

		User user = new User();
		//更新内容
		user.setAge(21);
		user.setName("lane2");
		user.setId(6l);
		int i = userMapper.updateById(user);
		System.out.println("更新行数为"+i);
		//MP会在插入之后为我们添加ID
		System.out.println("user id ："+user.getId());

	}
	/**
	 * 测试条件更新
	 * @author lane
	 * @date 2021/10/17 上午10:56
	 */
	@Test
	public  void testUpdateCondition(){

		User user = new User();
		//更新内容
		user.setAge(23);
		user.setName("lane3");
		//更新条件
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("id", 6);
		int i = userMapper.update(user, queryWrapper);
		System.out.println("行数为"+i);
		//MP会在插入之后为我们添加ID
		System.out.println("user name ："+user.getName());

	}

	/**
	 * 测试条件更新2
	 * @author lane
	 * @date 2021/10/17 上午10:56
	 */
	@Test
	public  void testUpdateCondition2(){


		//更新的条件以及字段
		UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
		updateWrapper.eq("id", 6)
				.set("name","lane4")
				.set("age",24);
		int i = userMapper.update(null, updateWrapper);
		System.out.println("行数为"+i);

	}
	/**
	 *
	 * 测试四种删除方法
	 * @author lane
	 * @date 2021/10/17 下午3:11
	 */
	@Test
	public void testDelete(){

		//deleteById
		int i = userMapper.deleteById(6l);

		//deleteByMap
		Map<String, Object> map = new HashMap<>();
		//多个之间是and的关系
		map.put("age",27);
		map.put("name","lane27");
		userMapper.deleteByMap(map);

		//delete
		User user = new User();
		user.setName("lane28");
		user.setAge(28);
		QueryWrapper<User> queryWrapper = new QueryWrapper<>(user);
		userMapper.delete(queryWrapper);

		//deleteBatchIds
		userMapper.deleteBatchIds(Arrays.asList(10,11));

	}

	/**
	 * 测试查询
	 * @author lane
	 * @date 2021/10/17 下午3:40
	 */
	@Test
	public void testSelect(){
		System.out.println("selectById");
		//selectById 根据 ID 查询
		User user = userMapper.selectById(3);
		System.out.println(user);
		System.out.println("selectBatchIds");
		//selectBatchIds
		//查询（根据ID 批量查询） @param idList 主键ID列表(不能为 null 以及 empty)
		List<User> users = userMapper.selectBatchIds(Arrays.asList(4, 5));
		users.forEach(user1 -> System.out.println(user1));
		System.out.println("selectByMap");
		//selectByMap
		Map<String, Object> map = new HashMap<>();
		//多个之间是and的关系
		map.put("age",27);
		map.put("name","lane27");
		List<User> usersMap = userMapper.selectByMap(map);
		usersMap.forEach(user1 -> System.out.println(user1));
		System.out.println("selectList");
		//selectList
		//根据 entity 条件，查询全部记录 * * @param queryWrapper 实体对象封装操作类（可以为 null）
		QueryWrapper<User> queryWrapper = new QueryWrapper();
		queryWrapper.gt("age", 27);//age 大于27
		List<User> usersWrapper = userMapper.selectList(queryWrapper);
		usersWrapper.forEach(user1 -> System.out.println(user1));
		System.out.println("selectCount");
		//selectCount
		//根据 Wrapper 条件，查询总记录数 * * @param queryWrapper 实体对象封装操作类（可以为 null）
		Integer count = userMapper.selectCount(queryWrapper);
		System.out.println(count);
		System.out.println("selectOne");
		//selectOne
		//根据 entity 条件，查询一条记录 * * @param queryWrapper 实体对象封装操作类（可以为 null）
		QueryWrapper<User> queryWrapper2 = new QueryWrapper();
		queryWrapper2.eq("name", "Jack");
		User user1 = userMapper.selectOne(queryWrapper2);
		System.out.println(user1);
	}


	/**
	 * 分页查询
	 * @author lane
	 * @date 2021/10/17 下午4:25
	 */
	@Test
	public void testPage(){

		QueryWrapper<User> queryWrapper = new QueryWrapper();
		queryWrapper.gt("age", 18);
		queryWrapper.orderByAsc("age");
		//分页信息 当前页面，显示条数
		Page<User> page = new Page<User>(1,2);

		IPage<User> userIPage = userMapper.selectPage(page, queryWrapper);
		System.out.println("当前页 "+userIPage.getCurrent());
		System.out.println("总条数 "+userIPage.getTotal());
		System.out.println("总页数 "+userIPage.getPages());
		System.out.println("信息 "+userIPage.getRecords());


	}

	/**
	 * 测试allEq
	 * @author lane
	 * @date 2021/10/17 下午7:11
	 */
	@Test
	public void testAllEq(){

		Map<String,Object> map = new HashMap<>();
		map.put("age",27);
		map.put("name","lane27");
	    map.put("email",null);
		QueryWrapper<User> queryWrapper = new QueryWrapper();
		//条件查询
		queryWrapper.allEq(map);//WHERE name = ? AND age = ? AND email IS NULL
		//为false时候忽略条件中的null值
		queryWrapper.allEq(map,false);//where name = ? AND age = ?
		//condition为true时候才进行条件查询
//		queryWrapper.allEq(true,map,true);
		//SELECT id,name,age,email AS mail FROM user WHERE name = ? AND age = ? AND email IS NULL
		List<User> users = userMapper.selectList(queryWrapper);
		users.forEach(user -> System.out.println(user));

	}

	/**
	 * 测试基本条件
	 * @author lane
	 * @date 2021/10/17 下午7:11
	 */
	@Test
	public void testCondition(){

		QueryWrapper<User> queryWrapper = new QueryWrapper();
		//条件查询
		queryWrapper.gt("age",18 )
				.eq("email", "lane29@outlook.com")
				.in("name", "lane28","lane6")
				.orderByAsc("id");
		List<User> users = userMapper.selectList(queryWrapper);
		users.forEach(user -> System.out.println(user));

	}

	/**
	 * 测试sort or select
	 * @author lane
	 * @date 2021/10/17 下午7:11
	 */
	@Test
	public void testOr(){

		QueryWrapper<User> queryWrapper = new QueryWrapper();
		//条件查询or  WHERE age = ? OR age = ?
		queryWrapper.eq("age", 28).or().eq("age","18");
		//or() desc select
		// SELECT name,age FROM user WHERE age = ? OR age = ? ORDER BY age DESC
		queryWrapper.eq("age", 28).or()
				.eq("age","18")
				.orderByDesc("age")
				.select("name","age");
		List<User> users = userMapper.selectList(queryWrapper);
		users.forEach(user -> System.out.println(user));

	}
	/**
	 * 测试逻辑删除
	 * @author lane
	 * @date 2021/10/18 下午12:34
	 */
	@Test
	public void testDeleteById(){
		// UPDATE user SET deleted=1 WHERE id=? AND deleted=0
		this.userMapper.deleteById(2L);
	}

	/**
	 * 测试逻辑删除
	 * @author lane
	 * @date 2021/10/18 下午12:34
	 */
	@Test
	public void testSelectById(){
		// SELECT id,name,age,email AS mail,deleted FROM user WHERE id=? AND deleted=0
		this.userMapper.selectById(2L);
	}
}
