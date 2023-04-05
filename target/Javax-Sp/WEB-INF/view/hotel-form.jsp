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


    <form:form action="saveHotel" modelAttribute="hotel" method="POST">

        <!-- need to associate this data with customer id -->
        <form:hidden path="hotelId" />

        <table>
            <tbody>
            <tr>
                <td><label>Hotel name:</label></td>
                <td><form:input path="nameHotel" /></td>
            </tr>

            <tr>
                <td><label>Country:</label></td>
                <td><form:input path="country" /></td>
            </tr>

            <tr>
                <td><label>City:</label></td>
                <td><form:input path="city" /></td>
            </tr>

            <tr>
                <td><label>Description:</label></td>
                <td><form:input path="description" /></td>
            </tr>

            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save" /></td>
            </tr>


            </tbody>
        </table>


    </form:form>



    <p>
        <a href="${pageContext.request.contextPath}/management/showeAllHotels">Back to List</a>
    </p>

</div>

</body>

</html>










