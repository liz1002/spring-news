package com.khrd.service;

import java.util.List;

import com.khrd.domain.NewsVO;

public interface NewsService {
	public List<NewsVO> selectList();
	public List<NewsVO> selectListByCName(String cName);
	public NewsVO selectListByNo(int nNo);
	public void regist(NewsVO vo);
}
