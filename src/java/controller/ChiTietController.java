/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.DonHangDAO;
import dal.XeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DichVu;
import model.KhachHang;

/**
 *
 * @author Asus
 */
public class ChiTietController extends BaseRequiredAuthenticationController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        XeDAO dao = new XeDAO();
        request.setAttribute("xe", dao.getXe(id));
        DonHangDAO dhDao = new DonHangDAO();
        ArrayList<DichVu> d = new ArrayList<>();
        d = dhDao.getDichVu();
        request.setAttribute("dich_vu", d);
        request.getRequestDispatcher("chitiet.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cname = request.getParameter("cname");
        String cmt = request.getParameter("cmt");
        String sdt = request.getParameter("sdt");
        String xid = request.getParameter("xid");
        String tong_ngay_thue = request.getParameter("tong_ngay_dat_xe");
        String did = request.getParameter("did");
        String dia_chi_nhan = request.getParameter("address_nhan_xe");
        if(dia_chi_nhan == null){
            dia_chi_nhan = " ";
        }
        String ghi_chu = request.getParameter("note");
        if (ghi_chu == null){
            ghi_chu = " ";
        }
        
        DonHangDAO dhDao = new DonHangDAO();
       
        dhDao.insert(cname, cmt, sdt, Integer.parseInt(xid), Integer.parseInt(did), Integer.parseInt(tong_ngay_thue),
                0, true, ghi_chu, dia_chi_nhan);
        
        String tien_dv = String.valueOf(dhDao.getGiaDv2(Integer.parseInt(did)));
//        dhDao.updateDonHang(Integer.parseInt(xid), Integer.parseInt(did));
        
        HttpSession session = request.getSession();
        session.setAttribute("cname", cname);
        session.setAttribute("cmt", cmt);
        session.setAttribute("sdt", sdt);
        session.setAttribute("xid", xid);
        session.setAttribute("tong_ngay_thue", tong_ngay_thue);
        session.setAttribute("did", did);
        session.setAttribute("dia_chi_nhan", dia_chi_nhan);
        session.setAttribute("note", ghi_chu);
//        session.setAttribute("tong_thue_xe", tong_thue_xe);
//        session.setAttribute("tong_tien", tong_tien);
        session.setAttribute("tien_dv", tien_dv);
        response.sendRedirect("thanhtoan");
    }

    
}
