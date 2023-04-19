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
                            <form:form  action="${pageContext.request.contextPath}/api/logout"
                                        method="POST">
                                <button type="submit"  class="btn btn-rounded nav-link  " data-mdb-ripple-color="#000000">Logout</button>
                            </form:form>

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


<!-- Background image -->
<div class="container pt-5 text-center text-white  ">
            <h2>Welcome in this page you can see oll yours reserved tours.</h2>
            <h2>Your Orders</h2>
</div>

<div class="container ">
    <div class="mask container   w-100" style="background-color: rgba(0, 0, 0, 0.5)">
        <table class="table table-striped table-hover table-borderless  text-center" style="--bs-table-striped-bg: rgb(255 250 250 / 8%);
    --bs-table-hover-bg: rgb(255 255 255 / 15%);">
            <thead  class="text-white">
            <tr>
                <th scope="col" >Name Hotel</th>
                <th scope="col" >Date Of Arrive</th>
                <th scope="col" >Date Departure </th>
                <th scope="col" >Number Room</th>
                <th scope="col" >Price</th>
                <th scope="col" >Action</th>
            </tr>
            </thead>

            <tbody >
            <c:forEach var="userOrders" items="${orderList}">

                <c:url var="cancelOrder" value="/api/deleteOrder">
                    <c:param name="roomId" value="${userOrders.room.roomId}"/>
                    <c:param name="arrivalDateSearch"  value="${userOrders.dateOfArrive}"/>
                    <c:param name="departureDateSearch" value="${userOrders.departureDate}"/>
                </c:url>

                <tr scope="row" >

                    <td class="text-white"> ${userOrders.hotel.nameHotel} </td>
                    <td class="text-white"> ${userOrders.dateOfArrive} </td>
                    <td class="text-white"> ${userOrders.departureDate} </td>
                    <td class="text-white"> ${userOrders.room.numberRoom} </td>
                    <td class="text-white"> ${userOrders.room.price} $ </td>
                    <td ><button type="button" class="btn btn-outline-secondary btn-rounded   " data-mdb-ripple-color="#000000">
                        <a  class="btn-outline-secondary    " data-mdb-ripple-color="#000000"
                            style="color: #89a9c6; border-color: #89a9c6;" href="${cancelOrder}"
                            onclick="if (!(confirm('Are you sure you want to  cancel this reservation ?')))
                            return false">Cancel Reservation</a>
                    </button>
                    </td>
                </tr>

            </c:forEach>
            </tbody>

        </table>
    </div>
</div>

</div>


</body>

</html>









