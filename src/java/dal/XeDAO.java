/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.LoaiXe;
import model.Xe;

/**
 *
 * @author Asus
 */
public class XeDAO extends DBContext {

    public ArrayList<Xe> getXebyLoaiXe(int id) {
        ArrayList<Xe> listXe = new ArrayList<>();
        try {
            String sql = "Select x.id ,x.Nhan_hieu, x.Trang_thai, x.Bien_so, x.id_loai_xe, lx.Gia_thue_tren_1_ngay as gia_thue\n"
                    + "from Xe x, Loai_xe lx\n"
                    + "where x.ID_loai_xe = lx.ID\n";
            if (id != 0) {
                sql += "and x.ID_loai_xe = " + id;
            }
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Xe x = new Xe();
                x.setId(rs.getInt("ID"));
                x.setNhan_hieu(rs.getString("Nhan_hieu"));
                x.setTrang_thai(rs.getBoolean("Trang_thai"));
                x.setBien_so(rs.getString("Bien_so"));

                LoaiXe lx = new LoaiXe();
                lx.setId(rs.getInt("ID_loai_xe"));
                lx.setGia_thue_1_ngay(rs.getFloat("Gia_thue"));

                x.setLoai_xe(lx);

                listXe.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(XeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listXe;
    }

    public Xe getXe(int id) {
        Xe x = new Xe();
        try {
            String sql = "Select x.id ,x.Nhan_hieu, x.Trang_thai, x.Bien_so, x.id_loai_xe, lx.Gia_thue_tren_1_ngay as gia_thue\n"
                    + "from Xe x, Loai_xe lx\n"
                    + "where x.ID_loai_xe = lx.ID\n"
                    + "and x.id = " + id;
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                x.setId(rs.getInt("ID"));
                x.setNhan_hieu(rs.getString("Nhan_hieu"));
                x.setTrang_thai(rs.getBoolean("Trang_thai"));
                x.setBien_so(rs.getString("Bien_so"));

                LoaiXe lx = new LoaiXe();
                lx.setId(rs.getInt("ID_loai_xe"));
                lx.setGia_thue_1_ngay(rs.getFloat("Gia_thue"));

                x.setLoai_xe(lx);

            }
        } catch (SQLException ex) {
            Logger.getLogger(XeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }
}
