package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.FileCut;
import com.util.UploadImg;

public class ScaleImgServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		String filename = req.getParameter("filename");
        System.out.println("ScaleImgServlet=filename:==>"+filename);
        //获取文件下载路径
        String path = getServletContext().getRealPath("/") + "images/";
        System.out.println("path:======>"+path);
        
        // 先放缩后切割图片,与后面代码无关
     	cutImg(path+filename,path,filename);
        
     	//图片自适应
		try {
			FileCut.Thumbnail(50, 50, filename,path);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//req.setAttribute("filename", filename);
        RequestDispatcher dispatcher = req.getRequestDispatcher("downloadServlet.do?filename="+("new"+filename));
        dispatcher.forward(req, resp);
        
	}

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req,resp);
    }
    //切割图片函数
  	public static void cutImg(String fromFileStr,String saveToFileStr,String filename) {
  		UploadImg UI;
  		boolean ss = false;
  		try {
  			UI = new UploadImg(fromFileStr, saveToFileStr,filename, "jpg",200,200);
  			ss = UI.createThumbnail();
  			if (ss) {
  				System.out.println("Success");
  			} else {
  				System.out.println("Error");
  			}
  		} catch (Exception e) {
  			System.out.print(e.toString());
  		}
  	}
}
