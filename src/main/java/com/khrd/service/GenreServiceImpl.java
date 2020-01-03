package com.khrd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khrd.persistence.GenreDAO;

@Service
public class GenreServiceImpl implements GenreService{
	
	@Autowired
	private GenreDAO dao;

	@Override
	public List<String> selectList() {
		return dao.selectList();
	}


}
