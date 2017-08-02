<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<head>
    <title>Lessons</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
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
                    <th>ACTION</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${lessonList}" var="lesson"  varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>${lesson.date}</td>
                        <td>${lesson.subject.subjectName}</td>
                        <td>
                            <div class="row">
                                <div class="col-md-2">
                                    <a type="button" href="/edit_lesson?id=${lesson.idLesson}" class="btn btn-primary btn-md">Edit</a>
                                </div>
                                <div class="col-md-2">
                                    <form action="delete_lesson?id=${lesson.idLesson}" method="post">
                                        <input type="submit" value="Delete" class="btn btn-primary btn-md">
                                    </form>
                                </div>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
