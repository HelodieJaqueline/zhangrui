package com.zhangrui.api;

import com.zhangrui.redis.RedisListOps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZhangruiApplicationTests {

	@Autowired
	private RedisListOps redisListOps;

	@Test
	public void redisList() {
		redisListOps.push();
		redisListOps.pop();
	}
}
