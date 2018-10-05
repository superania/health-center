<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 31.07.2018
  Time: 02:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Doctors</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">

</head>
<body>
<jsp:include page="menu.jsp"/>
<br>
<b>Doctor options:</b><br><br>
<a href="${pageContext.servletContext.contextPath}/doctors">
    <button>Show all doctors</button>
</a><br><br>
<a href="${pageContext.servletContext.contextPath}/findBySpecialization"><button>Find by specialization</button></a><br><br>
<a href="${pageContext.servletContext.contextPath}/findDoctorByNameAndSurname"><button>Find by name and surname</button></a><br><br>
<a href="${pageContext.servletContext.contextPath}/createDoctorAccount"><button>Add new doctor</button></a><br>
</body>
</html>
