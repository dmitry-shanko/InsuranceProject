<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/tags/InsuranceTags.tld" prefix="mytag"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<%@include file="../WEB-INF/jspf/formatter.jspf"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title><fmt:message bundle="${loc}" key="endTitle" />!</title>

</head>
<body>
	<c:set var="page" value="end" scope="page"></c:set>
	<c:set var="inscalc" value="${insurancecalcutalor }" scope="page" />
	<%@include file="../WEB-INF/jspf/encodingheader.jspf"%>

	<%@include file="../WEB-INF/jspf/mainpageheader.jspf"%>

	<%@include file="../WEB-INF/jspf/imageheader.jspf"%>

	<div class="container">
		<div>
			<legend class="info">
				<marge>
				<fmt:message bundle="${loc}" key="endMessage" /> "<fmt:message
					bundle="${loc}" key="endConfirm" />"</marge>
			</legend>
		</div>
		<table class="table table-striped table-bordered table-hover ">
			<thead>
				<tr class="info">

					<th><fmt:message bundle="${loc}" key="endInsuranceidnumber" /></th>
					<th><fmt:message bundle="${loc}" key="pageCompanyname" /></th>

				</tr>
			</thead>
			<tbody>
				<tr>
					<td align="center"><strong><h2>
								<c:out value="${idinsurance }"></c:out>
							</h2></strong></td>
					<td><h3>
							<mytag:i18n intvalue="${idcompany}" key="adminCompany" />
							<fmt:message bundle="${loc}" key="${key }" />
							:
						</h3></td>

				</tr>
			</tbody>
		</table>
		<br>

		<div align="right">
			<a class="btn btn-info btn-large" href="addwrite"><fmt:message
					bundle="${loc}" key="endConfirm" /></a>
		</div>
	</div>

	<%@include file="../WEB-INF/jspf/low.jspf"%>
</body>
</html>