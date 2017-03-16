package org.swinglife.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileUploadController {

	// 通过Spring的autowired注解获取spring默认配置的request
	@Autowired
	HttpServletRequest request;
	String path = "c:/users/weidiao/desktop/upload/";
	@RequestMapping("filesUpload")
	public String filesUpload(@RequestParam("files") MultipartFile[] files) {
		// 判断file数组不能为空并且长度大于0
		if (files != null && files.length > 0) {
			// 循环获取file数组中得文件
			for (int i = 0; i < files.length; i++) {
				MultipartFile file = files[i];
				// 保存文件

				saveFile(file);
			}
		}
		// 重定向
		return "redirect:/list.html";
	}

	/***
	 * 上传文件 用@RequestParam注解来指定表单上的file为MultipartFile
	 * 
	 * @param file
	 * @return
	 */
	@RequestMapping("fileUpload")
	public String fileUpload(@RequestParam MultipartFile file) {
		// 判断文件是否为空
		if (!file.isEmpty()) {
			try {
				saveFile(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 重定向
		return "redirect:/list.html";
	}

	private boolean saveFile(MultipartFile file) {
		System.out.println(
				request.getSession().getServletContext().getRealPath("/")
						+ "upload/" + file.getOriginalFilename());
		// 判断文件是否为空
		if (!file.isEmpty()) {
			try {
				// 转存文件
				file.transferTo(new File(path + file.getOriginalFilename()));
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@RequestMapping("list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("list");
		try {
			Files.newDirectoryStream(Paths.get(path))
					.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mav;
	}
}
