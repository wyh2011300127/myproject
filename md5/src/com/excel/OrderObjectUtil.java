package com.excel;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Arrays;

/**
 * ͨ��list�����е����ݣ����а�ĳ���������Խ�������
 * 
 * Ŀǰ֧�֣��ַ��������֣�����,���� ����������������
 */
public class OrderObjectUtil {

	/**
	 * �����־
	 */
	public static final String ASC = "ASC";

	/**
	 * �����־
	 */
	public static final String DESC = "DESC";

	/**
	 * �����ֶ���������
	 */
	public static final String NUMBER = "Number";

	/**
	 * �����ֶ���������
	 * 
	 */
	public static final String STRING = "String";

	/**
	 * �����ֶ���������
	 */
	public static final String DATE = "Date";

	/**
	 * �����ֶ�Boolean
	 */
	public static final String BOOLEAN = "Boolean";

	/**
	 * ����֮��Ķ���
	 * 
	 */
	private List orberObjectBefor;

	/**
	 * ����֮���Ķ���
	 * 
	 */
	private List orberObjectAfter;

	/**
	 * �������� �����ǽ���
	 */
	private String orderType = "ASC";

	/**
	 * �����ֶ���
	 * 
	 * @return
	 */
	private String orderFieldName = null;

	/**
	 * �����ֶ��������� ���ֻ�������
	 */
	private String OrderFieldDataType = "String";

	public String getOrderFieldName() {
		return orderFieldName;
	}

