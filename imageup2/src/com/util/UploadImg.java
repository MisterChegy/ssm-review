package com.util;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
 
import javax.imageio.ImageIO;
public class UploadImg {
	String fromFileStr;
	String saveToFileStr;
	String sysimgfile;
	int width;
	int height;
	String suffix;
	/**
	 * @param fromFileStr
	 *            原始图片完整路径
	 * @param saveToFileStr
	 *            缩略图片保存路径
	 * @param sysimgfilenNow
	 *            处理后的图片文件名前缀
	 * 
	 */
	public UploadImg(String fromFileStr, String saveToFileStr,String sysimgfile, String suffix,int width,int height) {
		this.fromFileStr = fromFileStr;
		this.saveToFileStr = saveToFileStr;
		this.sysimgfile = sysimgfile;
		this.width=width;
		this.height=height;
		this.suffix=suffix;
	}
	public boolean createThumbnail() throws Exception {
		// fileExtNmae是图片的格式 gif JPG 或png
		// String fileExtNmae="";
		File F = new File(fromFileStr);
		if (!F.isFile())
			throw new Exception(F
					+ " is not image file error in CreateThumbnail!");
		//File ThF = new File(saveToFileStr, sysimgfile +"."+suffix);
		BufferedImage buffer = ImageIO.read(F);
		/*
		 * 核心算法，计算图片的压缩比
		 */
		int w= buffer.getWidth();
		int h=buffer.getHeight();
		double ratiox = 1.0d;
		double ratioy = 1.0d;
		
		ratiox= w * ratiox / width;
		ratioy= h * ratioy / height;
		
		if( ratiox >= 1){
			if(ratioy < 1){
				ratiox = height * 1.0 / h;
			}else{
				if(ratiox > ratioy){
					ratiox = height * 1.0 / h;
				}else{
					ratiox = width * 1.0 / w;
				}
			}
		}else{
			if(ratioy < 1){
				if(ratiox > ratioy){
					ratiox = height * 1.0 / h;
				}else{
					ratiox = width * 1.0 / w;
				}
			}else{
				ratiox = width * 1.0 / w;
			}
		}
		/*
		 * 对于图片的放大或缩小倍数计算完成，ratiox大于1，则表示放大，否则表示缩小
		 */
		AffineTransformOp op = new AffineTransformOp(AffineTransform
				.getScaleInstance(ratiox, ratiox), null);
		buffer = op.filter(buffer, null);
		//从放大的图像中心截图
		
		try {
			//buffer = buffer.getSubimage((buffer.getWidth()-width)/2, (buffer.getHeight() - height) / 2, width, height);
			width = buffer.getWidth()/2;
			height = buffer.getHeight()/2;
			
			int x=0,y=0;
			
			BufferedImage buffer1 = buffer.getSubimage(x, y, width, height);
			File ThF1 = new File(saveToFileStr, "part_1"+ sysimgfile );
			
			x = width;
			BufferedImage buffer2 = buffer.getSubimage(x, y, width, height);
			File ThF2 = new File(saveToFileStr, "part_2"+ sysimgfile );
			
			x = 0;
			y = height;
			BufferedImage buffer3 = buffer.getSubimage(x, y, width, height);
			File ThF3 = new File(saveToFileStr, "part_3"+ sysimgfile );
			
			x = width;
			y = height;
			BufferedImage buffer4 = buffer.getSubimage(x, y, width, height);
			File ThF4 = new File(saveToFileStr, "part_4"+ sysimgfile );
			
			ImageIO.write(buffer1, suffix, ThF1);
			ImageIO.write(buffer2, suffix, ThF2);
			ImageIO.write(buffer3, suffix, ThF3);
			ImageIO.write(buffer4, suffix, ThF4);
			
		} catch (Exception ex) {
			throw new Exception(" ImageIo.write error in CreatThum.: "
					+ ex.getMessage());
		}
		return (true);
	}
	
	
//	public static void main(String[] args) {
//		UploadImg UI;
//		boolean ss = false;
//		try {
//			UI = new UploadImg("images.jpg", "C:/Users/Administrator/Pictures/ecommeration","sdf", "jpg",200,100);
//			ss = UI.createThumbnail();
//			if (ss) {
//				System.out.println("Success");
//			} else {
//				System.out.println("Error");
//			}
//		} catch (Exception e) {
//			System.out.print(e.toString());
//		}
//	}
}

