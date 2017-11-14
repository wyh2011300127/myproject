package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.common.DateUtil;
import com.excel.PoiReadExcelBean;
import com.excel.PoiReadExcelBeanImpl;


public class DemoUtilSub {
	public static void main(String[] args) {
		Map readMap = null;
		PoiReadExcelBean poiReadBean = new PoiReadExcelBeanImpl();// poi操作工具�?
		try {
			List<Map> readExcel = poiReadBean.readExcel("D:/stockSub.xls", 0);
			List<String> arrayList = new ArrayList<String>();
			for (Map m : readExcel) {
				String clientCode = (String) m.get(0);
				String groupId = (String) m.get(1);
				String color = (String) m.get(2);
				String num = (String) m.get(3);
				String opLine = (String) m.get(4);
				String orderNo = (String) m.get(5);
				System.out.println("clientCode=" + clientCode + "|groupId= " + groupId + "|colcor=" + color + "|num=" + num + "|opLine=" + opLine
						+ "|orderNo=" + orderNo);
				
				InputStream in = new FileInputStream(new File("D:/tmpSub.txt"));
				BufferedReader reader = new BufferedReader(new InputStreamReader(in));
				StringBuilder template = new StringBuilder();
				String line = "";
				while ((line = reader.readLine()) != null) {
					template.append(line).append("\n");
				}
				String result = template.toString();
				result = result.replaceAll("#clientCode#", clientCode).replaceAll("#groupId#", groupId)
				.replaceAll("#color#", color).replaceAll("#num#", num)
				.replaceAll("#opLine#", opLine)
				.replaceAll("#orderNo#", orderNo).replaceAll("#time#", DateUtil.date2Str(new Date(), "yyyyMMddHHmmss"));
				System.out.println(result);
				arrayList.add(result);
			}
			FileUtils.writeLines(new File("D:/resultSub.txt"), arrayList);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
