/**
 * 
 */
package com.eqiao.bidata.weixin.service.impl;

import javax.annotation.Resource;

import com.eqiao.bidata.weixin.dao.TestTbDao;
import com.eqiao.bidata.weixin.pojo.TestTb;
import com.eqiao.bidata.weixin.service.TestTbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author XinGuo
 *
 */
@Service("testTbService")
@Transactional//开启事务
public class TestTbServiceImpl implements TestTbService {

	@Autowired
	protected TestTbDao testTbDao;
	
	// 添加默认开启事务
	// @Transactional(readOnly = true) 查询关闭事务
	public void addTestTb(TestTb testTb) {
		testTbDao.addTestTb(testTb);
		// 抛异常测试事务
		//throw new RuntimeException();
	}

}
