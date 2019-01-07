package com.im;

import com.im.mapper.first.ApexDayMapper;
import com.im.pojo.first.ApexDay;
import com.im.resp.RespResult;
import com.im.service.GradeSubentryService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FuckDogApplicationTests {

	@Autowired
	private GradeSubentryService gradeSubentryService;
	@Autowired
	private ApexDayMapper apexDayMapper;

	@Test
	public void gradeSubentry(){
//		Double max = apexDayMapper.getMaxSum("201811110022","ygdl","2018-11-01","2018-12-31");
		RespResult result = gradeSubentryService.gradeSubentry("","2018-11-01","2018-12-31",0);
		System.out.print(result.getData().toString());
	}

}
