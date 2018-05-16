package com.revature.delegate;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.ImageDao;
import com.revature.dao.ImageDaoImple;

public class ImageDelegate {

	public ImageDao id = new ImageDaoImple();
	
	public void submitImage(HttpServletRequest request, HttpServletResponse response) throws IOException{
	}
}