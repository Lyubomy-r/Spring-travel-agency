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
    </div>
</div>

<div id="container">

    <div id="content">



        <!--  add our html table here -->

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
                    <c:forEach var="tempCustomer" items="${customers}">

                        <c:url var="reservedRoom" value="/api/addOrder">
                            <c:param name="roomId" value="${tempCustomer.roomId}"/>
                        </c:url>

                <tr>
                    <td> ${tempCustomer.hotel.nameHotel} </td>
                    <td> ${tempCustomer.numberRoom} </td>
                    <td> ${tempCustomer.type} </td>
                    <td> ${tempCustomer.price} </td>
                    <td><a href="${reservedRoom}">Reserved Room</a></td>




                </tr>

                    </c:forEach>

        </table>

    </div>

</div>
<div>
    <a href="${pageContext.request.contextPath}/api/showFormSearch">Back to Search Page</a>
</div>

</body>

</html>









