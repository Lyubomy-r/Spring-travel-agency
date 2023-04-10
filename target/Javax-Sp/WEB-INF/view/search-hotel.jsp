<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<head>
    <title>Add new customer</title>

</head>

<body>

<div >
    <div >
        <h2></h2>
    </div>
</div>

<div >
    <h3>Search Hotel</h3>
</div >
    <div >

<%--        <form:hidden path="hotId" value="${hotelName.hotelId}" />--%>

    <form:form action="freeHotel"  method="POST">

        <table>
            <tbody>
<%--            <c:url var="UserOrder" value="/management/showUserOrders">--%>
<%--                <c:param name="hotelId" value="${hotelName.hotelId}"/>--%>
<%--            </c:url>--%>

            <input name="hotId" type="hidden" value="${hotelName.hotelId}"/>


            <tr>
                <td><label>Hotel Name:</label></td>
<%--                <select  name="searchCountry">--%>
<%--                    <c:forEach var="temphotelList" items="${hotelList}">--%>
<%--                   <option value="${temphotelList.country}" label="${temphotelList.country}"/>--%>
<%--                    </c:forEach>--%>

<%--                </select>--%>
                <td><input type="text" name="searchCountry" value="${hotelName.nameHotel}" /></td>
<%--                <td><input type="text" name="arrivalDate" /></td>--%>
            </tr>

            <tr>
                <td><label>Date Arrive:</label></td>
                <td><input type="date" name="arrivalDate" /></td>
            </tr>

            <tr>
                <td><label>Date D:</label></td>
                <td><input type="date" name="departureDate"  /></td>
            </tr>

            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Submit"  /></td>
            </tr>


            </tbody>
        </table>
    </form:form>
</div>



<p>
    <a href="${pageContext.request.contextPath}/api/showFormSearch">Back to List</a>
</p>



</body>

</html>












