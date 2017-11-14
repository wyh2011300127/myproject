package com.excel;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings( { "unchecked", "serial" })
public class ExcelModel implements Serializable {

	/**
	 * ��ͷ�б���N��List��ɣ�List�ڴ�ű���ͷ�����ݡ�
	 */
	public List titleList;

	/**
	 * �����б���N��Map��ɡ�
	 */
	public List dataList;

	/**
	 * ��ͷ��ʼ�У�Ĭ��ֵΪ"0"��
	 */
	public int cellNum = 0;

	/**
	 * sheet���ơ�
	 */
	public String sheetName;

	/**
	 * �Ƿ��Զ������п�ֵΪ"0"ʱ�Զ������п�Ĭ��ֵΪ"0"��
	 */
	public int autoWidth = 0;

	/**
	 * ����֮��������Ĭ��ֵΪ"0"��
	 */
	public int spaceNum = 0;

	/**
	 * ÿsheet�����������Ĭ��ֵΪ"0"��
	 */
	public int countNum = 0;

	/**
	 * �����ʽ�м���
	 */
	public List styleCell;

	/**
	 * ָ��������
	 */
	public List<Integer> numberRow;

	/**
	 * ÿsheet�����������Ĭ��ֵΪ"0"��
	 */
	public int titleH = 30;

	/**
	 * ��ͷ����ɫ
	 */
	public List<Integer> titleColor;

	/**
	 * ĳ�а��ַ�������
	 */
	public List<Integer> strList;

	/**
	 * ��������ɫ
	 */
	public List<Integer> titleBgColor;

	public List getTitleList() {
		return titleList;
	}

	public void setTitleList(List titleList) {
		this.titleList = titleList;
	}

	public List getDataList() {
		return dataList;
	}

	public void setDataList(List dataList) {
		this.dataList = dataList;
	}

	public int getCellNum() {
		return cellNum;
	}

	public void setCellNum(int cellNum) {
		this.cellNum = cellNum;
	}

	public String getSheetName() {
		return sheetName;
	}

	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	public int getAutoWidth() {
		return autoWidth;
	}

	public void setAutoWidth(int autoWidth) {
		this.autoWidth = autoWidth;
	}

	public int getSpaceNum() {
		return spaceNum;
	}

	public void setSpaceNum(int spaceNum) {
		this.spaceNum = spaceNum;
	}

	public int getCountNum() {
		return countNum;
	}

	public void setCountNum(int countNum) {
		this.countNum = countNum;
	}

	public List getStyleCell() {
		return styleCell;
	}

	public void setStyleCell(List styleCell) {
		this.styleCell = styleCell;
	}

	/**
	 * @return the titleH
	 */
	public int getTitleH() {
		return titleH;
	}

	/**
	 * @param titleH
	 *            the titleH to set
	 */
	public void setTitleH(int titleH) {
		this.titleH = titleH;
	}

	/**
	 * @return the numberRow
	 */
	public List<Integer> getNumberRow() {
		return numberRow;
	}

	/**
	 * @param numberRow
	 *            the numberRow to set
	 */
	public void setNumberRow(List<Integer> numberRow) {
		this.numberRow = numberRow;
	}

	/**
	 * @return the titleColor
	 */
	public List<Integer> getTitleColor() {
		return titleColor;
	}

	/**
	 * @param titleColor
	 *            the titleColor to set
	 */
	public void setTitleColor(List<Integer> titleColor) {
		this.titleColor = titleColor;
	}

	/**
	 * @return the titleBgColor
	 */
	public List<Integer> getTitleBgColor() {
		return titleBgColor;
	}

	/**
	 * @param titleBgColor
	 *            the titleBgColor to set
	 */
	public void setTitleBgColor(List<Integer> titleBgColor) {
		this.titleBgColor = titleBgColor;
	}

	public List<Integer> getStrList() {
		return strList;
	}

	public void setStrList(List<Integer> strList) {
		this.strList = strList;
	}
}
