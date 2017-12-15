package com.test.factoryCategory;
/**
 * ������˵������ģʽ�ʺϣ����ǳ����˴����Ĳ�Ʒ��Ҫ���������Ҿ��й�ͬ�Ľӿ�ʱ��
 * ����ͨ����������ģʽ���д����������ϵ�����ģʽ�У���һ�����������ַ�������
 * ������ȷ�������󣬵���������ڵڶ��֣�����Ҫʵ���������࣬���ԣ����������£�
 * ���ǻ�ѡ�õ����֡�����̬��������ģʽ��
 * @author wangyuheng
 *
 */
public class FactoryTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * ��ͨ��������ģʽ
		 */
		SendFactory sendFactory = new SendFactory();
		Sender sender = sendFactory.produce("sms");
		sender.send();
		
		
		/**
		 * �����������ģʽ
		 */
		SendFactory factory = new SendFactory();
		Sender mail = factory.produceMail();
		mail.send();
		
		/**
		 * ��̬��������ģʽ
		 */
		Sender mailStatic = SendFactory.produceMailStatic();
		mailStatic.send();
	}

}
