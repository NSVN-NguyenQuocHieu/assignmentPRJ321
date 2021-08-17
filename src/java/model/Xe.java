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
public class Xe {
    private int id;
    private String nhan_hieu;
    private Date ngay_nhap;
    private float gia_nhap;
    private boolean trang_thai;
    private int so_ngay_da_thue;
    private String bien_so;
    private LoaiXe loai_xe;

    public LoaiXe getLoai_xe() {
        return loai_xe;
    }

    public void setLoai_xe(LoaiXe loai_xe) {
        this.loai_xe = loai_xe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNhan_hieu() {
        return nhan_hieu;
    }

    public void setNhan_hieu(String nhan_hieu) {
        this.nhan_hieu = nhan_hieu;
    }

    public Date getNgay_nhap() {
        return ngay_nhap;
    }

    public void setNgay_nhap(Date ngay_nhap) {
        this.ngay_nhap = ngay_nhap;
    }

    public float getGia_nhap() {
        return gia_nhap;
    }

    public void setGia_nhap(float gia_nhap) {
        this.gia_nhap = gia_nhap;
    }

    public boolean isTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(boolean trang_thai) {
        this.trang_thai = trang_thai;
    }

    public int getSo_ngay_da_thue() {
        return so_ngay_da_thue;
    }

    public void setSo_ngay_da_thue(int so_ngay_da_thue) {
        this.so_ngay_da_thue = so_ngay_da_thue;
    }

    public String getBien_so() {
        return bien_so;
    }

    public void setBien_so(String bien_so) {
        this.bien_so = bien_so;
    }
    
}
