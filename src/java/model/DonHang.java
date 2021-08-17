/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Asus
 */
public class DonHang {
    private KhachHang customer;
    private Xe xe;
    private DichVu dich_vu;
    private Date ngay_thue;
    private int so_ngay_thue;
    private float don_gia;
    private boolean status;
    private float tong_thue_xe;

    public float getTong_thue_xe() {
        return tong_thue_xe;
    }

    public void setTong_thue_xe(float tong_thue_xe) {
        this.tong_thue_xe = tong_thue_xe;
    }
    
    public KhachHang getCustomer() {
        return customer;
    }

    public void setCustomer(KhachHang customer) {
        this.customer = customer;
    }

    public Xe getXe() {
        return xe;
    }

    public void setXe(Xe xe) {
        this.xe = xe;
    }

    public DichVu getDich_vu() {
        return dich_vu;
    }

    public void setDich_vu(DichVu dich_vu) {
        this.dich_vu = dich_vu;
    }

    public Date getNgay_thue() {
        return ngay_thue;
    }

    public void setNgay_thue(Date ngay_thue) {
        this.ngay_thue = ngay_thue;
    }

    public int getSo_ngay_thue() {
        return so_ngay_thue;
    }

    public void setSo_ngay_thue(int so_ngay_thue) {
        this.so_ngay_thue = so_ngay_thue;
    }

    public float getDon_gia() {
        return don_gia;
    }

    public void setDon_gia(float don_gia) {
        this.don_gia = don_gia;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
