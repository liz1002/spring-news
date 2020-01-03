package com.khrd.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.khrd.domain.NewsVO;

@Repository
public class NewsDAOImpl implements NewsDAO{
	private static final String namespace = "mappers.NewsMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<NewsVO> selectList() {
		return sqlSession.selectList(namespace + "selectList");
	}

	@Override
	public void insert(NewsVO vo) {
		sqlSession.insert(namespace + "insert", vo);
	}

	@Override
	public void insertDetail(int nNo, String dContent) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("nNo", nNo);
		map.put("dContent", dContent);
		sqlSession.insert(namespace + "insertDetail", map);
	}

	@Override
	public List<NewsVO> selectListByCName(String cName) {
		return sqlSession.selectList(namespace + "selectListByCName", cName);
	}

	@Override
	public NewsVO selectListByNo(int nNo) {
		return sqlSession.selectOne(namespace + "selectListByNo", nNo);
	}

}
