<%--
  Created by IntelliJ IDEA.
  User: iminiatc
  Date: 04.08.2017
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<head>
    <title>Add mark for ${student.firstName} ${student.lastName}</title>
    <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/jquery/jquery-ui.min.css"/>" rel="stylesheet" >
    <script src="<c:url value="/resources/jquery/external/jquery/jquery.js"/>"></script>
    <script src="<c:url value="/resources/jquery/jquery-ui.min.js"/>"></script>
</head>
<body>
<jsp:include page="menu.jsp"/>
<form class="form-horizontal" action="/marks/add_mark" method="POST">
    <div class="container">
        <div class="col-md-12">
            <h1>Add mark for student ${student.firstName} ${student.lastName}</h1>
        </div>
    </div>
    <input type="hidden" id="id" value="${student.id}" name="id">
    <div class="form-group">
        <label for="lessonFor" class="col-sm-2 control-label">Subject name</label>
        <div class="col-sm-5">
            <select class="form-control" id="lessonFor" name="lesson">
                <c:forEach items="${lessonList}" var="lesson">
                    <option value="${lesson.idLesson}" name="lesson" id="lesson">Name - ${lesson.subject.subjectName}       |       Date - ${lesson.date}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="form-group <c:if test="${validation == 0}">has-error</c:if>">
        <label for="score" class="col-sm-2 control-label">Enter score:</label>
        <div class="col-sm-5">
            <input type="text" class="form-control" id="score"  placeholder="Enter score" name="score">
            <c:if test="${validation == 0}">
                <p class="help-block">The score isn't correct</p>
            </c:if>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-success">OK</button>
        </div>
    </div>
</form>
</body>
</html>
