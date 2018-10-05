<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 25.08.2018
  Time: 00:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Offices</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">

</head>
<body>
<jsp:include page="menu.jsp"/>
<br>
<a href="${pageContext.servletContext.contextPath}/showAllOffices" ><button>Show all offices</button></a>
<br><br>
<a href="${pageContext.servletContext.contextPath}/addNewOffice" ><button>Add new office</button></a>
<br><br>
<a href="${pageContext.servletContext.contextPath}/showOfficesPlan" ><button>Show schedules for all offices</button></a>
<br><br>
<a href="${pageContext.servletContext.contextPath}/showGivenOfficesPlan" ><button>Show schedules for given office</button></a>
<br><br>
</body>
</html>
