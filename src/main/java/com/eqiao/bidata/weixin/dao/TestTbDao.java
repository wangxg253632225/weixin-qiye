/**
 * 
 */
package com.eqiao.bidata.weixin.dao;


import com.eqiao.bidata.weixin.pojo.TestTb;

import java.util.List;

/**
 * 测试
 * @author XinGuo
 *
 */
public interface TestTbDao {

	public void addTestTb(TestTb testTb);

	public List<TestTb> findTestList();
}
