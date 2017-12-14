package com.test.properties;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
/**
 * ���ȣ�Java�е�getResourceAsStream�����¼��֣�
	1. Class.getResourceAsStream(String path) �� path ���ԡ�/'��ͷʱĬ���ǴӴ������ڵİ���ȡ��Դ��
	�ԡ�/'��ͷ���Ǵ�ClassPath���»�ȡ����ֻ��ͨ��path����һ������·�������ջ�����ClassLoader��ȡ��Դ��
	2. Class.getClassLoader.getResourceAsStream(String path) ��Ĭ�����Ǵ�ClassPath���»�ȡ��
	path�����ԡ�/'��ͷ����������ClassLoader��ȡ��Դ��
	3. ServletContext. getResourceAsStream(String path)��Ĭ�ϴ�WebAPP��Ŀ¼��ȡ��Դ��
	Tomcat��path�Ƿ��ԡ�/'��ͷ����ν����Ȼ��;��������ʵ���йء�
	4. Jsp�µ�application���ö�����������ServletContext��һ��ʵ�֡�
	��Σ�getResourceAsStream �÷����������¼��֣�
	��һ�� Ҫ���ص��ļ���.class�ļ���ͬһĿ¼�£����磺com.x.y ������me.class ,ͬʱ����Դ�ļ�myfile.xml
	��ô��Ӧ�������´��룺
	me.class.getResourceAsStream("myfile.xml");
	�ڶ�����me.classĿ¼����Ŀ¼�£����磺com.x.y ������me.class ,ͬʱ�� com.x.y.file Ŀ¼������Դ�ļ�myfile.xml
	��ô��Ӧ�������´��룺
	me.class.getResourceAsStream("file/myfile.xml");
	����������me.classĿ¼�£�Ҳ������Ŀ¼�£����磺com.x.y ������me.class ,ͬʱ�� com.x.file Ŀ¼������Դ�ļ�myfile.xml
	��ô��Ӧ�������´��룺
	me.class.getResourceAsStream("/com/x/file/myfile.xml");
	�ܽ�һ�£�����ֻ������д��
	��һ��ǰ���� ��   / ��
	�� / �������˹��̵ĸ�Ŀ¼�����繤��������myproject���� / ��������myproject
	me.class.getResourceAsStream("/com/x/file/myfile.xml");
	�ڶ���ǰ��û�� ��   / ��
	����ǰ���Ŀ¼
	me.class.getResourceAsStream("myfile.xml");
	me.class.getResourceAsStream("file/myfile.xml");
	����Լ�����⣺
	getResourceAsStream��ȡ���ļ�·��ֻ�����빤�̵�Դ�ļ����У������ڹ���src��Ŀ¼�£��Լ���������κ�λ�ã�
	������������ļ�·�����ڳ���Դ�ļ���֮��������ļ�����ʱ���÷������ò��˵ġ� 
 * @author wangyuheng
 *
 */
public class PropertiesDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("��ʼ");
		InputStream resourceAsStream = PropertiesDemo.class
				.getResourceAsStream("/log4j.properties");
		
		Properties properties = new Properties();
		try {
			properties.load(resourceAsStream);
			Iterator<Object> iterator = properties.keySet().iterator();
			while(iterator.hasNext()){
				String key = (String) iterator.next();
				String property = properties.getProperty(key);
				System.out.println(key+":"+property);
				//InputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(property)));	
					
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		InputStream resourceAsStream2 = PropertiesDemo.class.getClassLoader().getResourceAsStream("log4j.properties");
		System.out.println(resourceAsStream2);
		
		System.out.println("����");
	}

}



