package com.simple.controller;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.simple.command.UploadVO;

@Controller
@RequestMapping("/fileupload")
public class UploadController {
	public static final String UPLOAD_PATH = "D:\\course\\upload";
	
	@RequestMapping("/upload")
	public String upload() {
		
		return "fileupload/upload";
	}
	@RequestMapping("/upload_ok")
	public String upload_ok(@RequestParam("file") MultipartFile file) {
		
		try {
			String fileRealName = file.getOriginalFilename();
			long size = file.getSize();
			String fileExtention = fileRealName.substring(fileRealName.lastIndexOf("."),fileRealName.length());
			
			System.out.println("파일실제이름:" +fileRealName);
			System.out.println("파일크기:"+size);
			System.out.println("파일확장자:"+fileExtention);
			
			File saveFile = new File(UPLOAD_PATH+"\\"+fileRealName);
			file.transferTo(saveFile);//파일저장메서드(fileWriter작업을 손쉽게 처리) 
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return "fileupload/upload_ok";
	}
	//다중파일 처리1
	@RequestMapping("/upload_ok2")
	public String upload_ok2(MultipartHttpServletRequest files) {
		
		List<MultipartFile> list = files.getFiles("files");
		
		try {
			for (int i = 0; i < list.size(); i++) {
				String fileRealName = list.get(i).getOriginalFilename();
				long size = list.get(i).getSize();
				String fileExtention = fileRealName.substring(fileRealName.lastIndexOf("."),fileRealName.length());
				
				System.out.println("파일실제이름:" +fileRealName);
				System.out.println("파일크기:"+size);
				System.out.println("파일확장자:"+fileExtention);
				
				File saveFile = new File(UPLOAD_PATH+"\\"+fileRealName);
				list.get(i).transferTo(saveFile);//파일저장메서드(fileWriter작업을 손쉽게 처리)
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "fileupload/upload_ok";
	}
	@RequestMapping("/upload_ok3")
	public String upload_ok3(@RequestParam("file") List<MultipartFile> list) {
		
		try {
			for (int i = 0; i < list.size(); i++) {
				if(!list.get(i).isEmpty()) {
				String fileRealName = list.get(i).getOriginalFilename();
				long size = list.get(i).getSize();
				String fileExtention = fileRealName.substring(fileRealName.lastIndexOf("."),fileRealName.length());
				
				System.out.println("파일실제이름:" +fileRealName);
				System.out.println("파일크기:"+size);
				System.out.println("파일확장자:"+fileExtention);
				
				File saveFile = new File(UPLOAD_PATH+"\\"+fileRealName);
				list.get(i).transferTo(saveFile);//파일저장메서드(fileWriter작업을 손쉽게 처리)
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "fileupload/upload_ok";
	}
	@RequestMapping("/upload_ok4")
	public String upload_ok4(UploadVO vo) {
//		List<UploadVO> list = vo.getList();
//		
//		try {
//			for (int i = 0; i < list.size(); i++) {
//				
//				String fileRealName = list.get(i).getOriginalFilename();
//				long size = list.get(i).getSize();
//				String fileExtention = fileRealName.substring(fileRealName.lastIndexOf("."),fileRealName.length());
//				
//				System.out.println("파일실제이름:" +fileRealName);
//				System.out.println("파일크기:"+size);
//				System.out.println("파일확장자:"+fileExtention);
//				
//				File saveFile = new File(UPLOAD_PATH+"\\"+fileRealName);
//				list.get(i).transferTo(saveFile);//파일저장메서드(fileWriter작업을 손쉽게 처리)
//				
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
		return "fileupload/upload_ok";
		
	}
}
