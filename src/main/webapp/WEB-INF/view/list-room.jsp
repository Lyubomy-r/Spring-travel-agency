<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
    <title>List Customers</title>

    <!-- reference our style sheet -->



</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>We have free room for you</h2>
        <h3>On your date : <form:form action="addOrder"  method="POST">
    <input name="arrivalDateSearch" type="date" value="${arrivalDate}"/> / <input name="departureDateSearch" type="date" value="${departureDate}"/>
        </form:form></h3>

    </div>
</div>

<div id="container">

    <div id="content">






        <table>
            <tr>
                <th>Name Hotel</th>
                <th>Number Room</th>
                <th>Type Room</th>
                <th>Price Room</th>
                <th>Action</th>
            </tr>

            <!-- loop over and print our customers -->
<%--            <form:hidden path="id" >--%>
<%--                        <security:authentication property="principal.username"/>--%>
<%--            </form:hidden>--%>
<%--            <input name="arrivalDateSearch" type="hidden" value="${arrivalDate}"/>--%>
<%--            <input name="departureDateSearch" type="hidden" value="${departureDate}"/>--%>
                    <c:forEach var="tempRoom" items="${modelRooms}">

                        <c:url var="reservedRoom" value="/api/addOrder">
                            <c:param name="roomId" value="${tempRoom.roomId}"/>
                            <c:param name="arrivalDateSearch"  value="${arrivalDate}"/>
                            <c:param name="departureDateSearch" value="${departureDate}"/>
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









