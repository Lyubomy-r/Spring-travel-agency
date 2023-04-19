<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>

<head>

    <title>Add new Hotel</title>
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

                    <security:authorize access="hasAuthority('developers:write')">
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/management/managerPage">Manager Page</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/management/showUsers">Show all Users</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/management/addHotel">Add Hotel</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/management/addRoom">Add Room</a>
                        </li>
                    </security:authorize>


                </ul>


            </div>
        </div>
    </nav>
</header>

<body>

<div >

    <div class="container text-center " >
        <h1>Add new Hotel</h1>
        <h2>Hotel Form</h2>
    </div>
</div>

<div class="container " style="width: fit-content;">
    <form:form action="saveHotel" modelAttribute="hotel" method="POST">
        <form:hidden path="hotelId" />

        <div class="row mb-4">
            <div class="col">
                <div class="form-outline">

                    <form:input  path="nameHotel"  type="text" id="form6Example1" class="form-control"/>
                    <form:errors path="nameHotel" cssClass="error"/>
                    <label class="form-label" for="form6Example1">Hotel name</label>
                </div>
            </div>
            <div class="col">
                <div class="form-outline">

                    <td><form:input path="country" type="text" id="form6Example2" class="form-control" /></td>
                        <form:errors path="country" cssClass="error"/>
                    <label class="form-label" for="form6Example2">Country</label>
                </div>
            </div>
        </div>

        <!-- Text input -->
        <div class="form-outline mb-4">

            <form:input path="city" type="text" id="form6Example3" class="form-control"/>
            <form:errors path="city" cssClass="error"/>
            <label class="form-label" for="form6Example3">City</label>
        </div>

        <!-- Message input -->
        <div class="form-outline mb-4">

            <form:textarea path="description" class="form-control" id="form6Example7" rows="4" />
            <form:errors path="description" cssClass="error"/>
            <label class="form-label" for="form6Example7">Description. Additional information</label>
        </div>

        <!-- Submit button -->
        <button type="submit" class="btn btn-primary btn-block mb-4"
                style="width: 100%; background-color: #5cb85c;
                border-color: #4cae4c;">Save</button>
    </form:form >


</div>


</body>

</html>










