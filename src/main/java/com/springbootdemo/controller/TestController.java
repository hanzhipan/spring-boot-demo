package com.springbootdemo.controller;

import com.springbootdemo.dao.mapper.UserMapper;
import com.springbootdemo.domain.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author hanzhipan
 */
@RestController
public class TestController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private KafkaTemplate kafkaTemplate;

	@Autowired
	private UserMapper userMapper;

	private final CountDownLatch latch = new CountDownLatch(4);

	@RequestMapping("/show")
	public String show(){
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		list.forEach(n -> System.out.print(n));
		return "Hello World";
	}

	@RequestMapping("/getuser")
	public User getUser(@RequestParam String phone) {
		User user = userMapper.findUserByPhone(phone);
		return user;
	}

	@RequestMapping("/insertuser")
	public int insertUser(@RequestParam String name, @RequestParam String phone) {
		int cnt = userMapper.insert(name, phone);
		return cnt;
	}

	@RequestMapping(value = "/send")
	public void sendKafka(@RequestParam String message) {
		try {
			logger.info("kafka的消息={}", message);
			kafkaTemplate.send("test", "key", message);
			logger.info("发送kafka成功.");
		} catch (Exception e) {
			logger.error("发送kafka失败", e);
		}
	}
}
