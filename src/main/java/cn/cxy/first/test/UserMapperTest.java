package cn.cxy.first.test;

import cn.cxy.first.dao.mapper.UserMapper;
import cn.cxy.first.model.User;
import cn.cxy.first.model.UserCustomer;
import cn.cxy.first.vo.UserQueryVo;
import junit.framework.TestCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/9/28 21:58 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class UserMapperTest extends TestCase {

    private SqlSessionFactory factory;

    public void setUp() throws Exception {
        String resource = "sqlMapConfig_1.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        factory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public void testFindUserList() throws Exception {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserQueryVo vo = new UserQueryVo();
        UserCustomer customer = new UserCustomer();
        customer.setSex(1);
        customer.setUsername("测试");
        vo.setUser(customer);
        List<Integer> ids = new ArrayList<Integer>(){{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
            add(6);
            add(7);
            add(8);
        }};
        vo.setIds(ids);
        List<String> names = new ArrayList<String>(){{
            add("李二蛋");
            add("张三丰");
            add("测试2");
            add("茅台");
            add("李明慧");
        }};
        vo.setNames(names);
        List<UserCustomer> userList = mapper.findUserList(vo);
        int count = mapper.findUserCount(vo);
        System.err.println(count + " : " + userList);
    }

    public void testFindUserResultMap() throws Exception {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserQueryVo vo = new UserQueryVo();
        UserCustomer customer = new UserCustomer();
        customer.setSex(1);
        customer.setUsername("测试");
        vo.setUser(customer);
        List<User> userList = mapper.findUserResultMap(vo);
        System.err.println(userList);
    }

    /**
     * 动态 sql 测试
     * @throws Exception
     */
    public void testFindConditionsUserList() throws Exception {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserQueryVo vo = new UserQueryVo();
        UserCustomer customer = new UserCustomer();
        customer.setSex(1);
        customer.setUsername("测试");
        vo.setUser(customer);
        List<User> userList = mapper.findConditionsUserList(null);
        System.err.println(userList);
    }

    public void testFindUserById() throws Exception {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findUserById(1);
        System.out.println(user);
    }

    public void testFindUserByName() throws Exception {
        //TODO
    }

    public void testDeleteById() throws Exception {
        //TODO
    }

    public void testAddUser() throws Exception {
        //TODO
    }

}