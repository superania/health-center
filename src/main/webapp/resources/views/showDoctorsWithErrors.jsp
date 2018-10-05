<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 23.08.2018
  Time: 01:55
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
<span style="color: red; ">You can not remove doctor ${doctor.name} ${doctor.surname} because he had patient's visits already</span><br><br>
<a href="${pageContext.servletContext.contextPath}/doctors"><button>Back to all doctor's list</button></a>

</body>
</html>
