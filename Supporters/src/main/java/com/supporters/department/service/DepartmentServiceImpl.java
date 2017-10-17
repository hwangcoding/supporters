package com.supporters.department.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.supporters.department.dao.DepartmentDAO;
import com.supporters.domain.CommunityVO;
import com.supporters.function.FileUpload;


@Service
public class DepartmentServiceImpl  implements DepartmentService{

	
	@Inject
	private DepartmentDAO departmentDAO;
	
	@Inject
    private FileUpload fileUpload;


	@Override
	public void regist(CommunityVO vo) throws Exception {
		// TODO Auto-generated method stub
		
		/*DB 쿼리 */
		departmentDAO.create(vo);
	}
	@Override
	public List<CommunityVO>  read(CommunityVO vo) throws Exception {
		// TODO Auto-generated method stub
		return departmentDAO.read(vo);
	}

	@Override
	public void modify(CommunityVO vo) throws Exception {
		// TODO Auto-generated method stub
		departmentDAO.update(vo);
		
	}

	@Override
	public void remove(CommunityVO vo) throws Exception {
		// TODO Auto-generated method stub
		departmentDAO.delete(vo);
	}
 
	@Override
	public List<CommunityVO> list(CommunityVO vo) throws Exception {
		// TODO Auto-generated method stub
		return departmentDAO.list(vo);
	}

	@Override
	public int count(CommunityVO vo) throws Exception {
		// TODO Auto-generated method stub
		return departmentDAO.count(vo);
	}
	@Override
	public String fileInsert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		/*파일업로드 서비스 불러오기*/
		return null;
		
	}

	
	
}
