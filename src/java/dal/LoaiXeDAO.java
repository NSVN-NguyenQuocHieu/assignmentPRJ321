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

/**
 *
 * @author Asus
 */
public class LoaiXeDAO extends DBContext {

    public ArrayList<LoaiXe> getLoaiXe() {
        ArrayList<LoaiXe> listLoaiXe = new ArrayList<>();
        try {
            String sql = "select * from Loai_xe";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                LoaiXe list = new LoaiXe();
                list.setId(rs.getInt("ID"));
                list.setTen(rs.getString("Ten"));
                list.setTong_so_xe(rs.getInt("Tong_so_xe"));
                list.setGia_thue_1_ngay(rs.getFloat("Gia_thue_tren_1_ngay"));
                listLoaiXe.add(list);
            }
        }catch (SQLException ex) {
            Logger.getLogger(LoaiXeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listLoaiXe;
    }
}
