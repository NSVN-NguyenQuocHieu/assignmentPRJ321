/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.DonHangDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DonHang;

/**
 *
 * @author Asus
 */
public class ThanhToanCotroller extends BaseRequiredAuthenticationController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DonHangDAO dhDao = new DonHangDAO();
        DonHang dh = new DonHang();
        dh = dhDao.getDonHang(Integer.parseInt((String) session.getAttribute("xid")));
        
        request.setAttribute("don_hang", dh);
        request.getRequestDispatcher("thanhtoan.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}
