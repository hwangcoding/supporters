package com.supporters.management.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.supporters.management.dao.QnaDAO;
import com.supporters.management.domain.QnaVO;

@Service
public class QnaServiceImpl implements QnaService {
	
	@Inject
	private QnaDAO qnadao;

	@Override
	public void comment(QnaVO vo) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(QnaVO vo) throws Exception {
		// TODO Auto-generated method stub
		qnadao.update(vo);
	}

	@Override
	public void delete(QnaVO vo) throws Exception {
		// TODO Auto-generated method stub
		qnadao.delete(vo);
	}

	@Override
	public List<QnaVO> list(QnaVO vo) throws Exception {
		// TODO Auto-generated method stub
		return qnadao.list(vo);
	}

	@Override
	public int count(QnaVO vo) throws Exception {
		// TODO Auto-generated method stub
		return qnadao.count(vo);
	}

	@Override
	public List<QnaVO> view(QnaVO vo) throws Exception {
		// TODO Auto-generated method stub
		return qnadao.view(vo);
	}

	@Override
	public void write(QnaVO vo) throws Exception {
		// TODO Auto-generated method stub
		qnadao.write(vo);
	}
	
	
	
	

}
