package com.test.annotation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 一般注解可以分为三类：

    一类是Java自带的标准注解，包括@Override、@Deprecated和@SuppressWarnings，
    分别用于标明重写某个方法、标明某个类或方法过时、标明要忽略的警告，用这些注解标明后编译器就会进行检查。
    一类为元注解，元注解是用于定义注解的注解，包括@Retention、@Target、@Inherited、
    @Documented，@Retention用于标明注解被保留的阶段，@Target用于标明注解使用的范围，
    @Inherited用于标明注解可继承，@Documented用于标明是否生成javadoc文档。
    一类为自定义注解，可以根据自己的需求定义注解，并可用元注解对自定义注解进行注解。
 * @author wangyuheng
 *
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {
	String value() default "default";
}
