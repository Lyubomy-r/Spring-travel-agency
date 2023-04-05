<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
    <title>Table </title>

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
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Type Room</th>
                <th>Price Room</th>
                <th>Action</th>
            </tr>

            <c:forEach var="tempCustomer" items="${customers}">


                <tr>
                    <td> ${tempCustomer.nameHotel} </td>
                    <td> ${tempCustomer.city} </td>
                    <td> ${tempCustomer.country} </td>

                </tr>

            </c:forEach>

        </table>

    </div>

</div>


</body>

</html>









