<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Periodicals</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<body>
	<div class="container">

		<!-- Sidebar -->
		<div class="w3-sidebar w3-light-grey w3-bar-block" style="width: 10%">
			<h3 class="w3-bar-item">Menu</h3>
			<a href="/home" class="w3-bar-item w3-button">Home</a> <a
				href="/register-applicant" class="w3-bar-item w3-button">Register
				an applicant</a> <a href="/submissions" class="w3-bar-item w3-button">Submission</a>
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

				<table class="table table-striped">
					<thead>
						<tr>
							<th>Id</th>
							<th>Name</th>
							<th>Faculty Name</th>
							<th>Image</th>
							<th>All Grades</th>
							<th>Date</th>
							<th>Accepted</th>
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
