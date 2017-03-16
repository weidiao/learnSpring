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

	// ͨ��Spring��autowiredע���ȡspringĬ�����õ�request
	@Autowired
	HttpServletRequest request;
	String path = "c:/users/weidiao/desktop/upload/";
	@RequestMapping("filesUpload")
	public String filesUpload(@RequestParam("files") MultipartFile[] files) {
		// �ж�file���鲻��Ϊ�ղ��ҳ��ȴ���0
		if (files != null && files.length > 0) {
			// ѭ����ȡfile�����е��ļ�
			for (int i = 0; i < files.length; i++) {
				MultipartFile file = files[i];
				// �����ļ�

				saveFile(file);
			}
		}
		// �ض���
		return "redirect:/list.html";
	}

	/***
	 * �ϴ��ļ� ��@RequestParamע����ָ�����ϵ�fileΪMultipartFile
	 * 
	 * @param file
	 * @return
	 */
	@RequestMapping("fileUpload")
	public String fileUpload(@RequestParam MultipartFile file) {
		// �ж��ļ��Ƿ�Ϊ��
		if (!file.isEmpty()) {
			try {
				saveFile(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// �ض���
		return "redirect:/list.html";
	}

	private boolean saveFile(MultipartFile file) {
		System.out.println(
				request.getSession().getServletContext().getRealPath("/")
						+ "upload/" + file.getOriginalFilename());
		// �ж��ļ��Ƿ�Ϊ��
		if (!file.isEmpty()) {
			try {
				// ת���ļ�
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
