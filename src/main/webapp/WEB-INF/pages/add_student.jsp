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
    <script>
        
    function validateText(id) {
            if ($("#"+id).val()==null || $("#"+id).val()=="") {
                var div = $("#"+id).closest("div");
                div.addClass("has-error");
                return false;
            }
        }
    $(document).ready(
        function () {
            $("#contactbtn").click(function () {
                if (validateText("contactname")) {
                    return false;
                }
            })
        }
    );
    </script>

    <script src="<c:url value="/WEB-INF/js/validate.js"/>"></script>
</head>
<body>
<jsp:include page="menu.jsp"/>
<form class="form-horizontal " action="/add_student" method="POST" name="student" role="form">
    <div class="container">
        <div class="col-md-12">
            <h1>Add information about new student</h1>
        </div>
    </div>
    <div class="form-group <c:if test="${validationFirstName == 0}">has-error</c:if>" name="aca">
        <label for="contactname" class="col-sm-2 control-label" for="contactname">First name</label>
        <div class="col-sm-5">
            <input type="text" class="form-control" id="contactname"  placeholder="Enter first name" name="newFirstName">
            <c:if test="${validationFirstName == 0}">
                <p class="help-block">The first name isn't correct</p>
            </c:if>
        </div>
    </div>
    <div class="form-group <c:if test="${validationLastName == 0}">has-error</c:if>">
        <label class="control-label col-sm-2 col-md-2" for="lastName">Last name</label>
        <div class="col-sm-5">
            <input type="text" class="form-control" id="lastName" placeholder="Enter last name" name="newLastName" onclick="validator(newLastName, ${validationLastName})">
            <c:if test="${validationLastName == 0}">
                <p class="help-block">The last name isn't correct</p>
            </c:if>
        </div>
    </div>

    <input type="text" name="av" id="fana" onclick="validate(this.form)">

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button id="contactbtn" type="submit" class="btn btn-success">OK</button>
        </div>
    </div>
</form>
</body>
</html>
