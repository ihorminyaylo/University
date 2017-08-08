<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<head>
    <title>Lessons</title>
    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/jquery/external/jquery/jquery.js"/>"></script>
    <script src="<c:url value="/resources/jquery/jquery-ui.min.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
</head>
<body>
<jsp:include page="menu.jsp"/>
<div class="container">
    <c:choose>
        <c:when test="${empty lessonList}">
            We don't have lessons.
        </c:when>
        <c:otherwise>
            <h2>Lessons</h2>
            <table class="table table-condensed">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Date</th>
                    <th>Subject name</th>
                    <td class="col-md-1"></td>
                    <td class="col-md-1"></td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${lessonList}" var="lesson" varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>${lesson.date}</td>
                        <td>${lesson.subject.subjectName}</td>
                        <td>
                            <a href="/edit_lesson?id=${lesson.idLesson}" class="btn btn-primary btn-md">Edit</a>
                        </td>
                        <td>
                            <form action="/delete_lesson?id=${lesson.idLesson}" method="post">
                                <input type="submit" value="Delete" <c:if test="${lessonHasMarks.get(lesson.idLesson)}">disabled data-toggle="tooltip" title="The lesson has marks" data-placement="left"</c:if> class="btn btn-danger btn-md" onclick="return confirm('Are you sure?')">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
    <p><a type="button" href="/add_lesson" class="btn btn-primary btn-lg" cem>Add lesson</a></p>
</div>
</body>
</html>
