<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>first</title>
</head>
<body>
	<a href="${pageContext.request.contextPath }/il8nTest?locale=zh_CN">
	<spring:message code="language.cn"/>
	</a>--
	<a href="${pageContext.request.contextPath }/il8nTest?locale=en_US">
	<spring:message code="language.en"/>
	</a>
	<br><br>
	<spring:message code="first"/><br><br>
	<a href="${pageContext.request.contextPath }/my/second">
	<spring:message code="second"/>
	</a>
	
</body>
</html>