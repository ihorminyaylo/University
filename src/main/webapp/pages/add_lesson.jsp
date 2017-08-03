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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $( function() {
            $( "#datepicker" ).datepicker();
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
                    <option value="0">Select subject</option>
                    <c:forEach items="${subjectList}" var="subject">
                        <option value="${subject.idSubject}" name="newIdSubject" id="newIdSubject">${subject.subjectName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-md-8">
                <label for="enterDate">Enter Date:</label><br>
                <input type="text" id="datepicker" id="enterDate" placeholder="SELECT DATE" name="newDate">
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="form-group">
                    <button type="submit" class="btn btn-default">OK</button>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>
