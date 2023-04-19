<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>

<html>

<head>
    <title>Hotel has this rooms</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <!-- reference our style sheet -->


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
                            <a class="nav-link" href="${pageContext.request.contextPath}/api/logout">Logout</a>
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


    <div class="container text-center ">
        <h2>Hotel has this rooms</h2>
    </div>


<div >

    <div class="container ">

        <h3> HOTEL NAME : ${modelRooms.get(0).hotel.nameHotel}</h3>
    </div>

        <!--  add our html table here -->
        <div class="container ">
            <div class="table-responsive">
                <table class="table table-striped table-hover table-borderless  text-center" >
                    <thead>
            <tr>

                <th scope="col">Number Room</th>
                <th scope="col">Type Room</th>
                <th scope="col">Price Room</th>
                <th scope="col">Action</th>
            </tr>
                    </thead>

            <c:forEach var="tempRoom" items="${modelRooms}">

                <c:url var="updateRoom" value="/management/updateRoom">
                    <c:param name="roomId" value="${tempRoom.roomId}"/>
                </c:url>
                <c:url var="deleteRoom" value="/management/deleteRoom">
                     <c:param name="roomId" value="${tempRoom.roomId}"/>
                 </c:url>

                <tr scope="row" >

                    <td> ${tempRoom.numberRoom} </td>
                    <td> ${tempRoom.type} </td>
                    <td> ${tempRoom.price} </td>
                    <td ><button type="button" class="btn btn-outline-secondary btn-rounded   " data-mdb-ripple-color="#000000">
                        <a  class="btn-outline-secondary    " data-mdb-ripple-color="#000000"
                            style="color: #89a9c6; border-color: #89a9c6;" href="${updateRoom}">Update</a>
                    </button>
                        |
                        <button type="button" class="btn btn-outline-secondary btn-rounded   " data-mdb-ripple-color="#000000">
                            <a  class="btn-outline-secondary    " data-mdb-ripple-color="#000000"
                                style="color: #cc4a4a; border-color: #89a9c6;" href="${deleteRoom}"
                                onclick="if (!(confirm('Are you sure you want to delete this Room?'))) return false">
                                Delete</a>
                        </button>
                    </td>




                </tr>

            </c:forEach>

        </table>

    </div>

</div>

    <hr>

</div>

</body>

</html>









