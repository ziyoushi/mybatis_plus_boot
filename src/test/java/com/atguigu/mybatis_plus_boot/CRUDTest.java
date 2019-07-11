package com.atguigu.mybatis_plus_boot;

import com.atguigu.mybatis_plus_boot.entity.User;
import com.atguigu.mybatis_plus_boot.mapper.UserMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @create 2019-07-10 16:11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CRUDTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert(){
        User user = new User();
        user.setName("z4");
        user.setAge(23);
        user.setEmail("zhang@qq.com");
        int insert = userMapper.insert(user);
        //System.out.println(insert);
        System.out.println(user.getId());
    }

    @Test
    public void testUpdate(){

        User user = new User();
        user.setId(1149142506306551810L);
        user.setName("zhao888");
        int result = userMapper.updateById(user);

        System.out.println(result);

    }

    @Test
    public void testFill(){

        User user = new User();
        user.setName("zhaoliu");
        user.setAge(24);
        user.setEmail("zhao@qq.com");

        int result = userMapper.insert(user);
        System.out.println(result);
        System.out.println(user.getId());

    }

    //测试乐观锁
    @Test
    public void testOptimisticLock(){
        User user = userMapper.selectById(1L);

        user.setName("sun");
        user.setEmail("sun@123.com");
        int result = userMapper.updateById(user);
        System.out.println(result);

    }

    //查询测试
    @Test
    public void testSelectById(){
        User user = userMapper.selectById(1L);
        System.out.println(user);
    }

    //多个id批量查询
    @Test
    public void testSelectBatchIds(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);
    }

    //简单的条件查询

    /**
     * 注意：map中的key对应数据库中的列名
     *     eg:数据库中user_id,实体类中是userId 则此时的key应该写user_id
     */
    @Test
    public void testSelectByMap(){
        HashMap<String,Object> map = new HashMap<>();
        map.put("name","sun");
        map.put("age",18);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    //分页 通过Page对象来获取相关数据
    @Test
    public void testSelectPage(){

        Page<User> page = new Page<>(1,5);
        userMapper.selectPage(page,null);
        page.getRecords().forEach(System.out::println);

    }

    //使用map结果集
    @Test
    public void testSelectMapsPage(){

        Page<User> page = new Page<>(1,5);

        IPage<Map<String, Object>> mapIPage = userMapper.selectMapsPage(page, null);
        mapIPage.getRecords().forEach(System.out::println);
        System.out.println(mapIPage.getCurrent());
        System.out.println(mapIPage.getPages());
    }

    //删除 根据id删除
    @Test
    public void testDeleteById(){

        int result = userMapper.deleteById(1148910482594258947L);

        System.out.println(result);
    }

    //逻辑删除
    @Test
    public void testLogicDelete(){

        int i = userMapper.deleteById(1L);
        System.out.println(i);

    }


}
