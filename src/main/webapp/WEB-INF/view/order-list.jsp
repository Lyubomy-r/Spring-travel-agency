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



        <!--  add our html table here -->

        <table>
            <tr>
                <th>Name Hotel</th>
                <th>dateOfArrive</th>
                <th>dateOfArrive</th>
                <th>departureDate</th>
                <th>Id Room</th>

                <th>Action</th>
            </tr>

            <!-- loop over and print our customers -->

            <c:forEach var="tempCustomer" items="${customers}">
                <tr>
                    <td> ${tempCustomer.hotel.nameHotel} </td>
                    <td> ${tempCustomer.dateOfArrive} </td>
                    <td> ${tempCustomer.dateOfArrive} </td>
                    <td> ${tempCustomer.departureDate} </td>
                    <td> ${tempCustomer.room.numberRoom} </td>






                </tr>

            </c:forEach>

        </table>

    </div>

</div>


</body>

</html>









