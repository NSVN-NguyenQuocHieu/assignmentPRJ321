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
import model.DichVu;
import model.DonHang;
import model.KhachHang;
import model.Xe;

/**
 *
 * @author Asus
 */
public class DonHangDAO extends DBContext {

    public void insert(String name, String cmt, String sdt, int xid, int did, int so_ngay_thue,
            float don_gia, boolean status, String ghi_chu, String address) {
        try {
            String sql = "INSERT INTO [Khach_hang]\n"
                    + "           ([Ten]\n"
                    + "           ,[So_CMT]\n"
                    + "           ,[sdt]\n"
                    + "           ,[xID]\n"
                    + "           ,[dID])\n"
                    + "     VALUES\n"
                    + "           ('" + name + "'\n"
                    + "           ,'" + cmt + "'\n"
                    + "           ,'" + sdt + "'\n"
                    + "           ," + xid + "\n"
                    + "           ," + did + ")\n"
                    + "           \n"
                    + "INSERT INTO [Don_hang]\n"
                    + "           ([cID]\n"
                    + "           ,[xID]\n"
                    + "           ,[dID]\n"
                    + "           ,[Ngay_thue]\n"
                    + "           ,[So_ngay_thue]\n"
                    + "           ,[Don_gia]\n"
                    + "           ,[Trang_thai]\n"
                    + "           ,[Ghi_chu])\n"
                    + "     VALUES\n"
                    + "           ((select MAX(ID) as cid from Khach_hang)\n"
                    + "           ," + xid + "\n"
                    + "           ," + did + "\n"
                    + "           ,GETDATE()\n"
                    + "           ," + so_ngay_thue + "\n"
                    + "           ," + don_gia + "\n"
                    + "           ," + 1 + "\n"
                    + "           ,'" + ghi_chu + "')\n"
                    + "\n"
                    + "INSERT INTO [Thong_tin_nhan_tra_xe]\n"
                    + "                    ([cID]\n"
                    + "                    ,[Dia_chi]\n"
                    + "                    ,[Trang_thai_nhan])\n"
                    + "                    VALUES(\n"
                    + "                    (select MAX(ID) as cid from Khach_hang)\n"
                    + "                    ,'" + address + "'\n"
                    + "                    ,1)\n"
                    + "\n"
                    + "update Xe\n"
                    + "     set Trang_thai = 1\n"
                    + "     where ID = " + xid + "\n"
                    + "\n"
                    + "update [Don_hang]\n"
                    + "  set Don_gia = \n"
                    + "	(select ((select So_ngay_thue from Don_hang where cID=(select MAX(cid) from Don_hang))\n"
                    + "	*(select Gia_thue_tren_1_ngay from Loai_xe "
                    + "where ID=(select lx.ID from Xe x, Loai_xe lx where x.ID_loai_xe=lx.ID and x.ID = " + xid + "))\n"
                    + "	+(select Gia_dich_vu from Dich_vu where ID=" + did + ")))\n"
                    + "  where cID=(select MAX(cid) from Don_hang)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DonHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<DichVu> getDichVu() {
        ArrayList<DichVu> dv = new ArrayList<>();
        try {
            String sql = "Select * from Dich_vu";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                DichVu d = new DichVu();
                d.setId(rs.getInt("id"));
                d.setName(rs.getString("Ten_dich_vu"));
                d.setPrice(rs.getFloat("Gia_dich_vu"));

                dv.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dv;
    }

    public float getGiaDv2(int did) {
        for (DichVu dichVu : getDichVu()) {
            if (dichVu.getId() == did) {
                return dichVu.getPrice();
            }
        }
        return -1;
    }

    public DonHang getDonHang(int xid) {
        DonHang dh = new DonHang();
        try {
            String sql = "  select Don_gia,\n"
                    + "  ((select So_ngay_thue from Don_hang where cID=(select MAX(cid) from Don_hang))\n"
                    + "	*(select Gia_thue_tren_1_ngay from Loai_xe where ID=(select lx.ID from Xe x, Loai_xe lx where x.ID_loai_xe=lx.ID and x.ID = " + xid + "))) as tong_thue_xe\n"
                    + "  from Don_hang\n"
                    + "	where cID = (select MAX(cID) from Don_hang)";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                dh.setDon_gia(rs.getFloat("Don_gia"));
                dh.setTong_thue_xe(rs.getFloat("tong_thue_xe"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dh;
    }

    public void traXe(int xid) {
        try {
            String sql = "update Xe\n"
                    + "     set Trang_thai = 0\n"
                    + "     where ID = " + xid + "\n";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DonHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<DonHang> listDh(String month, String endDayOfMonth, String year) {
        ArrayList<DonHang> list = new ArrayList<>();
        try {
            String sql = "select c.Ten,x.Nhan_hieu,Ngay_thue,So_ngay_thue,Don_gia\n"
                    + "from Don_hang dh, Khach_hang c,Xe x\n"
                    + "	where dh.cID = c.ID and dh.xID = x.ID\n"
                    + "		and Ngay_thue >= '" + year + "-" + month + "-01'\n"
                    + "		and Ngay_thue <= '" + year + "-" + month + "-" + endDayOfMonth + "'\n"
                    + "order by cID";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                DonHang dh = new DonHang();

                KhachHang c = new KhachHang();
                c.setName(rs.getString("Ten"));

                dh.setCustomer(c);

                Xe x = new Xe();
                x.setNhan_hieu(rs.getString("Nhan_hieu"));

                dh.setXe(x);

                dh.setNgay_thue(rs.getDate("Ngay_thue"));
                dh.setSo_ngay_thue(rs.getInt("So_ngay_thue"));
                dh.setDon_gia(rs.getFloat("Don_gia"));

                list.add(dh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public float total(String month, String endDayOfMonth, String year) {
        float total = 0;
        String sql = "select SUM(Don_gia) as total from Don_hang\n"
                + "		where Ngay_thue >= '" + year + "-" + month + "-01'\n"
                + "		and Ngay_thue <= '" + year + "-" + month + "-" + endDayOfMonth + "'";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                total = rs.getFloat("total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    public String getYear() {
        String year = "";
        String sql = "select DATEPART(YEAR, GETDATE()) as [Year]";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                year = rs.getString("Year");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return year;
    }
    
    public String getMonth() {
        String month = "";
        String sql = "select DATEPART(MONTH, GETDATE()) as [Month]";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                month = rs.getString("Month");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return month;
    }
}
