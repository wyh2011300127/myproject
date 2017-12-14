package com.test.cost;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Demo {
	private static Log log = LogFactory.getLog(Demo.class);
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		for (int i = 1; i < 6; i++) {
			list1.add(i);
		}
		log.info(list1);
		for (int i = 10; i < 20; i++) {
			list2.add(i);
		}
		log.info(list2);
		map.put("list1", list1);
		map.put("list2", list2);
		log.info(map);
		// 遍历Map第一种方式
		Iterator<Entry<String, List<Integer>>> iterator = map.entrySet().iterator();
		int ii = iterator.hashCode();
		log.info("hashCode "+ii);
		while (iterator.hasNext()) {
			log.info("iterator.hasNext() "+iterator.hasNext());
			Entry<String, List<Integer>> next = iterator.next();
			String key = next.getKey();
			List<Integer> value = next.getValue();
			log.info("key: " + key + ",value: " + value);
			for (int i = 20; i < 25; i++) {
				value.add(i);
			}
		}
		log.info(map);
		// 遍历Map第二种方式
		Set<String> keySet = map.keySet();
		int hashCode = keySet.hashCode();
		log.info("hashCode "+hashCode);
		Iterator<String> iterator2 = keySet.iterator();
		while(iterator2.hasNext()){
			String next = iterator2.next();
			log.info(next);
		}
		Set<Integer> set = new HashSet<Integer>();
		set.add(1);
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(5);
		log.info(set);
		List<Integer> list3 = new ArrayList<Integer>();
		List<Integer> list4 = new LinkedList<Integer>();
		for(int i=0 ;i<10;i++){
			list3.add(i);
			list4.add(i);
		}
		log.info(list3);
		log.info(list4);
		boolean yesoOrNo = list3.addAll(list4);
		log.info(yesoOrNo);
		//list3.clear();
		log.info(list3);
		log.info(list3.containsAll(list4));
		log.info(list3.contains(200));
		//list3.notify();
		Iterator<Integer> iterator3 = list3.iterator();
		while(iterator3.hasNext()){
			log.info(iterator3.next());
		}
		Iterator<Integer> iterator4 = list4.iterator();
		while(iterator4.hasNext()){
			Integer next = iterator4.next();
			log.info(next);
		}
		log.info(list3);
		log.info(map);
		log.info(map.size());
		log.info(map.containsKey("list3"));
		log.info(map.containsKey("list1"));
		log.info(map.containsValue(list4));
		Iterator<Entry<String, List<Integer>>> ite = map.entrySet().iterator();
		while(ite.hasNext()){
			Entry<String, List<Integer>> next = ite.next();
			log.info(next.getKey()+":"+next.getValue());
		}
		
		Map<String,String> mapp = new HashMap<String,String>();
		mapp.put("1", "value1");
		mapp.put("2", "value2");
		mapp.put("3", "value3");
		mapp.put("4", "value4");
		log.info(mapp);
		//1.ketSet 效率低 通过键 获取值
		for(String key : mapp.keySet()){
			log.info(key + ":"+ mapp.get(key));
		}
		Iterator<String> iterator5 = mapp.keySet().iterator();
		while(iterator5.hasNext()){
			String key = iterator5.next();
			log.info(key+":"+mapp.get(key));
		}
		//2.Entry<String, String>
		Iterator<Entry<String, String>> iterator6 = mapp.entrySet().iterator();
		while(iterator6.hasNext()){
			Entry<String, String> next = iterator6.next();
			log.info(next.getKey()+":"+next.getValue());
		}
		//3.Set<Entry<String, String>>   推荐，尤其是容量大时
		Set<Entry<String, String>> sett = mapp.entrySet();
		for(Entry<String, String> entry : sett){
			log.info(entry.getKey()+":"+entry.getValue());
		}
		
		//4.通过Map.values()遍历所有的value，但不能遍历key
		Collection<String> values = mapp.values();
		for(String str : values){
			log.info("value:" + str);
		}
		
		
	}

}
