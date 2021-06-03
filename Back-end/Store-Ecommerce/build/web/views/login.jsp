<%-- 
    Document   : login
    Created on : Aug 6, 2019, 10:26:27 AM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Shop Quần Áo</title>

        <!-- Bootstrap Core CSS -->
        <link href="/DoAnTotNghiepAdmin/views/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- MetisMenu CSS -->
        <link href="/DoAnTotNghiepAdmin/views/assets/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="/DoAnTotNghiepAdmin/views/assets/dist/css/sb-admin-2.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="/DoAnTotNghiepAdmin/views/assets/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    </head>

    <body>

        <div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="login-panel panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Please Sign In</h3>
                        </div>
                        <div class="panel-body">
                            <form role="form" action="DangNhap.htm" method="get">
                                <fieldset>
                                    <h4>${msgSussess}</h4>
                                    <h4>${msgError}</h4>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Tên đăng nhập" name="taiKhoan" type="text" autofocus>
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Password" name="matKhau" type="password" value="">
                                    </div>
                                    <!-- Change this to a button or input when using this as a form -->
                                    <button class="btn btn-lg btn-success btn-block">Login</a>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- jQuery -->
        <script src="/DoAnTotNghiepAdmin/views/assets/vendor/jquery/jquery.min.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="/DoAnTotNghiepAdmin/views/assets/vendor/bootstrap/js/bootstrap.min.js"></script>

        <!-- Metis Menu Plugin JavaScript -->
        <script src="/DoAnTotNghiepAdmin/views/assets/vendor/metisMenu/metisMenu.min.js"></script>

        <!-- Custom Theme JavaScript -->
        <script src="/DoAnTotNghiepAdmin/views/assets/dist/js/sb-admin-2.js"></script>

    </body>

</html>

