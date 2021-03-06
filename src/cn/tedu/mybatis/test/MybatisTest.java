package cn.tedu.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.tedu.mybatis.beans.Dept;
import cn.tedu.mybatis.beans.Grade;
import cn.tedu.mybatis.beans.User;



public class MybatisTest {
	private SqlSessionFactory factory = null;
	@Before
	public void before() throws Exception{
		//1.读取MyBatis核心配置文件
		InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
		//2.根据配置文件创建sqlSessionFactory
		factory = new SqlSessionFactoryBuilder().build(in);
	}
	@Test
	public void test01() throws IOException{
		//3.创建sqlSession
		SqlSession session = factory.openSession();
		//4.执行操作
		List<User> list = session.selectList("cn.tedu.mybatis.beans.UserMapper.queryAll");
		//5.遍历结果
		System.out.println(Arrays.toString(list.toArray()));
	}
	@Test
	public void test02() throws IOException{
		//通过map准备参数
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("min", 30);
		map.put("max", 40);
		//3.创建sqlSession
		SqlSession session = factory.openSession();
		//4.执行操作
		List<User> list = session.selectList("cn.tedu.mybatis.beans.UserMapper.queryRange",map);
		//5.遍历结果
		System.out.println(Arrays.toString(list.toArray()));
	}
	@Test
	public void test03() throws IOException{
		//1通过对象准备参数
		User user = new User();
		user.setName("fff");
		user.setAge(55);
		//2.创建sqlSession
		SqlSession session = factory.openSession();
		//3.执行操作
		session.insert("cn.tedu.mybatis.beans.UserMapper.insertUser",user);
		//4.提交事务
		session.commit();
	}
	@Test
	public void test04() throws IOException{
		//3.创建sqlSession
		SqlSession session = factory.openSession();
		//4.执行操作
		User user = session.selectOne("cn.tedu.mybatis.beans.UserMapper.queryOne",4);
		//5.遍历结果
		System.out.println(user);
	}
	@Test
	public void test05() throws IOException{
		//通过map准备参数
		Map<String,String> map = new HashMap<String,String>();
		map.put("cname", "age");
		//3.创建sqlSession
		SqlSession session = factory.openSession();
		//4.执行操作
		List<User> list = session.selectList("cn.tedu.mybatis.beans.UserMapper.queryAllOrder",map);
		//5.遍历结果
		System.out.println(Arrays.toString(list.toArray()));
	}
	@Test
	public void test06() throws IOException{
		User user = new User();
		user.setId(3);
//		user.setName("yyy");
		user.setAge(33);
		//3.创建sqlSession
		SqlSession session = factory.openSession();
		//4.执行操作
		session.update("cn.tedu.mybatis.beans.UserMapper.updateOne",user);
		//5.提交事务
		session.commit();
	}
	@Test
	public void test07() throws IOException{
		User user = new User();
		user.setId(3);
//		user.setName("yyy");
//		user.setAge(33);
		//3.创建sqlSession
		SqlSession session = factory.openSession();
		//4.执行操作
		User userx = session.selectOne("cn.tedu.mybatis.beans.UserMapper.queryMany",user);
		//5.查看结果
		System.out.println(userx);
	}
	@Test
	public void test08() throws IOException{
		User user = new User();
//		user.setId(3);
		user.setName("xxx");
//		user.setAge(33);
		//3.创建sqlSession
		SqlSession session = factory.openSession();
		//4.执行操作
		session.insert("cn.tedu.mybatis.beans.UserMapper.insertOne",user);
		//5.提交事务
		session.commit();
	}
	@Test
	public void test09() throws IOException{
		User user = new User();
//		user.setId(12);
//		user.setName("xxx");
		user.setAge(33);
		//3.创建sqlSession
		SqlSession session = factory.openSession();
		//4.执行操作
		session.delete("cn.tedu.mybatis.beans.UserMapper.deleteOne",user);
		//5.提交事务
		session.commit();
	}
	@Test
	public void test10() throws IOException{
		//3.创建sqlSession
		SqlSession session = factory.openSession();
		//4.执行操作
		List<User> list = session.selectList("cn.tedu.mybatis.beans.UserMapper.queryByMapping");
		//5.遍历结果
		System.out.println(list);
	}
	@Test
	public void test11() throws IOException{
		//3.创建sqlSession
		SqlSession session = factory.openSession();
		//4.执行操作
		List<Grade> list = session.selectList("cn.tedu.mybatis.beans.UserMapper.queryo2o");
		//5.遍历结果
		System.out.println(list);
	}
	@Test
	public void test12() throws IOException{
		//3.创建sqlSession
		SqlSession session = factory.openSession();
		//4.执行操作
		List<Dept> list = session.selectList("cn.tedu.mybatis.beans.UserMapper.queryo2m");
		//5.遍历结果
		System.out.println(list);
	}
}
