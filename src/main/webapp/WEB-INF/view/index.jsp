<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
<h2>Hello World!</h2>

<a href="${pageContext.request.contextPath}/api/form">Form</a>
<hr>

<a href="${pageContext.request.contextPath}/management/showUsers">Show all Users</a>
<hr>

<a href="${pageContext.request.contextPath}/management/showeAllHotels">Add Hotel</a>
<hr>
<form:form action="${pageContext.request.contextPath}/api/logout"
           method="POST">

    <input type="submit" value="Logout" />

</form:form>

<td><label>Choose Country:</label></td>
<div>
<form:form action="${pageContext.request.contextPath}/api/showHotelInCountry"  method="POST">
<select  name="searchCountry">
    <c:forEach var="theCountryList" items="${countryList}">
        <option value="${theCountryList.country}" label="${theCountryList.country}"/>
    </c:forEach>

</select>

    <input type="submit" value="Choose Country" />
</form:form>

</div>

<table>
    <tr>
        <th>Name Hotel</th>
        <th>Country</th>
        <th>City</th>
        <th>Description</th>
        <th>Action</th>
    </tr>


    <c:forEach var="hotelInf" items="${countryList}">

<%--        <c:url var="updateHotel" value="/management/updateHotel">--%>
<%--            <c:param name="hotelId" value="${hotelInf.hotelId}"/>--%>
<%--        </c:url>--%>

        <c:url var="SearchRoom" value="/api/showFormSearch">
            <c:param name="hotelId" value="${hotelInf.hotelId}"/>
        </c:url>

        <tr>
            <td> ${hotelInf.nameHotel} </td>
            <td> ${hotelInf.country} </td>
            <td> ${hotelInf.city} </td>
            <td> ${hotelInf.description} </td>
<%--            <td><a href="${updateHotel}">Update</a></td>--%>
            <td><a href="${SearchRoom}">Search free rooms</a></td>

        </tr>

    </c:forEach>

</table>
<a href="${pageContext.request.contextPath}/">Back to all Hotels</a>

</body>
</html>
