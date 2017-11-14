package com.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@SuppressWarnings( { "deprecation", "unchecked" })
public class PoiReadExcelBeanImpl implements PoiReadExcelBean {

	static Log log = LogFactory.getLog(PoiReadExcelBeanImpl.class);

	private final static DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private final static String LINE_KEY = "line-_-Key";

	private final static int LINE_NUMBER = 100;
	private final static boolean IS_MANY_SHEET = true;

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
	public List readExcel(String filePaths, int readRowNum) throws FileNotFoundException, IOException {
		List<Map> resultList = new ArrayList<Map>();
		if (filePaths != null && !filePaths.equals("")) {
			// ����ļ���׺�����ж��ļ�����
			String filetype = filePaths.substring(filePaths.lastIndexOf(".") + 1);
			if (filetype.equals("xlsx")) {
				// ���ý���excel2007�ļ�����
				resultList = readPoiExcel2007(filePaths, readRowNum, LINE_NUMBER, LINE_KEY);
			} else if (filetype.equals("xls")) {
				// ���ý���excel2003�ļ�����
				resultList = readPoiExcel2003(filePaths, readRowNum, LINE_NUMBER, LINE_KEY);
			}
		}
		return resultList;
	}

	/**
	 * ��ȡExcel�ļ���ֻ����һ��Sheet���жϽ�����
	 * 
	 * @param filePaths
	 *            �����ļ�·��
	 * @param readRowNum
	 *            ��readRowNum�ж�ȡExcel����
	 * @param sheetNum
	 *            �ӵ�һ��Sheet�����ȡSheet�ĸ���
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public List readExcelSheet(String filePaths, int readRowNum, int sheetNum) throws FileNotFoundException,
			IOException {
		List<Map> resultList = new ArrayList<Map>();
		if (filePaths != null && !filePaths.equals("")) {
			// ����ļ���׺�����ж��ļ�����
			String filetype = filePaths.substring(filePaths.lastIndexOf(".") + 1);
			if (filetype.equals("xlsx")) {
				// ���ý���excel2007�ļ�����
				resultList = readPoiExcel2007Sheet(filePaths, readRowNum, sheetNum, LINE_NUMBER, LINE_KEY);
			} else if (filetype.equals("xls")) {
				// ���ý���excel2003�ļ�����
				resultList = readPoiExcel2003Sheet(filePaths, readRowNum, sheetNum, LINE_NUMBER, LINE_KEY);
			}
		}
		return resultList;
	}

	/**
	 * ��ȡExcel�ļ�����ͷ�����жϽ�����
	 * 
	 * @param filePaths
	 *            �����ļ�·��
	 * @param readRowNum
	 *            ��ͷ������
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public List readExcelTitle(String filePaths, int readRowNum) throws FileNotFoundException, IOException {
		List<Map> resultList = new ArrayList<Map>();
		if (filePaths != null && !filePaths.equals("")) {
			// ����ļ���׺�����ж��ļ�����
			String filetype = filePaths.substring(filePaths.lastIndexOf(".") + 1);
			if (filetype.equals("xlsx")) {
				// ���ý���excel2007�ļ�����
				resultList = readPoiExcel2007Title(filePaths, readRowNum);
			} else if (filetype.equals("xls")) {
				// ���ý���excel2003�ļ�����
				resultList = readPoiExcel2003Title(filePaths, readRowNum);
			}
		}
		return resultList;
	}

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
			throws FileNotFoundException, IOException {
		List<Map> resultList = new ArrayList<Map>();
		if (filePaths != null && !filePaths.equals("")) {
			// ����ļ���׺�����ж��ļ���ʽ
			String filetype = filePaths.substring(filePaths.lastIndexOf(".") + 1);
			if (filetype.equals("xlsx")) {
				// ���ý���excel2007�ļ�����
				resultList = readPoiExcel2007(filePaths, readRowNum, lineNum, lineKey);
			} else if (filetype.equals("xls")) {
				// ���ý���excel2003�ļ�����
				resultList = readPoiExcel2003(filePaths, readRowNum, lineNum, lineKey);
			}
		}
		return resultList;
	}

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
	public List readExcel(String filePaths, int readRowNum, List rowNumList) throws FileNotFoundException, IOException {
		List<Map> resultList = new ArrayList<Map>();
		if (filePaths != null && !filePaths.equals("")) {
			// ����ļ���׺�����ж��ļ���ʽ
			String filetype = filePaths.substring(filePaths.lastIndexOf(".") + 1);
			if (filetype.equals("xlsx")) {
				// ���ý���excel2007�ļ�����
				resultList = readPoiExcel2007(filePaths, readRowNum, LINE_NUMBER, LINE_KEY, rowNumList);
			} else if (filetype.equals("xls")) {
				// ���ý���excel2003�ļ�����
				resultList = readPoiExcel2003(filePaths, readRowNum, LINE_NUMBER, LINE_KEY, rowNumList);
			}
		}
		return resultList;
	}

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
			throws FileNotFoundException, IOException {
		List<Map> resultList = new ArrayList<Map>();
		if (filePaths != null && !filePaths.equals("")) {
			// ����ļ���׺�����ж��ļ���ʽ
			String filetype = filePaths.substring(filePaths.lastIndexOf(".") + 1);
			if (filetype.equals("xlsx")) {
				// ���ý���excel2007�ļ�����
				resultList = readPoiExcel2007(filePaths, readRowNum, lineNum, lineKey, rowNumList);
			} else if (filetype.equals("xls")) {
				// ���ý���excel2003�ļ�����
				resultList = readPoiExcel2003(filePaths, readRowNum, lineNum, lineKey, rowNumList);
			}
		}
		return resultList;
	}

	/**
	 * ����excel2007
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
	public List readPoiExcel2007(String filePaths, int readRowNum, int lineNum, String lineKey)
			throws FileNotFoundException, IOException {
		// �������map��list,map������ŵ�Ԫ������
		List<Map> excel07List = new ArrayList<Map>();
		try {
			// ���� XSSFWorkbook ����
			XSSFWorkbook xwb = new XSSFWorkbook(filePaths);
			// sheet����
			int numOfSheets = xwb.getNumberOfSheets();
			// ѭ������sheet
			labelSheet: for (int s = 0; s < numOfSheets; s++) {
				// ��ȡsheet�������
				XSSFSheet sheet = xwb.getSheetAt(s);
				// ��ȡ��sheet������
				int rows = sheet.getPhysicalNumberOfRows();
				if (rows > 0) {
					// ���� row
					XSSFRow row;
					// ѭ���������е�����
					for (int i = readRowNum; i < sheet.getPhysicalNumberOfRows(); i++) {
						// ����map����
						Map map = new HashMap();
						// ��ȡsheet��һ��
						row = sheet.getRow(i);
						for (int j = 0; j < row.getLastCellNum(); j++) {
							// ���ֹؼ��֣���������ѭ��
							if (row.getCell(lineNum) != null && cellTypeExcel2007(row.getCell(lineNum)).equals(lineKey)) {
								break labelSheet;
							} else {
								// ��ȡ��Ԫ�����ݣ�������map��
								if (row.getCell(j) != null) {
									// �ж��Ƿ�Ϊ��ʽ����
									if (row.getCell(j).getCellType() != XSSFCell.CELL_TYPE_FORMULA) {
										map.put(j, cellTypeExcel2007(row.getCell(j)));
									} else
										map.put(j, row.getCell(j));
								} else
									map.put(j, "");
							}
						}
						// ��map����list
						excel07List.add(map);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return excel07List;
	}

	/**
	 * ����excel2007
	 * 
	 * @param filePaths
	 *            �����ļ�·��
	 * @param readRowNum
	 *            ��readRowNum�ж�ȡExcel����
	 * @param lineNum
	 *            ��������������
	 * @param lineKey
	 *            ������
	 * @param sheetNum
	 *            ��ȡSheet�ĸ���
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public List readPoiExcel2007Sheet(String filePaths, int readRowNum, int sheetNum, int lineNum, String lineKey)
			throws FileNotFoundException, IOException {
		// �������map��list,map������ŵ�Ԫ������
		List<Map> excel07List = new ArrayList<Map>();
		try {
			// ���� XSSFWorkbook ����
			XSSFWorkbook xwb = new XSSFWorkbook(filePaths);
			// sheet����
			int numOfSheets = 0;
			if (xwb.getNumberOfSheets() > sheetNum && sheetNum > 0) {
				numOfSheets = sheetNum;
			} else {
				numOfSheets = xwb.getNumberOfSheets();
			}

			// ѭ������sheet
			labelSheet: for (int s = 0; s < numOfSheets; s++) {
				// ��ȡsheet�������
				XSSFSheet sheet = xwb.getSheetAt(s);
				// ��ȡ��sheet������
				int rows = sheet.getPhysicalNumberOfRows();
				if (rows > 0) {
					// ���� row
					XSSFRow row;
					// ѭ���������е�����
					for (int i = readRowNum; i < sheet.getPhysicalNumberOfRows(); i++) {
						// ����map����
						Map map = new HashMap();
						// ��ȡsheet��һ��
						row = sheet.getRow(i);
						for (int j = 0; j < row.getLastCellNum(); j++) {
							// ���ֹؼ��֣���������ѭ��
							if (row.getCell(lineNum) != null && cellTypeExcel2007(row.getCell(lineNum)).equals(lineKey)) {
								break labelSheet;
							} else {
								// ��ȡ��Ԫ�����ݣ�������map��
								if (row.getCell(j) != null) {
									// �ж��Ƿ�Ϊ��ʽ����
									if (row.getCell(j).getCellType() != XSSFCell.CELL_TYPE_FORMULA) {
										map.put(j, cellTypeExcel2007(row.getCell(j)));
									} else
										map.put(j, row.getCell(j));
								} else
									map.put(j, "");
							}
						}
						// ��map����list
						excel07List.add(map);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return excel07List;
	}

	/**
	 * ����excel2007
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
	public List readPoiExcel2007Title(String filePaths, int readRowNum) throws FileNotFoundException, IOException {
		// �������map��list,map������ŵ�Ԫ������
		List<Map> excel07List = new ArrayList<Map>();
		try {
			// ���� XSSFWorkbook ����
			XSSFWorkbook xwb = new XSSFWorkbook(filePaths);
			// sheet����
			int numOfSheets = xwb.getNumberOfSheets();
			// ��ȡsheet�������
			XSSFSheet sheet = xwb.getSheetAt(0);
			// ���� row
			XSSFRow row = sheet.getRow(readRowNum);
			// ����map����
			Map map = new HashMap();
			for (int j = 0; j < row.getLastCellNum(); j++) {
				// ��ȡ��Ԫ�����ݣ�������map��
				if (row.getCell(j) != null) {
					// �ж��Ƿ�Ϊ��ʽ����
					if (row.getCell(j).getCellType() != XSSFCell.CELL_TYPE_FORMULA) {
						map.put(j, cellTypeExcel2007(row.getCell(j)));
					} else
						map.put(j, row.getCell(j));
				} else
					map.put(j, "");

			}
			// ��map����list
			excel07List.add(map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return excel07List;
	}

	/**
	 * ����excel2007��ָ����ȡ��
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
	public List readPoiExcel2007(String filePaths, int readRowNum, int lineNum, String lineKey, List rowNumList)
			throws FileNotFoundException, IOException {
		// �������map��list,map������ŵ�Ԫ������
		List<Map> excel07List = new ArrayList<Map>();
		try {
			// ���� XSSFWorkbook ����
			XSSFWorkbook xwb = new XSSFWorkbook(filePaths);
			// sheet����
			int numOfSheets = xwb.getNumberOfSheets();
			// ѭ������sheet
			labelSheet: for (int s = 0; s < numOfSheets; s++) {
				// ��ȡsheet�������
				XSSFSheet sheet = xwb.getSheetAt(s);
				// ��ȡ��sheet������
				int rows = sheet.getPhysicalNumberOfRows();
				if (rows > 0) {
					// ���� row
					XSSFRow row;
					// ѭ���������е�����
					for (int i = readRowNum; i < sheet.getPhysicalNumberOfRows(); i++) {
						// ����map����
						Map map = new HashMap();
						// ��ȡsheet��һ��
						row = sheet.getRow(i);
						for (int j = 0; j < rowNumList.size(); j++) {
							int rn = Integer.parseInt(rowNumList.get(j).toString());
							// ���ֹؼ��֣���������ѭ��
							if (row.getCell(lineNum) != null && cellTypeExcel2007(row.getCell(lineNum)).equals(lineKey)) {
								break labelSheet;
							} else {
								// ��ȡ��Ԫ�����ݣ�������map��
								if (row.getCell(rn) != null) {
									// �ж��Ƿ�Ϊ��ʽ����
									if (row.getCell(rn).getCellType() != XSSFCell.CELL_TYPE_FORMULA)
										map.put(rn, cellTypeExcel2007(row.getCell(rn)));
									else
										map.put(rn, row.getCell(rn));
								} else
									map.put(rn, "");
							}
						}
						// ��map����list
						excel07List.add(map);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return excel07List;
	}

	/**
	 * ����excel2003
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
	public List readPoiExcel2003(String filePaths, int readRowNum, int lineNum, String lineKey)
			throws FileNotFoundException, IOException {
		// �������map��list,map������ŵ�Ԫ������
		List<Map> excel03List = new ArrayList<Map>();
		try {
			// ������Excel�������ļ�������
			HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(filePaths));
			// sheet����
			int numOfSheets = workbook.getNumberOfSheets();
			// ѭ������sheet
			labelSheet: for (int s = 0; s < numOfSheets; s++) {
				// �����Թ����������
				HSSFSheet sheet = workbook.getSheetAt(s);
				// ��ȡ�ù����������
				int rows = sheet.getPhysicalNumberOfRows();
				// �ж�sheet���Ƿ��������
				if (rows > 0) {
					// ����row
					HSSFRow row;
					// ѭ���������е�����
					for (int i = readRowNum; i < rows; i++) {
						// ����map����
						Map excel03Map = new HashMap();
						// ��ȡsheet��һ��
						row = sheet.getRow(i);
						int z = 0;
						for (short j = 0; j < row.getLastCellNum(); j++) {
							// ���ֹؼ��֣���������ѭ��
							if (row.getCell((short) lineNum) != null
									&& cellTypeExcel2003(row.getCell((short) lineNum)).equals(lineKey)) {
								break labelSheet;
							} else {
								// ��ȡ��Ԫ�����ݣ�������excel03Map��
								if (row.getCell(j) != null) {
									// �ж��Ƿ�Ϊ��ʽ����
									if (row.getCell(j).getCellType() != HSSFCell.CELL_TYPE_FORMULA)
										excel03Map.put(z, cellTypeExcel2003(row.getCell(j)));
									else
										excel03Map.put(z, row.getCell(j));
								} else
									excel03Map.put(z, "");
							}
							z++;
						}
						// ��map����list
						excel03List.add(excel03Map);
					}
				}
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return excel03List;
	}

	/**
	 * ����excel2003
	 * 
	 * @param filePaths
	 *            �����ļ�·��
	 * @param readRowNum
	 *            ��readRowNum�ж�ȡExcel����
	 * @param lineNum
	 *            ��������������
	 * @param lineKey
	 *            ������
	 * @param �ӵ�һ��Sheet�����ܶ�ȡSheetNum��Sheet
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public List readPoiExcel2003Sheet(String filePaths, int readRowNum, int sheetNum, int lineNum, String lineKey)
			throws FileNotFoundException, IOException {
		// �������map��list,map������ŵ�Ԫ������
		List<Map> excel03List = new ArrayList<Map>();
		try {
			// ������Excel�������ļ�������
			HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(filePaths));
			// sheet����
			int numOfSheets = 0;
			if (workbook.getNumberOfSheets() > sheetNum && sheetNum > 0) {
				numOfSheets = sheetNum;
			} else {
				numOfSheets = workbook.getNumberOfSheets();
			}
			// ѭ������sheet
			labelSheet: for (int s = 0; s < numOfSheets; s++) {
				// �����Թ����������
				HSSFSheet sheet = workbook.getSheetAt(s);
				// ��ȡ�ù����������
				int rows = sheet.getPhysicalNumberOfRows();
				// �ж�sheet���Ƿ��������
				if (rows > 0) {
					// ����row
					HSSFRow row;
					// ѭ���������е�����
					for (int i = readRowNum; i < rows; i++) {
						// ����map����
						Map excel03Map = new HashMap();
						// ��ȡsheet��һ��
						row = sheet.getRow(i);
						int z = 0;
						for (short j = 0; j < row.getLastCellNum(); j++) {
							// ���ֹؼ��֣���������ѭ��
							if (row.getCell((short) lineNum) != null
									&& cellTypeExcel2003(row.getCell((short) lineNum)).equals(lineKey)) {
								break labelSheet;
							} else {
								// ��ȡ��Ԫ�����ݣ�������excel03Map��
								if (row.getCell(j) != null) {
									// �ж��Ƿ�Ϊ��ʽ����
									if (row.getCell(j).getCellType() != HSSFCell.CELL_TYPE_FORMULA)
										excel03Map.put(z, cellTypeExcel2003(row.getCell(j)));
									else
										excel03Map.put(z, row.getCell(j));
								} else
									excel03Map.put(z, "");
							}
							z++;
						}
						// ��map����list
						excel03List.add(excel03Map);
					}
				}
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return excel03List;
	}

	/**
	 * ����excel2003
	 * 
	 * @param filePaths
	 *            �����ļ�·��
	 * @param readRowNum
	 *            ��readRowNum�ж�ȡExcel����
	 * @param lineNum
	 *            ��������������
	 * @param lineKey
	 *            ������
	 * @param b
	 *            �Ƿ�Ϊ��Sheet
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public List readPoiExcel2003Title(String filePaths, int readRowNum) throws FileNotFoundException, IOException {
		// �������map��list,map������ŵ�Ԫ������
		List<Map> excel03List = new ArrayList<Map>();
		try {
			// ������Excel�������ļ�������
			HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(filePaths));
			// �����Թ����������
			HSSFSheet sheet = workbook.getSheetAt(0);
			HSSFRow row = sheet.getRow(readRowNum);
			Map excel03Map = new HashMap();
			int z = 0;
			for (short j = 0; j < row.getLastCellNum(); j++) {
				if (row.getCell(j) != null) {
					// �ж��Ƿ�Ϊ��ʽ����
					if (row.getCell(j).getCellType() != HSSFCell.CELL_TYPE_FORMULA) {
						excel03Map.put(z, cellTypeExcel2003(row.getCell(j)));
					} else
						excel03Map.put(z, row.getCell(j));
				} else
					excel03Map.put(z, "");
				z++;
			}
			// ��map����list
			excel03List.add(excel03Map);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return excel03List;
	}

	/**
	 * ����excel2003��ָ����ȡ��
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
	public List readPoiExcel2003(String filePaths, int readRowNum, int lineNum, String lineKey, List rowNumList)
			throws FileNotFoundException, IOException {
		// �������map��list,map������ŵ�Ԫ������
		List<Map> excel03List = new ArrayList<Map>();
		try {
			// ������Excel�������ļ�������
			HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(filePaths));
			// sheet����
			int numOfSheets = workbook.getNumberOfSheets();
			// ѭ������sheet
			labelSheet: for (int s = 0; s < numOfSheets; s++) {
				// �����Թ����������
				HSSFSheet sheet = workbook.getSheetAt(s);
				// ��ȡ�ù����������
				int rows = sheet.getPhysicalNumberOfRows();
				// �ж�sheet���Ƿ��������
				if (rows > 0) {
					// ����row
					HSSFRow row;
					// ѭ���������е�����
					for (int i = readRowNum; i < rows; i++) {
						// ����map����
						Map excel03Map = new HashMap();
						// ��ȡsheet��һ��
						row = sheet.getRow(i);
						for (short j = 0; j < rowNumList.size(); j++) {
							int rn = Integer.parseInt(rowNumList.get(j).toString());
							// ���ֹؼ��֣���������ѭ��
							if (row.getCell((short) lineNum) != null
									&& cellTypeExcel2003(row.getCell((short) lineNum)).equals(lineKey)) {
								break labelSheet;
							} else {
								// ��ȡ��Ԫ�����ݣ�������excel03Map��
								if (row.getCell((short) rn) != null) {
									// �ж��Ƿ�Ϊ��ʽ����
									if (row.getCell((short) rn).getCellType() != HSSFCell.CELL_TYPE_FORMULA)
										excel03Map.put(rn, cellTypeExcel2003(row.getCell((short) rn)));
									else
										excel03Map.put(rn, row.getCell((short) rn));
								} else
									excel03Map.put(rn, "");
							}
						}
						// ��map����list
						excel03List.add(excel03Map);
					}
				}
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return excel03List;
	}

	/**
	 * Excel2003ת���ַ���
	 * 
	 * @param cell
	 * @return
	 */
	public String cellTypeExcel2003(HSSFCell cell) {
		String cellvalue = "";
		if (cell != null) {
			switch (cell.getCellType()) {
			// �����ǰCell��TypeΪNUMERIC
			case HSSFCell.CELL_TYPE_NUMERIC: {
				// �жϵ�ǰ��cell�Ƿ�ΪDate
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					// �����Date���ͣ�ȡ�ø�Cell��Dateֵ
					Date date = cell.getDateCellValue();
					// ��Dateת���ɱ��ظ�ʽ���ַ���
					cellvalue = DATE_FORMAT.format(date);
				}
				// ����Ǵ�����
				else {
					// ȡ�õ�ǰCell����ֵ
					long num = Long.valueOf(((long) cell.getNumericCellValue()));
					cellvalue = String.valueOf(num);
				}
				break;
			}
				// �����ǰCell��TypeΪSTRIN
			case HSSFCell.CELL_TYPE_STRING:
				// ȡ�õ�ǰ��Cell�ַ���
				cellvalue = cell.getRichStringCellValue().toString().replaceAll("'", "''");
				break;
			// Ĭ�ϵ�Cellֵ
			default:
				cellvalue = "";
			}
		} else {
			cellvalue = "";
		}
		return cellvalue;
	}

	/**
	 * Excel2007ת���ַ���
	 * 
	 * @param cell
	 * @return
	 */
	public String cellTypeExcel2007(XSSFCell cell) {
		String cellvalue = "";
		if (cell != null) {
			switch (cell.getCellType()) {
			// �����ǰCell��TypeΪNUMERIC
			case XSSFCell.CELL_TYPE_NUMERIC: {
				// �жϵ�ǰ��cell�Ƿ�ΪDate
				XSSFCellStyle style = cell.getCellStyle();
				int t = style.getDataFormat();
				if (isInternalDateFormat(t)) {
					// �����Date���ͣ�ȡ�ø�Cell��Dateֵ
					Date date = cell.getDateCellValue();
					// ��Dateת���ɱ��ظ�ʽ���ַ���
					cellvalue = DATE_FORMAT.format(date);
				}
				// ����Ǵ�����
				else {
					// ȡ�õ�ǰCell����ֵ
					long num = Long.valueOf(((long) cell.getNumericCellValue()));
					cellvalue = String.valueOf(num);
				}
				break;
			}
				// �����ǰCell��TypeΪSTRIN
			case XSSFCell.CELL_TYPE_STRING:
				// ȡ�õ�ǰ��Cell�ַ���
				cellvalue = cell.getRichStringCellValue().toString().replaceAll("'", "''");
				break;
			// Ĭ�ϵ�Cellֵ
			default:
				cellvalue = "";
			}
		} else {
			cellvalue = "";
		}
		return cellvalue;
	}

	/**
	 * ��ʽ������
	 * 
	 * @param format
	 * @return
	 */
	public boolean isInternalDateFormat(int format) {
		boolean retval = false;
		switch (format) {
		case 0x0e:
		case 0x0f:
		case 0x10:
		case 0x11:
		case 0x12:
		case 0x13:
		case 0x14:
		case 0x15:
		case 0x16:
		case 0x2d:
		case 0x2e:
		case 0x2f:
			retval = true;
			break;
		default:
			retval = false;
			break;
		}
		return retval;
	}
}
