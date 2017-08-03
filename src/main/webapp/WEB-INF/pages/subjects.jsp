<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<head>
    <title>Subjects</title>
    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
</head>
<body>
<jsp:include page="menu.jsp"/>
<div class="container">
    <c:choose>
        <c:when test="${empty subjects}">
            <h1>We don't have subjects.</h1>
        </c:when>
        <c:otherwise>
            <h2>Subjects</h2>
            <table class="table table-condensed">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Subject name</th>
                    <th class="col-md-1"></th>
                    <th class="col-md-1"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${subjects}" var="subject" varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>${subject.subjectName}</td>
                        <td>
                            <a type="button" href="/edit_subject?id=${subject.idSubject}" class="btn btn-primary btn-md">Edit</a>
                        </td>
                        <td>
                            <form action="/delete_subject?id=${subject.idSubject}" method="post">
                                <input type="submit" value="Delete" class="btn btn-danger btn-md">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
    <p><a type="button" href="/add_subject" class="btn btn-primary btn-lg" cem>Add subject</a></p>
</div>
</body>
</html>
