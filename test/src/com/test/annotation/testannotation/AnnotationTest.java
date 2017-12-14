package com.test.annotation.testannotation;

import com.test.annotation.annotation.Property;
import com.test.annotation.annotation.Test;
import com.test.annotation.annotation.TestAnnotation;

/**
 * ��javaԴ�뵽class�ֽ������ɱ�������ɵģ����������javaԴ����н���������class�ļ���
 * ��ע��Ҳ���ڱ���ʱ�ɱ��������д������������ע����Ŵ������ӵ�class�ṹ�У�
 * ����jvm�淶��class�ļ��ṹ���ϸ�����ĸ�ʽ��Ψһ���Ը�����Ϣ��class�ṹ�еķ�ʽ����
 * ���浽class�ṹ��attributes�����С�����֪�������ࡢ�ֶΡ���������class�ṹ�ж���
 * �Լ��ض��ı�ṹ�����Ҹ��Զ����Լ������ԣ�������ע�⣬���õķ�ΧҲ���Բ�ͬ���������������ϣ�
 * Ҳ�����������ֶλ򷽷��ϣ���ʱ���������Ӧ��ע����Ϣ��ŵ��ࡢ�ֶΡ������Լ��������ϡ�

 * �����ǵ�AnnotationTest�౻������ڶ�Ӧ��AnnotationTest.class�ļ��л����һ��
 * RuntimeVisibleAnnotations���ԣ��������ע�������������ϣ����Դ����Ա���ӵ�������Լ��ϡ�
 * ��Testע��ļ�ֵ��value=test�ᱻ��¼����������JVM����AnnotationTest.class�ļ��ֽ���ʱ��
 * �ͻὫRuntimeVisibleAnnotations����ֵ���浽AnnotationTest��Class�����У����Ǿ�
 * ����ͨ��AnnotationTest.class.getAnnotation(Test.class)��ȡ��Testע�����
 * ������ͨ��Testע������ȡ��Test���������ֵ��
 * @author wangyuheng
 *
 */
// ��һ�����ע��
@Test
public class AnnotationTest {
	// ����������ע��
	@Property()
	public AnnotationTest(){
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Test test = AnnotationTest.class.getAnnotation(Test.class);
		System.out.println(test.value());
		
		TestAnnotation methodAnno = null;
		try {
			methodAnno = AnnotationTest.class.getDeclaredMethod("testAnno",
					null).getAnnotation(TestAnnotation.class);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(methodAnno.value());
		
		Property annotation = null;
		try {
			annotation = AnnotationTest.class.getConstructor().getAnnotation(Property.class);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		System.out.println(annotation.value());
		
		
	}
	// ��һ��������ע��
	@TestAnnotation("tomcat-method-666")
	public void testAnno(){
		
	}
	
}
