package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FileDownController {
	//得到一个用来记录日志的对象，在打印时标记打印的是哪个类的信息
	private static final Log logger = LogFactory.getLog(FileDownController.class);
	
	//文件下载(图片展示）
	@RequestMapping("file/download.do")
	public ResponseEntity<byte[]> filedownload(String fileName) throws IOException {
		String path = "C:/Users/Administrator/Downloads/"+fileName;
		
		File file = new File(path);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
	}
	
	/**
	 * 显示要下载的文件
	 */
	@RequestMapping("showDownFiles")
	public String show(HttpServletRequest request,Model model){
		String realpath = null;
		realpath = "C:/Users/Administrator/Downloads";
		File dir = new File(realpath);
		File files[] = dir.listFiles();
		//获取该目录下的所有文件名
		ArrayList<String> fileName = new ArrayList<String>();
		for(int i=0;i < files.length;i++){
			fileName.add(files[i].getName());
			
		}
		model.addAttribute("files",fileName);
		return "showDownFiles";
	}
	
	//文件下载
	@RequestMapping("download.do")
	public ResponseEntity<byte[]> download(String fileName) throws IOException {
		String path = "C:/Users/Administrator/Downloads"+fileName;
//			System.out.println("------------>哈哈哈哈哈");
		File file = new File(path);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
	}
		
	/**
	 * 执行下载
	 */
	@RequestMapping("down")
	public String down(@RequestParam String filename,HttpServletRequest request,HttpServletResponse response){
		String aFilePath = null; //要下载的文件路径
		FileInputStream in = null; //输入流
		ServletOutputStream out = null; //输出流
		
		try {
			aFilePath = "C:/Users/Administrator/Downloads";
			//设置下载文件使用的报头
			response.setHeader("Content-Type", "application/x-msdownload");
			response.setHeader("Content-Disposition", "attachment;filename="+toUTF8String(filename));
			
			//读入文件
			in = new FileInputStream(aFilePath + "\\" +filename);
			//得到响应对象的输出流，用于向客户端输出二进制数据
			out = response.getOutputStream();
			out.flush();
			int aRead = 0;
			byte b[] = new byte[1024];
			while((aRead = in.read(b))!=-1 & in!=null){
				out.write(b,0,aRead);
			}
			out.flush();
			in.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("下载成功");
		return null;
	}
	/**
	 * 下载保存时中文文件名的字符编码转换方法
	 * @param str
	 * @return
	 */
	public String toUTF8String(String str){
		StringBuffer sb = new StringBuffer();
		int len = str.length();
		for(int i=0; i < len; i++){
			//取出字符中的每个字符
			char c = str.charAt(i);
			//Unicode码值为0~255时，不做处理
			if(c>=0 && c<=255){
				sb.append(c);
			}else{
				//转换UTF-8编码
				byte b[];
				try {
					b = Character.toString(c).getBytes("UTF-8");
					
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
					b = null;
					
				}
				//转换为%HH的字符串形式
				for(int j=0; j < b.length; j++){
					int k = b[j];
					if(k<0){
						k&=255;
					}
					sb.append("%" + Integer.toHexString(k).toUpperCase());
				}
			}
		}
		return sb.toString();
	}
	
}
