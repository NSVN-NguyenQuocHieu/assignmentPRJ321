package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class thanhtoan_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        ");

            String cname = (String) session.getAttribute("cname");
            String cmt = (String) session.getAttribute("cmt");
            String sdt = (String) session.getAttribute("sdt");
            String xid = (String) session.getAttribute("xid");
            String tong_ngay_thue = (String) session.getAttribute("tong_ngay_thue");
            String did = (String) session.getAttribute("did");
            String dia_chi_nhan = (String) session.getAttribute("dia_chi_nhan");
        
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form>\n");
      out.write("            <input type=\"text\" value=\"");
      out.print( cname );
      out.write("\" />\n");
      out.write("            <input type=\"text\" value=\"");
      out.print( cmt );
      out.write("\" />\n");
      out.write("            <input type=\"text\" value=\"");
      out.print( sdt );
      out.write("\" />\n");
      out.write("            <input type=\"text\" value=\"");
      out.print( xid );
      out.write("\" />\n");
      out.write("            <input type=\"text\" value=\"");
      out.print( tong_ngay_thue );
      out.write("\" />\n");
      out.write("            <input type=\"text\" value=\"");
      out.print( did );
      out.write("\" />\n");
      out.write("            <input type=\"text\" value=\"");
      out.print( dia_chi_nhan );
      out.write("\" />\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <td colspan=\"2\" align=center><b>Đơn giá</b></td>\n");
      out.write("\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Tổng tiền thuê xe</td>\n");
      out.write("                    <td><input type=\"text\" name=\"tong_tien_thue_xe\" value=\"\" readonly=\"\"/></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Tổng tiền dịch vụ</td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"text\" name=\"tong_tien_dich_vu\" \n");
      out.write("                               value=\"0\"\n");
      out.write("                               readonly=\"\"/></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Tổng tiền phải thanh toán</td>\n");
      out.write("                    <td><input type=\"text\" name=\"tong_thanh_toan\" value=\"aaaa\" readonly=\"\"/></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Trạng thái</td>\n");
      out.write("                    <td>\n");
      out.write("                        <select name=\"status\">\n");
      out.write("                            <option value=\"-1\"> </option>\n");
      out.write("                            <option value=\"1\">Đã thanh toán</option>\n");
      out.write("                            <option value=\"0\">Chưa thanh toán</option>\n");
      out.write("                        </select>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Thông tin thêm</td>\n");
      out.write("                    <td><input type=\"text\" name=\"thong_tin_them\"/></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td colspan=\"2\" align=\"center\">\n");
      out.write("                        <br>\n");
      out.write("                        <input type=\"submit\" value=\"Xác nhận\" />\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
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
