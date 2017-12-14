package com.test.cost;

public class Xxx {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Logs.getLog().info(111);
		String str1 = new String("AB12CABCDEF2GHIGK31IMND31ABCD45EFGH6IGK7IMIGKIMN");
		String str5 = new String("DDNFHVUCMS");
		String str2 = new String("D");
		String str3 = new String("P");
		String str12 = str1;
		int i = str12.indexOf(str2);
		int j = str12.indexOf(str3);
		System.out.println(i);
		System.out.println(j); //indexOf()  若字符串不包含时，返回-1
		byte[] bytes = str12.getBytes();
		try {
			byte[] bytes2 = str12.getBytes("utf-8");
			System.out.println(bytes2.toString());
			System.out.println(str1.replaceAll("\\d", "O"));
			System.out.println(bytes.toString());
			System.out.println();
			//System.out.println(str1.charAt(2)); // 字符串下标从0开始
			//System.out.println(str1.codePointAt(3));
			//System.out.println(str1.codePointBefore(3));
			//System.out.println(str1.codePointCount(3, 5));
			//System.out.println(str1.compareTo(str5));
			//System.out.println(str1.concat(str5));
			//System.out.println(str1.contains("z"));
			//System.out.println(str1.hashCode());
			//System.out.println(str1.isEmpty());
			//System.out.println(str1.replace("A", "&"));
			String[] split = str1.split("\\d+");
			System.out.println(split.length);
			for(String ssString : split){
				System.out.print(ssString+" ");
			}
			System.out.println();
			char[] charArray = str1.toCharArray();
			for (char cha : charArray) {
				System.out.print(cha+" ");
			}
			System.out.println();
			System.out.println(str1.substring(2, 6));
			System.out.println(Integer.valueOf("2121"));
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
