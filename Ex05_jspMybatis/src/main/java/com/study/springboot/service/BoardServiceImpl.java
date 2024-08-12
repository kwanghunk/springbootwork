package com.study.springboot.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.springboot.dto.Board;
import com.study.springboot.repository.BoardDao;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired // Dao를 자동으로 불러올 수 있도록
	BoardDao boardDao;
	
	@Override
	public int totalRecord() {
		return boardDao.totalRecord();
	}

	@Override
	public List<Board> list() {
		return boardDao.list();
	}

	@Override
	public Board detailBoard(String boardno) {
		return boardDao.detailBoard(boardno);
	}

	@Override
	public int deleteBoard(int boardno) {
		return boardDao.deleteBoard(boardno);
	}

	@Override
	@Transactional
	public int insertBoard(Map<String, String> map) {
		return boardDao.insertBoard(map);
	}

	@Override
	public int insertBoard(Board b) {
		return boardDao.insertBoard(b);
		
	}
	
	
	

}
