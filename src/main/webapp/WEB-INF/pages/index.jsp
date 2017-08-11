<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/login.css"/>" rel="stylesheet">
    <script src="<c:url value="/resources/jquery/external/jquery/jquery.js"/>"></script>
    <script src="<c:url value="/resources/jquery/jquery-ui.min.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
</head>
<body>
<div class = "container">
    <div class="wrapper <c:if test="${!valid}">has-error</c:if>">
        <form action="/" method="post" name="Login_Form" class="form-signin">
            <h3 class="form-signin-heading" align="center">Welcome to the best project!</h3>
            <hr class="colorgraph"><br>
            <input type="text" class="form-control" name="user" placeholder="Username" required="" autofocus="" />
            <input type="password" class="form-control" name="pwd" placeholder="Password" required=""/>
            <c:if test="${!valid}">
                <p class="help-block">The user's date isn't correct</p>
            </c:if>
            <button class="btn btn-lg btn-primary btn-block"  name="Submit" value="Login" type="Submit">Login</button>
        </form>
    </div>
</div>
</body>
</html>
