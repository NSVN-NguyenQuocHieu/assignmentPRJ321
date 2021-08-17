package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Xe;
import java.util.ArrayList;
import model.LoaiXe;
import util.SessionHelper;
import model.Accounts;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link href=\"newcss.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"></script>\n");
      out.write("        ");

            Accounts account = SessionHelper.getAccountFromSession(session);
            ArrayList<Xe> listXe = (ArrayList<Xe>) request.getAttribute("xe");
            ArrayList<LoaiXe> loaixe = (ArrayList<LoaiXe>) request.getAttribute("loaixe");
            Integer id = (Integer) request.getAttribute("id");
            String year = (String) request.getAttribute("year");
        
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!--Header-->\n");
      out.write("        <nav class=\"navbar navbar-expand-md navbar-dark navbar-custom p-0\">\n");
      out.write("            <a class=\"navbar-brand\" href=\"list\">\n");
      out.write("                <img src=\"https://scontent.fhan2-4.fna.fbcdn.net/v/t1.15752-9/71806691_2363765837285721_8467827555083223040_n.png?_nc_cat=105&_nc_oc=AQmI3EbmGult4NTj5ic11dUKyzxaoNRmxflBjJXBZQg_kMvHXRYi7MMnKomFeRwkJUw&_nc_ht=scontent.fhan2-4.fna&oh=ff7841ac1e6307fcb5b77a965123cac5&oe=5DF37E1D\" \n");
      out.write("                     alt=\"logo\" style=\"width:100px; height: 100px\">\n");
      out.write("            </a>\n");
      out.write("            <button class=\"navbar-toggler mr-3\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarContent\" aria-controls=\"navbarContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("            </button>\n");
      out.write("            <div><a href=\"thuchi?month=1&year=");
      out.print( year );
      out.write("\">Quản lý thu chi</a></div>\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbarContent\">\n");
      out.write("                <ul class=\"navbar-nav mr-auto\">\n");
      out.write("                    <li class=\"nav-item active\">\n");
      out.write("                        <a id=\"text\" class=\"nav-link\" href=\"#\">Home</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a id=\"text\" class=\"nav-link\" href=\"#\">Link</a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("            <div>\n");
      out.write("                You are logged in as ");
      out.print(account.getUserName());
      out.write("(<a href=\"logout\">Logout</a>)\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("        <!--Header-->   \n");
      out.write("\n");
      out.write("        <form action=\"list\" method=\"get\" id=\"frm\" align=\"center\">\n");
      out.write("            Loại xe <select name=\"id\" onchange=\"document.getElementById('frm').submit();\">\n");
      out.write("                <option value=\"0\">---------ALL---------</option>\n");
      out.write("                ");
for (LoaiXe d : loaixe) {
                
      out.write("\n");
      out.write("                <option ");
      out.print((d.getId() == id) ? "selected" : "");
      out.write(" value=\"");
      out.print(d.getId());
      out.write("\" >");
      out.print(d.getTen());
      out.write("</option>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("            </select>  \n");
      out.write("        </form>\n");
      out.write("        <br>\n");
      out.write("        <table border=\"1\" align=\"center\">\n");
      out.write("            <tr>\n");
      out.write("                <th>Nhãn hiệu</th>\n");
      out.write("                <th>Biển số</th>\n");
      out.write("                <th>Trạng thái</th>\n");
      out.write("                <th>Giá thuê theo ngày</th>\n");
      out.write("                <th> </th>\n");
      out.write("                <th> </th>\n");
      out.write("            </tr>\n");
      out.write("            ");
for (Xe x : listXe) {
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <input type=\"hidden\" value=\"");
      out.print(x.getId());
      out.write("\" />\n");
      out.write("                <td><b>");
      out.print(x.getNhan_hieu());
      out.write("</b></td>\n");
      out.write("                <td>");
      out.print(x.getBien_so());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(x.isTrang_thai() ? "Đã thuê" : "Chưa thuê");
      out.write("</td>\n");
      out.write("                <td>");
      out.print(x.getLoai_xe().getGia_thue_1_ngay());
      out.write("</td>\n");
      out.write("            <td>\n");
      out.write("                <a href=\"chitiet?id=");
      out.print(x.getId());
      out.write("\">\n");
      out.write("                    <input type=\"submit\" value=\"Đặt xe\" ");
      out.print(x.isTrang_thai() ? "disabled" : "");
      out.write(" />\n");
      out.write("                </a>\n");
      out.write("            </td>\n");
      out.write("            <td>\n");
      out.write("                <a href=\"traxe?xid=");
      out.print(x.getId());
      out.write("\">\n");
      out.write("                    <input type=\"button\" value=\"Trả xe\" ");
      out.print(x.isTrang_thai() ? "" : "disabled");
      out.write(" />\n");
      out.write("                </a>\n");
      out.write("            </td>\n");
      out.write("        </tr>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("    </table>\n");
      out.write("</body>\n");
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
