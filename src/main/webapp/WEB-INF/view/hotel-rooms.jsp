<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
    <title>List Customers</title>

    <!-- reference our style sheet -->



</head>

<body>

<div >
    <div >
        <h2>Hotel has this rooms</h2>
    </div>
</div>

<div >

    <div >

        <h3> HOTEL NAME : ${modelRooms.get(0).hotel.nameHotel}</h3>

        <!--  add our html table here -->

        <table>
            <tr>

                <th>Number Room</th>
                <th>Type Room</th>
                <th>Price Room</th>
                <th>Action</th>
            </tr>

            <!-- loop over and print our customers -->
            <%--            <form:hidden path="id" >--%>
            <%--                        <security:authentication property="principal.username"/>--%>
            <%--            </form:hidden>--%>
            <c:forEach var="tempRoom" items="${modelRooms}">

                <c:url var="updateRoom" value="/management/updateRoom">
                    <c:param name="roomId" value="${tempRoom.roomId}"/>
                </c:url>

                <tr>

                    <td> ${tempRoom.numberRoom} </td>
                    <td> ${tempRoom.type} </td>
                    <td> ${tempRoom.price} </td>
                    <td><a href="${updateRoom}">Update</a></td>




                </tr>

            </c:forEach>

        </table>

    </div>

</div>
<div>
    <hr>
    <a href="${pageContext.request.contextPath}/management/showeAllHotels">Back to Hotels table</a>
</div>

</body>

</html>









