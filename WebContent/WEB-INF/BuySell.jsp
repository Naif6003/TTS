<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
 
    <title>Buy and Sell</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet">

    <script src="http://code.jquery.com/jquery.js"></script>
    <script src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
    <link href="Bootstrap/css/style.css" rel="stylesheet">

    <!-- Bootstrap Core CSS -->
    <link href="bootstrap/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Le styles -->
    <link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet">

    <script src="http://code.jquery.com/jquery.js"></script>
    <script src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
    <link href="bootstrap/css/style.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="bootstrap/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>

    <!-- Theme CSS -->
    <link href="bootstrap/css/agency.min.css" rel="stylesheet">
</head>
<body id="page-top" class="index">

<!-- Navigation -->
    <nav id="mainNav" class="">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand" href="TTS">Trusted Trading Service</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li>
                        <a class="page-click" href="Services">Services</a>
                    </li>
                     <li>
                        <a class="page-click" href="ShoppingCart">Shopping Cart</a>
                    </li>
                    <li>
                        <a class="page-click" href="Buying_selling">Buy, Sell</a>
                    </li>
                    <li>
                        <a class="page-click" href="About">About</a>
                    </li>
                    <li>
                        <a class="page-click" href="Team">Team</a>
                    </li>
                    <li>
              <c:choose>
            <c:when test="${sessionScope.foundUser}"> 
                 <a class="page-click" href="Logout">Logout</a>
                </c:when>
                <c:otherwise>
                 <a class="page-click" href="TheLogin">Login</a>
                </c:otherwise>
                </c:choose>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>



    <span id=list></span>
      <!-- Example row of columns -->
      <div class="row-fluid">
        <ul class="thumbnails">
		 	<c:forEach items="${items}" var="item" varStatus="loop">
       			<li class="span3">
            	<div class="thumbnail">
             	<img alt="230x200"  src='${item.itemPhoto}'>
             	 <div class="caption">
      			<h3>${item.itemName}</h3>
      			<p>${item.itemDescription}</p>
      			<p><a href="Checkout" class="btn btn-primary">Add To Cart</a> <a href="ViewItem?id=${item.itemId}" class="btn">View</a></p>
            </div>
            </div>
          </li>
		</c:forEach>
        </ul>
      </div>
    

      <hr>

      <div class="footer">
        <p>&copy; Trading Services 2016</p>
      </div>


    </div> <!-- /container -->

        <!-- jQuery -->
    <script src="bootstrap/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="bootstrap/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>

    <!-- Contact Form JavaScript -->
    <script src="bootstrap/js/jqBootstrapValidation.js"></script>
    <script src="bootstrap/js/contact_me.js"></script>

    <!-- Theme JavaScript -->
    <script src="bootstrap/js/agency.min.js"></script>



</body>
</html>