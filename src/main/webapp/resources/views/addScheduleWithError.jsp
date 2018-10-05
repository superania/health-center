<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 04.08.2018
  Time: 02:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add schedule</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">

</head>
<body>
<jsp:include page="addSchedule.jsp"/>
<span style="color: red; ">Time from must be before time to </span>
</body>
</html>
