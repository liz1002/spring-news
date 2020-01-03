package com.khrd.controller.admin;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.khrd.domain.NewsVO;
import com.khrd.service.CategoryService;
import com.khrd.service.GenreService;
import com.khrd.service.NewsService;
import com.khrd.util.UploadFileUtils;

@RequestMapping("/admin/news/*")
@Controller
public class NewsController {
	private static final Logger logger = LoggerFactory.getLogger(NewsController.class);
	 
	@Resource(name = "uploadPath")
	private String uploadPath; 
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private GenreService genreService;
	
	@Autowired
	private NewsService newsService;
	
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public void registerGet(Model model) {
		logger.info("🚥 REGISTER GET 🚥");
		
		model.addAttribute("categoryList", categoryService.selectList());
		model.addAttribute("genreList", genreService.selectList());
	}
	
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String registerPost(NewsVO vo, MultipartFile mainFile) throws IOException {
		logger.info("🚥 REGISTER POST 🚥");
		logger.info("🚩 vo ::: " + vo);
		logger.info("🚩 mainFile ::: " + mainFile.getOriginalFilename());
		
		//파일 저장
		String saveName = UploadFileUtils.uploadFile(uploadPath, mainFile.getOriginalFilename(), mainFile.getBytes());
		
		//db에 저장
		vo.setnPath(saveName);
		newsService.regist(vo);
		
		//list로 이동
		return "redirect:list";
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void list(Model model, String cName) {
		logger.info("🚥 LIST 🚥");
		logger.info("🚩 cName ::: " + cName);
		
		if(cName != null) {
			model.addAttribute("newsList", newsService.selectListByCName(cName));	
		}else {
			model.addAttribute("newsList", newsService.selectList());
		}
		model.addAttribute("categoryList", categoryService.selectList());
		model.addAttribute("cName", cName);
	}
	
	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public void Upload(MultipartFile Filedata, String callback, String callback_func, HttpServletResponse servletResponse) throws IOException {
		logger.info("🚥 Upload 🚥");
		logger.info("🚩 filedata ::: " + Filedata.getOriginalFilename());
		
		String saveName = UploadFileUtils.uploadOriginFile(uploadPath, Filedata.getOriginalFilename(), Filedata.getBytes());
		String file_param = "&bNewLine=true&FileName="+saveName+"&sFileURL=/news/upload/displayFile?filename=/"+saveName;
		String result = callback + "?callback_func="+callback_func + file_param;
		System.out.println("!!!!" + saveName);
		servletResponse.sendRedirect(result);
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public void detail(Model model, int nNo) {
		logger.info("🚥 Detail 🚥");
		
		model.addAttribute("news", newsService.selectListByNo(nNo));
	}
}
