<%--
  Created by IntelliJ IDEA.
  User: iminiatc
  Date: 01.08.2017
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<head>
    <title>Edit subject</title>
    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
</head>
<body>
<jsp:include page="menu.jsp"/>
<form class="form-horizontal" action="/edit_subject" method="POST">
    <div class="container">
        <div class="col-md-12">
            <h1>Edit subject name for ${subject.subjectName}</h1>
        </div>
    </div>
    <input type="hidden" id="id" value="${subject.idSubject}" name="id">
    <div class="form-group <c:if test="${validation == 0}">has-error</c:if>">
        <label class="control-label col-sm-2" for="subjectName">Subject name</label>
        <div class="col-sm-5">
            <input type="text" class="form-control" id="subjectName" placeholder="Enter subject name" name="newSubjectName" value="${subject.subjectName}">
            <c:if test="${validation == 0}">
                <p class="help-block">The subject name isn't correct</p>
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
