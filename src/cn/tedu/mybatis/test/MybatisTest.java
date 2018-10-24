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
		//1.��ȡMyBatis���������ļ�
		InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
		//2.���������ļ�����sqlSessionFactory
		factory = new SqlSessionFactoryBuilder().build(in);
	}
	@Test
	public void test01() throws IOException{
		//3.����sqlSession
		SqlSession session = factory.openSession();
		//4.ִ�в���
		List<User> list = session.selectList("cn.tedu.mybatis.beans.UserMapper.queryAll");
		//5.�������
		System.out.println(Arrays.toString(list.toArray()));
	}
	@Test
	public void test02() throws IOException{
		//ͨ��map׼������
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("min", 30);
		map.put("max", 40);
		//3.����sqlSession
		SqlSession session = factory.openSession();
		//4.ִ�в���
		List<User> list = session.selectList("cn.tedu.mybatis.beans.UserMapper.queryRange",map);
		//5.�������
		System.out.println(Arrays.toString(list.toArray()));
	}
	@Test
	public void test03() throws IOException{
		//1ͨ������׼������
		User user = new User();
		user.setName("fff");
		user.setAge(55);
		//2.����sqlSession
		SqlSession session = factory.openSession();
		//3.ִ�в���
		session.insert("cn.tedu.mybatis.beans.UserMapper.insertUser",user);
		//4.�ύ����
		session.commit();
	}
	@Test
	public void test04() throws IOException{
		//3.����sqlSession
		SqlSession session = factory.openSession();
		//4.ִ�в���
		User user = session.selectOne("cn.tedu.mybatis.beans.UserMapper.queryOne",4);
		//5.�������
		System.out.println(user);
	}
	@Test
	public void test05() throws IOException{
		//ͨ��map׼������
		Map<String,String> map = new HashMap<String,String>();
		map.put("cname", "age");
		//3.����sqlSession
		SqlSession session = factory.openSession();
		//4.ִ�в���
		List<User> list = session.selectList("cn.tedu.mybatis.beans.UserMapper.queryAllOrder",map);
		//5.�������
		System.out.println(Arrays.toString(list.toArray()));
	}
	@Test
	public void test06() throws IOException{
		User user = new User();
		user.setId(3);
//		user.setName("yyy");
		user.setAge(33);
		//3.����sqlSession
		SqlSession session = factory.openSession();
		//4.ִ�в���
		session.update("cn.tedu.mybatis.beans.UserMapper.updateOne",user);
		//5.�ύ����
		session.commit();
	}
	@Test
	public void test07() throws IOException{
		User user = new User();
		user.setId(3);
//		user.setName("yyy");
//		user.setAge(33);
		//3.����sqlSession
		SqlSession session = factory.openSession();
		//4.ִ�в���
		User userx = session.selectOne("cn.tedu.mybatis.beans.UserMapper.queryMany",user);
		//5.�鿴���
		System.out.println(userx);
	}
	@Test
	public void test08() throws IOException{
		User user = new User();
//		user.setId(3);
		user.setName("xxx");
//		user.setAge(33);
		//3.����sqlSession
		SqlSession session = factory.openSession();
		//4.ִ�в���
		session.insert("cn.tedu.mybatis.beans.UserMapper.insertOne",user);
		//5.�ύ����
		session.commit();
	}
	@Test
	public void test09() throws IOException{
		User user = new User();
//		user.setId(12);
//		user.setName("xxx");
		user.setAge(33);
		//3.����sqlSession
		SqlSession session = factory.openSession();
		//4.ִ�в���
		session.delete("cn.tedu.mybatis.beans.UserMapper.deleteOne",user);
		//5.�ύ����
		session.commit();
	}
	@Test
	public void test10() throws IOException{
		//3.����sqlSession
		SqlSession session = factory.openSession();
		//4.ִ�в���
		List<User> list = session.selectList("cn.tedu.mybatis.beans.UserMapper.queryByMapping");
		//5.�������
		System.out.println(list);
	}
	@Test
	public void test11() throws IOException{
		//3.����sqlSession
		SqlSession session = factory.openSession();
		//4.ִ�в���
		List<Grade> list = session.selectList("cn.tedu.mybatis.beans.UserMapper.queryo2o");
		//5.�������
		System.out.println(list);
	}
	@Test
	public void test12() throws IOException{
		//3.����sqlSession
		SqlSession session = factory.openSession();
		//4.ִ�в���
		List<Dept> list = session.selectList("cn.tedu.mybatis.beans.UserMapper.queryo2m");
		//5.�������
		System.out.println(list);
	}
}
