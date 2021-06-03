<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>E-SHOP HTML Template</title>
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
    <div class="section">
        <!-- container -->
        <div class="container">
            <!-- row -->
            <div class="row">
                <!--  Product Details -->
                <div class="product product-details clearfix">
                    <div class="col-md-12">
                        <div class="product-body">
                            <table>  
                                <tr>
                                    <td><h1 class="product-name"> Tên Khách Hàng:</h1></td>
                                    <td><h1 class="product-name">&nbsp; </h1></td>
                                    <td><h1 class="product-name">${khachHang.tenKh}</h1></td>

                                </tr>
                                <tr>
                                    <td><h5 class="product-price">Tên Tài Khoản:</h5></td>
                                    <td><h1 class="product-name">&nbsp; </h1></td>
                                    <td><h5 class="product-price">${khachHang.tenTk}</h5></td>

                                </tr>
                                <tr>
                                    <td><h5 class="product-price">Địa chỉ:</h5></td>
                                    <td><h1 class="product-name">&nbsp; </h1></td>
                                    <td><h5 class="product-price">${khachHang.diaChi}</h5></td>

                                </tr>
                                <tr>
                                    <td><h5 class="product-price">Số Điện Thoại:</h5></td>
                                    <td><h1 class="product-name">&nbsp; </h1></td>
                                    <td><h5 class="product-price">${khachHang.soDienThoai}</h5></td>

                                </tr>
                                <tr>
                                    <td><h5 class="product-price">Email:</h5></td>
                                    <td><h1 class="product-name">&nbsp;</h1></td>
                                    <td><h5 class="product-price">${khachHang.email}</h5></td>
                                </tr>
                            </table>
                            <div class="product-btns">
                                <button class="primary-btn add-to-cart" onclick="location.href = 'capnhapkhachhang.htm?maKh=<%=session.getAttribute("ma")%>'">Sửa thông tin đặt hàng</button>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /Product Details -->
            </div>
            <!-- /row -->
        </div>
        <!-- /container -->
    </div>

    <jsp:include page="footer.jsp" flush="true"></jsp:include>
    <script src="/DoAn/views/js/jquery.min.js"></script>
    <script src="/DoAn/views/js/bootstrap.min.js"></script>
    <script src="/DoAn/views/js/slick.min.js"></script>
    <script src="/DoAn/views/js/nouislider.min.js"></script>
    <script src="/DoAn/views/js/jquery.zoom.min.js"></script>
    <script src="/DoAn/views/js/main.js"></script>

</body>

</html>

