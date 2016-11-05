<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Trusted Trading Service (TTS)</title>

    <!-- Bootstrap Core CSS -->
    <link href="bootstrap/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="bootstrap/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>

    <!-- Theme CSS -->
    <link href="bootstrap/css/agency.min.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
     <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->


</head>

<body id="page-top" class="index">

    <!-- Navigation -->
    <nav id="mainNav" class="navbar navbar-default navbar-custom navbar-fixed-top">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand page-scroll" href="#page-top">Trusted Trading Service</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li>
                        <a class="page-click" href="Trade">Trade</a>
                    </li>
                    <li>
                        <a class="page-click" href="BuySell">Buy, Sell</a>
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
                 <li>
                        <a class="page-click" href="ShoppingCart">Shopping Cart</a>
                    </li>
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

    <!-- Header -->
    <header>
        <div class="container">
            <div class="intro-text">
            <c:choose>
            <c:when test="${sessionScope.foundUser}"> 
                <div class="intro-lead-in">Hello ${sessionScope.username}! We are</div>
                </c:when>
                <c:otherwise>
                <div class="intro-lead-in">Hello there! We are</div>
                </c:otherwise>
                </c:choose>
                <div class="intro-heading">Trusted Trading Services</div>
                <a href="Services" class="page-click btn btn-xl">Tell Me More</a>
            </div>
        </div>
    </header>

<footer>
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <span class="copyright">Copyright &copy; TTS 2016</span>
                </div>
                <div class="col-md-4">
                    <ul class="list-inline social-buttons">
                        <li><a href="#"><i class="fa fa-twitter"></i></a>
                        </li>
                        <li><a href="#"><i class="fa fa-facebook"></i></a>
                        </li>
                        <li><a href="#"><i class="fa fa-linkedin"></i></a>
                        </li>
                    </ul>
                </div>
                <div class="col-md-4">
                    <ul class="list-inline quicklinks">
                        <li><a href="#">Privacy Policy</a>
                        </li>
                        <li><a href="#">Terms of Use</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </footer>

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