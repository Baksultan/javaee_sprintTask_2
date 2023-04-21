<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>User Profile</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</head>
<body>

    <div class="container" style="width: 1000px">

        <%@include file="navbar.jsp"%>

        <div style="display: flex; flex-direction: column; align-items: center; margin-top: 60px">

            <h1>Hello <%= request.getAttribute("user") %></h1>
            <h5 style="font-weight: 400; font-size: 15px">This is your profile page</h5>

        </div>



    </div>


</body>
</html>
