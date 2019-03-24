<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品</title>
</head>
<body>
	<form:form modelAttribute="goods" action="${pageContext.request.contextPath }/goods/save" method="post">
		<fieldset>
			<legend>添加一件商品</legend>
			<p>
				<label>商品名：</label>
				<form:input path="gname"/>
			</p>
			<p>
				<label>商品详情：</label>
				<form:input path="gdescription"/>
			</p>
			<p>
				<label>商品价格：</label>
				<form:input path="gprice"/>
			</p>
			<p>
				<label>创建日期：</label>
				<form:input path="gdate"/>(yyyy-MM-dd)
			</p>
			<p id="buttons">
				<input id="reset" type="reset">
				<input id="submit" type="submit" value="添加">
			</p>
		</fieldset>
		<!-- 取出所有验证错误 -->
		<form:errors path="*"/>
	</form:form>

</body>
</html>