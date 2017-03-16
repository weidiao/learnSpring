package org.swinglife.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("index")
	public ModelAndView index() {
		// ����ģ�͸���ͼ��������Ⱦҳ�档����ָ��Ҫ���ص�ҳ��Ϊhomeҳ��
		ModelAndView mav = new ModelAndView("home");
		return mav;
	}

	@RequestMapping("toFileUpload")
	public String toFileUpload() {
		return "fileUpload";
	}

	@RequestMapping("toFilesUpload")
	public String toFilesUpload() {
		return "filesUpload";
	}
}
