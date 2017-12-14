package com;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jsonStr = "{\"name\":\"张三\", \"age\":\"14\"}";
		System.out.println(jsonStr);
		JSONObject jsonObj =  JSONObject.fromObject(jsonStr);
		System.out.println(jsonObj);
		
		List<Integer> list = new ArrayList<Integer>();
		for ( int  i = 0 ; i < 10 ; i++) {
			list.add(i);
		}
		JSONArray jsonArry = JSONArray.fromObject(list);
		System.out.println(list);
		System.out.println(jsonArry);
		
		
	}

}
