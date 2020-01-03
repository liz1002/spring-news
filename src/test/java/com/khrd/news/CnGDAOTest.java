package com.khrd.news;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.khrd.persistence.CategoryDAO;
import com.khrd.persistence.GenreDAO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class CnGDAOTest {
	
	@Autowired
	private CategoryDAO cDao;

	@Autowired
	private GenreDAO gDao;
	
	@Test
	public void testSelectListCategory() {
		cDao.selectList();
	}
	
	@Test
	public void testSelectListGenre() {
		gDao.selectList();
	}
}
