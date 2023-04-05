<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
    <title>List Customers</title>

    <!-- reference our style sheet -->



</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>Order for Users</h2>
    </div>
</div>

<div id="container">

    <div id="content">


        <div>
            <h3>User : ${orderList.get(0).user.firstName}</h3>
        </div>
        <!--  add our html table here -->

        <table>
            <tr>
<%--                <th>User </th>--%>
                <th>Name Hotel</th>
                <th>dateOfArrive</th>
                <th>departureDate</th>
                <th>Number Room</th>

                <th>Action</th>
            </tr>

            <!-- loop over and print our customers -->

            <c:forEach var="userOrders" items="${orderList}">
                <tr>
<%--                    <td> ${userOrders.user.firstName} </td>--%>
                    <td> ${userOrders.hotel.nameHotel} </td>
                    <td> ${userOrders.dateOfArrive} </td>
                    <td> ${userOrders.departureDate} </td>
                    <td> ${userOrders.room.numberRoom} </td>

                </tr>

            </c:forEach>

        </table>

    </div>

</div>


</body>

</html>









