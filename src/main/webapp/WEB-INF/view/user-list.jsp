<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
    <title>Table</title>

</head>

<body>

<div >
    <div >
        <h2>Order for Users</h2>
    </div>
</div>

<div >

    <div >


        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Orders</th>
                <th>Action</th>
            </tr>

            <c:forEach var="User" items="${userList}">
                <c:url var="UserOrder" value="/management/showUserOrders">
                    <c:param name="userId" value="${User.userId}"/>
                </c:url>
                <tr>
                    <td> ${User.firstName} </td>
                    <td> ${User.lastName} </td>
                    <td> ${User.email} </td>
                    <td><a href="${UserOrder}">Show all ordrs</a></td>

                </tr>

            </c:forEach>

        </table>

    </div>

</div>


</body>

</html>









