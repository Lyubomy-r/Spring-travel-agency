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
                    <security:authorize access="hasAnyAuthority('developers:red','developers:write')">
                        <li class="nav-item">
                            <form:form  action="${pageContext.request.contextPath}/api/logout"
                                        method="POST">
                                <button type="submit"  class="btn btn-rounded nav-link  " data-mdb-ripple-color="#000000">Logout</button>
                            </form:form>

                        </li>
                    </security:authorize>
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

<div id="wrapper">
    <div id="header">
        <div class="container text-center ">
            <h2>Order for Users</h2>
            <h3>User : ${orderList.get(0).user.firstName}</h3>
        </div>
    </div>
</div>

<div class="container ">

    <div class="table-responsive">

        <table class="table table-striped table-hover table-borderless  text-center">
            <thead>
            <tr>
                <th scope="col" >First Name</th>
                <th scope="col" >Date Of Arrive</th>
                <th scope="col" >Departure Date</th>
                <th scope="col" >Number Room</th>
                <th scope="col" >Price</th>
                <th scope="col" >Order</th>
<%--                <th scope="col" >Action</th>--%>
            </tr>
            </thead>
            <tbody>

            <c:forEach var="userOrders" items="${orderList}">
                <c:url var="deleteOrder" value="/api/deleteOrder">
                    <c:param name="roomId" value="${userOrders.room.roomId}"/>
                    <c:param name="arrivalDateSearch"  value="${userOrders.dateOfArrive}"/>
                    <c:param name="departureDateSearch" value="${userOrders.departureDate}"/>
                </c:url>
                <tr scope="row">
                    <td> ${userOrders.hotel.nameHotel} </td>
                    <td> ${userOrders.dateOfArrive} </td>
                    <td> ${userOrders.departureDate} </td>
                    <td> ${userOrders.room.numberRoom} </td>
                    <td> ${userOrders.room.price} $</td>

                    <td ><button type="button" class="btn btn-outline-secondary btn-rounded   "  data-mdb-ripple-color="#000000" disabled>
                        Delete

                    </button>

                    </td>

                </tr>

            </c:forEach>

            </tbody>
        </table>


    </div>
</div>
<hr>


</body>

</html>









