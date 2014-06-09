<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/tags/InsuranceTags.tld" prefix="mytag"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<fmt:requestEncoding value="utf-8" />
<%@include file="../WEB-INF/jspf/formatter.jspf"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message bundle="${loc}" key="adminTitle" /></title>
</head>
<body>
<c:set var="page" value="admin" scope="page"></c:set>
	<%@include file="../WEB-INF/jspf/encodingheader.jspf"%>
	<%@include file="../WEB-INF/jspf/header.jspf"%>

	<c:forEach var="comp" items="${login.companies}">
	<mytag:i18n intvalue="${comp.id}" key="adminCompany"/>
	<fmt:message bundle="${loc}" key="${key }" />:
	<br>
	<fmt:message bundle="${loc}" key="adminSearch" />
		<form action="search" method="GET">
		<input type="hidden" name="idcompany" value="${comp.id}">
		<input name="idinsurance" class="span4" id="fioIcon" type="text" placeholder="<fmt:message bundle="${loc}" key="adminExample" />">
		<button type="submit" class="btn btn-danger span3"><fmt:message bundle="${loc}" key="adminFind" /></button>
			<fmt:message bundle="${loc}" key="adminFind" />
			</form>
		<br>
	</c:forEach>
	<br>


	<%@include file="../WEB-INF/jspf/low.jspf"%>
</body>
</html>