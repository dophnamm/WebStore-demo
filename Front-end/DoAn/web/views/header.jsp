<%-- 
    Document   : header
    Created on : Jul 18, 2019, 2:01:05 PM
    Author     : nguye
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- top Header -->
<div id="top-header">
    <div class="container">
        <div class="pull-left">
            <span>Chào mừng đến với E-Shop</span>
        </div>
    </div>
</div>
<div id="header">
    <div class="container">
        <div class="pull-left">
            <form action="searchsanpham.htm" method="get">
                Tìm kiếm: <input class="input search-input" type="text" name="tensp" placeholder="Nhập từ khóa">
            </form>
        </div>
        <div class="pull-right">
            <ul class="header-btns">
                <!-- Account -->
                <li class="header-account dropdown default-dropdown">
                    <div class="dropdown-toggle" role="button" data-toggle="dropdown" aria-expanded="true">
                        <div class="header-btns-icon">
                            <i class="fa fa-user-o"></i>
                        </div>
                        <% if (session.getAttribute("ten") != null) {%>
                        <strong class="text-uppercase"><%=session.getAttribute("ten")%> <i class="fa fa-caret-down"></i></strong>
                            <% } else { %>
                        <strong class="text-uppercase">Tài khoản</strong>
                            <% } %>
                    </div>

                    <% if (session.getAttribute("ten") != null) {%>
                    <a href="dangxuat.htm" class="text-uppercase">Đăng xuất</a>
                    <% } else { %>
                    <a href="loginuser.htm" class="text-uppercase"><h6>Đăng nhập</h6></a>
                    <% }%>

                    <% if (session.getAttribute("ten") != null) {%>
                    <ul class="custom-menu">
                        <li><a href = "thongtinkhachhang.htm?maKh=<%=session.getAttribute("ma")%>"><i class="fa fa-user-o"></i> Tài khoản của tôi</a></li>
                        <li><a href = "donhangkhachhang.htm?maKh=<%=session.getAttribute("ma")%>"><i class="fa fa-check"></i> Đơn hàng của tôi</a></li>
                        <li><a href = "danhsachuathich.htm?maKh=<%=session.getAttribute("ma")%>"><i class="fa fa-heart-o"></i> Yêu thích của bạn</a></li>
                    </ul>
                    <% } else { %>
                    <strong class="text-uppercase"></strong>
                    <% }%>

                </li>
                <!-- /Account -->

                <!-- Cart -->

                <jsp:include page="cart.jsp" flush="true"></jsp:include>

                <!-- /Cart -->

                <!-- Mobile nav toggle-->
                <li class="nav-toggle">
                    <button class="nav-toggle-btn main-btn icon-btn"><i class="fa fa-bars"></i></button>
                </li>
                <!-- / Mobile nav toggle -->
            </ul>
        </div>
    </div>
    <!-- header -->
</div>
<!-- container -->