<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="db.Items" %>
<%
    ArrayList<Items> items = (ArrayList<Items>) request.getAttribute("items");
%>
<html>
<head>
    <title>All Items</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</head>


<body style="background-color: #FFFFFF">


    <div class="container" style="width: 1000px">
        <%@include file="navbar.jsp"%>

        <div style="display: flex; flex-direction: column; align-items: center; margin-top: 30px;">
            <h2 style="font-weight: bold;">Welcome to BITLAB SHOP</h2>
            <p style="color: gray; margin-bottom: 30px">Electronic devices with high quality and service</p>
        </div>



        <div class="container text-center" style="margin-bottom: 50px">
            <div class="row row-cols-2 row-cols-lg-3 g-2 g-lg-4">

                <%
                    for (Items i: items) {
                %>

                <div class="col" style="margin-bottom: -15px;">
                    <div class="shadow p-4 mb-5 bg-white rounded">
                        <div>
                            <h5><%=i.getName()%></h5>
                        </div>
                        <div style="background-color: white">
                            <p style="font-size: large; color: #00894F; margin-top: 20px">$<%=i.getPrice()%></p>
                            <p style="margin-bottom: 0px"><%=i.getRamSize()%> GB RAM</p>
                            <p style="margin-bottom: 0px"><%=i.getMemory()%></p>
                            <p style="margin-bottom: 40px"><%=i.getDescription()%></p>
                            <button type="button" class="btn btn-success" style="width: 250px">Buy Now</button>
                        </div>
                    </div>
                </div>

                <%
                    }
                %>

            </div>
        </div>



    </div>

</body>
</html>
