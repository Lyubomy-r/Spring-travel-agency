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
                    <security:authorize access="hasAnyAuthority('developers:red')">
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/api/userName">My Reserved</a>

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

    <!-- Background image -->
    <div
            id="intro"
            class="bg-image"
            style="
              background-image: url(https://preview.colorlib.com/theme/direngine/images/bg_1.jpg.webp);
              height: 100vh;
              background-size: cover;
              background-repeat: no-repeat;
              background-position: center center;
              /*height: 785px;*/
              "
    >
        <div class="mask text-white position-absolute top-50 start-50 translate-middle w-100" style="background-color: rgba(0, 0, 0, 0.5)">
            <div class="container d-flex align-items-center text-center h-100">
                <div>

                    <h1 class="mb-4 mt-3">Travel Agency</h1>
                    <h4 class="mb-3">Let's Start Choose Country :</h4>

                    <form:form action="${pageContext.request.contextPath}/api/showHotelInCountry"  method="POST">

                        <div class="row gx-1 d-flex justify-content-center ">


                            <div class="col-2 g-col-md-4 ">

                                <button type="submit" class="btn btn-primary" style="background-color: #f85959;
                                                    border-color: #f85959;">Choose Country :</button>

                            </div>


                            <div class="col-2 g-col-md-4 ">

                                <select  name="searchCountry" id="disabledSelect" class="form-select" >
                                    <c:forEach var="theCountryList" items="${countryList}">
                                        <option value="${theCountryList}" label="${theCountryList}"
                                                class="form-select"/>
                                    </c:forEach>

                                </select>
                            </div>



                        </div>

                    </form:form>
                    <p class="mt-3" >
                        Lorem ipsum dolor, sit amet consectetur adipisicing elit. Officiis molestiae
                        laboriosam numquam expedita ullam saepe ipsam, deserunt provident corporis,
                        sit non accusamu!
                        Explore
                        your amazing city
                        Find great places to stay, eat, shop, or visit from local experts
                    </p>
                </div>
            </div>
        </div>
    </div>
    <!-- Background image -->
</header>

<body>


</body>
</html>
