/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.DonHangDAO;
import dal.LoaiXeDAO;
import dal.XeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Asus
 */
public class ListXeController extends BaseRequiredAuthenticationController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String raw_id = request.getParameter("id");
        if(raw_id == null)
            raw_id = "0";
        int id = Integer.parseInt(raw_id);
        
        LoaiXeDAO xdao = new LoaiXeDAO();
        request.setAttribute("loaixe", xdao.getLoaiXe());
        XeDAO dao = new XeDAO();
        request.setAttribute("xe", dao.getXebyLoaiXe(id));
        DonHangDAO dhdao = new DonHangDAO();
        String year = dhdao.getYear();
        request.setAttribute("year", year);
        String month = dhdao.getMonth();
        request.setAttribute("month", month);
        request.setAttribute("id", id);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }

}
