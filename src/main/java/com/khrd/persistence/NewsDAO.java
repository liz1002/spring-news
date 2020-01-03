package com.khrd.persistence;

import java.util.List;

import com.khrd.domain.NewsVO;

public interface NewsDAO {
	public List<NewsVO> selectList();
	public List<NewsVO> selectListByCName(String cName);
	public NewsVO selectListByNo(int nNo);
	public void insert(NewsVO vo);
	public void insertDetail(int nNo, String dContent);
}
