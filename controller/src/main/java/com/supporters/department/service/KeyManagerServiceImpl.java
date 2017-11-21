package com.supporters.department.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.supporters.department.dao.KeyManagerDAO;
import com.supporters.department.domain.KeyManagerVO;

@Service
public class KeyManagerServiceImpl implements KeyManagerService {
	
	@Inject
	KeyManagerDAO keymanagerDAO;

	@Override
	public List<KeyManagerVO> list(KeyManagerVO vo) throws Exception {
		// TODO Auto-generated method stub
		return keymanagerDAO.list(vo);
	}

	@Override
	public void update(KeyManagerVO vo) throws Exception {
		// TODO Auto-generated method stub
		keymanagerDAO.update(vo);
	}

	/* (non-Javadoc)
	 * @see com.supporters.department.service.KeyManagerService#count(com.supporters.department.domain.KeyManagerVO)
	 */
	@Override
	public int count(KeyManagerVO vo) throws Exception {
		// TODO Auto-generated method stub
		return keymanagerDAO.count(vo);
	}
	
	

}
