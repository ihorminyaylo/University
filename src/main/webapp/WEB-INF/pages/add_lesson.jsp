<%--
  Created by IntelliJ IDEA.
  User: AsusIT
  Date: 02.08.2017
  Time: 23:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<head>
    <title>Add lesson</title>
    <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/jquery/jquery-ui.min.css"/>" rel="stylesheet" >
    <script src="<c:url value="/resources/jquery/external/jquery/jquery.js"/>"></script>
    <script src="<c:url value="/resources/jquery/jquery-ui.min.js"/>"></script>
    <script>
        $( function() {
        $( "#date" ).datepicker();
        } );
    </script>
</head>
<body>
<jsp:include page="menu.jsp"/>
<form class="form-horizontal" action="/add_lesson" method="POST">
    <div class="container">
        <div class="col-md-12">
            <h1>Add lesson</h1>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-4">
                <label for="subjectName">Subject name</label>
                <select class="form-control col-md-6" id="subjectName" name="newIdSubject">
                    <c:forEach items="${subjectList}" var="subject">
                        <option value="${subject.idSubject}" name="newIdSubject" id="newIdSubject">${subject.subjectName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group <c:if test="${validation == 0}">has-error</c:if>">
            <div class="col-md-8">
                <label for="date">Enter Date:</label><br>
                <input type="text" id="date" placeholder="SELECT DATE" name="newDate">
                <c:if test="${validation == 0}">
                    <p class="help-block">The date isn't correct</p>
                </c:if>
            </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-success">OK</button>
            </div>
        </div>
    </div>
</form>
</body>
</html>
