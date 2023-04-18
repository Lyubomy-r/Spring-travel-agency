<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">

<head>

    <title>Login Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">




    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <!-- Reference Bootstrap files -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

    <script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>

<div>
    <form:form action="${pageContext.request.contextPath}/authenticateTheUser"
               method="POST" class="px-5 py-5"  style="width: 25%;margin: auto;">

        <c:if test="${param.error != null}">

            <div class="alert alert-danger col-xs-offset-1 col-xs-10">
                Invalid username and password.
            </div>

        </c:if>

        <c:if test="${param.logout != null}">

            <div class="alert alert-success col-xs-offset-1 col-xs-10">
                You have been logged out.
            </div>

        </c:if>
        <!-- Email input -->
        <div class="form-outline mb-4">
            <input type="email" name="username"  id="form1Example1" class="form-control" />
            <label class="form-label" for="form1Example1">Email address</label>
        </div>

        <!-- Password input -->
        <div class="form-outline mb-4">
            <input type="password"  name="password" id="form1Example2" class="form-control" />
            <label class="form-label" for="form1Example2">Password</label>
        </div>

        <!-- 2 column grid layout for inline styling -->
<%--        <div class="row mb-4">--%>
<%--            <div class="col d-flex justify-content-center">--%>
                <!-- Checkbox -->
<%--                <div class="form-check">--%>
<%--                    <input class="form-check-input" type="checkbox" value="" id="form1Example3" checked />--%>
<%--                    <label class="form-check-label" for="form1Example3"> Remember me </label>--%>
<%--                </div>--%>
<%--            </div>--%>

<%--            <div class="col">--%>
<%--                <!-- Simple link -->--%>
<%--                <a href="#!">Forgot password?</a>--%>
<%--            </div>--%>
<%--        </div>--%>

        <!-- Submit button -->
        <button type="submit" class="btn btn-primary btn-block">Login</button>
    </form:form >

<%--    <div id="loginbox" style="margin-top: 50px;"--%>
<%--         class="mainbox col-md-3 col-md-offset-2 col-sm-6 col-sm-offset-2">--%>

<%--        <div class="panel panel-info">--%>

<%--            <div class="panel-heading">--%>
<%--                <div class="panel-title">Sign In</div>--%>
<%--            </div>--%>

<%--            <div style="padding-top: 30px" class="panel-body">--%>

<%--                <!-- Login Form -->--%>
<%--                <form:form action="${pageContext.request.contextPath}/authenticateTheUser"--%>
<%--                           method="POST" class="form-horizontal">--%>

<%--                    <!-- Place for messages: error, alert etc ... -->--%>
<%--                    <div class="form-group">--%>
<%--                        <div class="col-xs-15">--%>
<%--                            <div>--%>

<%--                                <!-- Check for login error -->--%>

<%--                                <c:if test="${param.error != null}">--%>

<%--                                    <div class="alert alert-danger col-xs-offset-1 col-xs-10">--%>
<%--                                        Invalid username and password.--%>
<%--                                    </div>--%>

<%--                                </c:if>--%>

<%--                                <c:if test="${param.logout != null}">--%>

<%--                                    <div class="alert alert-success col-xs-offset-1 col-xs-10">--%>
<%--                                        You have been logged out.--%>
<%--                                    </div>--%>

<%--                                </c:if>--%>

<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>

<%--                    <!-- User name -->--%>
<%--                    <div style="margin-bottom: 25px" class="input-group">--%>
<%--                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>--%>

<%--                        <input type="text" name="username" placeholder="username" class="form-control">--%>
<%--                    </div>--%>

<%--                    <!-- Password -->--%>
<%--                    <div style="margin-bottom: 25px" class="input-group">--%>
<%--                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>--%>

<%--                        <input type="password" name="password" placeholder="password" class="form-control" >--%>
<%--                    </div>--%>

<%--                    <!-- Login/Submit Button -->--%>
<%--                    <div style="margin-top: 10px" class="form-group">--%>
<%--                        <div class="col-sm-6 controls">--%>
<%--                            <button type="submit" class="btn btn-success">Login</button>--%>
<%--                        </div>--%>
<%--                    </div>--%>

<%--                </form:form>--%>

<%--            </div>--%>

<%--        </div>--%>

<%--    </div>--%>

</div>

</body>
</html>