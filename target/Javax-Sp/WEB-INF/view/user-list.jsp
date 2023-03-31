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
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Password</th>
                <th>Action</th>
            </tr>

            <!-- loop over and print our customers -->

            <c:forEach var="tempCustomer" items="${customers}">
                <tr>
                    <td> ${tempCustomer.firstName} </td>
                    <td> ${tempCustomer.lastName} </td>
                    <td> ${tempCustomer.email} </td>
                    <td> ${tempCustomer.password} </td>





                </tr>

            </c:forEach>

        </table>

    </div>

</div>


</body>

</html>









