<%-- 
    Document   : list
    Created on : Oct 25, 2019, 11:15:59 AM
    Author     : Asus
--%>

<%@page import="model.Xe"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.LoaiXe"%>
<%@page import="util.SessionHelper"%>
<%@page import="model.Accounts"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danh sách đặt xe</title>
        <link href="list.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <%
            Accounts account = SessionHelper.getAccountFromSession(session);
            ArrayList<Xe> listXe = (ArrayList<Xe>) request.getAttribute("xe");
            ArrayList<LoaiXe> loaixe = (ArrayList<LoaiXe>) request.getAttribute("loaixe");
            Integer id = (Integer) request.getAttribute("id");
            String year = (String) request.getAttribute("year");
            String month = (String) request.getAttribute("month");
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
                    <li class="nav-item">
                        <a class="nav-link" href="thuchi?month=<%= month%>&year=<%= year%>">Quản lí thu chi</a>
                    </li>
                </ul>
                <span class="navbar-text">
                    You are logged in as <%=account.getUserName()%>(<a href="logout">Logout</a>)
                </span>
            </div>
        </nav>
        <!--Header-->   
        <br><br>
        <form action="list" method="get" id="frm" align="center">
            <b>Xem theo loại xe:</b> <select name="id" onchange="document.getElementById('frm').submit();">
                <option value="0">---------ALL---------</option>
                <%for (LoaiXe d : loaixe) {
                %>
                <option <%=(d.getId() == id) ? "selected" : ""%> value="<%=d.getId()%>" ><%=d.getTen()%></option>
                <%}%>
            </select>  
        </form>
        <br>

        <table class="table" id="tbl">
            <thead id="thead">
                <tr>
                    <th scope="col">Nhãn hiệu</th>
                    <th scope="col">Biển số</th>
                    <th scope="col">Trạng thái</th>
                    <th scope="col">Giá thuê theo ngày</th>
                    <th scope="col"></th>
                    <th scope="col"></th>
                </tr>
            </thead>
            <tbody>
                </tr>
                <%for (Xe x : listXe) {%>
                <tr>
            <input type="hidden" value="<%=x.getId()%>" />
            <td><b><%=x.getNhan_hieu()%></b></td>
            <td><%=x.getBien_so()%></td>
            <td><%=x.isTrang_thai() ? "Đã thuê" : "Chưa thuê"%></td>
            <td><%=x.getLoai_xe().getGia_thue_1_ngay()%></td>
            <td>
                <a href="chitiet?id=<%=x.getId()%>">
                    <button type="submit" class="btn btn-lg btn-primary" <%=x.isTrang_thai() ? "disabled" : ""%>>Đặt xe</button>
                </a>
            </td>
            <td>
                <a href="traxe?xid=<%=x.getId()%>">
                    <button type="button" class="btn btn-lg btn-primary" <%=x.isTrang_thai() ? "" : "disabled"%>>Trả xe</button>
                </a>
            </td>
        </tr>
        <%}%>
    </tbody>
</table>
</body>
</html>
