package com.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.common.StringUtil;


@SuppressWarnings( { "unchecked", "unused", "static-access" })
public class PoiWriteExcelBeanImpl implements PoiWriteExcelBean {
	private static final String LIGHT_YELLOW = "LIGHT_YELLOW";
	private static final String YELLOW = "YELLOW";

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
	public void writePoiExcel(ExcelModel em, Workbook wb, List fialList, List clist) throws Exception {
		// �������������ڼ��㴴��sheet����
		int sheetNum = 0;
		// �趨ÿsheet���洢����
		int num = 65000;
		// ����ٷ�����ʽ
		HSSFCellStyle cellPercentStyleStr = (HSSFCellStyle) wb.createCellStyle();
		HSSFCellStyle cellPercentStyle = (HSSFCellStyle) wb.createCellStyle();
		cellPercentStyle.setDataFormat((short) 9);// �ٷ���
		if (em.getCountNum() != 0 && em.getCountNum() <= num)
			num = em.getCountNum();
		// ���㴴��sheet����
		if (clist.size() <= num)
			sheetNum = 1;
		else {
			if (clist.size() % num == 0)
				sheetNum = clist.size() / num;
			else
				sheetNum = clist.size() / num + 1;
		}
		// ����sheet��cell��row����
		Sheet sheet;
		Cell cell;
		Row row;
		/* ===========haog=========== */
		// ��������������ʽ
		CellStyle style;
		Font font;
		style = wb.createCellStyle();
		font = wb.createFont();
		// ������ɫ
		font.setColor(HSSFFont.COLOR_RED);
		style.setFont(font);

		// ���ַ���������е�List
		List strList = em.getStrList();
		/* ===========haog=========== */
		// ѭ������sheet
		for (int c = 0; c < sheetNum; c++) {
			// ��Excel�������н�һsheet��ָ������
			if (c == 0)
				sheet = wb.createSheet(em.getSheetName());

			else
				sheet = wb.createSheet(em.getSheetName() + "_" + c);
			// haog ���ᴰ��
			// sheet.createFreezePane(0, 3);
			// ����һ�У���ű���ͷ��
			row = sheet.createRow((short) 0);
			// ��������ͷ��
			writeExcelHead(fialList, wb, row, em, sheet);
			// ��������z
			int z = 1;
			// ��䵥Ԫ������
			for (int i = c * num; i < clist.size(); i++) {
				if (i < num * (c + 1)) {
					Map map = (Map) clist.get(i);
					// ����һ��
					row = sheet.createRow(z);
					// �������
					for (int j = 0; j < map.size(); j++) {
						cell = row.createCell((short) j);
						if (null != strList) {
							if (strList.contains(j)) {
								this.formatCellStr(cell, getValue(map.get(j)), cellPercentStyleStr);
							} else {
								this.formatCell(cell, getValue(map.get(j)), cellPercentStyle);
							}
						} else {
							// ��ֵ
							this.formatCell(cell, getValue(map.get(j)), cellPercentStyle);
						}

						// ��ֵ
						// this.formatCell(cell, getValue(map.get(j)),
						// cellPercentStyle);

						/*
						 * if (!isNumber(em, j) ||
						 * "-".equals(getValue(map.get(j)))) { if
						 * (StringUtil.contains(getValue(map.get(j)), "%")) {
						 * String s =
						 * getValue(map.get(j)).substring(0,getValue(map.get(j)).length()-1);
						 * cell.setCellValue(Double.parseDouble(s)/100);
						 * cell.setCellStyle(cellPercentStyle); }else {
						 * cell.setCellValue(getValue(map.get(j))); } }else { //
						 * ������
						 * cell.setCellValue(Double.parseDouble(getValue(map.get(j)))); }
						 */
						/* ===========haog=========== */
						if (em.getStyleCell() != null) {// ������ݵ���ʽ
							for (int s = 0; s < em.getStyleCell().size(); s++) {
								if (Integer.parseInt(em.getStyleCell().get(s).toString()) == j) {
									cell.setCellStyle(style);
								}
							}
						}
						/* ===========haog=========== */
						/*
						 * // �Զ������п� if (em.getAutoWidth() == 0)
						 * sheet.autoSizeColumn((short) j);
						 */
					}
					z++;
				} else {
					break;
				}
			}
		}
	}

