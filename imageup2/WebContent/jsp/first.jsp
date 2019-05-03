<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<title>first.jsp</title>

<style type="text/css">
	p img{border-style:solid;
    border-width:4px;
    }
	
	
</style>
<script type="text/javascript">
	/**
	$(function(){
		$(".thumbs a").click(function(){
			var largePath = $(this).attr("href");
			var largeAlt = $(this).attr("title");
			$("largeImg").attr({
				src : largePath,
				alt : largeAlt
			})
		});
		return false;
	});
	*/
	//使用js实现文件上传图片的预览
	/* function showPreview(obj){
		var str = obj.value;
		document.getElementById("previewImg").innerHTML = 
			"'<img src = '" + str + "'/>";
	} */
</script>
</head>
<body>
	<!-- <form action="">
		请选择图片：<input id="myfile" name="myfile" type="file" onchange="showPreview(this)"/>
		<dir id="perviewImg"></dir>
	</form> -->
	
	<!-- <img id="previewImg" src="images/images.jpg" width="80" height="80"/> -->
	<form action="/imageup/uploadServlet.do" method="post" enctype="multipart/form-data">
		请选择图片：<input id="myfile" name="myfile" type="file" onchange="showPreview(this)"/>
		<input type="submit" value="提交">${result }
	</form>
	
	<%-- 下载：<a href="/imageup/downloadServlet.do?filename=test.txt">test.txt</a>
	&nbsp;&nbsp;${errorResult } --%>
	原图：
	<p>
		<img alt="原图" src="/imageup/downloadServlet.do?filename=${filename }"/>	
	</p>
	
	等比例缩放图片：
	<p class="cutImage">
		<img alt="等比例缩放图片" src="/imageup/scaleImgServlet.do?filename=${filename }">
	</p>
	
	将原图切割四等分图片：
	<p class="cutImage">
		<%-- <img alt="将原图切割四等分图片" src="/imageup/downloadServlet.do?filename=part_1${filename }">
		<img alt="将原图切割四等分图片" src="/imageup/downloadServlet.do?filename=part_2${filename }">
		<img alt="将原图切割四等分图片" src="/imageup/downloadServlet.do?filename=part_3${filename }">
		<img alt="将原图切割四等分图片" src="/imageup/downloadServlet.do?filename=part_4${filename }">
	 --%>
	 	<c:forEach var="i" begin="1" end="4">
		   <img alt="将原图切割四等分图片" src="/imageup/downloadServlet.do?filename=part_${i }${filename }">
		</c:forEach>
	</p>
	
	<!-- <h2>图片预览</h2>
	<p>
		<img id="largeImg" src="images/images.jpg" alt="large Image"/>
	</p>
	<p class="thumbs">
		<a href="images/img0.jpg" title="Image0"><img src="images/img0.jpg"></a>
		<a href="images/img1.jpg" title="Image1"><img src="images/img1.jpg"></a>
		<a href="images/img2.jpg" title="Image2"><img src="images/img2.jpg"></a>
		<a href="images/img3.jpg" title="Image3"><img src="images/img3.jpg"></a>
		<a href="images/img4.jpg" title="Image4"><img src="images/img4.jpg"></a>
	</p> -->
</body>
</html>