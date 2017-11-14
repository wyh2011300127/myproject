package com.excel;

import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;

@SuppressWarnings("unchecked")
public interface PoiWriteExcelBean {

	/**
	 * ������ͨ����
	 * 
	 * @param em
	 *            ����ģ�����
	 * @param wb
	 *            ��ǰ������
	 * @param fialList
	 *            ����ͷ�������б�
	 * @param clist
	 *            ���������б�
	 * @throws Exception
	 */
	public void writePoiExcel(ExcelModel em, Workbook wb, List fialList, List clist) throws Exception;

	/**
	 * ������sheet��ͬ��ʽexcel�ļ�
	 * 
	 * @param em
	 *            ����ģ�����
	 * @param wb
	 *            ��ǰ������
	 * @throws Exception
	 */
	public void writeManySheet(ExcelModel em, Workbook wb) throws Exception;

	/**
	 * �౨��ϲ�
	 * 
	 * @param em
	 *            ����ģ�����
	 * @param wb
	 *            ��ǰ������
	 * @param clist
	 *            ���ݼ���
	 * @param fialList
	 *            ����ͷ�������б�
	 * @throws Exception
	 */
	public void writeExcelUnite(ExcelModel em, Workbook wb, List clist, List fialList) throws Exception;

	/**
	 * ��ʼ��excel�ļ�
	 * 
	 * @param excelName
	 *            �ļ�·��
	 * @throws Exception
	 * @return
	 */
	public Workbook JudgeExcelType(String excelName) throws Exception;

	/**
	 * ����excel�ļ�
	 * 
	 * @param excelName
	 *            �ļ�·��
	 * @param wb
	 *            ��ǰ������
	 * @throws Exception
	 */
	public void closeWorkbook(String excelName, Workbook workbook) throws Exception;

	/**
	 * ��ͷ�ϲ���Ԫ��excel�ļ�
	 * 
	 * @param em
	 *            ����ģ�����
	 * @param wb
	 *            ��ǰ������
	 * @throws Exception
	 */
	public void UniteHeadSheet(ExcelModel em, Workbook wb, List fialList, List uniteRowList) throws Exception;
}