	/**
	 * ������sheet��ͬ��ʽexcel�ļ�
	 * 
	 * @param em
	 *            ����ģ�����
	 * @param wb
	 *            ��ǰ������
	 * @throws Exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.oppo.common.excel.PoiWriteExcelBean#writeManySheet(com.oppo.common.excel.ExcelModel,
	 *      org.apache.poi.ss.usermodel.Workbook)
	 */
	public void writeManySheet(ExcelModel em, Workbook wb) throws Exception {
		// ����sheet��cell��row����
		Sheet sheet;
		sheet = wb.createSheet(em.getSheetName());
		Cell cell = null;
		Row row = null;
		// ��ͷ�б�
		List titleList = em.getTitleList();
		// �����б�
		List dataList = em.getDataList();
		// ��ͷ��ʼ��
		int cellNum = em.getCellNum();
		// ��������ͷ��
		writeExcelHead(titleList, wb, sheet, cellNum, em);

		// ����ٷ�����ʽ
		HSSFCellStyle cellPercentStyle = (HSSFCellStyle) wb.createCellStyle();
		cellPercentStyle.setDataFormat((short) 9);// �ٷ���

		// �������
		for (int i = 0; i < dataList.size(); i++) {
			// ���ݿ�ʼ����
			int dataCellNum = i + cellNum + titleList.size();
			// ����һ��
			row = sheet.createRow(dataCellNum);
			// �������
			Map dataMap = (Map) dataList.get(i);
			for (int j = 0; j < dataMap.size(); j++) {
				cell = row.createCell((short) j);
				// ��ֵ
				this.formatCell(cell, getValue(dataMap.get(j)), cellPercentStyle);

				// ������ ��ʱע��
				/*
				 * if (!isNumber(em, j) || "-".equals(getValue(dataMap.get(j)))) {
				 * if (StringUtil.contains(getValue(dataMap), "%")) { String s =
				 * getValue(dataMap.get(j)).substring(0,getValue(dataMap.get(j)).length()-1);
				 * cell.setCellValue(Double.parseDouble(s)/100);
				 * cell.setCellStyle(cellPercentStyle); }else {
				 * cell.setCellValue(getValue(dataMap.get(j))); } }else { // ������
				 * cell.setCellValue(Double.parseDouble(getValue(dataMap.get(j)))); }
				 */
				/*
				 * // �Զ������п� if(em.getAutoWidth() == 0)
				 * sheet.autoSizeColumn((short) j);
				 */
			}
		}
	}

