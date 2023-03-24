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

                    <c:forEach var="tempCustomer" items="${customers}">
                <tr>
                    <td> ${tempCustomer.hotel.nameHotel} </td>
                    <td> ${tempCustomer.numberRoom} </td>
                    <td> ${tempCustomer.type} </td>
                    <td> ${tempCustomer.price} </td>





                </tr>

                    </c:forEach>

        </table>

    </div>

</div>


</body>

</html>









