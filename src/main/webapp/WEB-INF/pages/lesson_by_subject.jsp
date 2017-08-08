<%--
  Created by IntelliJ IDEA.
  User: iminiatc
  Date: 08.08.2017
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<head>
    <title>All lesson of ${subject.subjectName}</title>
    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/jquery/external/jquery/jquery.js"/>"></script>
    <script src="<c:url value="/resources/jquery/jquery-ui.min.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
</head>
<body>
<jsp:include page="menu.jsp"/>
<div class="container">
<h2>All lesson of ${subject.subjectName}</h2>
<table class="table table-condensed">
    <thead>
    <tr>
        <th>#</th>
        <th>Date</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${lessonList}" var="lesson" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${lesson.date}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
    <a href="/subjects" type="button" name="cancel" class="btn btn-default">Back</a>
</div>
</body>
</html>
