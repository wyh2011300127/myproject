package com.test.entity;

/**
 * 1.
 * 
 * 所有的class都必须有一个构造方法，如果你没有在代码里声明构造方法，系统会自动给你生成一个公有无参的构造方法。 而只要你自己声明了一个构造方法，
 * 无论有参无参，私有公有，系统就不再帮你生成默认无参构造器了。
 * 
 * 2.
 * 
 * 所有的子类构造器都要求在第一行代码中调用父类构造器，如果不写，系统默认去调用父类的无参构造器
 * 
 * @author wangyuheng
 * 
 */
public class AbstractClassExtendsEntity2 extends AbstractClassExtendsEntity1 {

	public static void main(String[] args) {
		AbstractClassExtendsEntity2 abstractClassExtendsEntity2 = new AbstractClassExtendsEntity2();
		System.out.println(abstractClassExtendsEntity2);
	}

}
