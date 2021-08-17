<%-- 
    Document   : thuchi
    Created on : Nov 7, 2019, 4:20:51 PM
    Author     : Asus
--%>

<%@page import="util.SessionHelper"%>
<%@page import="model.Accounts"%>
<%@page import="model.DonHang"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý thu chi</title>
        <link href="list.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <%
            Accounts account = SessionHelper.getAccountFromSession(session);
            ArrayList<DonHang> list = (ArrayList<DonHang>) request.getAttribute("list");
            Float total = (Float) request.getAttribute("total");
        %>
    </head>
    <body>
        <!--Header-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="list">
                <img src="https://scontent.fhan2-4.fna.fbcdn.net/v/t1.15752-9/71806691_2363765837285721_8467827555083223040_n.png?_nc_cat=105&_nc_oc=AQmI3EbmGult4NTj5ic11dUKyzxaoNRmxflBjJXBZQg_kMvHXRYi7MMnKomFeRwkJUw&_nc_ht=scontent.fhan2-4.fna&oh=ff7841ac1e6307fcb5b77a965123cac5&oe=5DF37E1D" 
                     alt="logo" style="width:100px; height: 100px">
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarText">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="list">Danh sách đặt xe </a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Quản lí thu chi<span class="sr-only">(current)</span></a>
                    </li>
                </ul>
                <span class="navbar-text">
                    You are logged in as <%=account.getUserName()%>(<a href="logout">Logout</a>)
                </span>
            </div>
        </nav>
        <!--Header--> 
        <br><br>
        <form action="thuchi" method="get" align="center">
            <b>Chọn tháng: </b><select name ="month">
                <option value="1">Tháng 1</option>
                <%for (int i = 2; i <= 12; i++) {%>
                <option value="<%=i%>" <%= (i == Integer.parseInt(request.getParameter("month")) ? "selected" : "")%>>
                    Tháng <%=i%>
                </option>
                <%}%>
            </select>

            <b>Nhập năm: </b><input type="text" name="year" value="<%= request.getParameter("year")%>" maxlength="4" pattern="[0-9]+" required=""/>
            <input type="submit" value="Xem" />
            <br>
            <br>

            <table class="table table-striped" id="table-striped">
                <thead class="thead-thuchi">
                    <tr>
                        <th scope="col">Tên khách hàng</th>
                        <th scope="col">Ngày thuê</th>
                        <th scope="col">Xe thuê</th>
                        <th scope="col">Thời gian thuê</th>
                        <th scope="col">Đơn giá</th>
                    </tr>
                </thead>
                <tbody>
                    <%for (DonHang dh : list) {%>
                    <tr>
                        <td><%= dh.getCustomer().getName()%></td>
                        <td><%= dh.getNgay_thue()%></td>
                        <td><%= dh.getXe().getNhan_hieu()%></td>
                        <td><%= dh.getSo_ngay_thue()%> ngày</td>
                        <td><%= dh.getDon_gia()%></td>
                    </tr> 
                    <%}%>
                    <tr>
                        <th colspan="4" class="tong-thu">Tổng thu tháng <%= request.getParameter("month")%>/<%= request.getParameter("year")%> : </th>
                        <th class="tong-thu"><%= total%></th>
                    </tr>
                </tbody>
            </table><br>
            <a href="list"><button type="button" class="btn btn-lg btn-primary">Quay về danh sách đặt xe</button></a><br><br>
    </body>
</html>
