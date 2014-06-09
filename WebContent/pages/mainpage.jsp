<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="/tags/InsuranceTags.tld" prefix="mytag"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<%@include file="../WEB-INF/jspf/formatter.jspf"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title><fmt:message bundle="${loc}" key="mainpageTitle" /></title>

</head>
<body>
<c:if test="${empty previd }">
<c:set var="previd" value="${'1'}" scope="page"/>
</c:if>
<mytag:i18n intvalue="${previd}" key="mainpage&id="/>
	<c:set var="page" value="${key}" scope="page"></c:set>
	<%@include file="../WEB-INF/jspf/encodingheader.jspf"%>

	<%@include file="../WEB-INF/jspf/mainpageheader.jspf"%>

	<%@include file="../WEB-INF/jspf/imageheader.jspf"%>

	<c:if test="${errormassage eq 'error key' }">
	<font color="RED">
	<fmt:message bundle="${loc}" key="mainpageError" /></font>
	</c:if>
	<c:choose>
		<c:when test="${previd eq '2' }">
			<%@include file="../WEB-INF/jspf/page2content.jspf"%>
		</c:when>
		<c:when test="${previd eq '3' }">
			<%@include file="../WEB-INF/jspf/page3content.jspf"%>
		</c:when>
		<c:when test="${previd eq '4' }">
			<%@include file="../WEB-INF/jspf/page4content.jspf"%>
		</c:when>
		<c:otherwise>
			<%@include file="../WEB-INF/jspf/page1content.jspf"%>
		</c:otherwise>
	</c:choose>


	<%@include file="../WEB-INF/jspf/low.jspf"%>
</body>
</html>