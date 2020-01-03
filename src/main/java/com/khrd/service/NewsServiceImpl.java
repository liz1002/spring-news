package com.khrd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.khrd.domain.NewsVO;
import com.khrd.persistence.NewsDAO;

@Service
public class NewsServiceImpl implements NewsService{
	
	@Autowired
	private NewsDAO dao;

	@Override
	public List<NewsVO> selectList() {
		return dao.selectList();
	}

	@Override
	@Transactional
	public void regist(NewsVO vo) {
		dao.insert(vo);
		dao.insertDetail(vo.getnNo(), vo.getdContent());
	}

	@Override
	public List<NewsVO> selectListByCName(String cName) {
		return dao.selectListByCName(cName);
	}

	@Override
	public NewsVO selectListByNo(int nNo) {
		return dao.selectListByNo(nNo);
	}
}
