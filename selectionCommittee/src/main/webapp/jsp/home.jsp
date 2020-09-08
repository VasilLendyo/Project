<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>Applicants</title>

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script type="text/javascript">
	$(document).ready(function() {
		var selItem = localStorage.getItem("locales");
		$('#locales').val(selItem ? selItem : 'en');
		$("#locales").change(function() {
			var selectedOption = $('#locales').val();
			if (selectedOption) {
				window.location.replace('?lang=' + selectedOption);
				localStorage.setItem("locales", selectedOption);
			}
		});
	});
</script>
</head>
<body>
	<div class="container">

		<!-- Sidebar -->
		<div class="w3-sidebar w3-light-grey w3-bar-block" style="width: 10%">
			<h3 class="w3-bar-item"><spring:message code="home.menu"/></h3>

			<a href="/home" class="w3-bar-item w3-button"><spring:message code="home.home"/></a>
			
			<security:authorize access="hasRole('ROLE_USER')">
			<a href="/register-applicant" class="w3-bar-item w3-button"><spring:message code="home.reg"/></a>
			</security:authorize>
				
			<security:authorize access="hasRole('ROLE_ADMIN')">	
			<a href="/submissions" class="w3-bar-item w3-button"><spring:message code="home.submission"/></a>
			</security:authorize>
		</div>

		<!-- Page Content -->
		<div style="margin-left: 10%">

			<div class="w3-container w3-teal">
				<h1><spring:message code="home.title"/></h1>
			</div>

			<div class="w3-container">
				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<form id="logoutForm" method="POST" action="${contextPath}/logout">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form>

					<h2>
						<spring:message code="home.welcome"/> ${pageContext.request.userPrincipal.name} | <a
							onclick="document.forms['logoutForm'].submit()"><spring:message code="home.logout"/></a>
					</h2>

				</c:if>
				
				<c:if test="${not empty applicants}">
					<c:forEach items="${applicants}" var="currentApplicant">

						<div class="w3-card-4" style="width: 20%; margin: 2%">
							<img
								src="data:image/jpg;base64, ${currentApplicant.encodedImage}"
								alt="Norway" style="width: 100%">
							<div class="w3-container w3-center">
								<h3>${currentApplicant.name}</h3>
								<p>${currentApplicant.facultyName}</p>
								<p>${currentApplicant.subject1}</p>
								<p>${currentApplicant.subject2}</p>
								<p>${currentApplicant.subject3}</p>
								<p><b>${currentApplicant.allGrades}</b></p>
							</div>
							
							<security:authorize access="hasRole('ROLE_ADMIN')">
							<form:form action="${contextPath}/submission" method="POST" enctype="multipart/form-data">
								<input type="hidden" value="${currentApplicant.id}"
									class="form-control" name="applicantId"> 
									<input type="submit" class="w3-button w3-block w3-dark-grey"
									value="+ <spring:message code="home.add"/>">
							</form:form>
							</security:authorize>
						</div>
					</c:forEach>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>