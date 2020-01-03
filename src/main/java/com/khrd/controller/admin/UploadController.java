package com.khrd.controller.admin;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/upload/*")
@Controller
public class UploadController {
	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

	@Resource(name = "uploadPath") //bean id로 주입 받기(= DI : Dependency Injection)
	private String uploadPath; //파일 저장 경로(c:/news/upload)
	
	@RequestMapping(value = "displayFile", method = RequestMethod.GET)
	public ResponseEntity<byte[]> displayFile(String filename){
		ResponseEntity<byte[]> entity = null;
		logger.info("filename ::: " + filename);
		
		try {
			String formatName = filename.substring(filename.lastIndexOf(".") + 1);
			MediaType type = null;
			if(formatName.equalsIgnoreCase("jpg") || formatName.equalsIgnoreCase("jpeg")) {
				type = MediaType.IMAGE_JPEG;
			}else if(formatName.equalsIgnoreCase("png")) {
				type = MediaType.IMAGE_PNG;
			}else if(formatName.equalsIgnoreCase("gif")) {
				type = MediaType.IMAGE_GIF;
			}
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(type);

			InputStream in;
			if(filename.substring(12, 14).equals("s_")) {
				String datePath = filename.substring(0, 12); // "년/월/일/" 자르기
				String originFilename = filename.substring(14); // "년/월/일/s_" 뒤부터
				in = new FileInputStream(uploadPath + datePath + originFilename);
			}else {
				in = new FileInputStream(uploadPath + "/" + filename);
			}
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
			in.close(); //파일 삭제 등 안 먹히면 반드시 close
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}
}
