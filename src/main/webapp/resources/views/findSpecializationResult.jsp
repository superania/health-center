<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 30.07.2018
  Time: 03:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Specializations</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">

</head>
<body>
<jsp:include page="specializations.jsp"/>
<h3><span style="color: red; ">${message}</span> </h3><br>
<br>
</body>
</html>
