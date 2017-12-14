package redis;

import redis.clients.jedis.Jedis;

public class Demo {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("localhost", 6379);
		// 验证密码，如果没有设置密码这段代码省略
		// jedis.auth("password");
		jedis.connect();
		jedis.set("1", "test");
		System.out.println(jedis.get("1"));
		//System.out.println(jedis.get("myKey"));
	}
}
