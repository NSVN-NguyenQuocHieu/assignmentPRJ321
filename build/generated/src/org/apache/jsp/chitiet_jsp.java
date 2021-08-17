package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.DichVu;
import java.util.ArrayList;
import model.Xe;
import util.SessionHelper;
import model.Accounts;

public final class chitiet_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"list.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"></script>\n");
      out.write("        ");

            Accounts account = SessionHelper.getAccountFromSession(session);
            Xe x = (Xe) request.getAttribute("xe");
            ArrayList<DichVu> d = (ArrayList<DichVu>) request.getAttribute("dich_vu");
            String year = (String) request.getAttribute("year");
        
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!--Header-->\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\n");
      out.write("            <a class=\"navbar-brand\" href=\"list\">\n");
      out.write("                <img src=\"https://scontent.fhan2-4.fna.fbcdn.net/v/t1.15752-9/71806691_2363765837285721_8467827555083223040_n.png?_nc_cat=105&_nc_oc=AQmI3EbmGult4NTj5ic11dUKyzxaoNRmxflBjJXBZQg_kMvHXRYi7MMnKomFeRwkJUw&_nc_ht=scontent.fhan2-4.fna&oh=ff7841ac1e6307fcb5b77a965123cac5&oe=5DF37E1D\" \n");
      out.write("                     alt=\"logo\" style=\"width:100px; height: 100px\">\n");
      out.write("            </a>\n");
      out.write("            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarText\" aria-controls=\"navbarText\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("            </button>\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbarText\">\n");
      out.write("                <ul class=\"navbar-nav mr-auto\">\n");
      out.write("                    <li class=\"nav-item active\">\n");
      out.write("                        <a class=\"nav-link\" href=\"list\">Danh sách đặt xe <span class=\"sr-only\">(current)</span></a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link\" href=\"thuchi?month=1&year=");
      out.print( year);
      out.write("\">Quản lí thu chi</a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("                <span class=\"navbar-text\">\n");
      out.write("                    You are logged in as ");
      out.print(account.getUserName());
      out.write("(<a href=\"logout\">Logout</a>)\n");
      out.write("                </span>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("        <!--Header--> \n");
      out.write("\n");
      out.write("        <form action=\"chitiet\" method=\"post\">\n");
      out.write("            <table class=\"table\" id=\"tbl-chitiet\" align=\"center\">\n");
      out.write("                <tr>\n");
      out.write("                    <td colspan=\"2\" align=center class=\"title\"><b>Thông tin khách hàng</b></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr class=\"content\">\n");
      out.write("                    <td align=\"right\">Tên khách hàng</td>\n");
      out.write("                    <td><input type=\"text\" name=\"cname\" required=\"\"/></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr class=\"content\">\n");
      out.write("                    <td align=\"right\">Số CMT</td>\n");
      out.write("                    <td><input type=\"text\" name=\"cmt\" required=\"\"/></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr class=\"content\">\n");
      out.write("                    <td align=\"right\">Số điện thoại</td>\n");
      out.write("                    <td><input type=\"text\" name=\"sdt\" pattern=\"[0-9]+\" maxlength=\"10\" pattern=\"[0-9]+\" required=\"\"/></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr class=\"content\">\n");
      out.write("                    <td colspan=\"2\" align=center class=\"title\"><b>Thông tin xe</b></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr class=\"content\">\n");
      out.write("                    <td align=\"right\">Tên xe<input type=\"hidden\" name=\"xid\" value=\"");
      out.print( x.getId() );
      out.write("\"/></td>\n");
      out.write("                    <td>");
      out.print(x.getNhan_hieu());
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr class=\"content\">\n");
      out.write("                    <td align=\"right\">Ngày nhận xe</td>\n");
      out.write("                    <td><input type=\"text\" id=\"getDate\" name=\"ngay_nhan\"/></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr class=\"content\">\n");
      out.write("                    <td align=\"right\">Tổng ngày đặt xe</td>\n");
      out.write("                    <td><input type=\"number\" min=\"0\" name=\"tong_ngay_dat_xe\" required=\"\"/></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr class=\"content\">\n");
      out.write("                    <td align=\"right\">Giá thuê trên 1 ngày</td>\n");
      out.write("                    <td>");
      out.print(x.getLoai_xe().getGia_thue_1_ngay());
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td colspan=\"2\" align=center class=\"title\"><b>Thông tin dịch vụ</b></td>\n");
      out.write("\n");
      out.write("                </tr>\n");
      out.write("                <tr class=\"content\">\n");
      out.write("                    <td align=\"right\">Tên dịch vụ</td>\n");
      out.write("                    <td>\n");
      out.write("                        <select name=\"did\">\n");
      out.write("                            ");
for (DichVu dv : d) {
      out.write("\n");
      out.write("                            <option value=\"");
      out.print( dv.getId());
      out.write('"');
      out.write('>');
      out.print( dv.getName());
      out.write("</option>\n");
      out.write("                            ");
}
      out.write("\n");
      out.write("                        </select>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr class=\"content\">\n");
      out.write("                    <td align=\"right\">Địa chỉ nhận xe</td>\n");
      out.write("                    <td><input type=\"text\" name=\"address_nhan_xe\"/></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td colspan=\"2\" align=center class=\"title\"><b>Ghi chú</b></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr class=\"content\">\n");
      out.write("                    <td colspan=\"2\" align=\"center\"><textarea cols=\"45\" rows=\"2\" name=\"note\"></textarea></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td colspan=\"2\" align=\"center\">\n");
      out.write("                        <br>\n");
      out.write("                        <a href=\"thanhtoan\">\n");
      out.write("                            <button type=\"submit\" class=\"btn btn-lg btn-primary\">Xác nhận</button>\n");
      out.write("                        </a>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("    <script>\n");
      out.write("        var n = new Date();\n");
      out.write("        var y = n.getFullYear();\n");
      out.write("        var m = n.getMonth() + 1;\n");
      out.write("        var d = n.getDate();\n");
      out.write("        document.getElementById(\"getDate\").value = y + \"/\" + m + \"/\" + d;\n");
      out.write("    </script>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