	public void setOrderFieldName(String orderFieldName) {
		this.orderFieldName = orderFieldName;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	/**
	 * ���������list����
	 * 
	 * @return
	 */
	public List getOrberObjectAfter() {
		return orberObjectAfter;
	}

	/**
	 * ������Ҫ�����list����
	 * 
	 * @param orberObjectBefor
	 */
	public void setOrberObjectBefor(List orberObjectBefor) {
		this.orberObjectBefor = orberObjectBefor;
	}

	/**
	 * ����������������
	 * 
	 * @return
	 */
	public String getOrderFieldDataType() {
		return OrderFieldDataType;
	}

	/**
	 * �����������������(String,Date,Number,Boolean)
	 * 
	 * @param orderFieldDataType
	 */
	public void setOrderFieldDataType(String orderFieldDataType) {
		OrderFieldDataType = orderFieldDataType;
	}

	/**
	 * ͨ���������ͣ������ֶ�
	 * 
	 * @param orderField
	 *            �����ֶ�
	 * @param filedType
	 *            �����ֶ���������(���ֻ����֣�
	 * @param orderType
	 *            �������ͣ��������
	 * 
	 * @return
	 */
	public List findOrderByObject(String orderFieldName, String orderFieldDataType, String orderType) {
		this.orderType = orderType;
		this.OrderFieldDataType = orderFieldDataType;
		this.orderFieldName = orderFieldName;
		return this.findOrderByObject();

	}

	/**
	 * ͨ���������ͣ������ֶ�
	 * 
	 * @param orderObject
	 *            �������
	 * @param orderField
	 *            �����ֶ�
	 * @param filedType
	 *            �����ֶ���������(���ֻ����֣�
	 * @param orderType
	 *            �������ͣ��������
	 * 
	 * @return
	 */
	public List findOrderByObject(List orderObject, String orderFieldName, String orderFieldDataType, String orderType) {
		this.orderType = orderType;
		this.orberObjectBefor = orderObject;
		this.OrderFieldDataType = orderFieldDataType;
		this.orderFieldName = orderFieldName;
		return this.findOrderByObject();

	}

	/**
	 * ���������List����
	 * 
	 * @return
	 */
	private List findOrderByObject() {
		if (this.orberObjectBefor == null || orderFieldName == null || orderFieldName.trim().equals("")) {
			return this.orberObjectBefor;
		}
		String[][] OrderFiledBefor = this.getOrderFiledArray();
		String[][] OrderFiledAfter = this.orderFiled(OrderFiledBefor);
		this.orderObject(OrderFiledAfter);
		return this.orberObjectAfter;
	}

	/**
	 * ��������
	 * 
	 * @param field
	 * @return
	 */
	private String[][] orderFiled(String[][] fieldArray) {
		String[][] newFieldArray = null;
		if (fieldArray != null) {
			// ����������

			if (this.OrderFieldDataType.equals(OrderObjectUtil.STRING)) {
				newFieldArray = this.orderByString(fieldArray);
			} else if (this.OrderFieldDataType.equals(OrderObjectUtil.NUMBER)) {
				// ����������

				newFieldArray = this.orderByNumber(fieldArray);
			} else if (this.OrderFieldDataType.equals(OrderObjectUtil.DATE)) {
				// ����������

				newFieldArray = this.orderByNumber(fieldArray);
			} else if (this.OrderFieldDataType.equals(OrderObjectUtil.BOOLEAN)) {
				// ��������
				newFieldArray = this.orderByNumber(fieldArray);
			}
		}
		return newFieldArray;
	}

	/**
	 * ���ַ�����������
	 * 
	 * @param fieldArray
	 *            �����������
	 * @return
	 */
	private String[][] orderByString(String[][] fieldArray) {
		String[][] newFieldArray = null;
		String[] orderFieldDataAfter = new String[fieldArray.length];
		newFieldArray = new String[fieldArray.length][2];
		for (int i = 0; i < fieldArray.length; i++) {
			orderFieldDataAfter[i] = fieldArray[i][1];
		}
		Arrays.sort(orderFieldDataAfter);// ��ֵ��������

		boolean islike = false;// �Ƿ�����һ����ͬ

		String curValue = null;// ��ǰ����ֵ

		int curIndex = -1;// ��ǰԭʼ�����±�ֵ

		for (int i = 0; i < orderFieldDataAfter.length; i++) {
			islike = false;// ��ʼΪfalse
			if (i != 0 && orderFieldDataAfter[i].equals(curValue)) {
				islike = true;// �����ǰ��

			}
			curValue = orderFieldDataAfter[i];// ����ǰ����ֵ

			int beginLength = 0;// ��ʼ����

			if (islike) {
				beginLength = curIndex + 1;// �������ͬ����Ӻ�һ����
			}
			for (int j = beginLength; j < fieldArray.length; j++) {
				if (fieldArray[j][1].equals(curValue)) {
					curIndex = j;
					break;
				}
			}
			newFieldArray[i][0] = Integer.toString(curIndex);
			newFieldArray[i][1] = curValue;
		}

		return newFieldArray;
	}

	/**
	 * �����ֽ�������
	 * 
	 * @param fieldArray
	 *            �����������
	 * @return
	 */
	private String[][] orderByNumber(String[][] fieldArray) {
		String[][] newFieldArray = null;
		double[] orderFieldDataAfter = new double[fieldArray.length];
		newFieldArray = new String[fieldArray.length][2];
		// ��ô��������

		for (int i = 0; i < fieldArray.length; i++) {
			String tmpData = fieldArray[i][1];
			if (tmpData == null || tmpData.trim().equals("")) {
				tmpData = "0";
			}
			orderFieldDataAfter[i] = Double.parseDouble(tmpData);
		}
		Arrays.sort(orderFieldDataAfter);// ��ֵ��������

		boolean islike = false;// �Ƿ�����һ����ͬ

		double curValue = 0.0;// ��ǰ����ֵ

		int curIndex = -1;// ��ǰԭʼ�����±�ֵ

		for (int i = 0; i < orderFieldDataAfter.length; i++) {
			islike = false;// ��ʼΪfalse
			if (i != 0 && orderFieldDataAfter[i] == curValue) {
				islike = true;// �����ǰ��

			}
			curValue = orderFieldDataAfter[i];// ����ǰ����ֵ

			int beginLength = 0;// ��ʼ����

			if (islike) {
				beginLength = curIndex + 1;// �������ͬ����Ӻ�һ����
			}
			for (int j = beginLength; j < fieldArray.length; j++) {
				String tmpData = fieldArray[j][1];
				if (tmpData == null || tmpData.trim().equals("")) {
					tmpData = "0";
				}
				double oldData = Double.parseDouble(tmpData);
				double newData = curValue;
				if (oldData == newData) {
					curIndex = j;
					break;
				}
			}
			newFieldArray[i][0] = Integer.toString(curIndex);
			newFieldArray[i][1] = Double.toString(curValue);
		}
		return newFieldArray;
	}

	/**
	 * ��õ�ǰ����List�����е��ֶ������ֶ�
	 * 
	 * @param fieldName
	 * @return
	 */
	private String[][] getOrderFiledArray() {
		String[][] fieldArray = null;
		if (this.orberObjectBefor == null && this.orberObjectBefor.size() > 0) {
			return null;
		}
		fieldArray = new String[this.orberObjectBefor.size()][2];
		for (int i = 0; i < this.orberObjectBefor.size(); i++) {
			Object bean = this.orberObjectBefor.get(i);
			fieldArray[i][0] = Integer.toString(i);
			try {
				Object data = null;
				if (this.OrderFieldDataType.equals(OrderObjectUtil.DATE)) {
					data = this.getProperty(bean, this.orderFieldName);
				} else if (this.OrderFieldDataType.equals(OrderObjectUtil.NUMBER)
						|| this.OrderFieldDataType.equals(OrderObjectUtil.STRING)) {
					data = this.getProperty(bean, this.orderFieldName);
				} else if (this.OrderFieldDataType.equals(OrderObjectUtil.BOOLEAN)) {
					data = this.getProperty(bean, this.orderFieldName);
				}

				if (data != null) {
					if (data instanceof Date) {
						fieldArray[i][1] = Long.toString(((Date) data).getTime());
					} else if (this.OrderFieldDataType.equals(OrderObjectUtil.NUMBER)
							|| this.OrderFieldDataType.equals(OrderObjectUtil.STRING)) {
						fieldArray[i][1] = data.toString();
					} else if (this.OrderFieldDataType.equals(OrderObjectUtil.BOOLEAN)) {
						if (data.toString().toLowerCase().equals("true")) {
							fieldArray[i][1] = "1";
						} else {
							fieldArray[i][1] = "0";
						}
					}
				} else {
					fieldArray[i][1] = "";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return fieldArray;
	}

	/**
	 * ��������ǰ��List�еĶ���
	 * 
	 * @param OrderFiledAfter
	 */
	@SuppressWarnings("unchecked")
	private void orderObject(String[][] OrderFiledAfter) {
		if (OrderFiledAfter != null) {
			this.orberObjectAfter = new ArrayList();
			if (this.orderType.equals(OrderObjectUtil.ASC)) {
				for (int i = 0; i < OrderFiledAfter.length; i++) {
					Object object = this.orberObjectBefor.get(Integer.parseInt(OrderFiledAfter[i][0]));
					this.orberObjectAfter.add(object);
				}
			} else {
				for (int i = OrderFiledAfter.length - 1; i >= 0; i--) {
					Object object = this.orberObjectBefor.get(Integer.parseInt(OrderFiledAfter[i][0]));
					this.orberObjectAfter.add(object);
				}
			}
		}
	}

	/**
	 * �����������
	 * 
	 * @param owner
	 * @param fieldName
	 * @return
	 * @throws Exception
	 */
	private Object getProperty(Object owner, String fieldName) throws Exception {
		Class ownerClass = owner.getClass();
		Field[] field = ownerClass.getDeclaredFields();
		for (int i = 0; i < field.length; i++) {
			field[i].setAccessible(true);
			if (field[i].getName().equals(fieldName)) {
				return field[i].get(owner);
			}
		}
		return null;
	}
}