	/**
	 * ��ͷ�ϲ���Ԫ��excel�ļ�
	 * 
	 * @param em
	 *            ����ģ�����
	 * @param wb
	 *            ��ǰ������
	 * @throws Exception
	 */
	public void UniteHeadSheet(ExcelModel em, Workbook wb, List fialList, List uniteRowList) throws Exception {
		// ����sheet��cell��row����
		Sheet sheet;
		sheet = wb.createSheet(em.getSheetName());
		Cell cell = null;
		Row row = null;
		// ��ͷ�б�
		List titleList = em.getTitleList();
		// �����б�
		List dataList = em.getDataList();
		// ��ͷ��ʼ��
		int cellNum = em.getCellNum();
		// ��������ͷ��
		writeUniteHead(fialList, em, wb, sheet, uniteRowList);
		writeExcelHead(titleList, wb, sheet, cellNum, em);
		// ��������������ʽ
		CellStyle style;
		Font font;
		style = wb.createCellStyle();
		font = wb.createFont();
		// ������ɫ
		font.setColor(HSSFFont.COLOR_RED);
		style.setFont(font);
		// ����ٷ�����ʽ
		HSSFCellStyle cellPercentStyle = (HSSFCellStyle) wb.createCellStyle();
		cellPercentStyle.setDataFormat((short) 9);// �ٷ���
		// �������
		for (int i = 0, n = dataList.size(); i < n; i++) {
			// ���ݿ�ʼ����
			int dataCellNum = i + cellNum + titleList.size();
			// ����һ��
			row = sheet.createRow(dataCellNum);
			// �������
			Map dataMap = (Map) dataList.get(i);
			for (int j = 0, m = dataMap.size(); j < m; j++) {
				cell = row.createCell((short) j);
				// cell.setCellValue(getValue(dataMap.get(j)));
				// ��ֵ
				this.formatCell(cell, getValue(dataMap.get(j)), cellPercentStyle);

				// ������ ��ʱע��
				/*
				 * if (!isNumber(em, j) || "-".equals(getValue(dataMap.get(j)))) {
				 * if (StringUtil.contains(getValue(dataMap.get(j)), "%")) {
				 * String s =
				 * getValue(dataMap.get(j)).substring(0,getValue(dataMap.get(j)).length()-1);
				 * cell.setCellValue(Double.parseDouble(s)/100);
				 * cell.setCellStyle(cellPercentStyle); }else {
				 * cell.setCellValue(getValue(dataMap.get(j))); } }else { // ������
				 * cell.setCellValue(Double.parseDouble(getValue(dataMap.get(j)))); }
				 */
				if (em.getStyleCell() != null) {
					for (int s = 0; s < em.getStyleCell().size(); s++) {
						if (Integer.parseInt(em.getStyleCell().get(s).toString()) == j) {
							cell.setCellStyle(style);
						}
					}
				}
				// �Զ������п�
				/*
				 * if(em.getAutoWidth() == 0) sheet.autoSizeColumn((short) j);
				 */
			}
		}
	}

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
	 *            ͷ�������б�
	 * @throws Exception
	 */
	public void writeExcelUnite(ExcelModel em, Workbook wb, List clist, List fialList) throws Exception {
		// ����sheet��cell��row����
		Sheet sheet;
		Cell cell;
		Row row;
		sheet = wb.createSheet(em.getSheetName());
		// ��ͷ�б�
		List titleList = em.getTitleList();
		// �����б�
		List dataList = em.getDataList();
		// д���ͷ��ʼ����
		int cellNum = em.getCellNum();
		// ������ʽ�������������
		CellStyle style = this.setStyle(wb);
		// ��ָ���д�����һ������ͷ��
		int titleNum = em.getCellNum();
		// ����ٷ�����ʽ
		HSSFCellStyle cellPercentStyle = (HSSFCellStyle) wb.createCellStyle();
		cellPercentStyle.setDataFormat((short) 9);// �ٷ���

		/*
		 * row = sheet.createRow((short) titleNum); row.setHeightInPoints(30);
		 */
		int z = titleNum + 1;
		for (int i = 0; fialList != null && i < fialList.size(); i++) {
			/*
			 * if (i != 0) { z = z + em.getSpaceNum(); // ����һ�У���ű�ͷ row =
			 * sheet.createRow(z); row.setHeightInPoints(30); z++; }
			 */
			// ��������ͷ������
			List fList = (List) fialList.get(i);
			for (int f = 0; f < fList.size(); f++) {
				if (i == 0) {
					row = sheet.createRow((short) f + titleNum);
					z = z + f;
				} else {
					if (f == 0)
						z = z + em.getSpaceNum();
					// ����һ�У���ű�ͷ
					row = sheet.createRow(z);
					row.setHeightInPoints(em.getTitleH());
					z++;
				}
				row.setHeightInPoints(em.getTitleH());
				List list = (List) fList.get(f);
				for (int b = 0; b < list.size(); b++) {
					cell = row.createCell((short) b);
					cell.setCellValue(getValue(list.get(b)));
					cell.setCellStyle(style);
				}
			}
			/*
			 * List list = (List) fialList.get(i); for (int b = 0; b <
			 * list.size(); b++) { cell = row.createCell((short) b);
			 * cell.setCellValue(list.get(b).toString());
			 * cell.setCellStyle(style); }
			 */
			// ����ҵ������
			List contentList = (List) clist.get(i);
			for (int cm = 0; contentList != null && cm < contentList.size(); cm++) {
				// ����һ��
				row = sheet.createRow(z);
				// �õ�excel����
				Map contentMap = (Map) contentList.get(cm);
				// ��䵥Ԫ������
				for (int j = 0; j < contentMap.size(); j++) {
					cell = row.createCell((short) j);
					// ��ֵ
					this.formatCell(cell, getValue(contentMap.get(j)), cellPercentStyle);

					/*
					 * if (!isNumber(em, j) ||
					 * "-".equals(getValue(contentMap.get(j)))) {
					 * 
					 * }else { // ������
					 * cell.setCellValue(Double.parseDouble(getValue(contentMap.get(j)))); }
					 */
					/*
					 * // �Զ������п� // if (em.getAutoWidth() == 0) //
					 * sheet.autoSizeColumn((short) j);
					 */
				}
				z++;
			}
		}
	}

