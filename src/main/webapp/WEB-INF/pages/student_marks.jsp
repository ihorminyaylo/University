<%--
  Created by IntelliJ IDEA.
  User: iminiatc
  Date: 04.08.2017
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<head>
    <title>Marks of student ${student.firstName} ${student.lastName}</title>
    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/jquery/external/jquery/jquery.js"/>"></script>
    <script src="<c:url value="/resources/jquery/jquery-ui.min.js"/>"></script>
</head>
<body>
<jsp:include page="menu.jsp"/>
<div class="container">
    <c:choose>
        <c:when test="${empty markList}">
            <h1>We don't have marks of ${student.firstName} ${student.lastName}.</h1>
        </c:when>
        <c:otherwise>
            <h2>Marks of ${student.firstName} ${student.lastName}</h2>
        <div class="form-group <c:if test="${hasAllLesson == 0}">has-error</c:if>">
            <c:if test="${hasAllLesson == 0}">
                <p class="help-block">The student has all scores of all lessons</p>
            </c:if>
        </div>
            <table class="table table-condensed">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Date</th>
                    <th>Subject name</th>
                    <th>Score</th>
                    <th class="col-md-1"></th>
                    <th class="col-md-1"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${markList}" var="mark" varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>${mark.lesson.date}</td>
                        <td>${mark.lesson.subject.subjectName}</td>
                        <td>${mark.score}</td>
                        <td>
                            <a type="button" href="/marks/edit_score?id=${st.id}" class="btn btn-primary btn-md">Edit Score</a>
                        </td>
                        <td>
                            <script>
                                function deleteM(s) {
                                    var r = confirm(s);
                                    return r;
                                }
                            </script>
                            <form action="/marks/delete_mark?idMark=${mark.idMark}" method="post">
                                <input type="hidden" id="id" value="${student.id}" name="id">
                                <input type="submit" value="Delete mark" class="btn btn-danger btn-md" onclick="return deleteM('Are you sure you want to remove this mark?')">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
    <p><a type="button" href="/marks/add_mark?id=${student.id}" class="btn btn-primary btn-lg" cem>Add mark for ${student.firstName} ${student.lastName}</a></p>
</div>
</body>
</html>
