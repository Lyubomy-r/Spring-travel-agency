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
                <th>Orders</th>
                <th>Action</th>
            </tr>

            <!-- loop over and print our customers -->

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
<%--        <c:forEach var="tempCustomer" items="${userList}">--%>
<%--            <td> ${tempCustomer.orderList} </td>--%>
<%--        </c:forEach>--%>
        </table>

    </div>

</div>
<hr>
<p>
    <a href="${pageContext.request.contextPath}/">Back to Home</a>
</p>

</body>

</html>









