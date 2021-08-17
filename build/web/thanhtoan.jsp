<%-- 
    Document   : thanhtoan
    Created on : Nov 5, 2019, 10:23:40 AM
    Author     : Asus
--%>

<%@page import="util.SessionHelper"%>
<%@page import="model.Accounts"%>
<%@page import="model.DonHang"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thanh toán</title>
        <link href="list.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <%
            Accounts account = SessionHelper.getAccountFromSession(session);
            String cname = (String) session.getAttribute("cname");
            String cmt = (String) session.getAttribute("cmt");
            String sdt = (String) session.getAttribute("sdt");
            String xid = (String) session.getAttribute("xid");
            String tong_ngay_thue = (String) session.getAttribute("tong_ngay_thue");
            String did = (String) session.getAttribute("did");
            String dia_chi_nhan = (String) session.getAttribute("dia_chi_nhan");
            String ghi_chu = (String) session.getAttribute("note");

            String tien_dv = (String) session.getAttribute("tien_dv");
            DonHang dh = (DonHang) request.getAttribute("don_hang");
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

        <form action="thanhtoan" method="post">
            <input type="hidden" value="<%= cname%>" name="cname"/>
            <input type="hidden" value="<%= cmt%>" name="cmt"/>
            <input type="hidden" value="<%= sdt%>" name="sdt"/>
            <input type="hidden" value="<%= xid%>" name="xid"/>
            <input type="hidden" value="<%= tong_ngay_thue%>" name="tong_ngay_thue"/>
            <input type="hidden" value="<%= did%>" name="did"/>
            <input type="hidden" value="<%= dia_chi_nhan%>" name="dia_chi_nhan"/>
            <input type="hidden" value="<%= ghi_chu%>" name="ghi_chu"/>
            <table class="table" id="tbl-chitiet" align="center">
                <tr>
                    <td colspan="2" align=center><b>Thanh toán</b></td>

                </tr>
                <tr>
                    <td align="right">Tổng tiền thuê xe</td>
                    <td><p><%= dh.getTong_thue_xe()%></p></td>
                </tr>
                <tr>
                    <td align="right">Tổng tiền dịch vụ</td>
                    <td><p><%= tien_dv%></p></td>
                </tr>
                <tr>
                    <td align="right">Tổng tiền phải thanh toán</td>
                    <td><p><%= dh.getDon_gia()%></p></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <br>
                        <a href="list">
                            <button type="button" class="btn btn-lg btn-primary">Xác nhận thanh toán</button>
                        </a>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
