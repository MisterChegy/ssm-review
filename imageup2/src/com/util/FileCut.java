package com.util;

import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class FileCut {
	
//	public static void main(String[] args) throws IOException, InterruptedException {
//		//cut("images.jpg");
//		Thumbnail("images.jpg","image01.jpg",50,50,100);
//	}
	
	public static void Thumbnail(int width,int heigth,String filename,String path) throws IOException, InterruptedException{
		//这个临时路径不稳定，重启服务器可能变化
		//String path = "D:/eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp9/wtpwebapps/imageup/images/";
		Thumbnail(path + filename,path + "new" + filename,width,heigth,100);
	}
	/** 
     * 等比例缩放图片 
     *  
     * @param infile 
     * @param outfile 
     * @param width 
     * @param height 
     * @param quality 
     * @throws IOException 
     * @throws InterruptedException 
     */  
    public static void Thumbnail(String infile, String outfile, int width,  
            int height, int quality) throws IOException, InterruptedException {  
        // save thumbnail image to OUTFILE  
        // System.out.println("infile:" + infile);  
        BufferedImage thumbImage = null;  
        BufferedOutputStream out = null;  
        Image image = null;  
        image = Toolkit.getDefaultToolkit().createImage(infile);  
        MediaTracker mediaTracker = new MediaTracker(new Container());  
        mediaTracker.addImage(image, 0);  
        mediaTracker.waitForID(0);  
        int thumbWidth = width;  
        int thumbHeight = height;  
        double thumbRatio = (double) thumbWidth / (double) thumbHeight;  
        int imageWidth = image.getWidth(null);  
        int imageHeight = image.getHeight(null);  
        double imageRatio = (double) imageWidth / (double) imageHeight;  
        if (thumbRatio < imageRatio) {  
            thumbHeight = (int) (thumbWidth / imageRatio);  
        } else {  
            thumbWidth = (int) (thumbHeight * imageRatio);  
        }  
        thumbImage = new BufferedImage(thumbWidth, thumbHeight,  
                BufferedImage.TYPE_INT_RGB);  
        Graphics2D graphics2D = thumbImage.createGraphics();  
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION,  
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);  
        graphics2D.drawImage(image, 0, 0, thumbWidth, thumbHeight, null);  
        out = new BufferedOutputStream(new FileOutputStream(outfile));  
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);  
        JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(thumbImage);  
        quality = Math.max(0, Math.min(quality, 100));  
        param.setQuality((float) quality / 100.0f, false);  
        encoder.setJPEGEncodeParam(param);  
        encoder.encode(thumbImage);  
        out.close();  
        thumbImage = null;  
        out = null;  
        image = null;  
    }  
	
//	public static void cut(String srcFile){
//		try {
//			FileInputStream fis = new FileInputStream(srcFile);
//			byte[] bs = new byte[1024];
//			int total = 0;
//			//用来拼接变量名字的变量
//			int count=0;
//			
//			while((total=fis.read(bs))!=-1){
//				//每次读取到1k的数据的数据就重新new一个输出流  输出到新文件
//				FileOutputStream fos = new FileOutputStream("image" + (++count) +".jpg");
//				fos.write(bs,0,total);
//				fos.close();
//				
//			}
//			fis.close();
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//	}
//	
//	/**
//     * 本地获取
//     * */
//    @Test
//    public void testImg2() throws IOException{
//           File picture = new File("C:/Users/Administrator/Pictures/ecommeration/03a290bb867948cb.jpg");
//           BufferedImage sourceImg =ImageIO.read(new FileInputStream(picture)); 
//           System.out.println(String.format("%.1f",picture.length()/1024.0));// 源图大小
//           System.out.println(sourceImg.getWidth()); // 源图宽度
//           System.out.println(sourceImg.getHeight()); // 源图高度
//
//    }
}
