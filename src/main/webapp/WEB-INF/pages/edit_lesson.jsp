<%--
  Created by IntelliJ IDEA.
  User: iminiatc
  Date: 02.08.2017
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<head>
    <title>Edit lesson</title>
    <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/but_imp_exp.css"/>">
    <link href="<c:url value="/resources/jquery/jquery-ui.min.css"/>" rel="stylesheet" >
    <script src="<c:url value="/resources/jquery/external/jquery/jquery.js"/>"></script>
    <script src="<c:url value="/resources/jquery/jquery-ui.min.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.5.3/css/bootstrapValidator.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/1000hz-bootstrap-validator/0.11.9/validator.js"></script>

    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.min.css" />
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker3.min.css" />

    <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.min.js"></script>
    <style type="text/css">
        /**
         * Override feedback icon position
         * See http://formvalidation.io/examples/adjusting-feedback-icon-position/
         */
        #eventForm .form-control-feedback {
            top: 0;
            right: -15px;
        }
    </style>
</head>
<body>
<jsp:include page="menu.jsp"/>
<form class="form-horizontal" action="/edit_lesson" method="POST" id="formLesson" data-toggle="validator" role="form">
    <div class="container">
        <div class="col-md-12">
            <h1>Edit information about lesson</h1>
        </div>
    </div>
    <input type="hidden" id="id" value="${lesson.idLesson}" name="id">
    <div class="form-group">
        <label class="control-label col-sm-2" for="subjectName">Subject name</label>
        <div class="col-sm-5">
            <select class="form-control col-md-6" id="subjectName" name="newIdSubject">
                <c:forEach items="${subjectList}" var="subject">
                    <option value="${subject.idSubject}" name="newIdSubject" id="newIdSubject">${subject.subjectName}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="form-group <c:if test="${validation == 0}">has-error</c:if>">
        <label class="control-label col-sm-2">Date</label>
        <div class="col-xs-5 date">
            <div class="col-sm-5 input-group input-append date" id="datePicker">
                <input type="text" class="form-control" name="newDate" data-error="The date isn't correct" readonly required>
                <c:if test="${validation == 0}">
                    <p class="help-block">The date isn't correct</p>
                </c:if>
                <div class="help-block with-errors"></div>
                <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button id="contactbtn" type="submit" class="btn btn-success">OK</button>
            <a href="/lessons" type="button" name="cancel" class="btn btn-default">Cancel</a>
        </div>
    </div>
</form>
<script src="<c:url value="/resources/js/datapicker.js"/>"></script>
</body>
</html>
