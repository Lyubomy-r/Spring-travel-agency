<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
    <title>List Customers</title>

</head>

<body>

<div >
    <div >
        <h2>Order for Users</h2>
    </div>
</div>

<div >

    <div >


        <div>
            <h3>User : ${orderList.get(0).user.firstName}</h3>
        </div>


        <table>
            <tr>

                <th>Name Hotel</th>
                <th>dateOfArrive</th>
                <th>departureDate</th>
                <th>Number Room</th>

                <th>Action</th>
            </tr>


            <c:forEach var="userOrders" items="${orderList}">
                <tr>

                    <td> ${userOrders.hotel.nameHotel} </td>
                    <td> ${userOrders.dateOfArrive} </td>
                    <td> ${userOrders.departureDate} </td>
                    <td> ${userOrders.room.numberRoom} </td>

                </tr>

            </c:forEach>

        </table>

    </div>

</div>
<p>
    <a href="${pageContext.request.contextPath}/">Back to Home Page</a>
</p>

</body>

</html>









