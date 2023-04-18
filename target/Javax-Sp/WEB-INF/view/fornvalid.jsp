<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form action="saveHotel" modelAttribute="hotel" method="POST">
    <form:hidden path="hotelId" />


                    <%--                    <input type="text" id="form6Example1" class="form-control" />--%>
                <form:input  path="nameHotel"  type="text"  class="form-control"/>
                <form:errors path="nameHotel" cssClass="error"/>
                <h1>Hotel name</h1>


                    <%--                    <input type="text" id="form6Example2" class="form-control" />--%>
                <td><form:input path="country" type="text"  class="form-control" /></td>
                <form:errors path="country" cssClass="error"/>
                <h2 >Country</h2>



    <!-- Text input -->

            <%--            <input type="text" id="form6Example3" class="form-control" />--%>
        <form:input path="city" type="text"  class="form-control"/>
        <form:errors path="city" cssClass="error"/>
        <h2  >City</h2>


    <!-- Message input -->

            <%--            <textarea class="form-control" id="form6Example7" rows="4"></textarea>--%>
        <form:textarea path="description" class="form-control" id="form6Example7" rows="4" />
        <label  >Description. Additional information</label>


    <%--        <!-- Checkbox -->--%>
    <%--        <div class="form-check d-flex justify-content-center mb-4">--%>
    <%--            <input class="form-check-input me-2" type="checkbox" value="" id="form6Example8" checked />--%>
    <%--            <label class="form-check-label" for="form6Example8"> Create an account? </label>--%>
    <%--        </div>--%>

    <!-- Submit button -->
    <input type="submit"  value="Save"></input>
</form:form >
</body>
</html>
