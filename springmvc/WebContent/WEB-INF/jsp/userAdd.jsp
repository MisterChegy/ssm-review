<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>userAdd</title>
</head>
<body>
	<form:form modelAttribute="user" method="post" action="${pageContext.request.contextPath }/user/save">
		
		<fieldest>
			<legend>添加一个用户</legend>
			<p>
				<label>用户名:</label>
				<form:input path="userName"/>
			</p>
			<p>
				<label>爱好</label>
				<form:checkboxes items="${hobbys }" path="hobby" />
			</p>
			<p>
				<lable>朋友</lable>
				<form:checkbox path="friends" value="张三"/>张三
				<form:checkbox path="friends" value="李四"/>李四
				<form:checkbox path="friends" value="王五"/>王五
				<form:checkbox path="friends" value="赵柳"/>赵柳
				
			</p>
			<p>
				<lable>职业</lable>
				<form:select path="carrer">
					<option/>请选择职业
					<form:options items="${carrers }"/>
				</form:select>
			</p>
			<p>
				<lable>户籍</lable>
				<form:select path="houseRegister">
					<option/>请选择户籍
					<form:options items="${houseRegisters }"/>
				</form:select>
			</p>
			<p>
				<lable>个人描述</lable>
				<form:textarea path="remark" rows="5"/>
			</p>
			<p id="buttons">
				<input id="reset" type="reset">
				<input id="submit" type="submit" value="添加">
			</p>
		</fieldest>
		
	</form:form>
</body>
</html>