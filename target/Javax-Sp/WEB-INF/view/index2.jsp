<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>


    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">


</head>
<header>
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-light bg-white">
        <div class="container-fluid">
            <button
                    class="navbar-toggler"
                    type="button"
                    data-mdb-toggle="collapse"
                    data-mdb-target="#navbarExample01"
                    aria-controls="navbarExample01"
                    aria-expanded="false"
                    aria-label="Toggle navigation"
            >
                <i class="fas fa-bars"></i>
            </button>
            <div class="collapse navbar-collapse" id="navbarExample01">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item active">
                        <a class="nav-link" aria-current="page" href="${pageContext.request.contextPath}/">Home</a>
                    </li>
                    <security:authorize access="hasAuthority('developers:write')">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/management/showUsers">Show all Users</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/management/addHotel">Add Hotel</a>
                    </li>
                    </security:authorize>
                    <security:authorize access="hasAnyAuthority('developers:red','developers:write')">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/api/logout">Logout</a>
                    </li>
                    </security:authorize>

                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/showMyLoginPage">Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/register">register</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- Navbar -->



    <!-- Jumbotron -->
    <div class="p-5 text-center bg-light">
        <h1 class="mb-3">Travel Agency</h1>
        <h4 class="mb-3">Let's Start Choose Country :</h4>
        <form:form action="${pageContext.request.contextPath}/api/showHotelInCountry"  method="POST">

            <div class="row gx-1 d-flex justify-content-center ">

<%--                <label for="disabledSelect" class="form-label">Choose Country :</label>--%>

                <div class="col-2 g-col-md-4 ">

                    <button type="submit" class="btn btn-primary">Choose Country :</button>

                </div>


                <div class="col-2 g-col-md-4 ">

                    <select  name="searchCountry" id="disabledSelect" class="form-select" >
                        <c:forEach var="theCountryList" items="${countryList}">
                            <option value="${theCountryList.country}" label="${theCountryList.country}" class="form-select"/>
                        </c:forEach>

                    </select>
                </div>



            </div>

        </form:form>
<%--        <a class="btn btn-primary" href="" role="button">Call to action</a>--%>
    </div>
    <!-- Jumbotron -->
</header>
<body>
<div class="bd-example">
<button type="button" class="btn btn-primary mb-2" data-mdb-toggle="modal" data-mdb-target="#exampleModal" style="">
    Large
</button>


<!-- Modal -->
<div class="modal top fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" data-mdb-backdrop="false" data-mdb-keyboard="true">
    <div class="modal-dialog  ">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                <button type="button" class="btn-close" data-mdb-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">...</div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-mdb-dismiss="modal">
                    Close
                </button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>

</div>

<%--<a href="${pageContext.request.contextPath}/api/form">Form</a>--%>
<%--<hr>--%>
<%--<a class="btn btn-outline-danger" href="${pageContext.request.contextPath}/management/showUsers"--%>
<%--   role="button" >Show all Users</a>--%>

<%--<hr>--%>
<%--<a class="btn btn-outline-danger" href="${pageContext.request.contextPath}/management/showeAllHotels"--%>
<%--   role="button" >Add Hotel</a>--%>

<%--<hr>--%>
<%--<form:form action="${pageContext.request.contextPath}/api/logout"--%>
<%--           method="POST">--%>

<%--    <input type="submit" value="Logout"  class="btn btn-primary"/>--%>

<%--</form:form>--%>



<div id="container">
    <div id="content">

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

    </div>

</div>
<a href="${pageContext.request.contextPath}/">Back to all Hotels</a>


</body>
</html>
