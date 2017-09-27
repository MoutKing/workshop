package com.delta.workshop.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baidu.ueditor.MyActionEnter;

@RestController
public class UEditorController {
	
	@Value("${web.upload-path}")
	private String fileDirectory;

	@RequestMapping("/controller")
	public String controller(HttpServletRequest request,HttpServletResponse response) throws IOException, JSONException {
		request.setCharacterEncoding("utf-8");
		String baseState = new MyActionEnter(request, fileDirectory).exec();
		return baseState;
	}

}
