package com.test.annotation.testannotation;

import com.test.annotation.annotation.Property;
import com.test.annotation.annotation.Test;
import com.test.annotation.annotation.TestAnnotation;

/**
 * 从java源码到class字节码是由编译器完成的，编译器会对java源码进行解析并生成class文件，
 * 而注解也是在编译时由编译器进行处理，编译器会对注解符号处理并附加到class结构中，
 * 根据jvm规范，class文件结构是严格有序的格式，唯一可以附加信息到class结构中的方式就是
 * 保存到class结构的attributes属性中。我们知道对于类、字段、方法，在class结构中都有
 * 自己特定的表结构，而且各自都有自己的属性，而对于注解，作用的范围也可以不同，可以作用在类上，
 * 也可以作用在字段或方法上，这时编译器会对应将注解信息存放到类、字段、方法自己的属性上。

 * 在我们的AnnotationTest类被编译后，在对应的AnnotationTest.class文件中会包含一个
 * RuntimeVisibleAnnotations属性，由于这个注解是作用在类上，所以此属性被添加到类的属性集上。
 * 即Test注解的键值对value=test会被记录起来。而当JVM加载AnnotationTest.class文件字节码时，
 * 就会将RuntimeVisibleAnnotations属性值保存到AnnotationTest的Class对象中，于是就
 * 可以通过AnnotationTest.class.getAnnotation(Test.class)获取到Test注解对象，
 * 进而再通过Test注解对象获取到Test里面的属性值。
 * @author wangyuheng
 *
 */
// 给一个类加注解
@Test
public class AnnotationTest {
	// 给构造器加注解
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
	// 给一个方法加注解
	@TestAnnotation("tomcat-method-666")
	public void testAnno(){
		
	}
	
}
