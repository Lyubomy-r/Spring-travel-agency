<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
    <title>Table</title>

</head>

<body>

<div >
    <div >
        <h2></h2>
    </div>
</div>

<div >

    <div >

        <table>
            <tr>
                <th>Hotel Name</th>
                <th>City Name</th>
                <th>Country</th>
                <th>Type Room</th>
                <th>Price Room</th>
                <th>Action</th>
            </tr>

            <c:forEach var="tempCustomer" items="${customers}">


                <tr>
                    <td> ${tempCustomer.hotel.nameHotel} </td>
                    <td> ${tempCustomer.hotel.city} </td>
                    <td> ${tempCustomer.hotel.country} </td>
                    <td> ${tempCustomer.room.numberRoom} </td>
                    <td> ${tempCustomer.room.price} </td>
                    <td> ${tempCustomer.orderId} </td>


                </tr>

            </c:forEach>

        </table>

    </div>

</div>


</body>

</html>









