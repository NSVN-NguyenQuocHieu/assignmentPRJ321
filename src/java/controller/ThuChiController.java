/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.DonHangDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DonHang;

/**
 *
 * @author Asus
 */
public class ThuChiController extends BaseRequiredAuthenticationController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DonHangDAO dao = new DonHangDAO();
        String month = request.getParameter("month");
        String year = request.getParameter("year");
        int y = Integer.parseInt(request.getParameter("year"));
        String endDay = "";
        if (month.equals("1") || month.equals("3") || month.equals("5") || month.equals("7") || month.equals("8")
                || month.equals("10") || month.equals("12")) {
            endDay = "31";
        } else if (month.equals("4") || month.equals("6") || month.equals("9") || month.equals("11")) {
            endDay = "30";
        } else if (month.equals("2")) {
            if (y % 4 == 0) {
                endDay = "29";
            } else if (y % 4 != 0) {
                endDay = "28";
            }
        }
        ArrayList<DonHang> list = dao.listDh(month, endDay, year);

        float total = dao.total(month, endDay, year);

        request.setAttribute("list", list);
        request.setAttribute("total", total);
        request.getRequestDispatcher("thuchi.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
