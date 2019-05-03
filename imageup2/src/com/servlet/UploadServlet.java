package com.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UploadServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException {
		
		doPost(request,response);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //从request当中获取流信息
        InputStream fileSource = req.getInputStream();
        String tempFileName = "D:/tempFile";
        //tempFile指向临时文件
        File tempFile = new File(tempFileName);
        //outputStram文件输出流指向这个临时文件
        FileOutputStream outputStream = new FileOutputStream(tempFile);
        byte b[] = new byte[1024];
        int n;
        while(( n = fileSource.read(b)) != -1){
            outputStream.write(b, 0, n);
        }
        //关闭输出流、输入流
        outputStream.close();
        fileSource.close();

        //获取上传文件的名称
        RandomAccessFile randomFile = new RandomAccessFile(tempFile,"r");
        randomFile.readLine();
        String str = randomFile.readLine();
        int beginIndex = str.lastIndexOf("filename=\"") + 10;
        int endIndex = str.lastIndexOf("\"");
        String filename = str.substring(beginIndex, endIndex);
        System.out.println("filename:" + filename);

        //重新定位文件指针到文件头
        randomFile.seek(0);
        long startPosition = 0;
        int i = 1;
        //获取文件内容 开始位置
        //开始位置的获取是因为Request Payload部分的第五行开始的
        while(( n = randomFile.readByte()) != -1 && i <=4){
            if(n == '\n'){
                startPosition = randomFile.getFilePointer();
                i ++;
            }
        }
        startPosition = randomFile.getFilePointer() -1;
        //获取文件内容 结束位置
        //从后往前获取到倒数第二行结束
        randomFile.seek(randomFile.length());
        long endPosition = randomFile.getFilePointer();
        int j = 1;
        while(endPosition >=0 && j<=2){
            endPosition--;
            randomFile.seek(endPosition);
            if(randomFile.readByte() == '\n'){
                j++;
            }
        }
        endPosition = endPosition -1;

        //设置保存上传文件的路径
        String realPath = getServletContext().getRealPath("/") + "images";
        System.out.println("realPath:====>"+realPath);
        File fileupload = new File(realPath);
        if(!fileupload.exists()){
            fileupload.mkdir();
        }
        File saveFile = new File(realPath,filename);
        RandomAccessFile randomAccessFile = new RandomAccessFile(saveFile,"rw");
        //从临时文件当中读取文件内容（根据起止位置获取）
        randomFile.seek(startPosition);
        while(startPosition < endPosition){
            randomAccessFile.write(randomFile.readByte());
            startPosition = randomFile.getFilePointer();
        }
        //关闭输入输出流、删除临时文件
        randomAccessFile.close();
        randomFile.close();
        tempFile.delete();

        req.setAttribute("result", "上传成功！");
        req.setAttribute("filename", filename);
        RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/first.jsp");
        dispatcher.forward(req, resp);
    }
}