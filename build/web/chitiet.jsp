<%-- 
    Document   : chitiet
    Created on : Oct 28, 2019, 8:31:09 PM
    Author     : Asus
--%>

<%@page import="model.DichVu"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Xe"%>
<%@page import="util.SessionHelper"%>
<%@page import="model.Accounts"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chi tiết đơn hàng</title>
        <link href="list.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <%
            Accounts account = SessionHelper.getAccountFromSession(session);
            Xe x = (Xe) request.getAttribute("xe");
            ArrayList<DichVu> d = (ArrayList<DichVu>) request.getAttribute("dich_vu");
            String year = (String) request.getAttribute("year");
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
                    <li class="nav-item active">
                        <a class="nav-link" href="list">Danh sách đặt xe <span class="sr-only">(current)</span></a>
                    </li>
                </ul>
                <span class="navbar-text">
                    You are logged in as <%=account.getUserName()%>(<a href="logout">Logout</a>)
                </span>
            </div>
        </nav>
        <!--Header--> 

        <form action="chitiet" method="post">
            <table class="table" id="tbl-chitiet" align="center">
                <tr>
                    <td colspan="2" align=center class="title"><b>Thông tin khách hàng</b></td>
                </tr>
                <tr class="content">
                    <td align="right">Tên khách hàng</td>
                    <td><input type="text" name="cname" required=""/></td>
                </tr>
                <tr class="content">
                    <td align="right">Số CMT</td>
                    <td><input type="text" name="cmt" required=""/></td>
                </tr>
                <tr class="content">
                    <td align="right">Số điện thoại</td>
                    <td><input type="text" name="sdt" pattern="[0-9]+" maxlength="10" pattern="[0-9]+" required=""/></td>
                </tr>
                <tr class="content">
                    <td colspan="2" align=center class="title"><b>Thông tin xe</b></td>
                </tr>
                <tr class="content">
                    <td align="right">Tên xe<input type="hidden" name="xid" value="<%= x.getId() %>"/></td>
                    <td><%=x.getNhan_hieu()%></td>
                </tr>
                <tr class="content">
                    <td align="right">Ngày nhận xe</td>
                    <td><input type="text" id="getDate" name="ngay_nhan"/></td>
                </tr>
                <tr class="content">
                    <td align="right">Tổng ngày đặt xe</td>
                    <td><input type="number" min="0" name="tong_ngay_dat_xe" required=""/></td>
                </tr>
                <tr class="content">
                    <td align="right">Giá thuê trên 1 ngày</td>
                    <td><%=x.getLoai_xe().getGia_thue_1_ngay()%></td>
                </tr>
                <tr>
                    <td colspan="2" align=center class="title"><b>Thông tin dịch vụ</b></td>

                </tr>
                <tr class="content">
                    <td align="right">Tên dịch vụ</td>
                    <td>
                        <select name="did">
                            <%for (DichVu dv : d) {%>
                            <option value="<%= dv.getId()%>"><%= dv.getName()%></option>
                            <%}%>
                        </select>
                    </td>
                </tr>
                <tr class="content">
                    <td align="right">Địa chỉ nhận xe</td>
                    <td><input type="text" name="address_nhan_xe"/></td>
                </tr>
                <tr>
                    <td colspan="2" align=center class="title"><b>Ghi chú</b></td>
                </tr>
                <tr class="content">
                    <td colspan="2" align="center"><textarea cols="45" rows="2" name="note"></textarea></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <br>
                        <a href="thanhtoan">
                            <button type="submit" class="btn btn-lg btn-primary">Xác nhận</button>
                        </a>
                    </td>
                </tr>
            </table>
        </form>
    </body>
    <script>
        var n = new Date();
        var y = n.getFullYear();
        var m = n.getMonth() + 1;
        var d = n.getDate();
        document.getElementById("getDate").value = y + "/" + m + "/" + d;
    </script>
</html>
