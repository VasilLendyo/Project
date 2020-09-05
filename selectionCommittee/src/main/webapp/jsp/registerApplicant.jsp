<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Applicants</title>

<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	<div class="container">

		<!-- Sidebar -->
		<div class="w3-sidebar w3-light-grey w3-bar-block" style="width: 10%">
			<h3 class="w3-bar-item">Menu</h3>

			<a href="/home" class="w3-bar-item w3-button">Home</a>
			
			<security:authorize access="hasRole('ROLE_USER')">
			<a href="/register-applicant" class="w3-bar-item w3-button">Register
				an applicant</a>
			</security:authorize>
				
			<security:authorize access="hasRole('ROLE_ADMIN')">	
			<a href="/submissions" class="w3-bar-item w3-button">Submission</a>
			</security:authorize>
		</div>

		<!-- Page Content -->
		<div style="margin-left: 10%">

			<div class="w3-container w3-teal">
				<h1>Applicants</h1>
			</div>

			<div class="w3-container">
				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<form id="logoutForm" method="POST" action="${contextPath}/logout">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form>

					<h2>
						Welcome ${pageContext.request.userPrincipal.name} | <a
							onclick="document.forms['logoutForm'].submit()">Logout</a>
					</h2>
				</c:if>

				<form:form method="POST" action="${contextPath}/addApplicant"
					enctype="multipart/form-data">
					<table>
						<tr>
							<td>Name</td>
							<td><input type="text" name="name" /></td>
						</tr>
						<tr>
							<td>Faculty Name</td>
							<td><input type="text" name="facultyName"></td>
						</tr>
						<tr>
							<td>Subject 1</td>
							<td><input type="number" name="subject1"></td>
						</tr>
						<tr>
							<td>Subject 2</td>
							<td><input type="number" name="subject2"></td>
						</tr>
						<tr>
							<td>Subject 3</td>
							<td><input type="number" name="subject3"></td>
						</tr>
						<tr>
							<td>Select an image to upload</td>
							<td><input type="file" name="image"></td>
						</tr>
						<tr>
							<td><input type="submit" value="Submit" /></td>
						</tr>
					</table>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>