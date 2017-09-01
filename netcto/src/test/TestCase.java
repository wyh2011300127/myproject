package test;

import org.hibernate.impl.SessionFactoryImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class TestCase {
	private ApplicationContext applicationContext;
	@Before
	public void init(){
		applicationContext = new ClassPathXmlApplicationContext("config/spring-common.xml");
	}
	@Test
	public void test1(){
		PropertyPlaceholderConfigurer object = applicationContext.getBean("jdbcConfig",PropertyPlaceholderConfigurer.class);
		System.out.println(object);
	}
	@Test
	public void test2(){
		ComboPooledDataSource comboPooledDataSource = 
				applicationContext.getBean("dataSourceLocal",ComboPooledDataSource.class);
		System.out.println(comboPooledDataSource);
	}
	@Test
	public void test3(){
		Object obj = 
				applicationContext.getBean("sessionFactory", SessionFactoryImpl.class);
		System.out.println(obj);
	}
}






