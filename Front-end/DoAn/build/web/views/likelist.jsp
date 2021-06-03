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
            <div id="navigation">
                <!-- container -->
                <div class="container">
                    <div id="responsive-nav">
                        <!-- category nav -->
                        <div class="category-nav show-on-click">
                            <span class="category-header">Categories <i class="fa fa-list"></i></span>
                            <ul class="category-list">
                            <c:forEach var="item" items="${nhomsanpham}">
                                <li class="dropdown side-dropdown">
                                    <a onclick="location.href = 'searchbynhomsp.htm?maNhomSp=${item.maNhomSp}'" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">${item.tenNhomSp}<i class="fa fa-angle-right"></i></a>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
                <div class="menu-nav">
                    <span class="menu-header">Menu <i class="fa fa-bars"></i></span>
                    <ul class="menu-list">
                        <li><a href="redirect.jsp">Home</a></li>
                        <li><a href="#">Shop</a></li>
                        <li><a href="#">Sales</a></li>
                        <li class="dropdown default-dropdown"><a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">Pages <i class="fa fa-caret-down"></i></a>
                            <ul class="custom-menu">
                                <li><a href="redirect.jsp">Home</a></li>
                                <li><a href="products.html">Products</a></li>
                                <li><a href="product-page.html">Product Details</a></li>
                                <li><a href="checkout.html">Checkout</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
                <!-- menu nav -->
            </div>
        </div>
        <!-- /container -->
    </div>
    <!-- /NAVIGATION -->
    <!-- section -->

    <!------ Include the above in your HEAD tag ---------->

    <div class="container chitietdonhang">
        <% if (session.getAttribute("sanphamuathich") != null) {%>
        <table class="shopping-cart-table table">
            <thead>
                <tr>
                    <th class="text-center">Ảnh</th>
                    <th class="text-center">Tên Sản phẩm</th>
                    <th class="text-center">Nhà sản xuất</th>
                    <th class="text-center">Giá </th>
                    <th></th>
                    <th class="text-center">Giỏ hàng</th>
                    <th class="text-center">Xóa</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${sanphamuathich}" var="sput">
                    <tr>
                        <td class="thumb text-center"><img src="${sput.maSp.anh}" alt=""></td>
                        <td class="price text-center"><strong>${sput.maSp.tenSp}</strong><br><del class="font-weak"></del></td>
                        <td class="price text-center"><strong>${sput.maSp.maNcc.tenNcc}</strong><br><del class="font-weak"></del></td>
                        <td class="total text-center"><strong class="primary-color">${sput.maSp.gia}</strong></td>
                        <td class="text-center"><a href = "detailsanpham.htm?maSp=${sput.maSp.maSp}">Chi tiết sản phẩm</a></td>
                        <td class="text-center"><button class="main-btn icon-btn" onclick="location.href = 'addlikelisttocart.htm?maSp=${sput.maSp.maSp}&maUt=${sput.maUt}&maKh=<%=session.getAttribute("ma")%>'"><i class="fa fa-truck"></i></button></td>
                        <td class="text-center"><button class="main-btn icon-btn" onclick="location.href = 'removelikelist.htm?maUt=${sput.maUt}&maKh=<%=session.getAttribute("ma")%>'"><i class="fa fa-close"></i></button></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <% } else { %>
        <div class="text-center">
        <h3 class="color">Không có sản phẩm nào được yêu thích</h3>
        <a href="redirect.jsp" ><img src="https://cdn.pixabay.com/photo/2017/02/07/18/20/heart-2046689_960_720.png" width="150px" height="150px" /></a>
            </div>
        <% }%>
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
