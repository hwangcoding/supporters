package com.supporters.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.supporters.dao.AlertLogDAO;
import com.supporters.domain.AlertLogVO;

@Service
public class AlertLogServiceImpl implements AlertLogService {

	
	@Inject
	private AlertLogDAO alertLogDAO;
	
	@Override
	public void log(AlertLogVO vo) throws Exception {
		// TODO Auto-generated method stub
		alertLogDAO.log(vo);
	}

	/* (non-Javadoc)
	 * @see com.supporters.service.AlertLogService#list(com.supporters.domain.AlertLogVO)
	 */
	@Override
	public List<AlertLogVO> list(AlertLogVO vo) throws Exception {
		// TODO Auto-generated method stub
		return alertLogDAO.list(vo);
	}

	/* (non-Javadoc)
	 * @see com.supporters.service.AlertLogService#count(com.supporters.domain.AlertLogVO)
	 */
	@Override
	public int count(AlertLogVO vo) throws Exception {
		// TODO Auto-generated method stub
		return alertLogDAO.count(vo);
	}
	
	
	
	

}
