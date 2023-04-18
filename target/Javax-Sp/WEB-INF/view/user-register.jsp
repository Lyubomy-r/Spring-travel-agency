<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
    <title>Travel Agency</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">


</head>
<header>
    <!-- Animated navbar-->
    <nav class="navbar navbar-expand-lg navbar-light bg-white">
        <div class="container-fluid">
            <button
                    class="navbar-toggler"
                    type="button"
                    data-mdb-toggle="collapse"
                    data-mdb-target="#navbarExample01"
                    aria-controls="navbarExample01"
                    aria-expanded="false"
                    aria-label="Toggle navigation"
            >
                <i class="fas fa-bars"></i>
            </button>
            <div class="collapse navbar-collapse" id="navbarExample01">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item active">
                        <a class="nav-link" aria-current="page" href="${pageContext.request.contextPath}/">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/showMyLoginPage">Login</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>
<body>

<section class="vh-100 bg-image"
<%--         style="background-image: url('https://mdbcdn.b-cdn.net/img/Photos/new-templates/search-box/img4.webp');"  --%>
                                                                                                            >
    <div class="mask d-flex align-items-center h-100 gradient-custom-3">
        <div class="container h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-9 col-lg-7 col-xl-6">
                    <div class="card" style="border-radius: 15px;">
                        <div class="card-body p-5">
                            <h2 class="text-uppercase text-center mb-5">Create an account</h2>

                            <form:form action="${pageContext.request.contextPath}/api/saveUser" modelAttribute="userEntity"
                                       method="POST">

                                <div class="form-outline mb-4">
                                    <form:input  path="firstName"   id="form3Example1cg" class="form-control form-control-lg" />
                                    <form:errors path="firstName" cssClass="error"/>
                                    <label class="form-label" for="form3Example1cg">Your Name</label>
                                </div>

                                <div class="form-outline mb-4">
                                    <form:input  path="lastName" id="form3Example3cg" class="form-control form-control-lg" />
                                    <form:errors path="lastName" cssClass="error"/>
                                    <label class="form-label" for="form3Example3cg">Your Last Name</label>
                                </div>

                                <div class="form-outline mb-4">
                                    <form:input  path="email" type="email" id="form3Example3cg" class="form-control form-control-lg" />
                                    <form:errors path="email" cssClass="error"/>
                                    <label class="form-label" for="form3Example3cg">Your Email</label>
                                </div>

                                <div class="form-outline mb-4">
                                    <form:input path="password" type="password" id="form3Example4cg" class="form-control form-control-lg" />
                                    <form:errors path="password" cssClass="error"/>
                                    <label class="form-label" for="form3Example4cg">Password</label>
                                </div>

<%--                                <div class="form-outline mb-4">--%>
<%--                                    <input type="password" id="form3Example4cdg" class="form-control form-control-lg" />--%>
<%--                                    <label class="form-label" for="form3Example4cdg">Repeat your password</label>--%>
<%--                                </div>--%>

<%--                                <div class="form-check d-flex justify-content-center mb-5">--%>
<%--                                    <input class="form-check-input me-2" type="checkbox" value="" id="form2Example3cg" />--%>
<%--                                    <label class="form-check-label" for="form2Example3g">--%>
<%--                                        I agree all statements in <a href="#!" class="text-body"><u>Terms of service</u></a>--%>
<%--                                    </label>--%>
<%--                                </div>--%>

                                <div class="d-flex justify-content-center">
                                    <button type="submit"
                                            class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">Register</button>

                                </div>

                                <p class="text-center text-muted mt-5 mb-0">Have already an account? <a href="${pageContext.request.contextPath}/showMyLoginPage"
                                                                                                        class="fw-bold text-body"><u>Login here</u></a></p>


                            </form:form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>