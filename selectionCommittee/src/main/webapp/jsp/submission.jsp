<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Periodicals</title>
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

				<table class="table table-striped">
					<thead>
						<tr>
							<th>Id</th>
							<th><spring:message code="reg.name"/></th>
							<th><spring:message code="reg.faculty_name"/></th>
							<th><spring:message code="submission.image"/></th>
							<th><spring:message code="submission.grades"/></th>
							<th><spring:message code="submission.date"/></th>
							<th><spring:message code="submission.accepted"/></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="submission" items="${submissionItems}">
							<tr>
								<td>${submission.id}</td>
								<td>${submission.applicant.name}</td>
								<td>${submission.applicant.facultyName}</td>
								<td><img
									src="data:image/jpg;base64,${submission.applicant.encodedImage}"
									alt="image" style="width: 10%"></td>
								<td>${submission.applicant.allGrades}</td>
								<td>${submission.date}</td>
								<td>${submission.accepted}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>


			</div>

		</div>


	</div>
</body>
</html>
