package com.hdn.zp;

import com.hdn.zp.utils.RedisUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@SpringBootTest(classes = {ZpApplication.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ZpApplicationTests {

	@Resource
	RedisUtils redisUtils;

	@Test
	public void testRedis() {
		redisUtils.set("aa","cc",50);
	}

}
