package cn.tyler.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.tyler.mybatis.mapper.MapperDemo;
import cn.tyler.mybatis.vo.EmpVO;

/**
 * Hello world!
 *
 */
public class App
{
    /**
     * 第一种方式
     */
    @Test
    public void demo1()
    {
	String resource = "mybatis-config.xml";
	InputStream inputStream;
	try
	{
	    inputStream = Resources.getResourceAsStream(resource);
	    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

	    SqlSession session = sqlSessionFactory.openSession();

	    EmpVO vo = session.selectOne("cn.tyler.mybatis.mapper.MapperDemo.findEmpByNumber", 7369);

	    System.out.println(vo);
	    
	    session.close();
	} catch (IOException e)
	{
	    e.printStackTrace();
	}
    }

    /**
     * 第二种方式
     * 1,不基于字符串常量的，就会更安全
     * 2,其次，如果你的 IDE 有代码补全功能，那么你可以在有了已映射 SQL 语句的基础之上利用这个功能
     */
    
    @Test
    public void demo2()
    {
	String resource = "mybatis-config.xml";
	InputStream inputStream;
	try
	{
	    inputStream = Resources.getResourceAsStream(resource);
	    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	    SqlSession session = sqlSessionFactory.openSession();
	    
	    MapperDemo mapper = session.getMapper(MapperDemo.class);
	    
	    EmpVO empVO = mapper.findEmpByNumber(7369);
	    
	    System.out.println(empVO);
	    
	    session.close();
	} catch (IOException e)
	{
	    e.printStackTrace();
	}

    }
    
    /*
        package org.mybatis.example;
        public interface BlogMapper {
          @Select("SELECT * FROM blog WHERE id = #{id}")
          Blog selectBlog(int id);
        }
                        映射器类（Mapper class）  映射的语句可以不需要用 XML 来做。取而代之的是可以使用 Java 注解
                       对于简单语句来说，注解使代码显得更加简洁，然而 Java 注解对于稍微复杂的语句就会力不从心并且会显得更加混乱。
                       因此，如果你需要做很复杂的事情，那么最好使用 XML 来映射语句。               
     */
}
