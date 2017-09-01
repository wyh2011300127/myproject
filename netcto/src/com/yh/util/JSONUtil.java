package com.yh.util;

import com.alibaba.fastjson.JSON;

public class JSONUtil {
	public static <T> String object2Json(Object object ){
		return JSON.toJSONString(object);
	}
}
