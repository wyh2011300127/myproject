package com.test.annotation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * һ��ע����Է�Ϊ���ࣺ

    һ����Java�Դ��ı�׼ע�⣬����@Override��@Deprecated��@SuppressWarnings��
    �ֱ����ڱ�����дĳ������������ĳ����򷽷���ʱ������Ҫ���Եľ��棬����Щע�������������ͻ���м�顣
    һ��ΪԪע�⣬Ԫע�������ڶ���ע���ע�⣬����@Retention��@Target��@Inherited��
    @Documented��@Retention���ڱ���ע�ⱻ�����Ľ׶Σ�@Target���ڱ���ע��ʹ�õķ�Χ��
    @Inherited���ڱ���ע��ɼ̳У�@Documented���ڱ����Ƿ�����javadoc�ĵ���
    һ��Ϊ�Զ���ע�⣬���Ը����Լ���������ע�⣬������Ԫע����Զ���ע�����ע�⡣
 * @author wangyuheng
 *
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {
	String value() default "default";
}
