package com.excel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@SuppressWarnings("unchecked")
public interface PoiReadExcelBean {

	/**
	 * ��ȡExcel�ļ������жϽ�����
	 * 
	 * @param filePaths
	 *            �����ļ�·��
	 * @param readRowNum
	 *            ��readRowNum�ж�ȡExcel����
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public List readExcel(String filePaths, int readRowNum) throws FileNotFoundException, IOException;

	/**
	 * ��ȡExcel�ļ������жϽ�����
	 * 
	 * @param filePaths
	 *            �����ļ�·��
	 * @param readRowNum
	 *            ��readRowNum�ж�ȡExcel����
	 * @param lineNum
	 *            ��������������
	 * @param lineKey
	 *            ������
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public List readExcelKey(String filePaths, int readRowNum, int lineNum, String lineKey)
			throws FileNotFoundException, IOException;

	/**
	 * ��ȡExcel�ļ�ָ���У����жϽ�����
	 * 
	 * @param filePaths
	 *            �����ļ�·��
	 * @param readRowNum
	 *            ��readRowNum�ж�ȡExcel����
	 * @param rowNumList
	 *            ָ����ȡ���м���
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public List readExcel(String filePaths, int readRowNum, List rowNumList) throws FileNotFoundException, IOException;

	/**
	 * ��ȡExcel�ļ�ָ���У����жϽ�����
	 * 
	 * @param filePaths
	 *            �����ļ�·��
	 * @param readRowNum
	 *            ��readRowNum�ж�ȡExcel����
	 * @param lineNum
	 *            ��������������
	 * @param lineKey
	 *            ������
	 * @param rowNumList
	 *            ָ����ȡ���м���
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public List readExcelKey(String filePaths, int readRowNum, int lineNum, String lineKey, List rowNumList)
			throws FileNotFoundException, IOException;
}
