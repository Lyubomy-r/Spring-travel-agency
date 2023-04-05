<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
    <title>Add new Hotel</title>

</head>

<body>

<div >
    <div >
        <h2>Hotel Form</h2>
    </div>
</div>

<div >


    <form:form action="updateRoom" modelAttribute="room" method="POST">

        <form:hidden path="roomId" />

        <table>
            <tbody>
            <tr>
                 <td><label>Hotel name:</label></td>
                <td><form:input path="hotel.nameHotel" /></td>

            </tr>

            <tr>
                <td><label>Number Room:</label></td>
                <td><form:input path="numberRoom" /></td>
            </tr>

            <tr>
                <td><label>Type:</label></td>
                <td><form:input path="type" /></td>
            </tr>

            <tr>
                <td><label>Price:</label></td>
                <td><form:input path="price" /></td>
            </tr>

            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save" /></td>
            </tr>


            </tbody>
        </table>


    </form:form>



    <p>
        <a href="${pageContext.request.contextPath}/api/showeAllHotels">Back to List</a>
    </p>

</div>

</body>

</html>










