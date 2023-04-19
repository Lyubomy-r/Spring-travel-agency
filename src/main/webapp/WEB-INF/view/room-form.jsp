<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>

<head>
    <title>Add new Room</title>
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

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>


        <div class="container text-center " >
            <h1>Add new Room</h1>
            <h2>Room Form</h2>
        </div>



<div class="container " style="width: fit-content;">


    <form:form action="saveRoom" modelAttribute="room" method="POST">


        <form:hidden path="roomId" />
        <div class="row mb-4">
            <div class="col">
                <div class="form-outline">

                            <select  name="hotelName"  id="form6Example1" class="form-select ">
                                <c:forEach var="hotelNameList"  items="${nameHotel}">
                                    <option value="${hotelNameList.nameHotel}" label="${hotelNameList.nameHotel}"/>
                                </c:forEach>

                            </select>
<%--                    <form:input  path="nameHotel"  type="text" id="form6Example1" class="form-control"/>--%>
                    <label class="form-label" for="form6Example1">Hotel name</label>
                </div>
            </div>
            <div class="col">
                <div class="form-outline">

                    <td><form:input path="numberRoom" type="text" id="form6Example2" class="form-control" /></td>
                    <label class="form-label" for="form6Example2">Number Room</label>
                </div>
            </div>
        </div>

        <!-- Text input -->
        <div class="form-outline mb-4">

            <form:input path="type" type="text" id="form6Example3" class="form-control"/>
            <label class="form-label" for="form6Example3">Type</label>
        </div>

        <!-- Message input -->
        <div class="form-outline mb-4">

            <form:input path="price" class="form-control" id="form6Example7" rows="4" />
            <label class="form-label" for="form6Example7">Price </label>
        </div>



        <!-- Submit button -->
        <button type="submit" class="btn btn-primary btn-block mb-4"
                style="width: 100%; background-color: #5cb85c;
                border-color: #4cae4c;">Save</button>


    </form:form>


</div>

</body>

</html>










