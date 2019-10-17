package com.kzhou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
public class HelloWorldController {

	@RequestMapping("/index")
	public void index(HttpServletRequest request,HttpServletResponse response) throws IOException {
		//处理请求，返回一个静态页面index.html
		String basePath = HelloWorldController.class.getResource("/").getPath();
		String fileName = request.getRequestURI();
		String path = basePath + fileName;
		//D:\WorkSpace_IDEA\spring-framework-5.0.x\spring-luban\out\production\resources\static\index.html
		path = "D:\\WorkSpace_IDEA\\spring-framework-5.0.x\\spring-luban\\out\\production\\resources\\static\\index.html";
		File file = new File(path);
		InputStream inputStream = new FileInputStream(file);
		byte[] bytes = new byte[2048];
		inputStream.read(bytes);
		inputStream.close();
		String s = new String(bytes);
		response.setContentType("text/html");
		response.getWriter().write(s);
	}
}
