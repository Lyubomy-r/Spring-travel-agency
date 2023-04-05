<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
    <title>Table</title>

</head>

<body>

<div >
    <div >
        <h2>We have free room for you</h2>
    </div>
</div>

<div >

    <div >


        <table>
            <tr>
                <th>Name Hotel</th>
                <th>Number Room</th>
                <th>Type Room</th>
                <th>Price Room</th>
                <th>Action</th>
            </tr>

            <c:forEach var="tempRoom" items="${modelRooms}">

                <c:url var="reservedRoom" value="/api/addOrder">
                    <c:param name="roomId" value="${tempRoom.roomId}"/>
                </c:url>

                <tr>
                    <td> ${tempRoom.hotel.nameHotel} </td>
                    <td> ${tempRoom.numberRoom} </td>
                    <td> ${tempRoom.type} </td>
                    <td> ${tempRoom.price} </td>
                    <td><a href="${reservedRoom}">Reserved Room</a></td>


                </tr>

            </c:forEach>

        </table>

    </div>

</div>
<div>
    <hr>
    <a href="${pageContext.request.contextPath}/api/showFormSearch">Back to Search Page</a>
</div>

</body>

</html>









