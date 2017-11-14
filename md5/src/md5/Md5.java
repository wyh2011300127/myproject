package md5;

import org.apache.commons.codec.digest.DigestUtils;

public class Md5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//重置卖家密码
		//System.out.println(DigestUtils.md5Hex("重置的密码" + "X0w3@v" + "卖家工号"));	
		//System.out.println(DigestUtils.md5Hex("Ab2_Yz6!" + "X0w3@v" + "ZDGS@test04"));
		System.out.println(DigestUtils.md5Hex("000000" + "X0w3@v" + "ZDGS"));
	}

}
