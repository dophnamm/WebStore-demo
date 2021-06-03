
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <form action="searchbooks.htm" method="get">
            Search: <input type="text" name="title" />
        </form>
        <a href="insertbooks.htm">Them moi</a>
        <table border="1">
            <tr>
                <td>Ten Sp</td>
                <td>Anh Sp</td>
                <td>Gia</td>
                <td>Nha san xuat</td>
                <td>Mo ta</td>
                <td>Xóa</td>
                <td>Chi tiết</td>
                <td>Update</td>
            </tr>
            <c:forEach items="${sanpham}" var="s">
                <tr>
                    <td>${s.tenSp}</td>
                    <td><img src="${s.anh}" width="100"></td>
                    <td>${s.gia}</td>
                    <td>${s.nhaSanXuat}</td>
                    <td>${s.mota}</td>
                    
                    <td>
                        <a href="deleteBooks.htm?bookId=${b.maSp}" onclick="return confirm('Ban chac chan muon xoa?')">delete</a>
                    </td>
                    <td>
                        <a href="detailBooks.htm?bookId=${b.maSp}">Detail</a>
                    </td>
                    <td>
                        <a href="updateBooks.htm?bookId=${b.maSp}">Update</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
