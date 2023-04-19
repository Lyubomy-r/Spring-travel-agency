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
    <!-- Animated navbar-->
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
                            <a class="nav-link" href="${pageContext.request.contextPath}/management/managerPage">Manager Page</a>
                        </li>
                    </security:authorize>
                    <security:authorize access="hasAnyAuthority('developers:red','developers:write')">
                        <li class="nav-item">
                            <form:form  action="${pageContext.request.contextPath}/api/logout"
                                        method="POST">
                                <button type="submit"  class="btn btn-rounded nav-link  " data-mdb-ripple-color="#000000">Logout</button>
                            </form:form>

                        </li>
                    </security:authorize>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/showMyLoginPage">Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/api/register">Register</a>
                    </li>
                </ul>


            </div>
        </div>
    </nav>
    <!-- Animated navbar -->


</header>

<body>
<!-- Background image -->
<div
        id="intro"
        class="bg-image"
        style="
              background-image: url(https://preview.colorlib.com/theme/direngine/images/bg_5.jpg.webp);
              height: 100vh;
              background-size: cover;
              background-repeat: no-repeat;
              background-position: center center;
              height: 785px;
              "
>
    <div class="mask  position-absolute top-50 start-50 translate-middle w-100" style="background-color: rgba(0, 0, 0, 0.5)">
        <div class="container d-flex align-items-center text-center h-100">
            <div>

                <div class="card-group ">
                    <div class="row row-cols-2 row-cols-md-4 mt-3 mb-4 g-4">

                        <div class="card text-center ">

                            <div class="card-body h-100">
                                <form:form action="freeHotel"  method="POST">

                                    <table>
                                        <tbody >
                                        <div class="input-group mb-3 mt-5">

                                            <button type="button" class="btn btn-outline-primary"
                                                    style="    color: #7499d1;
                                                        border-color: #7499d1;">Hotel Name:
                                            </button>
                                            <select  name="searchCountry" id="disabledSelect" class="form-select"   class="btn btn-outline-primary dropdown-toggle dropdown-toggle-split"
                                                     data-mdb-toggle="dropdown"
                                                     aria-expanded="false"> <span class="visually-hidden">Toggle Dropdown</span>
                                                <c:forEach var="theCountryList" items="${countryList}">
                                                    <option value="${theCountryList.nameHotel}" label="${theCountryList.nameHotel}" class="form-select"/>
                                                </c:forEach>

                                            </select>


                                        </div>

                                        <div class="input-group mb-3">
                                            <input type="date" class="form-control"  aria-label="Text input with segmented dropdown button" name="arrivalDate"  />
                                            <button type="button" class="btn btn-outline-primary"
                                                    style=" color: #7499d1;
                                                        border-color: #7499d1;">Date Arrive:
                                            </button>


                                        </div>
                                        <div class="input-group mb-5">
                                            <button type="button" class="btn btn-outline-primary"
                                                    style=" color: #7499d1;
                                                        border-color: #7499d1;">Departure Date
                                            </button>
                                            <input type="date" class="form-control"
                                                   aria-label="Text input with segmented dropdown button" name="departureDate" />
                                        </div>

                                        <div class="card-footer  mx-auto mt-5"></div>

                                        <input type="submit" class="btn btn-primary mt-3" data-mdb-ripple-color="#f3f2f2"
                                               style="background-color: #7499d1;
                                                       border-color: #7499d1;" value="Search free rooms">

                                        </tbody>
                                    </table>
                                </form:form>
                            </div>

                        </div>

                        <c:forEach var="hotelInf" items="${countryList}">


                            <c:url var="SearchRoom" value="/api/showFormSearch">
                                <c:param name="hotelId" value="${hotelInf.hotelId}"/>
                            </c:url>
                            <div class="col">
                                <div class="card h-100">

                                    <img src="<c:url value="/resources/photo/hotel${hotelInf.hotelId}.jpeg"></c:url>/" class="card-img-top" alt="Hollywood Sign on The Hill"/>
                                    <div class="card-body">
                                        <h5 class="card-title">${hotelInf.nameHotel}</h5>
                                        <p class="card-text">
                                                ${hotelInf.description}
                                        </p>
                                    </div>
                                    <div class="card-footer">
                                        <small class="text-muted">Last updated 3 mins ago</small>
                                    </div>
                                </div>
                            </div>


                        </c:forEach>

                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
<!-- Background image -->

</body>
</html>
