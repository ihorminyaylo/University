<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<head>
    <title>Marks</title>
    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
</head>
<body>
<jsp:include page="menu.jsp"/>
<div class="container">
    <c:choose>
        <c:when test="${empty markList}">
            We don't have marks.
        </c:when>
        <c:otherwise>
            <h2>Marks</h2>
            <table class="table table-condensed">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Subject name</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${markList}" var="mark">
                    <tr>
                        <td>1</td>
                        <td>${mark.subjectName}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
