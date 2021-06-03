<%-- 
    Document   : cart
    Created on : Jul 20, 2019, 9:24:07 PM
    Author     : PC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<li class="header-cart dropdown default-dropdown">
    <a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
        <div class="header-btns-icon">
            <i class="fa fa-shopping-cart"></i>
            <span class="qty">${sessionScope.myCartNum}</span>
        </div>
        <strong class="text-uppercase">Giỏ Hàng:</strong>
        <br>
        <span></span>
    </a>

    <div class="custom-menu">
        <div id="shopping-cart">
            <div class="shopping-cart-list">
                <c:forEach var="map" items="${sessionScope.myCartItems}">
                    <div class="product product-widget">
                        <div class="product-thumb">
                            <img src="${map.value.sanPham.anh}" alt="">
                        </div>
                        <div class="product-body">
                            <h3 class="product-price">$${map.value.sanPham.gia}</h3>
                            <h5>Số lượng: <span>${map.value.soLuong}</span></h5>
                            <h2 class="product-name"><a href="#">${map.value.sanPham.tenSp}</a></h2>
                        </div>
                        <button class="cancel-btn" onclick="location.href = 'removehome.htm?maSp=${map.value.sanPham.maSp}'"><i class="fa fa-trash"></i></button>
                    </div>
                </c:forEach>
            </div>
            <div class="shopping-cart-btns">
                <a onclick="location.href='checkout.htm'" class="primary-btn" >Checkout <i class="fa fa-arrow-circle-right"></i></a>
            </div>
        </div>
    </div>
</li>