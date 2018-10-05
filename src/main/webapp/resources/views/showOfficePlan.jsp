<%@ page import="java.util.Map" %>
<%@ page import="healthCenter.entity.Visit" %>
<%@ page import="healthCenter.entity.Office" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 05.09.2018
  Time: 03:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Office</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">

</head>
<body>
<jsp:include page="menu.jsp"/>
<br>
<b>${date.date}</b><br><br>
<% Map<Office, List<Visit>> visits = (HashMap<Office, List<Visit>>) request.getAttribute("visits");%>
<% for (Office office : visits.keySet()) { %>
<b>Office number: <%= office.getNumber()%>
</b><br>
<% if (visits.get(office).size() == 0) {%>
There are not any visits that day<br>
<%}%>
<% for (Visit visit : visits.get(office)) {%>
<%= visit.getTimeFrom()%> - <%=visit.getTimeTo()%>
<%= visit.getDoctor().getSurname()%> <%=visit.getDoctor().getName()%><br>
<%}%>
<br>
<%}%>
<a href="${pageContext.servletContext.contextPath}/officeOption" ><button>Back</button></a>

</body>
</html>
