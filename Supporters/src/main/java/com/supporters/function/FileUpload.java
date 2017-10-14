package com.supporters.function;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.supporters.domain.CommunityVO;

@Service
public class FileUpload { 

	    public String parseInsertFileInfo(MultipartHttpServletRequest request, HttpSession session) throws Exception{
	        String filePath =session.getServletContext().getRealPath("/resources/img/");
	        Iterator<String> iterator = request.getFileNames();
	        System.out.println(filePath);
	        MultipartFile multipartFile = null;
	        String originalFileName = null;
	        String originalFileExtension = null;
	        String storedFileName = null;
	         
	         
	         /*폴더 있는지 없는지 확인*/
	        File file = new File(filePath);
	        if(file.exists() == false){
	            file.mkdirs();
	        }
	         
	        while(iterator.hasNext()){
	            multipartFile = request.getFile(iterator.next());
	            if(multipartFile.isEmpty() == false){
	                originalFileName = multipartFile.getOriginalFilename();
	                originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
	                storedFileName = RandomName.getRandomName() + originalFileExtension;
	                 
	                file = new File(filePath + storedFileName);
	                multipartFile.transferTo(file);
	                System.out.println("이미지 들어옴");
	                
	            }
	            
	        }
	        
	        return storedFileName;
	    }
	    
    }
