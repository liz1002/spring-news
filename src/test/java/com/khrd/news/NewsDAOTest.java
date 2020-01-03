package com.khrd.news;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.khrd.domain.NewsVO;
import com.khrd.persistence.NewsDAO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class NewsDAOTest {
	
	@Autowired
	private NewsDAO dao;
	
//	@Test
	public void testInsert() {
		dao.insert(new NewsVO(0, "제목", "소제목", "이미지", "출처", null, "여행", "카페", "링크", "내용"));
	}
	
//	@Test
	public void testInsertDetail() {
		dao.insertDetail(3, "기사 내용");
	}
	
//	@Test
	public void testSelectList() {
		dao.selectList();
	}
	
	@Test
	public void testSelectListByCName() {
		dao.selectListByCName("영화");
	}
}
