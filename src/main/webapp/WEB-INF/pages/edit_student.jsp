<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<head>
    <title>Edit student</title>
    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
</head>
<body>
<jsp:include page="menu.jsp"/>
<form class="form-horizontal" action="/edit_student" method="POST">
    <div class="container">
    <div class="col-md-12">
        <h1>Edit information about ${student.firstName} ${student.lastName}</h1>
    </div>
    </div>
    <input type="hidden" id="id" value="${student.id}" name="id">
    <div class="form-group <c:if test="${validation == 0}">has-error</c:if>">
        <label for="firstName" class="col-sm-2 control-label" for="firstName">First name</label>
        <div class="col-sm-5">
            <input type="text" class="form-control" id="firstName" placeholder="Enter first name" name="newFirstName" value="${student.firstName}">
            <c:if test="${validation == 0}">
                <p class="help-block">The first name isn't correct</p>
            </c:if>
        </div>
    </div>
    <div class="form-group <c:if test="${validation == 0}">has-error</c:if>">
        <label class="control-label col-sm-2 col-md-2" for="lastName">Last name</label>
        <div class="col-sm-5">
            <input type="text" class="form-control" id="lastName" placeholder="Enter last name" name="newLastName" value="${student.lastName}">
            <c:if test="${validation == 0}">
                <p class="help-block">The last name isn't correct</p>
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
