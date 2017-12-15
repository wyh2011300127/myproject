package com.test.factoryCategory;
/**
 * 工厂，生成实例
 * @author wangyuheng
 *
 */
public class SendFactory {

	/**
	 * 普通工厂方法模式
	 * @param type
	 * @return
	 */
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
	
	/**
	 * 多个工厂方法模式
	 * @return
	 */
	public Sender produceSms(){
		return new SmsSender();
	}
	
	public Sender produceMail(){
		return new MailSender();
	}
	
	/**
	 * 静态工厂方法模式
	 * @return
	 */
	public static Sender produceMailStatic(){  
        return new MailSender();  
    }  
      
    public static Sender produceSmsStatic(){  
        return new SmsSender();  
    }  
	
}
