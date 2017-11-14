package com.common;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;

import com.sinovatech.common.util.DateUtil;

/**
 * @description < String���� >
 */
public class StringUtil {

	public static String format(String s, String... args) {
		String result = s;
		int index = 0;
		while (result.contains("%s")) {
			if (index == args.length)
				break;

			if (args[index] == null) {
				args[index] = " ";
			}
			result = result.replaceFirst("%s", args[index]);
			index++;
		}
		return result;
	}

	public static double round(double v, int scale) {

		String temp = "###0.";
		for (int i = 0; i < scale; i++) {
			temp += "0";
		}
		return Double.valueOf(new java.text.DecimalFormat(temp).format(v));
	}

	public static double round(double v, int scale, boolean falg) {

		String temp = "###0.0";
		String tempScale = "1";
		for (int i = 0; i < scale; i++) {
			temp += "0";
			tempScale += "0";
		}
		double count = Double.parseDouble(tempScale);
		v = v * count;
		v = java.lang.Math.round(v) / count;
		return Double.valueOf(new java.text.DecimalFormat(temp).format(v));
	}

	/**
	 * ��������list �ֱ�ȥ���ظ���list
	 * 
	 * @param map
	 *            keyΪone two ��ʾ��һ���͵ڶ���list
	 * @return
	 */
	public static Map<String, List<String>> removeDuplicate(Map<String, List<String>> map) {
		boolean b = false;
		List<String> list1 = map.get("one");
		List<String> list2 = map.get("two");
		for (int i = 0, n = list1.size(); i < n; i++) {
			for (int j = 0, m = list2.size(); j < m; j++) {
				if (list2.get(j).equals(list1.get(i))) {
					list2.remove(j);
					list1.remove(i);
					i = n;
					b = true;
					break;
				}
			}
		}
		map.put("one", list1);
		map.put("two", list2);
		if (b) {
			return removeDuplicate(map);
		} else {
			return map;
		}
	}

	/**
	 * ��������list �õ�list2��ȥ���ظ����list
	 * 
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static List<String> delDuplicate(List<String> list1, List<String> list2) {
		boolean b = false;
		for (int i = 0, n = list1.size(); i < n; i++) {
			for (int j = 0, m = list2.size(); j < m; j++) {
				if (list2.get(j).equals(list1.get(i))) {
					list2.remove(j);
					list1.remove(i);
					i = n;
					b = true;
					break;
				}
			}
		}
		if (b) {
			return delDuplicate(list1, list2);
		} else {
			return list2;
		}
	}

	/**
	 * �Ƴ��ظ����ַ���
	 * 
	 * @param list
	 * @return
	 */
	public static List<String> removeDuplicate(List<String> list) {
		HashSet<String> h = new HashSet<String>(list);
		list.clear();
		list.addAll(h);

		return list;
	}

	/**
	 * �ϲ�����list ����ȥ�ظ�
	 * 
	 * @param list
	 * @param list2
	 * @return
	 */
	public static ArrayList<String> removeDuplicate(ArrayList<String> list, ArrayList<String> list2) {
		HashSet<String> hashSet = new HashSet<String>(list);
		hashSet.addAll(list2);
		list.clear();
		list.addAll(hashSet);
		return list;
	}

	/**
	 * ȡ��excel��Ԫ���ַ���ֵ
	 * 
	 * @param cell
	 * @return
	 */
	public static String getStringValue(HSSFCell cell) {
		return null != cell ? cell.getRichStringCellValue().toString().trim().toUpperCase() : "";
	}

	/**
	 * ȡ��excel��Ԫ��longֵ
	 * 
	 * @param cell
	 * @return
	 */
	public static long getLongValue(HSSFCell cell) {
		return null != cell ? (long) cell.getNumericCellValue() : 0;
	}

