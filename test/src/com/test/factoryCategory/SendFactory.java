package com.test.factoryCategory;
/**
 * 工厂，生成实例
 * @author wangyuheng
 *
 */
public class SendFactory {

	public Sender produce(String type) {
		
		if ("main".equals(type)) {
			return new MailSender();
		} else if ("sms".equals(type)) {
			return new SmsSender();
		} else {
			System.out.println("请输入正确的类型！");
			return null;
		}
	}
	
	
}
