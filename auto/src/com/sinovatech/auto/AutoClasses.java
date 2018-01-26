package com.sinovatech.auto;


public class AutoClasses {
	// 工作空间路径
	public static String WORKSPACE = "D:/workspaces/";
	// 打包文件存储目录
	static String TO_FOLDER = "D:/package";
	// 打包列表文件路径
	static String PATH_QT = "D:/classes.txt";

	public static void main(String[] args) throws Exception {
		B2bFileUtil.execute(PATH_QT, TO_FOLDER, "WebRoot");
	}

}
