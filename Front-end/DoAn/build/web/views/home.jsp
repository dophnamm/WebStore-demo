<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="mytag" uri="/WEB-INF/my-tag.tld" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>E-SHOP Việt Nam</title>
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
            <div id="home">
                <!-- container -->
                <div class="container">
                    <!-- home wrap -->
                    <div class="home-wrap">
                        <!-- home slick -->
                        <div id="home-slick">
                        <c:forEach items="${quangcao}" var="qc">
                            <div class="banner banner-1">
                                <img src="${qc.anh}" height="600px">
                                <div class="banner-caption text-center">
                                    <button onclick="location.href = 'detailquangcao.htm?maQc=${qc.maQc}'" class="primary-btn">Chi tiết</button>
                                </div>
                            </div>
                        </c:forEach>

                        <!-- /banner -->
                    </div>
                    <!-- /home slick -->
                </div>
                <!-- /home wrap -->
            </div>
        </div>
        <!-- /HOME -->

        <!-- section -->
        <div class="section">
            <!-- container -->
            <div class="container">
                <!-- row -->
                <div class="row">
                    <!-- banner -->
                    <div class="col-md-4 col-sm-6">
                        <a class="banner banner-1" href="getAo.htm">
                            <img src="https://i.a4vn.com/2018/9/13/bst-nhung-mau-ao-khoac-phao-ngan-hot-mua-dong-2018-7b248f.jpg" height="275px" alt="">
                            <div class="banner-caption text-center">
                                <h2 class="white-color">Áo Đông</h2>
                            </div>
                        </a>
                    </div>
                    <!-- /banner -->

                    <!-- banner -->
                    <div class="col-md-4 col-sm-6">
                        <a class="banner banner-1" href="getGiay.htm">
                            <img src="/DoAn/views/img/banner11.jpg" height="275px" alt="">
                            <div class="banner-caption text-center">
                                <h2 class="white-color">Giày sneaker</h2>
                            </div>
                        </a>
                    </div>
                    <!-- /banner -->

                    <!-- banner -->
                    <div class="col-md-4 col-md-offset-0 col-sm-6 col-sm-offset-3">
                        <a class="banner banner-1" href="getQuan.htm">
                            <img src="http://velvet.vn/files/tin/178/jpg/quan-jogger-bo-gan-age2x.jpg" height="275px" alt="">
                            <div class="banner-caption text-center">
                                <h2 class="white-color">Quần Jogger</h2>
                            </div>
                        </a>
                    </div>
                    <!-- /banner -->
                </div>
                <!-- /row -->
            </div>
            <!-- /container -->
        </div>



        <!-- /section -->
        <div class="section">
            <!-- container -->
            <div class="container">
                <!-- row -->
                <div class="row">
                    <!-- section title -->
                    <div class="col-md-12">
                        <div class="section-title">
                            <h2 class="title">Sản phẩm</h2>
                        </div>
                    </div>
                    <!-- section title -->
                    <c:forEach items="${sanpham}" var="s">
                        <!-- Product Single -->
                        <div class="col-md-3 col-sm-6 col-xs-6">
                            <div class="product product-single">
                                <div class="product-thumb">
                                    <button value="Chi tiết" class="main-btn quick-view" onclick="location.href = 'detailsanpham.htm?maSp=${s.maSp}'"><i class="fa fa-search-plus"></i> Chi tiết</button>
                                    <img src="${s.anh}" width="200px" height="310px" alt="">
                                </div>
                                <div class="product-body">
                                    <h3 class="product-price colortext"> <fmt:formatNumber value="${s.gia}"/> </h3>
                                    <h3 class="product-price"> <del class="product-old-price">VNĐ</del></h3>
                                    <div class="product-rating">
                                        <a class="fa fa-star" href="yeuthich.htm?maSp=${s.maSp}&soSao=1"></a>
                                        <a class="fa fa-star" href="yeuthich.htm?maSp=${s.maSp}&soSao=2"></a>
                                        <a class="fa fa-star" href="yeuthich.htm?maSp=${s.maSp}&soSao=3"></a>
                                        <a class="fa fa-star" href="yeuthich.htm?maSp=${s.maSp}&soSao=4"></a>
                                        <a class="fa fa-star" href="yeuthich.htm?maSp=${s.maSp}&soSao=5"></a>
                                    </div>
                                    <h2 class="product-name colorname">${s.tenSp}</a></h2>
                                    <div class="product-btns" >
                                        <% if (session.getAttribute("ten") != null) {%>
                                        
                                        <button class="main-btn icon-btn" onclick="location.href = 'uathich.htm?maSp=${s.maSp}&maKh=<%=session.getAttribute("ma")%>'"><i class="fa fa-heart"></i></button>
                                            <% } else { %>

                                        <% }%>
                                        <button onclick="location.href = 'add.htm?maSp=${s.maSp}'" class="primary-btn add-to-cart" ><i class="fa fa-shopping-cart"></i> Thêm giỏ hàng</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>

                <div class="row">
                    <div class="col-md-12 col-sm-12" style="text-align: right"></div>
                </div>
                <br>
                <div class="keys" style="display: none" title="/shop">
                    <span>2</span><span>3</span><span>4</span>
                </div>
                <div style=" text-align: center ;padding-right: 20px">
                    <mytag:my_tag steps="12" offset="${offset}" count="${numberProductDetail}"   uri="showsanpham.htm" next="&raquo;"   previous="&laquo;"/>
                </div>
                <!-- /Product Single -->
            </div>
        </div>
    </div>


    <!-- section -->
    <div class="section section-grey">
        <!-- container -->
        <div class="container">
            <!-- row -->
            <div class="row">
                <!-- banner -->
                <div class="col-md-8">
                    <div class="banner banner-1">
                        <img src="/DoAn/views/img/banner13.jpg" alt="">
                        <div class="banner-caption text-center">
                            <h1 class="primary-color">HOT DEAL<br><span class="white-color font-weak">Up to 50% OFF</span></h1>
                            <button class="primary-btn">Shop Now</button>
                        </div>
                    </div>
                </div>
                <!-- /banner -->

                <!-- banner -->
                <div class="col-md-4 col-sm-6">
                    <a class="banner banner-1" href="#">
                        <img src="/DoAn/views/img/banner11.jpg" alt="">
                        <div class="banner-caption text-center">
                            <h2 class="white-color">NEW COLLECTION</h2>
                        </div>
                    </a>
                </div>
                <!-- /banner -->

                <!-- banner -->
                <div class="col-md-4 col-sm-6">
                    <a class="banner banner-1" href="#">
                        <img src="/DoAn/views/img/banner12.jpg" alt="">
                        <div class="banner-caption text-center">
                            <h2 class="white-color">NEW COLLECTION</h2>
                        </div>
                    </a>
                </div>
                <!-- /banner -->
            </div>
            <!-- /row -->
        </div>
        <!-- /container -->
    </div>
    <div class="section">
        <!-- container -->
        <div class="container">
            <!-- row -->
            <div class="row">
                <!-- section-title -->
                <div class="col-md-12">
                    <div class="section-title">
                        <h2 class="title">Deals Of The Day</h2>
                        <div class="pull-right">
                            <div class="product-slick-dots-1 custom-dots"></div>
                        </div>
                    </div>
                </div>
                <!-- /section-title -->

                <!-- banner -->
                <div class="col-md-3 col-sm-6 col-xs-6">
                    <div class="banner banner-2">
                        <img src="/DoAn/views/img/banner14.jpg" alt="">
                        <div class="banner-caption">
                            <h2 class="white-color">NEW<br>COLLECTION</h2>
                            <button class="primary-btn">Shop Now</button>
                        </div>
                    </div>
                </div>
                <!-- /banner -->

                <!-- Product Slick -->
                <div class="col-md-9 col-sm-6 col-xs-6">
                    <div class="row">
                        <div id="product-slick-1" class="product-slick">
                            <!-- Product Single -->
                            <c:forEach items="${yeuthich}" var="yt">
                                <div class="product product-single">
                                    <div class="product-thumb">
                                        <div class="product-label">
                                            <span>New</span>
                                            <span class="sale">-20%</span>
                                        </div>
                                        <ul class="product-countdown">
                                            <li><span>00 H</span></li>
                                            <li><span>00 M</span></li>
                                            <li><span>00 S</span></li>
                                        </ul>
                                        <button class="main-btn quick-view"><i class="fa fa-search-plus"></i> Quick view</button>
                                        <img src="${yt.maSp.anh}" width="200px" height="310px" alt="">
                                    </div>
                                    <div class="product-body">
                                        <h3 class="product-price">$32.50 <del class="product-old-price">$45.00</del></h3>
                                        <div class="product-rating">
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star-o empty"></i>
                                        </div>
                                        <h2 class="product-name"><a href="#">${yt.maSp.tenSp}</a></h2>
                                        <div class="product-btns">
                                            <button class="main-btn icon-btn"><i class="fa fa-heart"></i></button>
                                            <button class="main-btn icon-btn"><i class="fa fa-exchange"></i></button>
                                            <button class="primary-btn add-to-cart"><i class="fa fa-shopping-cart"></i> Add to Cart</button>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                            <!-- /Product Single -->
                        </div>
                    </div>
                </div>
                <!-- /Product Slick -->
            </div>
        </div>
        <!-- /container -->
    </div>
    <!-- /section -->

    <!-- section -->

    <jsp:include page="footer.jsp" flush="true"></jsp:include>
    <script src="/DoAn/views/js/jquery.min.js"></script>
    <script src="/DoAn/views/js/bootstrap.min.js"></script>
    <script src="/DoAn/views/js/slick.min.js"></script>
    <script src="/DoAn/views/js/nouislider.min.js"></script>
    <script src="/DoAn/views/js/jquery.zoom.min.js"></script>
    <script src="/DoAn/views/js/main.js"></script>

</body>

</html>

