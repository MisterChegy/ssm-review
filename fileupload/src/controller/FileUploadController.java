package controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import pojo.FileDomain;
import pojo.MultiFileDomain;
@Controller
public class FileUploadController {

	//得到一个用来记录日志的对象，这样在打印信息时能够标记打印的是哪个类的信息
	private static final Log logger = LogFactory.getLog(FileUploadController.class);
	
	/**
	 * 单文件上传
	 * @param fileDomain
	 * @param request
	 * @return
	 */
	@RequestMapping("/onefile")
	public String oneFileUpload(@ModelAttribute FileDomain fileDomain,
			HttpServletRequest request){
		
		String realpath = request.getServletContext().getRealPath("uploadfiles");
		logger.info(realpath);
		String fileName = fileDomain.getMyfile().getOriginalFilename();
		File targetFile = new File("C:/Users/Administrator/Downloads",fileName);
		if(!targetFile.exists()){
			targetFile.mkdirs();
		}
		
		//上传
		try{
			fileDomain.getMyfile().transferTo(targetFile);
			logger.info("成功");
		}catch(Exception e){
			e.printStackTrace();
		}
		return "showOne";
	}
	/**
	 * 多文件上传
	 */
	@RequestMapping("/multifile")
	public String multiFileUpload(@ModelAttribute MultiFileDomain multiFileDomain,HttpServletRequest request){
		String realpath = null;
		realpath="C:/Users/Administrator/Downloads";
		File targetDir = new File(realpath);
		if(!targetDir.exists()){
			targetDir.mkdirs();
		}
		List<MultipartFile> files = multiFileDomain.getMyfile();
		for(int i=0; i < files.size();i++){
			MultipartFile file = files.get(i);
			String fileName = file.getOriginalFilename();
			File targetFile = new File(realpath,fileName);
			//上传
			try{
				file.transferTo(targetFile);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		logger.info("成功");
		return "showMulti";
	}
}
