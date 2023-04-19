<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>


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
                    </security:authorize>
                    <security:authorize access="hasAnyAuthority('developers:red','developers:write')">
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/api/logout">Logout</a>
                        </li>
                    </security:authorize>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/showMyLoginPage">Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/api/register">Register</a>
                    </li>
                </ul>


            </div>
        </div>
    </nav>
    <!-- Animated navbar -->


</header>

<body>



<!-- Background image -->
<div
        id="intro"
        class="bg-image"
        style="
              background-image: url(https://preview.colorlib.com/theme/direngine/images/bg_5.jpg.webp);
              height: 100vh;
              background-size: cover;
              background-repeat: no-repeat;
              background-position: center center;
              height: 785px;
              "
>
    <div class="container text-center text-white  ">
        <div id="wrapper">
            <div id="header">
                <h2>We have free room for you</h2>
                <h3>On your date :
                    <form:form action="addOrder"  method="POST">
                        ${arrivalDate} / ${departureDate}
                        <%--              <input  name="arrivalDateSearch" type="date" value="${arrivalDate}"/> / <input name="departureDateSearch" type="date" value="${departureDate}"/>--%>
                    </form:form></h3>

            </div>
        </div>
    </div>
    <div class="container ">

        <div class="container d-flex align-items-center text-center h-100">
            <div>

                <div class="card-group ">
                    <div class="row row-cols-2 row-cols-md-4 mt-3 mb-4 g-4">



                        <c:forEach var="tempRoom" items="${modelRooms}">


                            <c:url var="reservedRoom" value="/api/addOrder">
                                <c:param name="roomId" value="${tempRoom.roomId}"/>
                                <c:param name="arrivalDateSearch"  value="${arrivalDate}"/>
                                <c:param name="departureDateSearch" value="${departureDate}"/>
                            </c:url>
                            <div class="col">
                                <div class="card h-100">
                                    <img src="<c:url value="/resources/photo/room${tempRoom.roomId}.jpeg"></c:url>/" class="card-img-top" alt="Hollywood Sign on The Hill"/>
                                    <div class="card-body">
                                        <h5 class="card-title">${tempRoom.hotel.nameHotel}</h5>
                                        <p class="card-text">
                                                ${tempRoom.type}
                                        </p>
                                        <p class="card-text">
                                                ${tempRoom.numberRoom}
                                        </p>
                                        <p class="card-text">
                                                ${tempRoom.price} $
                                        </p>
                                    </div>
                                    <div class="card-footer">
                                        <button type="button" class="btn btn-outline-secondary btn-rounded   "
                                                data-mdb-ripple-color="#000000">
                                            <a  class="btn-outline-secondary    " data-mdb-ripple-color="#000000"
                                                style="color: #89a9c6; border-color: #89a9c6;"
                                                href="${reservedRoom}">Reserved Room</a>
                                        </button>

                                    </div>
                                </div>
                            </div>

                        </c:forEach>

                    </div>



                </div>
            </div>
        </div>

    </div>
</div>
<!-- Background image -->


</body>
</html>
