<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/tags/InsuranceTags.tld" prefix="mytag"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<fmt:requestEncoding value="utf-8" />
<br>
<br>
<%@include file="../WEB-INF/jspf/formatter.jspf"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message bundle="${loc}" key="adminTitle" /></title>
</head>
<body>
<c:set var="page" value="admin" scope="page"></c:set>
<div class="container">
	<%@include file="../WEB-INF/jspf/header.jspf"%>
	<c:choose>
	<c:when test="${not empty searchinsurance }">
	<c:out value="${searchinsurance.idinsurance }"/><br>
	<c:out value="${searchinsurance.fio }"/><br>
	<c:out value="${searchinsurance.price }"/><br>
	</c:when>
	<c:otherwise>
	<fmt:message bundle="${loc}" key="resultNothing" />
	</c:otherwise>
	</c:choose>
	
	<a href="admin"><fmt:message bundle="${loc}" key="resultBack" /></a>
	<%@include file="../WEB-INF/jspf/low.jspf"%>
</body>
</html>