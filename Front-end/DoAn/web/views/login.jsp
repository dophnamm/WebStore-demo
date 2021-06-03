<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>E-SHOP HTML Template</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <link href="https://fonts.googleapis.com/css?family=Hind:400,700" rel="stylesheet">
        <link type="text/css" rel="stylesheet" href="/DoAn/views/css/bootstrap.min.css" />
        <link type="text/css" rel="stylesheet" href="/DoAn/views/css/slick.css" />
        <link type="text/css" rel="stylesheet" href="/DoAn/views/css/slick-theme.css" />
        <link type="text/css" rel="stylesheet" href="/DoAn/views/css/nouislider.min.css" />
        <link rel="stylesheet" href="/DoAn/views/css/font-awesome.min.css">
        <link type="text/css" rel="stylesheet" href="/DoAn/views/css/style.css" />
    </head>
    <body>
        <header>
            <jsp:include page="header.jsp" flush="true"></jsp:include>
            </header>
        <jsp:include page="menu.jsp" flush="true"></jsp:include>
            <!-- menu nav -->
        </div>
    </div>
    <!-- /container -->
</div>
<!-- /NAVIGATION -->
<!-- section -->

<!------ Include the above in your HEAD tag ---------->

<div class="container">
    <div class="a">
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-login">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-6">
                            <a href="#" class="active" id="login-form-link">Login</a>
                        </div>
                        <div class="col-xs-6">
                            <a href="#" id="register-form-link">Register</a>
                        </div>
                    </div>
                    <hr>
                </div>
                <div class="panel-body">
                    <div class="row">

                        <div class="col-lg-12">
                        <f:form id="login-form" commandName="khachHang" action="dangnhap.htm" method="get" role="form" style="display: block;">
                            <div class="text-center">
                                <h4 class="color1">${msgsussessdk}</h4>
                                <h4 class="color" >${msg}</h4>
                                <h4 class="color" >${msgcheck}</h4>
                                <h4 class="color" >${msgcheck1}</h4>
                                <h5 class="color" >${msgchecktk}</h5>
                                <h5 class="color" >${msgcheckmk}</h5>
                            </div>
                            
                            <div class="form-group">
                                
                                <f:input type="text" path="tenTk" id="username" tabindex="1" class="form-control" placeholder="Username" value="" required="required"/>
                            </div>
                            <div class="form-group">
                                <f:input type="password" path="matKhau" id="password" tabindex="2" class="form-control" placeholder="Password" required="required"/>
                            </div>
                            <div class="form-group text-center">
                                <input type="checkbox" tabindex="3" class="" name="remember" id="remember">
                                <label for="remember"> Remember Me</label>
                            </div>
                            <div class="form-group">
                                <div class="row">
                                    <div class="col-sm-6 col-sm-offset-3">
                                        <f:button name="login-submit"  id="login-submit" tabindex="4" class="form-control btn btn-login">Login</f:button>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <div class="text-center">
                                                <a href="https://phpoll.com/recover" tabindex="5" class="forgot-password">Forgot Password?</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                        </f:form>

                        <f:form id="register-form" type="reset" commandName="khachHang" action="dangKyKhachHang.htm" method="post" role="form" style="display: none;">
                            
                            <div class="form-group">
                                <f:input minlenght="6" type="text" path="tenKh" id="username" tabindex="1" class="form-control" placeholder="Tên khách hàng" value="" required="required"/>
                            </div>
                                
                            <div class="form-group">
                                <f:input type="text" path="tenTk" id="username" tabindex="1" class="form-control" placeholder="Tên tài khoản" required="required"/>
                            </div>
                                
                            <div class="form-group">
                                <f:input type="password" path="matKhau" id="password" tabindex="1" class="form-control" placeholder="Mật khẩu" required="required"/>
                            </div>
                            <div class="form-group">
                                <f:input type="text" path="diaChi" id="username" tabindex="1" class="form-control" placeholder="Địa chỉ" value="" required="required"/>
                            </div>
                            <div class="form-group">
                                <f:input type="text" path="soDienThoai" id="username" tabindex="1" class="form-control" placeholder="Số điện thoại" value="" required="required"/>
                            </div>
                            <div class="form-group">
                                <f:input type="email" path="email" id="email" tabindex="1" class="form-control" placeholder="Email" value="" required="required"/>
                            </div>

                            <div class="form-group">
                                <div class="row">
                                    <div class="col-sm-6 col-sm-offset-3">
                                        <f:button name="register-submit" id="register-submit" tabindex="4" class="form-control btn btn-register" value="Register Now">Lưu</f:button>
                                        </div>
                                    </div>
                                </div>
                        </f:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>

<jsp:include page="footer.jsp" flush="true"></jsp:include>
<script src="/DoAn/views/js/jquery.min.js"></script>
<script src="/DoAn/views/js/bootstrap.min.js"></script>
<script src="/DoAn/views/js/slick.min.js"></script>
<script src="/DoAn/views/js/nouislider.min.js"></script>
<script src="/DoAn/views/js/jquery.zoom.min.js"></script>
<script src="/DoAn/views/js/main.js"></script>
<script>
    $(function () {

        $('#login-form-link').click(function (e) {
            $("#login-form").delay(100).fadeIn(100);
            $("#register-form").fadeOut(100);
            $('#register-form-link').removeClass('active');
            $(this).addClass('active');
            e.preventDefault();
        });
        $('#register-form-link').click(function (e) {
            $("#register-form").delay(100).fadeIn(100);
            $("#login-form").fadeOut(100);
            $('#login-form-link').removeClass('active');
            $(this).addClass('active');
            e.preventDefault();
        });

    });
</script>

</body>

</html>
