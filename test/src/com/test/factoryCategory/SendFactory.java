package com.test.factoryCategory;
/**
 * ����������ʵ��
 * @author wangyuheng
 *
 */
public class SendFactory {

	/**
	 * ��ͨ��������ģʽ
	 * @param type
	 * @return
	 */
	public Sender produce(String type) {
		
		if ("main".equals(type)) {
			return new MailSender();
		} else if ("sms".equals(type)) {
			return new SmsSender();
		} else {
			System.out.println("��������ȷ�����ͣ�");
			return null;
		}
	}
	
	/**
	 * �����������ģʽ
	 * @return
	 */
	public Sender produceSms(){
		return new SmsSender();
	}
	
	public Sender produceMail(){
		return new MailSender();
	}
	
	/**
	 * ��̬��������ģʽ
	 * @return
	 */
	public static Sender produceMailStatic(){  
        return new MailSender();  
    }  
      
    public static Sender produceSmsStatic(){  
        return new SmsSender();  
    }  
	
}
