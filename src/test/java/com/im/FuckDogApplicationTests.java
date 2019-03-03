package com.im;

import com.im.mapper.first.ApexDayMapper;
import com.im.service.GradeSubentryService;
import org.springframework.beans.factory.annotation.Autowired;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class FuckDogApplicationTests {

	@Autowired
	private GradeSubentryService gradeSubentryService;
	@Autowired
	private ApexDayMapper apexDayMapper;

//	@Test
	public void gradeSubentry(){
//		Double max = apexDayMapper.getMaxSum("201811110022","ygdl","2018-11-01","2018-12-31");
//		ServerResponse result = gradeSubentryService.gradeSubentry("","2018-11-01","2018-12-31",0);
//		System.out.print(result.getData().toString());
	}

}
