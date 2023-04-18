<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
    <title>List Customers</title>

    <!-- reference our style sheet -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.2.0/css/bootstrap.min.css">
    <link href="https://cdn.datatables.net/1.13.4/css/dataTables.bootstrap5.min.css">

    <script defer src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script defer src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
    <script defer src="https://cdn.datatables.net/1.13.4/js/dataTables.bootstrap5.min.js"></script>
    <script defer src="resources/script.js"></script>
</head>

<body>






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

    <div class="container text-center text-white  "style="padding-top: 120px;">
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
<%--<div class="datatable" data-mdb-striped="true" data-mdb-hover="true" data-mdb-border-color="light" data-mdb-loader-class="bg-light">--%>

<div class="container ">
    <div class="mask container  position-absolute top-50 start-50 translate-middle w-100" style="background-color: rgba(0, 0, 0, 0.5)">
        <table class="table table-striped table-hover table-borderless  text-center" style="--bs-table-striped-bg: rgb(255 250 250 / 8%);
    --bs-table-hover-bg: rgb(255 255 255 / 15%);">
            <thead  class="text-white">
            <tr>
                <th scope="col" >Name Hotel</th>
                <th scope="col" >Number Room</th>
                <th scope="col" >Type Room</th>
                <th scope="col" >Price Room</th>
                <th scope="col" >Action</th>
            </tr>
            </thead>
            <!-- loop over and print our customers -->
<%--            <form:hidden path="id" >--%>
<%--                        <security:authentication property="principal.username"/>--%>
<%--            </form:hidden>--%>
<%--            <input name="arrivalDateSearch" type="hidden" value="${arrivalDate}"/>--%>
<%--            <input name="departureDateSearch" type="hidden" value="${departureDate}"/>--%>
            <tbody >
                    <c:forEach var="tempRoom" items="${modelRooms}">

                        <c:url var="reservedRoom" value="/api/addOrder">
                            <c:param name="roomId" value="${tempRoom.roomId}"/>
                            <c:param name="arrivalDateSearch"  value="${arrivalDate}"/>
                            <c:param name="departureDateSearch" value="${departureDate}"/>
                        </c:url>

                <tr scope="row" >

                    <td class="text-white"> ${tempRoom.hotel.nameHotel} </td>
                    <td class="text-white"> ${tempRoom.numberRoom} </td>
                    <td class="text-white"> ${tempRoom.type} </td>
                    <td class="text-white"> ${tempRoom.price} </td>
                    <td ><button type="button" class="btn btn-outline-secondary btn-rounded   " data-mdb-ripple-color="#000000">
                        <a  class="btn-outline-secondary    " data-mdb-ripple-color="#000000"
                            style="color: #89a9c6; border-color: #89a9c6;" href="${reservedRoom}">Reserved Room</a>
                        </button>
                    </td>



                </tr>

                    </c:forEach>
            </tbody>

        </table>
</div>
</div>
</div>


    <hr>
    <a href="${pageContext.request.contextPath}/api/showFormSearch">Back to Search Page</a>


</body>

</html>









