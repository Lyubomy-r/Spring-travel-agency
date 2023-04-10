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
        <h2>We have free room for you</h2>
    </div>
</div>

<div>

    <div >
        <input type="button" value="Add Hotel"
               onclick="window.location.href='addHotel'; return false;"

        />

        <input type="button" value="Add Room"
               onclick="window.location.href='addRoom'; return false;"

        />

        <table>
            <tr>
                <th>Name Hotel</th>
                <th>Country</th>
                <th>City</th>
                <th>Description</th>
                <th>Update</th>
                <th>Action</th>
            </tr>


            <c:forEach var="hotelInf" items="${hotel}">

                <c:url var="updateHotel" value="/management/updateHotel">
                    <c:param name="hotelId" value="${hotelInf.hotelId}"/>
                </c:url>

                <c:url var="showRoom" value="/management/showHotelRooms">
                    <c:param name="hotelId" value="${hotelInf.hotelId}"/>
                </c:url>

                <tr>
                    <td> ${hotelInf.nameHotel} </td>
                    <td> ${hotelInf.country} </td>
                    <td> ${hotelInf.city} </td>
                    <td> ${hotelInf.description} </td>
                    <td><a href="${updateHotel}">Update</a></td>
                    <td><a href="${showRoom}">Hotel rooms</a></td>

                </tr>

            </c:forEach>

        </table>

    </div>

</div>
<div>
    <hr>
    <a href="${pageContext.request.contextPath}/api/showFormSearch">Search free Hotel</a>
</div>

</body>

</html>









