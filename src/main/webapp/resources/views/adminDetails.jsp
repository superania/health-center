<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 30.07.2018
  Time: 02:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin details</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">

</head>
<body>
<jsp:include page="menu.jsp"/>
<br>
<b>ADMIN PERSONAL DETAILS</b><br><br>
<b>Name:</b><br>
${admin.name}<br>
<b>Surname:</b><br>
${admin.surname}<br>
<b>Date of birth:</b><br>
${admin.dateOfBirth}<br>
<b>Id number:</b><br>
${admin.idNumber}<br>
<b>Address:</b><br>
${admin.address.country} ${admin.address.city} ${admin.address.street}<br>
<br>
<a href="${pageContext.servletContext.contextPath}/changeAdminDetails"><button>Change details</button></a>
</body>
</html>
