package com.khrd.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDAOImpl implements CategoryDAO {
	private static final String namespace = "mappers.CategoryMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<String> selectList() {
		return sqlSession.selectList(namespace + "selectList");
	}

}