	/**
	 * ȡ��excel��Ԫ����ַ���ֵ
	 * 
	 * @param cell
	 * @return
	 */
	public static String getStringCellValue(HSSFCell cell) {
		String strCell = "";
		if (cell == null) {
			return strCell;
		}
		switch (cell.getCellType()) {
		case HSSFCell.CELL_TYPE_STRING:
			strCell = cell.toString();
			break;
		case HSSFCell.CELL_TYPE_NUMERIC:
			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				// strCell = DateUtil.formatDate(cell.getDateCellValue(), 1);
				strCell = formatDate(cell.getDateCellValue());
			} else {
				java.text.DecimalFormat df = new java.text.DecimalFormat("0");
				strCell = String.valueOf(df.format(cell.getNumericCellValue()));
			}
			break;
		case HSSFCell.CELL_TYPE_BOOLEAN:
			strCell = String.valueOf(cell.getBooleanCellValue());
			break;
		case HSSFCell.CELL_TYPE_BLANK:
			strCell = "";
			break;
		default:
			strCell = "";
			break;
		}
		return strCell;
	}

	/**
	 * Ĭ�ϸ�ʽ������
	 */
	public static String formatDate(java.util.Date date) {
		return DateUtil.format(date, DateUtil.yyyyMMddSpt);
	}

	/**
	 * ȡ��excel��Ԫ���ַ���ֵ
	 * 
	 * @param cell
	 * @return
	 */
	public static String getStringValue(String strCellValue) {
		return strCellValue;
	}

	/**
	 * ȡ��excel��Ԫ��longֵ
	 * 
	 * @param cell
	 * @return
	 */
	public static long getLongValue(String strCellValue) {
		return StringUtils.isEmpty(strCellValue) ? 0 : new Long(strCellValue);
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static Double parseDouble(String str) {
		if (StringUtil.isEmpty(str)) {
			return 0.0;
		}
		try {
			return Double.parseDouble(str);
		} catch (Exception ex) {
			return 0.0;
		}
	}

	/**
	 * �ж��Ƿ�Ϊȫ���� ������
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str) {
		Pattern p = Pattern.compile("^[0-9]\\d+$");
		return p.matcher(str).find();
	}

	/**
	 * �ж��Ƿ�Ϊ�������� ������С����
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumberAll(String str) {
		Pattern p = Pattern.compile("^(-|\\+)?\\d+(\\.\\d+)?$");// [0-9]\\d*\\.?\\d+$
		return p.matcher(str).find();
	}

	public static boolean contains(String str, char searchChar) {
		return StringUtils.contains(str, searchChar);
	}

	public static boolean contains(String str, String searchStr) {
		return StringUtils.contains(str, searchStr);
	}

	public static String getText(String str) {
		if (str == null)
			return ("");
		if (str.equals(""))
			return ("");
		// ����һ��StringBuffer��������������
		StringBuffer buf = new StringBuffer(str.length() + 6);
		char ch = '\n';
		for (int i = 0; i < str.length(); i++) {
			ch = str.charAt(i);
			if (ch == '\r') {
				buf.append(" ");
			} else if (ch == '\n') {
				buf.append(" ");
			} else if (ch == '\t') {
				buf.append("    ");
			} else if (ch == ' ') {
				buf.append(" ");
			} else if (ch == '\'') {
				buf.append("\\'");
			} else if (ch == '\"') {
				buf.append("\\\"");
			} else if (ch == '&') {
				buf.append("&amp;");
			} else if (ch == '<') {
				buf.append("&lt;");
			} else if (ch == '>') {
				buf.append("&gt;");
			} else {
				buf.append(ch);
			}
		}
		return buf.toString();
	}

	/**
	 * �ж��ַ����Ƿ�Ϊ��
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return (str == null || "".equals(str.trim()));
	}

	/**
	 * �ж��ַ����Ƿ�Ϊ�ǿ�
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}

	public static int parseInt(String str, int defaultVal) {
		try {
			return Integer.parseInt(str);
		} catch (Exception e) {
			return defaultVal;
		}
	}

	/**
	 * �ַ����ո���
	 * 
	 * @param value
	 * @return
	 */
	public static String trim(String value) {
		return value == null ? "" : value.trim();
	}
	
	public static final String encode(String str) {
        String encodedStr = str;
        try {
            encodedStr = URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            // ignored
        }
        return encodedStr;
	}
}
