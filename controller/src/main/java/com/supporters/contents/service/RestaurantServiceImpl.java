package com.supporters.contents.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.supporters.contents.dao.RestaurantDAO;
import com.supporters.contents.domain.RestaurantVO;
import com.supporters.domain.CommunityVO;
import com.supporters.function.FileUpload;



@Service
public class RestaurantServiceImpl implements RestaurantService{

	@Inject
	private RestaurantDAO restaurantDAO;
	
	
	@Inject
    private FileUpload fileUpload;
	
	@Override
	public int count(RestaurantVO vo) throws Exception {
		// TODO Auto-generated method stub
		return restaurantDAO.count(vo);
	}

	@Override
	public List<RestaurantVO> list(RestaurantVO vo) throws Exception {
		// TODO Auto-generated method stub
		return restaurantDAO.list(vo);
	}

	@Override
	public void write(RestaurantVO vo) throws Exception {
		// TODO Auto-generated method stub
		restaurantDAO.write(vo);
	}

	@Override
	public void delete(RestaurantVO vo) throws Exception {
		// TODO Auto-generated method stub
		restaurantDAO.delete(vo);
	}

	@Override
	public void update(RestaurantVO vo) throws Exception {
		// TODO Auto-generated method stub
		restaurantDAO.update(vo);
	}

	@Override
	public List<RestaurantVO> view(RestaurantVO vo) throws Exception{
		// TODO Auto-generated method stub
		
		return restaurantDAO.view(vo);
		
	}

	@Override
	public String fileUpload(MultipartHttpServletRequest request,HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		/*파일업로드 서비스 불러오기*/
		
		return fileUpload.parseInsertFileInfo(request,session);
	}

	/* (non-Javadoc)
	 * @see com.supporters.contents.service.RestaurantService#comment(com.supporters.contents.domain.RestaurantVO)
	 */
	@Override
	public List<RestaurantVO> comment(RestaurantVO vo) throws Exception {
		// TODO Auto-generated method stub
		return restaurantDAO.comment(vo);
	}
	
	

	


}
