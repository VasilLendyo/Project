<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	<div class="container">

		<!-- Sidebar -->
		<div class="w3-sidebar w3-light-grey w3-bar-block" style="width: 10%">
			<h3 class="w3-bar-item">Menu</h3>
			<a href="/home" class="w3-bar-item w3-button">Home</a> <a
				href="/register-applicant" class="w3-bar-item w3-button">Register
				an applicant</a> <a href="#" class="w3-bar-item w3-button">Submission</a>
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
				
				<c:if test="${not empty applicants}">
					<c:forEach items="${applicants}" var="currentApplicant">

						<div class="w3-card-4" style="width: 20%; margin: 2%">
							<img
								src="https://kaverisias.com/wp-content/uploads/2018/01/catalog-default-img.gif"
								alt="Norway" style="width: 100%">
							<div class="w3-container w3-center">
								<h3>${currentApplicant.name}</h3>
								<p>${currentApplicant.facultyName}</p>
								<p>${currentApplicant.averageGrade}</p>
							</div>
							<button class="w3-button w3-block w3-dark-grey">+ add to
								submission</button>
						</div>

					</c:forEach>
				</c:if>
			</div>
		</div>
	</div>
	<!-- /container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>