	/**
	 * �����򵥱���ͷ��
	 * 
	 * @param fialList
	 *            ����ͷ��
	 * @param row
	 *            ��ǰ��
	 * @throws Exception
	 */
	public void writeExcelHead(List fialList, Workbook wb, Row row, Sheet sheet, ExcelModel em) throws Exception {
		List<Integer> colorList = em.getTitleColor(); // ��ɫlist
		try {
			// ������ʽ�������������
			CellStyle style = this.setStyle(wb);
			row.setHeightInPoints(em.getTitleH());
			// ��������ͷ��
			for (int i = 0; i < fialList.size(); i++) {
				Cell cell = row.createCell((short) i);
				cell.setCellValue(getValue(fialList.get(i)));
				cell.setCellStyle(style);
				// �Զ������п�
				if (em.getAutoWidth() == 0)
					sheet.autoSizeColumn((short) i);
				// �趨�����ɫ
				if (null != colorList) {
					if (colorList.contains(i)) {
						cell.setCellStyle(this.setTitleRead(wb));
						sheet.setColumnWidth(i, 2048);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * �����򵥱���ͷ��
	 * 
	 * @param fialList
	 *            ����ͷ��
	 * @param row
	 *            ��ǰ��
	 * @throws Exception
	 */
	public void writeExcelHead(List fialList, Workbook wb, Row row, ExcelModel em, Sheet sheet) throws Exception {
		List<Integer> colorList = em.getTitleColor(); // ��ɫlist
		List<Integer> bgcolorList = em.getTitleBgColor(); // �õ�����ɫ
		try {
			// ������ʽ�������������
			CellStyle style = this.setStyle(wb);
			row.setHeightInPoints(em.getTitleH());
			// ��������ͷ��
			for (int i = 0; i < fialList.size(); i++) {
				Cell cell = row.createCell((short) i);
				cell.setCellValue(getValue(fialList.get(i)));
				cell.setCellStyle(style);
				// �Զ������п�
				if (em.getAutoWidth() == 0)
					sheet.autoSizeColumn((short) i);
				// �趨�����ɫ
				if (null != colorList) {
					if (colorList.contains(i)) {
						cell.setCellStyle(this.setTitleRead(wb));
						sheet.setColumnWidth(i, 2048);
					}
				}
				// �趨������ɫ
				if (null != bgcolorList && null != colorList) {
					boolean bb = false;
					if (bgcolorList.contains(i) && !colorList.contains(i)) {
						cell.setCellStyle(this.setTitleBgColor(wb, YELLOW, bb));
					} else if (bgcolorList.contains(i) && colorList.contains(i)) {
						bb = true;
						cell.setCellStyle(this.setTitleBgColor(wb, YELLOW, bb));
					}
				} else if (null != bgcolorList && null == colorList) {
					cell.setCellStyle(this.setTitleBgColor(wb, YELLOW, false));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ָ���д�������ͷ��
	 * 
	 * @param titleList
	 *            ����ͷ��
	 * @param wb
	 *            ��ǰ������
	 * @param sheet
	 *            ��ǰ��
	 * @param cellNum
	 *            ��ͷ��ʼ��
	 * @throws Exception
	 */
	/*
	 * public void writeExcelHead(List titleList,Workbook wb, Sheet sheet,int
	 * cellNum) throws Exception { try { // ������ʽ������������� CellStyle style =
	 * this.setStyle(wb); // ��������ͷ�� Cell cell; for(int t =0;t <
	 * titleList.size();t++){ Row row = sheet.createRow((short)(t+cellNum));
	 * row.setHeightInPoints(30); List nextList = (List)titleList.get(t);
	 * for(int i =0; i < nextList.size(); i++){ cell =
	 * row.createCell((short)(i)); cell.setCellValue(getValue(nextList.get(i)));
	 * cell.setCellStyle(style); } } } catch (Exception e) {
	 * e.printStackTrace(); } }
	 */

	/**
	 * ָ���д�������ͷ��
	 * 
	 * @param titleList
	 *            ����ͷ��
	 * @param wb
	 *            ��ǰ������
	 * @param sheet
	 *            ��ǰ��
	 * @param cellNum
	 *            ��ͷ��ʼ��
	 * @throws Exception
	 */
	public void writeExcelHead(List titleList, Workbook wb, Sheet sheet, int cellNum, ExcelModel em) throws Exception {
		List<Integer> colorList = em.getTitleColor(); // ��ɫlist
		try {
			// ������ʽ�������������
			CellStyle style = this.setStyle(wb);
			// ��������ͷ��
			Cell cell;
			for (int t = 0; t < titleList.size(); t++) {
				Row row = sheet.createRow((short) (t + cellNum));
				row.setHeightInPoints(em.getTitleH());
				List nextList = (List) titleList.get(t);
				for (int i = 0; i < nextList.size(); i++) {
					cell = row.createCell((short) (i));
					cell.setCellValue(getValue(nextList.get(i)));
					cell.setCellStyle(style);
					// �Զ������п�
					if (em.getAutoWidth() == 0)
						sheet.autoSizeColumn((short) i);
					// �趨�����ɫ
					if (null != colorList) {
						if (colorList.contains(i)) {
							cell.setCellStyle(this.setTitleRead(wb));
							sheet.setColumnWidth(i, 2048);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * �����ϲ���Ԫ�񱨱�ͷ��
	 * 
	 * @param fialList
	 *            ����ͷ��
	 * @param em
	 *            ����ģ�����
	 * @param wb
	 *            ��ǰ������
	 * @param uniteRowList
	 *            ��ϲ���Ԫ�񼯺�
	 * @throws Exception
	 */
	private void writeUniteHead(List fialList, ExcelModel em, Workbook wb, Sheet sheet, List uniteRowList)
			throws Exception {
		// ������ʽ�������������
		CellStyle style = this.setStyle(wb);
		// ��������
		int endTemp = 0;
		int num = 0;
		int fnum = 0;
		int unum = 0;
		List uniteRowListTemp = new ArrayList();
		// �����µĺϲ���Ԫ�񼯺�
		for (int u = 0; u < uniteRowList.size(); u++) {
			Map uniteRowMap = new HashMap();
			Map mapTemp = (Map) uniteRowList.get(u);
			if (u != 0) {
				if (Integer.parseInt(mapTemp.get(0).toString()) - (endTemp + 1) == 0) {
					uniteRowMap = mapTemp;
					uniteRowListTemp.add(uniteRowMap);
				} else {
					int et = endTemp + 1;
					for (int t = 0; t < Integer.parseInt(mapTemp.get(0).toString()) - (endTemp + 1); t++) {
						Map unMap = new HashMap();
						unMap.put(0, et);
						unMap.put(1, et);
						uniteRowListTemp.add(unMap);
						et++;
					}
					uniteRowMap = mapTemp;
					uniteRowListTemp.add(uniteRowMap);
				}
				endTemp = Integer.parseInt(uniteRowMap.get(1).toString());
			} else {
				if (Integer.parseInt(mapTemp.get(0).toString()) > 0) {
					for (int t = 0; t < Integer.parseInt(mapTemp.get(0).toString()); t++) {
						Map unMap = new HashMap();
						unMap.put(0, t);
						unMap.put(1, t);
						uniteRowListTemp.add(unMap);
					}
					uniteRowMap = mapTemp;
					uniteRowListTemp.add(uniteRowMap);
				} else {
					uniteRowMap = mapTemp;
					uniteRowListTemp.add(uniteRowMap);
				}
				endTemp = Integer.parseInt(uniteRowMap.get(1).toString());
			}
		}
		// ����ºϲ���Ԫ�񼯺�С�ڱ���ͷ���������ۼӡ�
		fnum = fialList.size();
		unum = uniteRowListTemp.size();
		if (fnum - unum > 0) {
			for (int j = 0; j < fnum - unum; j++) {
				if (j == 0) {
					Map uMap = (Map) uniteRowListTemp.get(unum - 1);
					num = Integer.parseInt(uMap.get(1).toString()) + 1;
				}
				Map uMapTemp = new HashMap();
				uMapTemp.put(0, num);
				uMapTemp.put(1, num);
				uniteRowListTemp.add(uMapTemp);
				num++;
			}
		}
		// ���úϲ���Ԫ�񷽷�
		merged(sheet, 0, uniteRowListTemp);
		// ��������ͷ��
		Row row = sheet.createRow((short) 0);
		row.setHeightInPoints(em.getTitleH());
		List<Integer> colorList = em.getTitleBgColor(); // �õ�����ɫ
		for (int i = 0; i < fialList.size(); i++) {
			if (i < uniteRowListTemp.size()) {
				Map fialMap = (Map) uniteRowListTemp.get(i);
				Cell cell = row.createCell((short) Integer.parseInt(fialMap.get(0).toString()));
				cell.setCellValue(getValue(fialList.get(i)));
				cell.setCellStyle(style);
				// �趨������ɫ
				if (null != colorList) {
					if (colorList.contains(i)) {
						cell.setCellStyle(this.setTitleBgYellow(wb));
					}
				}
			} else {
				Cell cell = row.createCell((short) i);
				cell.setCellValue(getValue(fialList.get(i)));
				cell.setCellStyle(style);
				// �趨������ɫ
				if (null != colorList) {
					if (colorList.contains(i)) {
						cell.setCellStyle(this.setTitleBgYellow(wb));
					}
				}
			}
			// �Զ������п�
			if (em.getAutoWidth() == 0)
				sheet.autoSizeColumn((short) i);

		}
	}

	/**
	 * �ϲ���Ԫ��
	 * 
	 * @param sheet
	 *            ��ǰ������
	 * @param rowNum
	 *            �ڵ�rowNum�кϲ�
	 * @param uniteRowList
	 *            ��ϲ���Ԫ�񼯺�
	 * @throws Exception
	 */
	private static void merged(Sheet sheet, int rowNum, List uniteRowList) throws Exception {
		int start = 0;
		int end = 0;
		for (int m = 0; m < uniteRowList.size(); m++) {
			Map map = (Map) uniteRowList.get(m);
			start = Integer.parseInt(map.get(0).toString());
			end = Integer.parseInt(map.get(1).toString());
			CellRangeAddress cellRangeAddress = new CellRangeAddress(rowNum, rowNum, (short) (start), (short) (end));
			sheet.addMergedRegion(cellRangeAddress);
		}
	}

	/**
	 * ��ʼ��excel�ļ�
	 * 
	 * @param excelName
	 *            �ļ�·��
	 * @throws Exception
	 * @return
	 */
	public Workbook JudgeExcelType(String excelName) throws Exception {
		Workbook workbook = null;
		try {
			String filePath = excelName.substring(0, excelName.lastIndexOf("\\") + 1);
			File myFilePath = new File(filePath);
			if (!myFilePath.exists()) {
				myFilePath.mkdirs();
			}
			String excelType = excelName.substring(excelName.lastIndexOf(".") + 1);
			if (excelType.equals("xls") || excelType.equals("xlsx")) {
				if (excelType.equals("xls"))
					workbook = new HSSFWorkbook();
				else
					workbook = new XSSFWorkbook();
			}
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return workbook;
	}

	/**
	 * ����excel�ļ�
	 * 
	 * @param excelName
	 *            �ļ�·��
	 * @param wb
	 *            ��ǰ������
	 * @throws Exception
	 */
	public void closeWorkbook(String excelName, Workbook wb) throws Exception {
		// �����ļ�
		FileOutputStream fileOut = new FileOutputStream(excelName);
		wb.write(fileOut);
		fileOut.close();
	}

	/**
	 * ��ͷ���ɫ
	 * 
	 * @param wb
	 * @return
	 */
	public CellStyle setTitleRead(Workbook wb) {
		CellStyle style;
		Font font;
		style = wb.createCellStyle();
		font = wb.createFont();
		// ��ֱ����
		style.setVerticalAlignment((short) 2);
		// �Զ�����
		style.setWrapText(true);
		// ������ɫ
		font.setColor(HSSFFont.COLOR_RED);
		// �ֺ�
		font.setFontHeightInPoints((short) 10);
		// ����
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// �趨��ʽ�ĵı�����ɫ
		// style.setFillForegroundColor(HSSFColor.YELLOW.index);
		// style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setFont(font);
		return style;
	}

	/**
	 * ��ͷ�������ɫ
	 * 
	 * @param wb
	 * @return
	 */
	public CellStyle setTitleBgYellow(Workbook wb) {
		CellStyle style;
		Font font;
		style = wb.createCellStyle();
		// font = wb.createFont();
		// ��ֱ����
		style.setVerticalAlignment((short) 2);
		// �Զ�����
		style.setWrapText(true);
		// ������ɫ
		// font.setColor(HSSFFont.COLOR_RED);
		// �ֺ�
		// font.setFontHeightInPoints((short) 10);
		// ����
		// font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// �趨��ʽ�ĵı�����ɫ
		style.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
		style.setFillForegroundColor(HSSFColor.YELLOW.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		return style;
	}

	/**
	 * ��ͷ�������ɫ
	 * 
	 * @param wb
	 * @return
	 */
	public CellStyle setTitleBgColor(Workbook wb, String str, boolean bb) {
		CellStyle style;
		Font font;
		style = wb.createCellStyle();

		// ��ֱ����
		style.setVerticalAlignment((short) 2);
		// �Զ�����
		style.setWrapText(true);
		// ���ñ߿�
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);

		// ����һ����Ԫ��߿���ɫ
		style.setRightBorderColor(IndexedColors.LIME.getIndex());
		style.setLeftBorderColor(IndexedColors.LIME.getIndex());
		style.setBottomBorderColor(IndexedColors.LIME.getIndex());
		style.setTopBorderColor(IndexedColors.LIME.getIndex());
		if (bb) {
			font = wb.createFont();
			// ������ɫ
			font.setColor(HSSFFont.COLOR_RED);
			// �ֺ�
			// font.setFontHeightInPoints((short) 10);
			// ����
			// font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			style.setFont(font);
		}

		// �趨��ʽ�ĵı�����ɫ
		if (str.equals("LIGHT_YELLOW")) {
			style.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
		}
		if (str.equals("YELLOW")) {
			style.setFillForegroundColor(HSSFColor.YELLOW.index);
		}
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		return style;
	}

	/**
	 * ��ͷ��ʽ
	 * 
	 * @param wb
	 *            ��ǰ������
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	public CellStyle setStyle(Workbook wb) throws Exception {
		CellStyle style;
		Font font;
		style = wb.createCellStyle();
		font = wb.createFont();
		// ��ֱ����
		style.setVerticalAlignment((short) 2);
		// �Զ�����
		style.setWrapText(true);
		// ������ɫ
		// font.setColor(HSSFFont.COLOR_RED);
		// �ֺ�
		font.setFontHeightInPoints((short) 10);
		// ����
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// �趨��ʽ�ĵı�����ɫ
		// style.setFillForegroundColor(HSSFColor.YELLOW.index);
		// style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setFont(font);
		return style;
	}

	/**
	 * �жϴ����Ƿ�Ϊnull ����� ���滻�ɿ��ַ���
	 * 
	 * @param obj
	 * @return
	 */
	public String getValue(Object obj) {
		return null == obj ? "" : obj.toString();
	}

	/**
	 * �ж��������Ƿ�Ϊ������
	 * 
	 * @param list
	 * @param i
	 * @return
	 */
	public boolean isNumber(ExcelModel em, int i) {
		return null != em.getNumberRow() ? em.getNumberRow().contains(i) : false;
	}

	/**
	 * ����������дcell
	 * 
	 * @param cell
	 * @param value
	 * @param cellPercentStyle
	 */
	public static void formatCell(Cell cell, String value, HSSFCellStyle cellPercentStyle) {
		if (StringUtil.isNumberAll(value)) { // ���Ϊ������
			// ת��������
			// double d = Double.parseDouble(value);
			cell.setCellValue(value);
		} else {
			if (StringUtil.contains(value, "%")) {
				String strTemp = value.replace("%", "");
				if (StringUtil.isNumber(strTemp)) { // ȥ��%�� ���ȫΪ���֣���ת�ɰٷ�����ʽ
					cell.setCellValue(Double.parseDouble(strTemp) / 100);
					cell.setCellStyle(cellPercentStyle);
				} else {
					cell.setCellValue(value);
				}
			} else {
				cell.setCellValue(value);
			}
		}
	}

	/**
	 * ����������дcell
	 * 
	 * @param cell
	 * @param value
	 * @param cellPercentStyle
	 */
	public static void formatCellStr(Cell cell, String value, HSSFCellStyle cellPercentStyle) {
		cellPercentStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		if (value != null && !"".equals(value) && !"".equals(value.trim())) {
			value = value.trim();
		}
		if (StringUtil.isNumberAll(value)) { // ���Ϊ������
			// ת��������
			double d = Double.parseDouble(value);
			cell.setCellValue(d);
			cell.setCellStyle(cellPercentStyle);
		} else {
			if (StringUtil.contains(value, "%")) {
				String strTemp = value.replace("%", "");
				if (StringUtil.isNumber(strTemp)) { // ȥ��%�� ���ȫΪ���֣���ת�ɰٷ�����ʽ
					cell.setCellValue(Double.parseDouble(strTemp) / 100);
					// cell.setCellValue(strTemp);
					cell.setCellStyle(cellPercentStyle);
				} else {
					cell.setCellValue(value);
				}
			} else {
				cell.setCellValue(value);
				cell.setCellStyle(cellPercentStyle);
			}
		}

	}

}
