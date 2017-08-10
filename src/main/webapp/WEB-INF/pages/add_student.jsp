<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<head>
    <title>Add student</title>
    <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/but_imp_exp.css"/>">
    <link href="<c:url value="/resources/jquery/jquery-ui.min.css"/>" rel="stylesheet" >
    <script src="<c:url value="/resources/jquery/external/jquery/jquery.js"/>"></script>
    <script src="<c:url value="/resources/jquery/jquery-ui.min.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.5.3/css/bootstrapValidator.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/1000hz-bootstrap-validator/0.11.9/validator.js"></script>
</head>
<body>
<jsp:include page="menu.jsp"/>
<form class="form-horizontal " action="/add_student" method="POST" id="formStudent" data-toggle="validator" role="form">
    <div class="container">
        <div class="col-md-12">
            <h1>Add information about new student</h1>
        </div>
    </div>
    <div class="form-group <c:if test="${validationFirstName == 0}">has-error</c:if>">
        <label for="firstName" class="col-sm-2 control-label">First name</label>
        <div class="col-sm-5">
            <input type="text" class="form-control" id="firstName"  placeholder="Enter first name" name="newFirstName"
                   pattern="[A-Z][a-z]{1,10}" data-error="The first name cann't" required>
            <c:if test="${validationFirstName == 0}">
                <p class="help-block">The first name isn't correct</p>
            </c:if>
            <div class="help-block with-errors"></div>
        </div>
    </div>
    <div class="form-group <c:if test="${validationLastName == 0}">has-error</c:if>">
        <label class="control-label col-sm-2 col-md-2" for="lastName">Last name</label>
        <div class="col-sm-5">
            <input type="text" class="form-control" id="lastName" placeholder="Enter last name" name="newLastName"
                   pattern="[A-Z][a-z]{1,10}" data-error="The last name isn't correct" required>
            <c:if test="${validationLastName == 0}">
                <p class="help-block">The last name isn't correct</p>
            </c:if>
            <div class="help-block with-errors"></div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button id="contactbtn" type="submit" class="btn btn-success">OK</button>
            <a href="/students" type="button" name="cancel" class="btn btn-default">Cancel</a>
        </div>
    </div>
</form>
</body>
</html>
