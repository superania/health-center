<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 04.08.2018
  Time: 01:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Schedule</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">

</head>
<body>
<jsp:include page="menu.jsp"/>
<br>
<a href="${pageContext.servletContext.contextPath}/findScheduleByDate"><button>Find by date</button></a>
<a href="${pageContext.servletContext.contextPath}/showSchedule"><button>Show all</button></a>
<a href="${pageContext.servletContext.contextPath}/addSchedule"><button>Add</button></a>
<a href="${pageContext.servletContext.contextPath}/showFreeOffices"><button>Show available offices</button></a>
</body>
</html>
