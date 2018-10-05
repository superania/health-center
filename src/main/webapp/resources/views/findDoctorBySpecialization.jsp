<%@ page import="healthCenter.entity.Specialization" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 03.08.2018
  Time: 02:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find doctor by specialization</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">

</head>
<body>
<jsp:include page="menu.jsp"/>
<br>
Enter specialization name:
<form:form action="findBySpecialization" modelAttribute="specialization" method="post">
    <form:select multiple="true" path="name">
        <% List<Specialization> specializations = (List<Specialization>) request.getAttribute("specializations");
            for (Specialization specialization : specializations) {%>
            <form:option value="<%=specialization.getName()%>">
                <%=specialization.getName()%>
            </form:option>
        <%}%>
    </form:select>
    <input type="submit" value="Find">
</form:form>
<br>
<a href="${pageContext.servletContext.contextPath}/doctorOptions"><button>Back</button></a>
</body>
</html>
