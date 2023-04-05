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
        <h2>CRM - Customer Relationship Manager</h2>
    </div>
</div>

<div >
    <h3>Search Hotel</h3>

    <form:form action="freeHotel"  method="POST">

        <table>
            <tbody>

            <tr>
                <td><label>Country:</label></td>
                <select  name="searchCountry">
                    <c:forEach var="temphotelList" items="${hotelList}">
                        <option value="${temphotelList.country}" label="${temphotelList.country}"/>
                    </c:forEach>

                </select>

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












