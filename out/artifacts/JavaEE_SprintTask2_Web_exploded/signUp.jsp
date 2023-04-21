<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="db.Users" %>
<html>
<head>
    <title>Sign Up</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</head>

<body>

  <div class="container" style="width: 1000px">

      <%@include file="navbar.jsp"%>



      <div style="padding: 20px; display: flex; flex-direction: column; align-items: center;">
          <h1 style="margin-bottom: 20px">Sign Up</h1>

          <% if (request.getAttribute("error") != null) { %>
          <div class="alert alert-danger alert-dismissible fade show" role="alert" style="width: 820px;">
              <%= request.getAttribute("error") %>
              <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
          </div>
          <% } %>

          <form action="/sign_up" method="post">

              <div class="mb-4 mt-3">
                  <label for="exampleFormControlInput1" class="form-label"><strong>FULL NAME</strong></label>
                  <input type="text" class="form-control" id="exampleFormControlInput1" name="full_name" placeholder="Full name">
              </div>

              <div class="mb-4 mt-3">
                  <label for="exampleFormControlInput1" class="form-label"><strong>EMAIL ADDRESS</strong></label>
                  <input type="email" class="form-control" id="exampleFormControlInput2" placeholder="name@example.com" name="email">
              </div>

              <% if (request.getAttribute("password_error") != null) { %>
              <div class="alert alert-danger alert-dismissible fade show" role="alert" style="width: 820px;">
                  <%= request.getAttribute("password_error") %>
                  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
              </div>
              <% } %>

              <label for="inputPassword5" class="form-label"><strong>PASSWORD</strong></label>
              <input type="password" id="inputPassword5" class="form-control" aria-labelledby="passwordHelpBlock" name="password" placeholder="Password">
              <div id="passwordHelpBlock" class="form-text" style="margin-bottom: 30px">
                  Your password must be 8-20 characters long, contain letters and numbers, and must not contain spaces, special characters, or emoji.
              </div>


              <label for="inputPassword5" class="form-label"><strong>REPEAT PASSWORD</strong></label>
              <input style="margin-bottom: 30px" type="password" id="inputPassword6" class="form-control" aria-labelledby="passwordHelpBlock" name="repeat_password" placeholder="Repeat password">


              <button class="btn btn-success" style="width: 150px;">Sign up</button>
          </form>
      </div>




  </div>


</body>
</html>
